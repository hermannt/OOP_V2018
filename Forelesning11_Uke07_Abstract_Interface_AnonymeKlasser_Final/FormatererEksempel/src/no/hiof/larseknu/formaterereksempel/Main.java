package no.hiof.larseknu.formaterereksempel;

import no.hiof.larseknu.formaterereksempel.formaterere.*;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
	    String pun = "This is unBEARable!";



	    StorTekstFormaterer storTekstFormaterer = new StorTekstFormaterer();
        //System.out.println(storTekstFormaterer.formater(pun));

        LitenTekstFormaterer litenTekstFormaterer = new LitenTekstFormaterer();
        //System.out.println(litenTekstFormaterer.formater(pun));

        CamelCaseFormaterer camelCaseFormaterer = new CamelCaseFormaterer();
        //System.out.println(camelCaseFormaterer.formater(pun));

        TilfeldigFormaterer tilfeldigFormaterer = new TilfeldigFormaterer();
        //System.out.println(tilfeldigFormaterer.formater(pun));

        gjorFormateringOgSkrivUt(storTekstFormaterer, Formaterer.STANDARD_TEKST);
        gjorFormateringOgSkrivUt(litenTekstFormaterer, pun);
        gjorFormateringOgSkrivUt(camelCaseFormaterer, pun);
        gjorFormateringOgSkrivUt(tilfeldigFormaterer, pun);

        gjorFormateringOgSkrivUt(new Formaterer() {
            @Override
            public String formater(String tekstSomSkalFormateres) {
                StringBuilder stringBygger = new StringBuilder(pun);

                return stringBygger.reverse().toString();
            }
        },
        pun);
    }

    private static void gjorFormateringOgSkrivUt(Formaterer enFormaterer, String tekstSomSkalFormateres) {
        System.out.println(enFormaterer.formater(tekstSomSkalFormateres));
    }
}
