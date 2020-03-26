package models;

public class Einkaufswagenartikel{
    private Artikel _artikel;
    private int _anzahl;

    public Artikel getArtikel() {
        return _artikel;
    }
    public void setArtikel(Artikel Artikel){
        this._artikel = Artikel;
    }

    public int getAnzahl() {
        return _anzahl;
    }

    public void setAnzahl(int anzahl) {
        if(anzahl >= 0) {
            this._anzahl = anzahl;
        }
    }

    public Einkaufswagenartikel() {this(null,0);}

    public Einkaufswagenartikel(Artikel artikel, int anzahl){
        this.setAnzahl(anzahl);
        this.setArtikel(artikel);
    }

    @Override
    public String toString () {

        return String.format("%10d %40s %10.2f %10d %10.2f", this._artikel.getId(), this._artikel.getName(), this._artikel.getPreis(),
                this._anzahl, (this._artikel.getPreis()*this._anzahl));
    }


}
