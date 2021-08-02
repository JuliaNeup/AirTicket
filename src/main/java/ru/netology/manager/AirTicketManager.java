package ru.netology.manager;

import ru.netology.domain.AirTicket;
import ru.netology.repository.AirTicketRepository;

import java.util.Arrays;

public class AirTicketManager {
    private AirTicketRepository repository;

    public AirTicketManager(AirTicketRepository repository) {
        this.repository = repository;
    }

    public AirTicket[] searchBy(String from, String to) {
        AirTicket[] result = new AirTicket[0];
        for (AirTicket ticket : repository.findAll()) {
            if (ticket.matches(from, to)) {
                AirTicket[] tmp = new AirTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
    public AirTicket[] showOffers() {
        AirTicket[] result = repository.getAll();
        Arrays.sort(result);
        return result;
    }
}
