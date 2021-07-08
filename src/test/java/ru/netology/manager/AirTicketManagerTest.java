package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTicket;
import ru.netology.repository.AirTicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AirTicketManagerTest {

    AirTicketRepository repository = new AirTicketRepository();
    AirTicketManager manager = new AirTicketManager(repository);
    private AirTicket one = new AirTicket(1, 5500, "LED", "KUF", 80);
    private AirTicket two = new AirTicket(2, 3200, "OGZ", "LED", 180);
    private AirTicket three = new AirTicket(3, 1800, "DME", "LED", 70);
    private AirTicket four = new AirTicket(4, 1500, "KUF", "LED", 80);
    private AirTicket five = new AirTicket(5, 3500, "DME", "LED", 75);


    @BeforeEach
    public void setUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);
    }

    @Test
    public void shouldSearchIfFlightFind() {
        AirTicket[] actual = manager.searchBy("DME", "LED");
        AirTicket[] expected = new AirTicket[]{three, five};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfFlightNotFind() {
        AirTicket[] actual = manager.searchBy("OGZ", "KUF");
        AirTicket[] expected = new AirTicket[0];

        assertArrayEquals(expected, actual);
    }
}
