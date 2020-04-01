package models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Kunde implements Serializable {

    Einkaufswagen einkaufswagen = new Einkaufswagen();

    private List <Adresse> _adressen = new ArrayList<>();
    private String _vorname;
    private String _nachname;


    public String getVorname() {
        return _vorname;
    }
    public void setVorname(String vorname) {
        this._vorname = vorname;
    }

    public String get_nachname() {
        return _nachname;
    }
    public void set_nachname(String _nachname) {
        this._nachname = _nachname;
    }

    public List<Adresse> getAdressen() {

        return _adressen;
    }

    public void addAdrssen(Adresse adressen){

        _adressen.add(adressen);
    }
    public boolean removeWaren(Adresse adresse){
        if (_adressen.remove(adresse)) {
            return true;
        }
        else{
            return false;
        }
    }
}
