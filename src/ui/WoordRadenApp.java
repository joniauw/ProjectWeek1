package ui;

import domain.HintWoord;
import domain.Speler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WoordRadenApp {
    public WoordRadenApp(GridPane root, Speler speler) {
        HintWoord hintwoord = new HintWoord("testwoord");

        Label fill = new Label("Wow een woord! Wat zou het zijn?"), woord = new Label(hintwoord.toString()), give = new Label("Geef hier letters in");
        TextField invoer = new TextField();
        //een belangrijk ding is dat je alles mooi sorteert in de rows & columns. Stel het je voor als een tabel waarvan je de lengte & breedte kan aanpassen
        //hier had ik enkel rows nodig. De volgorde waarin je ze toevoegt is niet van belang, zolang je ze maar in de juiste plaatsen laat staan in de tabel
        root.add(fill, 0, 1);
        root.add(woord, 0, 2);
        root.add(give, 0, 3);
        root.add(invoer, 0, 4);
        Label l = new Label();
        root.add(l, 0, 0);

        //een beetje ingewikkeldere anonieme functie, maar dezelfde principes gelden
        //een belangrijk ding in anonieme functies is dat je enkel nieuwe objecten mag manipuleren die binnen de scope bestaan, dus moet je setters & getters gebruiken voor informatie hierbinnen
        //hier kijk ik eerst ofdat de lengte van de invoer > 0 is, en dan raad ik een letter. Indien deze geraden is, dan update ik mijn woord, clear ik de invoer, en check ik ofdat het HELE woord geraden is.
        //als dit zo is, wipe ik het hele blad en plaats ik een label erop. Indien niet, update ik gewoon de label op de top van de gridpane.
        //als de letter niet geraden is, pas ik ook de label aan, maar met een andere text.
        invoer.setOnAction(e -> {
            if (invoer.getText().length() > 0) {
                if(hintwoord.raad(invoer.getText().charAt(0))) {
                    woord.setText(hintwoord.toString());
                    invoer.clear();
                    if (hintwoord.isGeraden()){
                        root.getChildren().clear();
                        l.setText("Je hebt het woord gevonden! Het woord was " + hintwoord.getWoord());
                        root.add(l, 0, 0);
                    }
                    else {
                        l.setText("Goed gedaan! Dat was correct gegokt!");
                    }
                }
                else {
                    l.setText("Ai... Probeer nog eens!");;
                }
            }
        });
    }
}
