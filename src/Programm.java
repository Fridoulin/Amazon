import models.Shop;
import models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import static java.lang.System.*;

public class Programm implements Serializable {

    static Shop shop = new Shop();
    static Kunde kunde = new Kunde();
    static Adresse KundenAdresse = new Adresse();
    static Kunde KundeFromFile;
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {

        char wahl = 'a';

        Einkaufswagen ekw = new Einkaufswagen();
        int produktid, anzahl;
        char wahlSuchen;

        String ArtikelDatei = "Artikels.bin";

        String nachname;


        List<Artikel> gefundeneArtikel;
        String _artikelName;
        String accountjaodernein;

        System.out.println("Haben Sie schon einen Account?[j,n]");
        accountjaodernein = reader.nextLine();
        if(accountjaodernein.equals("j")){
            System.out.println("Nachname: ");
            nachname=reader.nextLine();
            File temp1 = new File(nachname + ".bin");
            if(temp1.exists()){
                kunde.set_nachname(nachname);
            }
        else{
                System.out.println("Falsche Eingabe");
                System.exit(0);
            }
        }
        else if (accountjaodernein.equals("n")){
            Kundeneingebenlassen();
            final File KundenFile = new File(kunde.get_nachname() + ".bin");
            if(!KundenFile.exists()){
                createEinkaufswagenDatei();
                createKundenDatei();
                writeKundeInFile();
            }
        }
        else{
            System.out.println("Falsche Eingabe!!!");
            System.exit(0);
        }


        boolean bestellt=false;
        do {
            out.println("Was wollen Sie machen?");
            out.println("e...Programm beenden");
            out.println("a...Alle Produkte anzeigen");
            out.println("s...Nach Artikel suchen");
            out.println("h...Artikel zu Warenkorb hinzufügen");
            out.println("l...Artikel aus Warenkorb entfernen");
            out.println("b...Waren aus dem Warenkorb ausgeben");
            out.println("k...Kundeninfos ausgeben lassen");
            out.println("z...Bezahlen.");
            wahl = reader.next().toLowerCase().charAt(0);

            switch (wahl) {
                case 's':
                    //z.B. GTX1060 Achtung Groß- und Kleinbuchstaben
                    out.println("Nach was wollen Sie suchen?");
                    out.println("b...Artikel ");
                    out.print("Wahl: ");
                    wahlSuchen = reader.next().toLowerCase().charAt(0);

                    if (wahlSuchen == 'b') {
                        out.print("Artikel: ");
                        _artikelName = reader.next();
                        gefundeneArtikel = shop.findByName(_artikelName);
                        for (int i = 0; i < gefundeneArtikel.size(); i++) {
                            out.println("ID: " + gefundeneArtikel.get(i).getId() + " Name: " + gefundeneArtikel.get(i).getName() + " Preis: " + gefundeneArtikel.get(i).getPreis());
                        }
                    }
                    break;
                case 'a':
                    Shop.checkIfArtikelExists();
                    break;
                case 'h':
                    out.println("Welche Produkt-ID wollen Sie hinzufügen?");
                    produktid = reader.nextInt();
                    out.println("Wieviele Artikel wollen Sie hinzufügen?");
                    anzahl = reader.nextInt();
                    shop.wareZuEinkaufswagen(anzahl, produktid);
                    writeEinkaufswageninFile();
                    break;
                case 'l':
                    out.println("Das Produkt mit welcher Produkt-ID wollen Sie löschen?");
                    produktid = reader.nextInt();
                    out.println("Wieviele Artikel wollen Sie löschen?");
                    anzahl = reader.nextInt();
                    shop.wareEntfernen(anzahl, produktid);
                    break;
                case 'b':
                    //out.print(shop.getBasket().toString());
                    System.out.println(loadekw());
                    break;
                case'k':
                    KundeFromFile = loadKunde();
                    System.out.println(KundeFromFile.toString());
                    System.out.println(KundeFromFile.getAdressen());
                    break;
                case 'z':
                    KundeFromFile = loadKunde();
                    System.out.println(KundeFromFile.toString());
                    System.out.println(KundeFromFile.getAdressen());
                    System.out.println(loadekw());
                    String entscheidung;
                    //out.print(shop.getBasket().toString());
                    out.println("Sind Sie sicher, dass sie bestellen wollen?[j,n]");
                    entscheidung = reader.next();
                    if (entscheidung.toLowerCase().equals("j")) {
                        out.println("Bestellung erfolgreich aufgegeben!");
                        bestellt=true;
                        try {
                            Files.delete(Paths.get(kunde.get_nachname() + "ekw.bin"));
                        }
                        catch (IOException e){
                            System.out.println(kunde.get_nachname() + ".bin konnte nicht gelöscht werden!");
                            e.printStackTrace();
                        }

                    } else {
                        out.println("Bestellung nicht aufgegeben!");

                    }
                    break;


            }
        } while (wahl != 'e'&&bestellt==false);
        out.println("Programm beendet!");
    }

    public static void Kundeneingebenlassen() {
        System.out.println("Vorname: ");
        kunde.setVorname(reader.nextLine());
        System.out.println("Nachname: ");
        kunde.set_nachname(reader.nextLine());
        System.out.println("Stadt: ");
        KundenAdresse.setStadt(reader.nextLine());
        System.out.println("PLZ: ");
        KundenAdresse.setPlz(reader.nextLine());
        System.out.println("Strasse: ");
        KundenAdresse.setStraße(reader.nextLine());
        System.out.println("Strassennummer: ");
        KundenAdresse.setstraßennr(reader.nextLine());
        kunde.addAdrssen(KundenAdresse);
    }
    public static void createKundenDatei(){
        try {
            Files.createFile(Paths.get(kunde.get_nachname() + ".bin"));
        }catch (IOException e){
            System.out.println(kunde.get_nachname() + ".bin konnte nicht erzeugt werden");
        }
    }
    public static void writeKundeInFile(){
        //Serialize
        try(FileOutputStream fos = new FileOutputStream(kunde.get_nachname() + ".bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(kunde);
        }
        catch (IOException e){
            System.out.println("Serialisierung hat nicht funktioniert");
            e.printStackTrace();

        }
    }
    public static Kunde loadKunde(){
        //Deserialize
        try(FileInputStream fis = new FileInputStream(kunde.get_nachname() + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (Kunde)ois.readObject();
        }
        catch (IOException e){
            System.out.println("Deserialisierung hat nicht funktioniert");
        }
        catch (ClassNotFoundException e){
            System.out.println("Klasse Person oder Address existiert nicht");
        }
        return null;
    }
    public static void createEinkaufswagenDatei(){
        try {
            Files.createFile(Paths.get(kunde.get_nachname() + "ekw"+".bin"));
        }catch (IOException e){
            System.out.println(kunde.get_nachname() + "ekw" + ".bin konnte nicht erzeugt werden");
        }
    }
    public static void writeEinkaufswageninFile(){
        //Serialize
        try(FileOutputStream fos = new FileOutputStream(kunde.get_nachname() + "ekw" + ".bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(shop.getBasket());
        }
        catch (IOException e){
            System.out.println("Serialisierung hat nicht funktioniert");
            e.printStackTrace();

        }
    }
    public static Einkaufswagen loadekw(){
        //Deserialize
        try(FileInputStream fis = new FileInputStream(kunde.get_nachname() + "ekw"+".bin");
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (Einkaufswagen) ois.readObject();
        }
        catch (IOException e){
            System.out.println("Kein Einkaufswagen vorhanden");
        }
        catch (ClassNotFoundException e){
            System.out.println("Klasse Person oder Address existiert nicht");
        }
        return null;
    }
    }

