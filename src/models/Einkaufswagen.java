package models;
import java.util.*;
import java.util.List;


import java.util.ArrayList;

public class Einkaufswagen{

    //private List<Einkaufswagenartikel> _waren = new ArrayList<>();
    private double _versand;
    private double _gesamtPreis;

    List<Einkaufswagenartikel> _einkaufswagenartikel = new ArrayList<Einkaufswagenartikel>();

 //   Einkaufswagenartikel einkaufswagenartikel = new Einkaufswagenartikel();
    public double getVersand() {

        return _versand;
    }
    public void setVersand(double versand) {

        this._versand = versand;
    }

    public double getGesamtPreis() {
        double gesamtPreis = 0.0;

        for (Einkaufswagenartikel a: this._einkaufswagenartikel) {
            gesamtPreis += a.getAnzahl()*a.getArtikel().getPreis();
        }

        // alle Waren durchlaufen und den ges. Preis bestimmen

        return _gesamtPreis;
    }



    public List<Einkaufswagenartikel> getEinkaufswagen() {
        return _einkaufswagenartikel;
    }
    public void addEinkaufswagenartikel(Einkaufswagenartikel einkaufswagenartikel){
        _einkaufswagenartikel.add(einkaufswagenartikel);
    }
    public boolean removeEinkaufswagenartikel(Einkaufswagenartikel einkaufswagenartikel){
        if (_einkaufswagenartikel.remove(einkaufswagenartikel)) {
            return true;
        }
        else{
            return false;
        }
    }

    //public void addWaren(Einkaufswagenartikel waren){_waren.add(waren);}



    public Einkaufswagen() {this(0.0);}
    public  Einkaufswagen (double versand){

        this._versand = versand;
    }


    @Override
    public String toString () {
        String s = "";

        for(Einkaufswagenartikel a:this._einkaufswagenartikel){
            s+= a.toString() + "\n";
        }
            return s;
    }



}

