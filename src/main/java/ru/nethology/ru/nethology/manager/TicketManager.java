package ru.nethology.ru.nethology.manager;

import ru.nethology.domain.TicketOffer;
import ru.nethology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketManager() {

    }

    public void add(TicketOffer item) {
        repository.save(item);
    }

    public TicketOffer[] searchBy(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticket : repository.findAll()) {
            if (matches(ticket, from)) {
                if (matches(ticket, to)) {
                }
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result,0, tmp, 0,result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }

        }
        return result;
    }

    public boolean matches(TicketOffer ticket, String search) {
        if (ticket instanceof TicketOffer) {
            TicketOffer tickets = (TicketOffer) ticket;
            if (tickets.getArrivalAirport().contains(search)) {
                return true;
            }
            if (tickets.getDepartureAirport().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

}
