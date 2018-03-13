package no.hiof.larseknu.varargs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Kaller summer-metode med 2 argumenter
        System.out.println(summer(5, 6));
        // Kaller summer-metode med 3 argumenter
        System.out.println(summer(5, 6, 6));
        // Kaller summer-metode med ukjent antall int-verdier (når vi kommer over 3)
        System.out.println(summer(5, 6, 6, 6));
        // Kaller doMath-matode som først tar en string, så et ukjent antall int-verdier
        System.out.println(doMath("substraher", 5, 6, 6, 6));


        // Sjekker om et tilfeldig tall vi generer er over eller under ti ved hjelp av en "hurtig-if)
        String tall = (10 < new Random().nextInt() ? "over ti" : "under ti");

        // Kaller string-format med forskjellige typer argumenter
        // Argumentene etter den første stringen blir lagt inn der vi har satt specifiers (%s, %d) etc.
        System.out.println(String.format("Dette er en %s med mange argumenter %tY + %d, %s", "string", LocalDate.of(2016, 2, 2), 2, tall));

        // En litt enklere versjon
        // Argumentene etter den første stringen blir lagt inn der vi har satt specifiers (%s, %d) etc.
        System.out.println(String.format("Dette er en %s som tar varargs %d, %d", "string", 42, 9001));

        // Lager en liste med filmer
        ArrayList<Film> filmer = new ArrayList<>();
        filmer.add(new Film("Iron Man", LocalDate.of(2009, 1, 1)));
        filmer.add(new Film("Iron Man 2", LocalDate.of(2011, 1, 1)));
        filmer.add(new Film("Iron Man 3", LocalDate.of(2012, 1, 1)));
        filmer.add(new Film("Iron Man 4"));

        // Går gjennom alle filmene
        for (Film enFilm : filmer) {
            // Undersøker om datoen er lik LocalDate.MIN, skriver ut datoen hvis den ikke er det.
            if (enFilm.getDato() == LocalDate.MIN)
                System.out.println("Ingen dato");
            else
                System.out.println(enFilm.getDato());

            // "Hurtig-if" av if-spørringen rett over. Gjør akkurat det samme.
            // spørring ? true : false
            System.out.println((enFilm.getDato() == LocalDate.MIN ? "Ingen dato" : enFilm.getDato()));
        }
    }

    // Summer-metode som tar to int verdier
    public static int summer(int a, int b) {
        return summer(a, b, 0);
    }

    // Summer-metode som tar tre int verdier
    public static int summer(int a, int b, int c) {
        return a + b + c;
    }

    // Summer-metode som tar et ukjent antall int-verdier
    public static int summer(int... tall) {
        int sum = 0;

        for (int etTall : tall) {
            sum += etTall;
        }

        return sum;
    }

    // doMath metode som først tar "typen" matte, for så et ukjent antall int-verdier
    public static int doMath(String type, int... tall) {
        // Sjekker hva vi skal gjøre, summere eller substrahere
        switch (type) {
            case "summer":
                // bruker summer-metoden vi allerede har
                return summer(tall);
            case "substraher":
                int sum = 0;
                for (int etTall : tall)
                    sum -= etTall;
                return sum;
        }

        return 0;
    }
}
