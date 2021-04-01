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

        //column & row = positie
        root.add(fill, 0, 1);
        root.add(woord, 0, 2);
        root.add(give, 0, 3);
        root.add(invoer, 0, 4);
        Label l = new Label();
        root.add(l, 0, 0);

        //doel anonieme functie: spel spelen => ingewikkelder, maar invoer.onAction: altijd uitgevoerd op Enter press als op invoer gefocust => handig!
        invoer.setOnAction(e -> {
            //invoer.getText() > 0 & hintwoord.raad(invoer.getText()) & hintwoord.isGeraden() => beëindig spel
            //invoer.getText() > 0 & hintwoord.raad(invoer.getText()) & !hintwoord.isGeraden() => raad letter & update woord;
            //invoer.getText() > 0 & !hintwoord.raad(invoer.getText()) => geef foutmelding
            //invoer.getText < 0 => doe niets
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
