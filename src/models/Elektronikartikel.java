package models;

public class Elektronikartikel extends Artikel {
    private boolean _RGBTauglich;
    private double _Stromverbrauch;


    public boolean getRGBTauglich() {
        return _RGBTauglich;
    }
    public void setRGBTauglich(boolean RGBTauglich) {
        this._RGBTauglich = RGBTauglich;
    }
    public double getStromverbrauch() {
        return _Stromverbrauch;
    }
    public void setStromverbrauch(double Stromverbrauch) {if (Stromverbrauch > 0) {
        this._Stromverbrauch = Stromverbrauch;}
    }

    //ctors
    public Elektronikartikel(){this("",0.0,0,"",false, 0.0);}

    public Elektronikartikel(String marke, double preis, int id, String name, boolean RGBTauglich, double Stromverbrauch){
        super(marke, preis, id, name);
        this.setRGBTauglich(RGBTauglich);
        this.setStromverbrauch(Stromverbrauch);
    }

    @Override
    public String toString () {return super.toString() +"Stromverbrauch: "+ this._Stromverbrauch +"RGB tauglich: "+ this._RGBTauglich;}

}
