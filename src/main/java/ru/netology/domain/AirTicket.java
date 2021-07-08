package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirTicket implements Comparable<AirTicket> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int travelTime;

    @Override
    public int compareTo(AirTicket p) {

        return this.price - p.price;
    }

    public boolean matches(String from, String to) {
        return departure.equalsIgnoreCase(from) & arrival.equalsIgnoreCase(to);
    }
}