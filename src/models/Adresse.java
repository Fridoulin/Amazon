package models;

import java.io.Serializable;

public class Adresse implements Serializable {
    private String _plz;
    private String _straße;
    private String _straßennr;
    private String _stadt;
    private String _land;


    public String straßennr(){
        return _straßennr;
    }
    public void setstraßennr(String straßennr){
        this._straßennr = straßennr;
    }
    public String getstadt(){
        return _stadt;
    }
    public void setStadt(String stadt){
        this._stadt=stadt;
    }
    public String getLand(){
        return _land;
    }
    public void setLand(String land){
        this._land=land;
    }
    public String getPlz(){
        return _plz;
    }
    public void setPlz(String PLZ){
        this._plz = PLZ;
    }
    public String getStraße(){
        return _straße;
    }
    public void setStraße(String Straße){
        this._straße = Straße;
    }
    public Adresse(){
        this("", "", "", "", "");
    }
    public Adresse(String PLZ, String straße, String straßennr,String stadt, String land) {
        this.setPlz(PLZ);
        this.setStraße(straße);
        this.setLand(land);
        this.setStadt(stadt);
        this.setstraßennr(straßennr);
    }
    @Override
    public String toString(){
        return super.toString() + "PLZ: " + this.getPlz() + "Straße: " + this.getStraße();
    }
}
