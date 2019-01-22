package outfittery;
/*
 * Die Klasse Artikel ist die Basisklasse aller unserer Artikelobjekte.
 * Sie ist abstrakt, da aus den Subklassen Objekte erzeugt werden sollen, nicht aber auf Basis dieser Klasse.
 * 
 * @author Loreen Gerard
 * @version v1 - Dezember 2018
 */
 

public abstract class Artikel 
{ //Instanzvariablen
    private int artikelnummer;
    private double preis;
    private int lageranzahl;
    private int größe;
    private int preiskategorie;
    private int geschlecht;
    private int stil;
    private String beschreibung;
    
    
    
 // Statische Variablen
  
 private static int artnr_counter = 1000;
 
  public Artikel()
  {
  }
  /** 
   *@param par1 ist der Preis
   * @param par2 ist die Preiskategorie
   * @param par3 ist das Geschlecht
   * @param par4 ist der Stil
   * @param par5 ist die Lageranzahl
   * @param par6 ist die Größe des Kleidungsstücks
   * @param par7 ist die Beschreibung
   */
  public Artikel(double par1,int par2, int par3,int par4, int par5, int par6, String par7)
    { this.artikelnummer = Artikel.artnr_counter;
        artnr_counter = artnr_counter + 1;
       this.preis=par1;
       this.preiskategorie=par2;
       this.geschlecht=par3;
       this.stil=par4;
       this.lageranzahl=par5;
       this.größe=par6;
       this.beschreibung =par7;
       
    }
  public void setArtikelnummer(int artikelnummer)
    {
        this.artikelnummer = artikelnummer;
    }
    
    public double getArtikelnummer()
    {
        return this.artikelnummer;
 
    }
public void setPreis(double preis)
    {
        this.preis = preis;
    }
    
    public double getPreis()
    {
        return this.preis;
 
    }
    
public void setGeschlecht(int geschlecht)
    {
        this.geschlecht = geschlecht;
    }
    
public int getGeschlecht()
    {
        return this.geschlecht;
    }
public void setStil(int stil)
    {
        this.stil = stil;
    }
    
public int getStil()
           
    {
        return this.stil;
    }
public void setPreiskategorie(int preiskategorie)
    {
        this.preiskategorie = preiskategorie;
    }
    
public int getPreiskategorie()
    {
        return this.preiskategorie;
 
    }
public void setLageranzahl(int lageranzahl) 
    {
        this.lageranzahl = lageranzahl;
    }
    
public double getLageranzahl()
    {
        return this.lageranzahl;
 
    }
public void setGröße(int größe)
    {
        this.größe = größe;
    }
    
public double getGröße()
    {
        return this.größe;
 
    }
public String getBeschreibung()
{ return this.beschreibung;
}

public void setBeschreibung( String beschreibung)
{

    this.beschreibung = beschreibung;
}
}
    


