package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.AirTicketManager;
import ru.netology.repository.AirTicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AirTicketRepositoryTest {
    private AirTicketRepository repository = new AirTicketRepository();
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
    public void shouldFindAll() {
        AirTicket [] actual = repository.findAll();
        AirTicket[] expected = new AirTicket[]{four,three,two,five,one};
        assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldRemoveById (){
        int idToRemove = 2;
        repository.removeById(idToRemove);
        AirTicket [] actual = repository.findAll();
        AirTicket[] expected = new AirTicket[]{four,three,five,one};
        assertArrayEquals(expected, actual);
    }
}
