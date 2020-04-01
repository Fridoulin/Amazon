package models;

import java.io.Serializable;

public class Freizeitartikel extends Artikel implements Serializable {

    private String _zustand;
    private String _material;

    public String getzustand() {
        return _zustand;
    }
    public void setzustand(String zustand) {
        this._zustand = zustand;
    }
    public String getmaterial() {
        return _material;
    }
    public void setmaterial(String material) {
        this._material = material;
    }
    public Freizeitartikel(){this("",0.0,0,"","", "" );}

    public Freizeitartikel(String marke, double preis, int id, String name, String zustand, String material){
        super(marke, preis, id, name);
        this.setzustand(zustand);
        this.setmaterial(material);
    }

    @Override
    public String toString () {return super.toString() +"Zustand: "+ this._zustand +"Material: "+ this._material;}
}
