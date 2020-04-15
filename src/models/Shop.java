package models;

import java.nio.file.Files;
import java.util.*;
import java.util.List;
import java.io.*;
import java.nio.file.*;

public class Shop implements Serializable{

    private Einkaufswagen _basket = new Einkaufswagen();
    private static List<Artikel> _artikels = createArticlesForShop();
    private List<Artikel> _hinzugefügteArtikel = new ArrayList<>();
    public List<Artikel> getArtikel() {
        return _artikels;
    }
    public Einkaufswagen getBasket(){
        return this._basket;
    }

    public void wareZuEinkaufswagen(int anzahl, int id){

        for(Artikel a:_artikels){
            if(a.getId()==(id)){
                _basket.addEinkaufswagenartikel(new Einkaufswagenartikel(a, anzahl));
            }
        }
    }
    public void wareEntfernen(int anzahl, int id){
        for(Einkaufswagenartikel a:_basket.getEinkaufswagen()){
            if(a.getArtikel().getId()==(id)){
                //for(int i = 0; i < _basket.getEinkaufswagen().size(); i++){
                //  Einkaufswagenartikel ew = _basket.getEinkaufswagen().get(i);

                if(a.getAnzahl() - anzahl > 0) {
                    a.setAnzahl(a.getAnzahl() - anzahl);
                }
                else{
                    _basket.removeEinkaufswagenartikel(a);
                }

            }
        }
    }

    /*public void wareLöschen(int anzahl, int id){
        for(Artikel a:_waren){
            if(a.getId()==(id)){
                _basket.removeEinkaufswagenartikel((a, anzahl));
            }
        }
    }*/


    public boolean addArtikel(Artikel artikel){
        if(this._artikels.add(artikel)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean removeArtikel(Artikel arikel){
        if(this._artikels.remove(arikel)){
            return true;
        }
        else{
            return false;
        }
    }
    /*
    public Artikel searchforKategories{
        switch(wahl)

    }*/
    /*public Shop(){
        this._artikels = createArticlesForShop();
    }*/
    public Shop(){

    }
    static String artikelDatei = "Artikels.bin";

    private static List<Artikel>  createArticlesForShop() {
        List<Artikel> artikels = new ArrayList<>();
        artikels.add(new Bier("Zipfer", 3.50, 1, "Märzen", 214.9, 1, false, false));
        artikels.add(new Bier("Stiegl", 3.80, 2, "Goldbräu", 243.2, 1, false, false));
        artikels.add(new Bier("Paulaner", 4.40, 3, "Weizen", 341, 1, true, false));
        artikels.add(new Milch("Tirol Milch", 1.35, 4, "Bergbauernmilch", 655, 320, 50, 1));
        artikels.add(new Milch("Zillertal Milch", 1.50, 5, "Frischmilch", 670, 375, 67, 1));

        artikels.add(new Maus("Roccat", 80, 6, "Kone XTD", true, 1, false, 11));
        artikels.add(new Maus("Razer", 50, 7, "Deathadder", true, 0.5, false, 6));
        artikels.add(new Grafikkarte("AMD", 180, 9, "Radeon RX580", true, 185, 1257, 14));
        artikels.add(new Grafikkarte("Nvidia", 250, 10, "GTX1060", true,120, 1645, 8));

        artikels.add(new Fahrrad("KTM", 2456.90, 11, "Macina", "neu", "Aluminium", false, 29, Unterstützung.out));
        artikels.add(new Fahrrad("Lector", 2306.90, 12, "9 GX 19", "neu", "Carbon", true, 28, Unterstützung.out));
        artikels.add(new Skistöcke("Leki", 59.96, 13, "Leki Worldcup Racing Lite GS", "neu", "Aluminium", 120, 16));
        artikels.add(new Skistöcke("Atomic", 69.78, 14, "AMT Carbon SQS 18/19", "neu", "Carbon", 125, 16));

        return artikels;
    }
    public List <Artikel> findByName(String artikelName) {
        List<Artikel> foundArtikel = new ArrayList<>();
        for (Artikel a : this._artikels) {
            if (a.getName().toLowerCase().contains(artikelName.toLowerCase())) {
                foundArtikel.add(a);
            }
        }
        return foundArtikel;
    }
    public static void checkIfArtikelExists (){
        List<Artikel> ArtikelFromFile;
        final File Artikelfile = new File("./Artikels.bin");
        if(!Artikelfile.exists()){
            createArtikelDatei();
            writeArtikelsInFile();
            ArtikelFromFile = loadArtikel();

            for(int i=0;i<ArtikelFromFile.size();i++){
                System.out.println(ArtikelFromFile.get(i));
            }
        }
        else {
            ArtikelFromFile= loadArtikel();
            for(int i=0;i<ArtikelFromFile.size();i++){
                System.out.println(ArtikelFromFile.get(i));
            }
        }
    }

    public static void writeArtikelsInFile(){
        //Serialize
        try(FileOutputStream fos = new FileOutputStream(artikelDatei);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(_artikels);
        }
        catch (IOException e){
            System.out.println("Serialisierung hat nicht funktioniert");
            e.printStackTrace();

        }
    }

    public static List<Artikel> loadArtikel(){
        //deserialize
        try(FileInputStream fis = new FileInputStream(artikelDatei);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<Artikel>)ois.readObject();
        }

        catch (IOException e){
            e.printStackTrace();
            System.out.println("Laden hat nicht funktioniert!");
        }
        catch(ClassNotFoundException e){
            System.out.println("Klasse existiert nicht!");
        }
        return null;
    }

    /*public static void printArtikels(){
        try {
            String content = Files.readString(Paths.get(artikelDatei));
            System.out.println(content);
        }catch (IOException e){
            System.out.println("Fehler: Text konnte nicht in der Datei abgeleget werden!");
        }
    }*/
    // besseren Methodennamen verwenden
    public static void createArtikelDatei(){
        try {
            Files.createFile(Paths.get("Artikels.bin"));
        }catch (IOException e){
            // sinnvolle Fehlermeldung angeben
            System.out.println("Artikels.bin konnte nicht erzeugt werden");
        }
    }


    /*public static void printArtikels(){
        // in allgemeinen Klassen sollte nichts ausgegeben werden -> dadurch kann diese Methode in jeder Anwendung
        //  (nicht nur Konsoleanwendung) verwendet werden
        //      => die Ausgabe der Artikel funktionierte schon vorher richtig
        try {
            String content = Files.readString(Paths.get(artikelDatei));
            System.out.println(content);
        }catch(IOException e){
            System.out.println("Dateiinhalt konnte nicht gelesen werden!");
        }
    }*/

    /*public String Artikelausgeben(int idnummer){
        String s="";
        for(Artikel a : this._artikels){
            if(a.getId().equals(idnummer)){
                s += a.getId() + " " + a.getName()  +  " " + a.getPreis();
            }
        }
        return s;
    }*/
    @Override
    public String toString(){
        String s = "";


        for(Artikel a : this._artikels){
            s += a.getId() + " " + a.getName()  +  " " + a.getPreis() + "\n";
        }
        return s;

    }
}