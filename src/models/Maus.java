package models;

public class Maus extends Elektronikartikel{
    private boolean _Kabellos;
    private int _Maustasten;

    public boolean getKabellos() {
        return _Kabellos;
    }
    public void setKabellos(boolean Kabellos) {
        this._Kabellos = Kabellos;
    }
    public int getMaustasten() {
        return _Maustasten;
    }
    public void setMaustasten(int maustasten) {
        if(maustasten>=2) {
            this._Maustasten = maustasten;
        }
    }
    public Maus(){
    this("", 0.0, 0,"", false, 0.0, false, 2);
    }
    public Maus(String marke, double preis, int id, String name, boolean RGBTauglich, double stromverbrauch, boolean kabellos, int maustasten){
        super(marke, preis, id, name, RGBTauglich, stromverbrauch);
        this.setKabellos(kabellos);
        this.setMaustasten(maustasten);
    }

    @Override
    public String toString(){
        return super.toString() + "Kabellos: " + this.getKabellos() + "Maustasten: " + this.getMaustasten();
    }
}
