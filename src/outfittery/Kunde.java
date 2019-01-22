
package outfittery;

 /**
 * Die Klasse Kunde ist ein einfaches Modell eines Kunden des OutfitteryPortals.
 *
 * @author Loreen
 * @version v1 - Dezember 2018
 */
public class Kunde
{
    // hier stehen die Instanzvariablen, sie haben Geltung in dem gesamten Objekt
    // (können innerhalb des Objektes mit this.ATTRIBUTNAME angesprochen werden)
    private static int kundencounter= 1000;
    private int kundennummer;
    private String telefonnummer;
    private String name;
    private String vorname;

    /**
     * Standardkonstruktor
     */
    public Kunde()
    {
    }

    /**
     * Konstruktor der Klasse Kunde mit drei Parametern
     * @param vorname Vorname des Kunden
     * @param name Nachname des Kunden
     * @param telefonnummer Telefonnummer des Kunden
     */
    public Kunde(String vorname, String name, String telefonnummer)
    {
        this.vorname = vorname;
        this.name = name;
        this.telefonnummer = telefonnummer;
        this.kundennummer = kundencounter;
        kundencounter++;
    }

    /**
     * Methode setzt die Telefonnummer des Kunden neu.
     * @param telefonnummer Die Telefonnummer des Kunden.
     */
    public void setTelefonnummer(String telefonnummer)
    {
        this.telefonnummer = telefonnummer;
    }

    /**
     * Methode gibt die Telefonnummer des Kunden zurueck.
     * @return telefonnummer
     */
    public String getTelefonnummer()
    {
        return this.telefonnummer;
    }

    /**
     * Methode setzt den Vornamen des Kunden neu.
     * @param vorname Der Vorname des Kunden.
     */
    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    /**
     * Methode gibt den Vornamen des Kunden zurueck.
     * @return vorname
     */
    public String getVorname()
    {
        return this.vorname;
    }    

    /**
     * Methode setzt den Nachnamen des Kunden neu.
     * @param name Nachname des Kunden.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Methode gibt den Nachnamen des Kunden zurueck.
     * @return name
     */
    public String getName()
    {
        return this.name;
    }       


    /**
     * Methode gibt die eindeutige ID des Kunden zurueck.
     * @return id
     */
    public int getKundennummer()
    {
        return this.kundennummer;
    }

    /**
     * Methode setzt die eindeutige ID des Kunden neu.
     * Diese Methode sollte nicht benutzt werden, da dann evtl.
     * doppelte ID vorkommen könnten.
     * @param kundennummer Die Kundennummer des Kunden.
     */
    public void setKundenummer(int kundennummer)
    {
        this.kundennummer = kundennummer;
    }
}
   

