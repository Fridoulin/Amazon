import models.Shop;
import models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import static java.lang.System.*;

public class Programm implements Serializable {


    static Kunde kunde = new Kunde();
    static Adresse KundenAdresse = new Adresse();
    static Kunde KundeFromFile;
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Files.delete(Paths.get("Kunde.bin"));
        }catch (IOException e){
            System.out.println("Datei Kunde.bin hat nicht existiert");
        }
        char wahl = 'a';
        Shop shop = new Shop();
        Einkaufswagen ekw = new Einkaufswagen();
        int produktid, anzahl;
        char wahlSuchen;

        String ArtikelDatei = "Artikels.bin";


        List<Artikel> gefundeneArtikel;
        String _artikelName;

        Kundeneingebenlassen();
        createKundenDatei();
        writeKundeInFile();


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
                    break;
                case 'l':
                    out.println("Das Produkt mit welcher Produkt-ID wollen Sie löschen?");
                    produktid = reader.nextInt();
                    out.println("Wieviele Artikel wollen Sie löschen?");
                    anzahl = reader.nextInt();
                    shop.wareEntfernen(anzahl, produktid);
                    break;
                case 'b':
                    out.print(shop.getBasket().toString());
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
                    String entscheidung;
                    out.print(shop.getBasket().toString());
                    out.println("Sind Sie sicher, dass sie bestellen wollen?[j,n]");
                    entscheidung = reader.next();
                    if (entscheidung.toLowerCase().equals("j")) {
                        out.println("Bestellung erfolgreich aufgegeben!");
                        bestellt=true;

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
            Files.createFile(Paths.get("Kunde.bin"));
        }catch (IOException e){
            System.out.println("Kunde.bin konnte nicht erzeugt werden");
        }
    }
    public static void writeKundeInFile(){
        //Serialize
        try(FileOutputStream fos = new FileOutputStream("Kunde.bin");
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
        try(FileInputStream fis = new FileInputStream("Kunde.bin");
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
}