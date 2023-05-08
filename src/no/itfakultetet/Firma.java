package no.itfakultetet;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Firma {

    public Firma() {
    }

    static String velgFormat(Scanner inNavn) {
        System.out.print("Hvilket format ønsker du? Tast 1 for XML, 2 for JSON: ");
        String formatNummer = inNavn.nextLine();
        String format = "xml";

        if (formatNummer.equals("1")) {
            format = "xml";
        } else if (formatNummer.equals("2")) {
            format = "json";
        } else {
            System.out.println("Ukjent format, tast 1 eller 2");
            format = velgFormat(inNavn);
        }
        return format;
    }

    public void lagreFirma(String firmanavn, String format, List<String> firma) {
        try (FileWriter lagfil = new FileWriter(firmanavn + "." + format)) {  // Eksempel på try-with-resources, som automatisk lukker lagfil
            for (String linje : firma) {
                lagfil.append(linje + "\n");
            }
            System.out.println("Filen " + firmanavn + "." + format + " ble lagret.");
            System.out.print("Vis innholdet i filen? (j/n): ");
            Scanner in = new Scanner(System.in);
            String vis = in.nextLine();
            if(vis.equals("j")) {
                visFirma(firmanavn, format);
            }

        } catch (Exception e) {
            System.out.println("Noe gikk galt under oppretting av " + firmanavn + "." + format + ", fordi: " + e.getMessage());
        }
    }

    public void hentFirma(String firmanavn, String format, List<String> firma) {
        try (Scanner in = new Scanner(new URL("https://hotell.difi.no/api/" + format + "/brreg/enhetsregisteret?query=" + firmanavn).openStream())) {
            while (in.hasNext()) {
                firma.add(in.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void visFirma(String firmanavn, String format) {
        try (FileReader innFil = new FileReader(firmanavn + "." + format)) {
            Scanner sc1 = new Scanner(innFil);
            while (sc1.hasNextLine()) {
                System.out.println(sc1.nextLine());
            }
            sc1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
