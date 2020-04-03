package models;

import java.io.Serializable;

public class Fahrrad extends Freizeitartikel implements Serializable {
    private boolean _fußantrieb;
    private double _reifgröße;
    private Unterstützung _unterstützung;

    public boolean getfußantrieb() {
        return _fußantrieb;
    }
    public void setfußantrieb(boolean fußantrieb) {
        this._fußantrieb = fußantrieb;
    }
    public double getreifgröße() {
        return  _reifgröße;
    }
    public void setreifgröße (double reifgröße) {
        if (reifgröße > 0){
            this._reifgröße = reifgröße;
        }
    }
    public Unterstützung getunterstützung() {
        return _unterstützung;
    }
    public void setunterstützung (Unterstützung unterstützung) {
        this._unterstützung = unterstützung;
    }

    public Fahrrad(){this("",0.0,0,"", "","",false,0.0, Unterstützung.out);}

    public Fahrrad(String marke, double preis, int id, String name, String zustand, String material, boolean fußantrieb, double reifgröße, Unterstützung unterstützung ){
        super(marke, preis, id, name, zustand, material);
        this.setfußantrieb(fußantrieb);
        this.setreifgröße(reifgröße);
        this.setunterstützung(unterstützung);
    }

    @Override
    public String toString () {return super.toString() +"Unterstützung: "+ this._unterstützung +"Reifengröße: "+ this._reifgröße +"Fußantrieb: "+ this._fußantrieb;}
}
