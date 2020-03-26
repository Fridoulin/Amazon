package models;

public class Grafikkarte extends Elektronikartikel{
    public double _taktrate;
    public int _pinanzahl;

    public double getTaktrate() {
        return _taktrate;
    }
    public void setTaktrate(double taktrate) {
        this._taktrate = taktrate;
    }
    public int getPinanzahl() {
        return _pinanzahl;
    }
    public void setPinanzahl(int pinanzahl) {
        this._pinanzahl = pinanzahl;
    }

    public Grafikkarte(){this("", 0.0, 0,"", false, 0.0, 0.0, 0);}
    public Grafikkarte(String marke, double preis, int id, String name, boolean RGBTauglich, double stromverbrauch, double taktrate, int pinanzahl){
        super(marke, preis, id, name, RGBTauglich, stromverbrauch);
        this.setTaktrate(taktrate);
        this.setPinanzahl(pinanzahl);
    }
    @Override
    public String toString(){
        return super.toString() + "Taktrate: " + getTaktrate() + "Pinanzahl: " + getPinanzahl();
    }

}
