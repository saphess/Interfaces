package ru.netology.homework15.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticketKazan1;
    Ticket ticketKazan2;
    Ticket ticketKazan3;
    Ticket ticketKazan4;
    Ticket ticketKazan5;
    Ticket ticketTokio1;
    Ticket ticketTokio2;

    @BeforeEach
    public void setup() {
        ticketKazan1 = new Ticket("Moscow", "Kazan", 15500, 9, 13); //4
        ticketKazan2 = new Ticket("Moscow", "Kazan", 6400, 2, 5); //3
        ticketKazan3 = new Ticket("Moscow", "Kazan", 4400, 0, 4); //4
        ticketKazan4 = new Ticket("Moscow", "Kazan", 8456, 9, 14); //5
        ticketKazan5 = new Ticket("Moscow", "Kazan", 25500, 11, 12); //1
        ticketTokio1 = new Ticket("Moscow", "Tokio", 38532, 13, 23);
        ticketTokio2 = new Ticket("Moscow", "Tokio", 25500, 12, 20);
    }

    @Test
    public void shouldCompareToIfIdentically() {
        int actual = ticketKazan5.compareTo(ticketTokio2);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToIfLess() {
        int actual = ticketKazan3.compareTo(ticketTokio1);
        int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToIfOver() {
        int actual = ticketTokio1.compareTo(ticketTokio2);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByPricesIfNotSorted() {
        AviaSouls ticketsNoSorted = new AviaSouls();
        ticketsNoSorted.add(ticketKazan1);
        ticketsNoSorted.add(ticketKazan2);
        ticketsNoSorted.add(ticketKazan3);
        ticketsNoSorted.add(ticketKazan4);
        ticketsNoSorted.add(ticketKazan5);
        ticketsNoSorted.add(ticketTokio1);
        ticketsNoSorted.add(ticketTokio2);

        Ticket[] actual = ticketsNoSorted.search("Moscow", "Kazan");
        Ticket[] expected = {ticketKazan3, ticketKazan2, ticketKazan4, ticketKazan1, ticketKazan5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPricesIfSorted() {
        AviaSouls ticketsNoSorted = new AviaSouls();
        ticketsNoSorted.add(ticketKazan3);
        ticketsNoSorted.add(ticketKazan2);
        ticketsNoSorted.add(ticketKazan4);
        ticketsNoSorted.add(ticketKazan1);
        ticketsNoSorted.add(ticketKazan5);
        ticketsNoSorted.add(ticketTokio1);
        ticketsNoSorted.add(ticketTokio2);

        Ticket[] actual = ticketsNoSorted.search("Moscow", "Kazan");
        Ticket[] expected = {ticketKazan3, ticketKazan2, ticketKazan4, ticketKazan1, ticketKazan5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByTimeIfNotSorted() {
        AviaSouls ticketsNoSorted = new AviaSouls();
        ticketsNoSorted.add(ticketKazan1);
        ticketsNoSorted.add(ticketKazan2);
        ticketsNoSorted.add(ticketKazan3);
        ticketsNoSorted.add(ticketKazan4);
        ticketsNoSorted.add(ticketKazan5);
        ticketsNoSorted.add(ticketTokio1);
        ticketsNoSorted.add(ticketTokio2);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] actual = ticketsNoSorted.searchAndSortBy("Moscow", "Kazan", ticketTimeComparator);
        Ticket[] expected = {ticketKazan5, ticketKazan2, ticketKazan1, ticketKazan3, ticketKazan4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByTimeIfSorted() {
        AviaSouls ticketsNoSorted = new AviaSouls();
        ticketsNoSorted.add(ticketKazan5);
        ticketsNoSorted.add(ticketKazan2);
        ticketsNoSorted.add(ticketKazan1);
        ticketsNoSorted.add(ticketKazan3);
        ticketsNoSorted.add(ticketKazan4);
        ticketsNoSorted.add(ticketTokio1);
        ticketsNoSorted.add(ticketTokio2);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] actual = ticketsNoSorted.searchAndSortBy("Moscow", "Kazan", ticketTimeComparator);
        Ticket[] expected = {ticketKazan5, ticketKazan2, ticketKazan1, ticketKazan3, ticketKazan4};

        Assertions.assertArrayEquals(expected, actual);
    }
}
