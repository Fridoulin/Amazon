package models;

import java.io.Serializable;

public class Lebensmittel extends Artikel implements Serializable {
    //fields
    private double _kalorien;
    private double _fettgehalt;

    //get/set
    public double getKalorien(){
        return this._kalorien;
    }
    public void setKalorien(double kalorien){
        this._kalorien = kalorien;
    }
    public double getFettgehalt() {
        return _fettgehalt;
    }
    public void setFettgehalt(double fettgehalt) {
        this._fettgehalt = fettgehalt;
    }
    //c-tors
    public Lebensmittel(){
        this("", 0.0, 0, "", 0.0, 0.0);
    }
    public Lebensmittel(String marke, double preis, int id, String name, double kalorien, double fettgehalt){
        super(marke, preis, id, marke);
        this.setKalorien(kalorien);
        //this._Kalorien = Kalorien;
        this.setFettgehalt(fettgehalt);
    }
    @Override
    public String toString () {return super.toString() + "Kalorien: "+ this._kalorien + "Fettgehalt: "+ this._fettgehalt;}


}
