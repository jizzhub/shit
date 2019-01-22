
 
package outfittery;
/**
 * Die KLasse Schuhe ist eine Spezialisierung eines Artikels.
 * @author loreen
 * @version v1 - Dezember 2018
 */

public class Schuhe extends Artikel
{
    /**
     * Standardkonstruktor (eigentlich nur notwendig für die XML-Speicherung)
     */
    public Schuhe()
    {
    }
    

    /**
     * Konstruktor der Klasse Schuhe mit sechs Parametern
     * @param preis Preis, eines Oberteiles
     * @param größe Größe, des Oberteiles
     * @param preiskategorie gewünschte Höhe des Preises
     * @param geschlecht Geschlecht, welches dieses Oberteil tragen kann
     * @param lageranzahl vorhandener Lagervorrat dieses Oberteils
     * @param stil gewünschter Stil (sportlich, business,freizeit?)
     * @param beschreibung
     */
    public Schuhe(double preis,int größe, int preiskategorie,int geschlecht, int lageranzahl, int stil, String beschreibung)
    {
        super(preis, größe, preiskategorie, geschlecht, lageranzahl, stil, beschreibung);
    }
}