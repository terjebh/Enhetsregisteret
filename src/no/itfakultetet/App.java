package no.itfakultetet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner inNavn = new Scanner(System.in);

        while (true) {
            System.out.print("Tast inn et firmanavn (eller 'q' for avslutt): ");
            String firmanavn = inNavn.nextLine();

            if (firmanavn.equals("q")) {
                System.out.println("Farvel...");
                inNavn.close();
                System.exit(0);
            }

            String format = Firma.velgFormat(inNavn);

            List<String> firma = new ArrayList<>();

            Firma f1 = new Firma();
            f1.hentFirma(firmanavn, format, firma);
            f1.lagreFirma(firmanavn, format, firma);
            // f1.visFirma(firmanavn);
        } //slutt på while-løkken

    } // slutt på main-metoden

} // slutt på klassen App
