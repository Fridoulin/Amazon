package models;

public class Bier extends Lebensmittel{
    //fields
    private boolean _weizen;
    private boolean _alkoholfrei;

    //get/set

    public boolean isWeizen() {
        return _weizen;
    }

    public void setWeizen(boolean weizen) {
        this._weizen=weizen;
    }

    public boolean isAlkoholfrei() {
        return _alkoholfrei;
    }

    public void setAlkoholfrei(boolean alkoholfrei) {
        this._alkoholfrei=alkoholfrei;
    }

    //ctors
    public Bier(){
        this("", 0.0, 0, "",0.0,0.0, false, false);
    }
    public Bier(String marke, double preis, int id, String name, double kalorien, double fettgehalt, boolean weizen, boolean alkoholfrei){
        super(marke, preis, id, name ,kalorien, fettgehalt);
        this.setWeizen(weizen);
        this.setAlkoholfrei(alkoholfrei);
    }
    @Override
    public String toString(){
        return super.toString() + "Weizen: " + this._weizen + "Alkoholfrei: " + this._alkoholfrei;
    }
}
