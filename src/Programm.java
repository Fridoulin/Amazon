import models.Shop;
import models.*;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import static java.lang.System.*;

public class Programm implements Serializable {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        char wahl='a';
        Shop shop = new Shop();
        Einkaufswagen ekw = new Einkaufswagen();
        int produktid, anzahl;
            //1. Benutzer anlegen
        //2. Switch shop öfffnen, warenkorb öffnen, programm beenden,
        char wahlSuchen;
        String Dateiname="Artikels.bin";

        List <Artikel> gefundeneArtikel;
        String _artikelName;

       do {
           out.println("Was wollen Sie machen?");
           out.println("e...Programm beenden");
           out.println("a...Alle Produkte anzeigen");
           out.println("s...Nach Artikel suchen");
           out.println("h...Artikel zu Warenkorb hinzufügen");
           out.println("l...Artikel aus Warenkorb entfernen");
           out.println("b...Waren aus dem Warenkorb ausgeben");
           out.println("z...Bezahlen.");
           wahl=reader.next().toLowerCase().charAt(0);

           switch (wahl) {
               case 's':
                   //z.B. GTX1060 Achtung Groß- und Kleinbuchstaben
                   out.println("Nach was wollen Sie suchen?");
                   out.println("b...Artikel ");
                   out.print("Wahl: ");
                   wahlSuchen = reader.next().toLowerCase().charAt(0);

                   if(wahlSuchen == 'b') {
                       out.print("Artikel: ");
                       _artikelName = reader.next();
                       gefundeneArtikel = shop.findByName(_artikelName);
                       for(int i = 0; i < gefundeneArtikel.size(); i++){
                           out.println("ID: " + gefundeneArtikel.get(i).getId() + " Name: " + gefundeneArtikel.get(i).getName() + " Preis: " + gefundeneArtikel.get(i).getPreis());
                       }
                   }
                   break;
               case 'a':
                   Shop.checkIfArtikelExists();
                    //Funktioniert nicht, habe den Fehler nicht gefunden Exception writeArtikelsInFile "Fehler!!!"
                    // ausgelöst?
                   break;
               case'h':
                   out.println("Welche Produkt-ID wollen Sie hinzufügen?");
                   produktid = reader.nextInt();
                   out.println("Wieviele Artikel wollen Sie hinzufügen?");
                   anzahl=reader.nextInt();
                   shop.wareZuEinkaufswagen(anzahl,produktid);
                   break;
               case'l':
                   out.println("Das Produkt mit welcher Produkt-ID wollen Sie löschen?");
                   produktid = reader.nextInt();
                   out.println("Wieviele Artikel wollen Sie löschen?");
                   anzahl=reader.nextInt();
                   shop.wareEntfernen(anzahl,produktid);
                   //shop.wareLöschen(anzahl,produktid);
                   break;
               case'b':
                   out.print(shop.getBasket().toString());
                   break;
               case'z':
                   String entscheidung, Vorname, Nachname, Plz, Straße, Straßennr, Stadt, Land;
                   Kunde kunde = new Kunde();
                   Adresse adresse1=new Adresse();
                   out.println("Vorname: ");
                   Vorname=reader.next();
                   kunde.setVorname(Vorname);
                   out.println("Nachname: ");
                   Nachname=reader.next();
                   kunde.set_nachname(Nachname);
                   out.println("Plz: ");
                   Plz=reader.next();
                   adresse1.setPlz(Plz);
                   out.println("Straße: ");
                   Straße=reader.next();
                   adresse1.setStraße(Straße);
                   out.println("Straßennr: ");
                   Straßennr=reader.next();
                   adresse1.setstraßennr(Straßennr);
                   out.println("Stadt: ");
                   Stadt = reader.next();
                   adresse1.setStadt(Stadt);
                   out.println("Land: ");
                   Land = reader.next();
                   adresse1.setLand(Land);
                   kunde.addAdrssen(adresse1);
                   out.println();
                   out.print(shop.getBasket().toString());
                   out.println("Sind Sie sicher, dass sie bestellen wollen?[j,n]");
                   entscheidung=reader.next();
                   if(entscheidung.toLowerCase().equals("j")){
                       out.println("Bestellung aufgegeben!");
                       //Bestätigungsemail senden
                       Email email = new Email();
                       //weiter?
               }
               else{
                   out.println("Bestellung nicht aufgegeben!");
                   }

                   break;
           }
       }while(wahl!='e');
        out.println("Programm beendet!");
    }
}
