import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class TicketTest {


    Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 5_000, 15, 17);//Время полета 2 часа
    Ticket ticket2 = new Ticket("Санкт-Петербург", "Ереван", 9_000, 12, 17);//Время полета 5 часов
    Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 3_000, 10, 16);//Время полета 6 часов
    Ticket ticket4 = new Ticket("Сочи", "Москва", 12_000, 16, 19);//Время полета  3 часа
    Ticket ticket5 = new Ticket("Москва", "Екатеринбург", 3_000, 10, 16);//Время полета 6 часов

    Ticket ticket6 = new Ticket("Санкт-Петербург", "Ереван", 12_000, 8, 15);//Время полета 7 часов
    Ticket ticket7 = new Ticket("Санкт-Петербург", "Ереван", 10_000, 1, 2);//Время полета 1 час

    @Test
    public void showShortingByPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket3, ticket5, ticket1, ticket2, ticket4};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void showSearchTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {ticket2, ticket7, ticket6};
        Ticket[] actual = aviaSouls.search("Санкт-Петербург", "Ереван");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void showSearchTicketsWithFliTime() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7, ticket2, ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Санкт-Петербург", "Ереван", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
