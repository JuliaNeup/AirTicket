package ru.netology.repository;

import ru.netology.domain.AirTicket;

import java.util.Arrays;

public class AirTicketRepository {
    private AirTicket[] tickets = new AirTicket[0];

    public void save(AirTicket ticket) {
        int length = tickets.length + 1;
        AirTicket[] tmp = new AirTicket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public AirTicket[] findAll() {
        Arrays.sort(tickets);
        return tickets;
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        AirTicket[] tmp = new AirTicket[length];
        int index = 0;
        for (AirTicket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

}

