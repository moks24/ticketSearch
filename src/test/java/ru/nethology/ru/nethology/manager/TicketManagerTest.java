package ru.nethology.ru.nethology.manager;

import org.junit.jupiter.api.Test;
import ru.nethology.domain.TicketOffer;
import ru.nethology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    TicketOffer first = new TicketOffer(1, 1900, "DME","OGZ", 180);
    TicketOffer second = new TicketOffer(2, 1450, "LED","GOJ", 72);
    TicketOffer third = new TicketOffer(3, 1100, "REN","LED", 82);

    @Test
    public void shouldLookForABook() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        TicketOffer[] expected = new TicketOffer[]{third};
        TicketOffer[] actual = manager.searchBy("REN", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPrice() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        TicketOffer[] expected = new TicketOffer[]{third, second, first};
        TicketOffer[] actual = repository.findAll();
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);}

}