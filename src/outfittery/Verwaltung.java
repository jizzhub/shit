
package outfittery;

import java.beans.*;                        // fuer die XML-Speicherung
import java.io.*;                           // fuer das Speichern und Laden in / von Dateien
import java.util.*;                         // fuer ArrayLists
import de.htw.saarland.stl.Stdin;           // fuer Eingaben von der Konsole

/**
 * Die Klasse Verwaltung stellt den Hauptteil der Applikation OutfitteryPortal dar.
 * Hier wird die Programmlogik implementiert, sowie die Benutzer-Menues.
 *
 * @author Loreen
 * @version v1 - Dezeber 2018
 */
public class Verwaltung implements Serializable
{
    private ArrayList <Artikel> artikelListe;
    private ArrayList <Kunde> kundenListe;

    final static int FELDLAENGE = 14;

    /**
     * Constructor for objects of class Verwaltung
     */
    public Verwaltung()
    {
        artikelListe = new ArrayList <Artikel>();
        kundenListe = new ArrayList <Kunde>();
    }
   
    public void initData()
    {
        Kunde k1 = new Kunde("Tim","Müller","0156 09354267");
        Kunde k2 = new Kunde("Michelle","Watson","0171 2233593");
        Kunde k3 = new Kunde("Lena","Caron","0177 4622273");
        Kunde k4 = new Kunde("Eric","Lentes","0160 8874036");
        kundenListe.add(k1);
        kundenListe.add(k2);
        kundenListe.add(k3);
        kundenListe.add(k4);
        
   
}
     private void saveDataToXML() throws IOException
    {
        XMLEncoder o = new XMLEncoder(new FileOutputStream("outfittery.xml"));
        o.writeObject("outfittery");
        o.writeObject(this);
        o.close();
    }

    public Object loadDataFromXML() throws IOException
    {
        XMLDecoder o = new XMLDecoder(new FileInputStream("outfittery.xml"));
        o.readObject();
        Object obj = o.readObject();
        o.close();
        return obj;
    }

    private void save()
    {
        try
        {
            saveDataToXML();
        }
        catch(java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    private void load()
    {
        try
        {
            Verwaltung v = (Verwaltung) loadDataFromXML();
            // hier starten wir ein neues Programm (eine neue Instanz der Klasse Verwaltung, der wir auch die Kontrolle übergeben), damit wir an die geladenen Daten kommen
            v.mainMenue();
        }
        catch(java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    private void beenden()
    {
        System.exit(0);
    }

    public ArrayList getArtikelListe()
    {
        return this.artikelListe;
    }

    public void setArtikelListe(ArrayList liste)
    {
        this.artikelListe = liste;
    }

    public ArrayList getKundenListe()
    {
        return this.kundenListe;
    }

    public void setKundenListe(ArrayList liste)
    {
        this.kundenListe = liste;
    }

    private void mainMenue()
    {
        char eingabe;

        do
        {
            System.out.println("WELCOME BY OUTFITTERY");
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Warenbestand");
            System.out.println("[2] Kundenmenue");
            System.out.println("[3] Verwaltung");
            System.out.println("[4] Outfitsuche");
            System.out.println("[x] Programm beenden");

            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe)
            {
                case 'x': System.out.println("Vielen Dank für die Nutzung des Outfittery-Portal. Das Programm wird beendet.");
                beenden();
                case '1': warenBestand();
                          break;
                case '2': kundenMenue();
                          break;
                case '3': verwaltungsMenue();
                          break;
                case '4': outfitSuche ();
                default: printEingabeFehler();
            }
        } while (true);
    }

    private void warenBestand()
    {
        char eingabe;
        boolean menuewechsel = false;
        do
        {
            System.out.println("WARENBESTAND");
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Zeige alle Oberteile an ");
            System.out.println("[2] Zeige alle Unterteile an ");
            System.out.println("[3] Zeige alle Schuhe an ");
            System.out.println("[4] Zeige alle Accessoires an ");
            System.out.println("[0] HAUPTMENUE");

            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe)
            {
                case '0': menuewechsel = true;
                    break;
                case '1': showOberteilListe(false, false);
                    break;
                case '2': showUnterteilListe(true, true);
                    break;
                case '3': showSchuhListe();
                    break;
                case '4': showAccessoiresListe ();
                default: printEingabeFehler();
            }
        } while (!menuewechsel);
    }

    private void verwaltungsMenue()
    {
        char eingabe;
        boolean menuewechsel = false;
        do
        {
            System.out.println("VERWALTUNGSMENUE");
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Lade Daten aus XML-Datei");
            System.out.println("[2] Speichere Daten in XML-Datei");
            System.out.println("[0] HAUPTMENUE");

            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe)
            {
                case '0': menuewechsel = true;
                    break;
                case '1': load();
                    break;
                case '2': save();
                    break;
                default: printEingabeFehler();
            }
        } while (!menuewechsel);
    }

    private void kundenMenue()
    {
        char eingabe;
        boolean menuewechsel = false;
        do
        {
            System.out.println("KUNDENMENUE");
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Zeige alle Kunden an");
            System.out.println("[2] Suche Kunden nach Nachname");
            System.out.println("[3] Erstelle neuen Kunden");
            System.out.println("[0] HAUPTMENUE");

            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe)
            {
                case '0': menuewechsel = true;
                    break;
                case '1': showKundenListe();
                    break;
                case '2': sucheKundeNachNachname();
                    break;
                case '3': erstelleNeuenKunden();
                    break;
                default: printEingabeFehler();
            }
        } while (!menuewechsel);
    }

//    private void erstelleNeuenKunden()
//    {
//        Kunde k1 = new Kunde("Hans","Becker","0171 9876543");
//        Kunde k2 = new Kunde("Olaf","Lohrer","0171 1234567");
//        kundenListe.add(k1);
//        kundenListe.add(k2);
//    }

    private void erstelleNeuenKunden()
    {
        String nachname = Stdin.readlnString("Bitte geben Sie den Nachnamen des Kunden ein:");
        String vorname = Stdin.readlnString("Bitte geben Sie den Vornamen des Kunden ein:");

        String telefonnummer;
        do
        {
            telefonnummer = Stdin.readlnString("Bitte geben Sie eine Telefonnummer des Kunden ein (nur Zahlenwerte ohne Leerzeichen sind erlaubt!):");
        } while (!telefonnummer.matches("[0-9]+"));

        Kunde k1 = new Kunde(vorname, nachname, telefonnummer);
        kundenListe.add(k1);
    }

    private void showOberteilListe(boolean filterAn, boolean nurAngebote)
    {
        String s;

        printZentriert("Artikelnummer");
        printZentriert("Größe");
        printZentriert("Geschlecht");
        printZentriert("Stil");
        printZentriert("Preiskategorie");
        printZentriert("Preis");
        printZentriert("Lagerbestand");
        printLF();
        printLinieLF(7); // Trennlinie für 6 Felder anzeigen

        Iterator <Artikel>iter = artikelListe.iterator();
        while(iter.hasNext())
        {
            Artikel i  =  iter.next();
            if (i instanceof Oberteile)
            {
                if (filterAn && nurAngebote && !i.getIstAngebot())
                {
                    continue;
                }

                s = castDouble2String(i.getArtikelnummer());
                printZentriert(s);

                s = castInt2String(i.getArtikelnummer().getGröße());
                printZentriert(s);

                s = castInt2String(i.getArtikelnummer().getGeschlecht());
                printZentriert(s);
               
                 s = castInt2String(i.getArtikelnummer().getStil());
                printZentriert(s);
                
                 s = castInt2String(i.getArtikelnummer().getPreiskategorie());
                printZentriert(s);
                
                 s = castInt2String(i.getArtikelnummer().getPreis());
                printZentriert(s);
                
                 s = castInt2String(i.getArtikelnummer().getLagerbestand());
                printZentriert(s);
                Oberteile o = (Oberteile) i;
                s = castDouble2String(h.getGröße());
                printRechtsbuendig(s);

                s = castDouble2String(i.getPreis());
                printRechtsbuendig(s);

               
                printLF();

            }
        }
        printLF();
    }

    private void showKundenListe()
    {
        String s;

        printZentriert("Kundennummer");
        printZentriert("Vorname");
        printZentriert("Name");
        printZentriert("Telefon");
        printLF();
        printLinieLF(4); // Trennlinie für 6 Felder anzeigen

        Iterator <Kunde>iter = kundenListe.iterator();
        while(iter.hasNext())
        {
            Kunde i  =  iter.next();

            s = castInt2String(i.getKundennummer());
            printZentriert(s);

            printLinksbuendig(i.getVorname());

            printLinksbuendig(i.getName());

            printLinksbuendig(i.getTelefonnummer());

            printLF();
        }
        printLF();
    }

    private void sucheKundeNachNachname()
    {
        String nachname = Stdin.readString("Bitte Nachnamen eingeben, nachdem gesucht werden soll:");

        // wir machen einen Testlauf, ob es überhaupt einen Kunden mit diesem Nachnamen gibt
        boolean treffer = false;
        Iterator <Kunde>iter = kundenListe.iterator();
        while(iter.hasNext())
        {
            Kunde i  =  iter.next();
            if (i.getName().equalsIgnoreCase(nachname)) treffer = true;
        }

        if (!treffer)
        {
            System.out.println("Es gibt keinen Kunden mit dem Nachnamen "+nachname);
        }
        else
        {
            printZentriert("Kundennummer");
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Telefon");
            printLF();
            printLinieLF(4); // Trennlinie für 6 Felder anzeigen

            Iterator <Kunde>iter2 = kundenListe.iterator();
            while(iter2.hasNext())
            {
                Kunde i  =  iter2.next();
                
                // nur die Kunden ausgeben, die dem Suchkriterium entsprechen
                if (i.getName().equalsIgnoreCase(nachname))
                {
                    String s = castInt2String(i.getKundennummer());
                    printZentriert(s);

                    printLinksbuendig(i.getVorname());

                    printLinksbuendig(i.getName());

                    printLinksbuendig(i.getTelefonnummer());

                    printLF();
                }
            }
            printLF();
        }
    }

    private void showSchuhListe()
    {
        String s;

        printZentriert("Artikelnummer");
        printZentriert("Größe");
        printZentriert("Geschlecht");
        printZentriert("Stil");
        printZentriert("Preiskategorie");
        printZentriert("Preis");
        printZentriert("Lagerbestand");
        printLF();
        printLinieLF(6); // Trennlinie für 6 Felder anzeigen

        Iterator <Artikel>iter = artikelListe.iterator();
        while(iter.hasNext())
        {
            Artikel i  =  iter.next();

            s = castInt2String(i.getArtikelnummer());
            printZentriert(s);

            s = castInt2String(i.getKunde().getKundennummer());
            printZentriert(s);

            s = castInt2String(i.getAdresse().getPostleitzahl());
            printZentriert(s);

            if (i instanceof Grundstueck) printZentriert("Grundstueck"); 
            if (i instanceof Wohnung) printZentriert("Wohnung"); 
            if (i instanceof Haus) printZentriert("Haus");

            s = castDouble2String(i.getPreis());
            printRechtsbuendig(s);

            if (i.getIstAngebot()) printZentriert("BIETE");
            else printZentriert("SUCHE");

            printLF();            
        }
        printLF();
    }

    private String castInt2String(int meinInt)
    {
        return Integer.toString(meinInt);
        // die obige Zeile ist von der Funktion identisch zu
        // Integer i = new Integer(meinInt);
        // return i.toString();
    }

    private String castDouble2String(double meinDouble)
    {
        // hier nutzen wir die Format-Anweisung der Klasse String um die Nachkommastellen zu bestimmen etc.
        return String.format("%,8.2f", meinDouble);
    }

    private void printLF()
    {
        System.out.println();
    }

    private void printZentriert(String s)
    {
        System.out.print(baueZentriertenString(s, FELDLAENGE));
    }

    private void printLinksbuendig(String s)
    {
        System.out.print(baueLinksbuendigenString(s, FELDLAENGE));
    }

    private void printRechtsbuendig(String s)
    {
        System.out.print(baueRechtsbuendigenString(s, FELDLAENGE));
    }

    private void printLinieLF(int anzahlFelder)
    {
        /* Besonderheit: hier Nutzung des StringBuilders statt direkt mit String zu arbeiten.
         * Ist sparsamer im Umgang mit Speicher.
         */
        StringBuilder s = new StringBuilder();
        int laenge = anzahlFelder*(FELDLAENGE+3);
        for (int i=1;i<=laenge;i++)
        {
            s=s.append("-");
        }
        System.out.println(s);
    }

    private String baueZentriertenString(String s, int laenge)
    {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge)
        {
            s.substring(0, laenge);
        }
        else
        {
            int differenzLinks = (laenge - s.length())/2;
            for (int i=1;i<=differenzLinks;i++) s=" "+s+" ";
            if (s.length()<laenge) s=s+" ";
        }

        return s+" | ";
    }

    private String baueRechtsbuendigenString(String s, int laenge)
    {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge)
        {
            s.substring(0, laenge);
        }
        else
        {
            int differenzLinks = (laenge - s.length());
            for (int i=1;i<=differenzLinks;i++) s=" "+s;
        }

        return s+" | ";
    }

    private String baueLinksbuendigenString(String s, int laenge)
    {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge)
        {
            s.substring(0, laenge);
        }
        else
        {
            int differenz = (laenge - s.length());
            for (int i=1;i<=differenz;i++) s=s+" ";
        }

        return s+" | ";
    }

    private void printEingabeFehler()
    {
        System.out.print("Ihre Eingabe wurde nicht erkannt.\n");
    }

    private void printAuswahlTreffen()
    {
        System.out.print("Bitte treffen Sie eine Auswahl ...\n");
    }

    private void printProgrammInfo()
    {
        System.out.println("************************************************************");
        System.out.println("* HTW-ImmoPortal v1.0 written by Prof. Dr. Daniel F. Abawi *");
        System.out.println("*                                Oliver Fourman (M.Sc.)    *");
        System.out.println("************************************************************");
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        Verwaltung v = new Verwaltung();

        v.initData();
        v.printProgrammInfo();
        v.mainMenue();        
    }

}
