package models;

public abstract class Artikel {
    private String _marke;
    private double _preis;
    private  int _id;
    private String _name;

    public String getMarke() {
        return _marke;
    }
    public void setMarke(String marke) {
        this._marke = marke;
    }

    public double getPreis() {
        return _preis;
    }
    public void setPreis(double preis) {
        if(preis >= 0) {
            this._preis = preis;
        }
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        if(id >= 0) {
            this._id = id;
        }
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public Artikel() {this("",0.0,0, "");}

    public Artikel(String marke, double preis, int id, String name) {
        this.setMarke(marke);
        this.setPreis(preis);
        this.setId(id);
        this.setName(name);
    }

    @Override
    public String toString() {
        return this.getMarke() +" "+ this.getId() +" "+this.getPreis() + " " + this.getName();
    }
}
