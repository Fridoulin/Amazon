package models;

public class Milch extends Lebensmittel {
    //fields
    private double _zuckergehalt;
    private double _menge;

    //get/set


    public double getZuckergehalt() {
        return _zuckergehalt;
    }
    public void setZuckergehalt(double zuckergehalt) {
        this._zuckergehalt = zuckergehalt;
    }
    public double getMenge() {
        return _menge;
    }
    public void setMenge(double menge) {
        this._menge=menge;
    }
    //ctors
    public Milch(){
        this("", 0.0, 0, "", 0, 0.0, 0.0, 0.0);
    }
    public Milch(String marke, double preis, int id, String name, double kalorien, double fettgehalt, double zuckergehalt, double menge){
        super(marke, preis, id, name, kalorien, fettgehalt);
        this.setZuckergehalt(zuckergehalt);
        this.setMenge(menge);
    }
    @Override
    public String toString(){
        return super.toString()+ "Zuckergehalt: " + this._zuckergehalt + "Menge: "+ this._menge;
    }
}
