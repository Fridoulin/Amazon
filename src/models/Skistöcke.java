package models;

public class Skistöcke extends Freizeitartikel {
    private double _länge;
    private double _durchmesser;


    public double getlänge() {
        return _länge;
    }
    public void setlänge(double länge) {
        if(länge > 0){
        this._länge = länge;
        }
    }
    public double getdurchmesser() {
        return _durchmesser;
    }
    public void setdurchmesser(double durchmesser) {
        if(durchmesser > 0){
            this._durchmesser = durchmesser;
        }
    }


    public Skistöcke(){this("",0.0,0,"","","",0.0,0.0);}

    public Skistöcke(String marke, double preis, int id,String name,String zustand, String material, double länge, double durchmesser ){
        super(marke, preis, id, name, zustand, material);
        this.setlänge(länge);
        this.setdurchmesser(durchmesser);
    }

    @Override
    public String toString () {return super.toString() +"Länge: "+ this._länge +"Durchmesser: "+ this._durchmesser;}
}
