package ru.nethology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketOffer implements Comparable<TicketOffer>{
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    @Override
    public int compareTo(TicketOffer o) {
        TicketOffer p = (TicketOffer) o;
        return price -p.price;
        //TODO "доделать метод"
    }
}
