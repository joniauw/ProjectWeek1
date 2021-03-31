package ui;

import domain.Driehoek;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public DriehoekApp(GridPane root) {
        //het idee achter deze labels & textfields is dat het 1 per 1 de inputs aan u geeft, zodat je gemakkelijker kan begrijpen waar de error zit
        //bvb: lax & tfax zijn de javafx onderdelen die instaan voor het aan de gebruiker duidelijk maken dat die de x coordinaat van de eerste driehoek meegeeft

        Label lax = new Label("Geef de x coordinaat in voor het eerste hoekpunt van de driehoek");
        TextField tfax = new TextField();
        Label lay = new Label("Geef de y coordinaat in voor het eerste hoekpunt van de driehoek");
        TextField tfay = new TextField();
        Label lbx = new Label("Geef de x coordinaat in voor het tweede hoekpunt van de driehoek");
        TextField tfbx = new TextField();
        Label lby = new Label("Geef de y coordinaat in voor het tweede hoekpunt van de driehoek");
        TextField tfby = new TextField();
        Label lcx = new Label("Geef de x coordinaat in voor het derde hoekpunt van de driehoek");
        TextField tfcx = new TextField();
        Label lcy = new Label("Geef de y coordinaat in voor het derde hoekpunt van de driehoek");
        TextField tfcy = new TextField();

        root.add(lax, 0, 0);
        root.add(tfax, 1, 0);

        //setOnAction is een functie die een anonieme functie als parameter neemt (of een lambda expressie, dat betekent hetzelfde)
        //bij textfields wordt deze uitgeroepen als je op enter drukt terwijl die textbox gefocust is
        //we roepen hierin aan dat ze de volgende kolom moeten weergeven, maar ook dat ze de geldigheid van de eerste kolom nakijken
        //try/catch vangt exceptions up, en we weten dat parseInt een numberformatexception geeft indien het geen getal binnenkrijgt, dus die vangen we op & daar geven we dan een alert voor
        //deze volgende paar lijnen zijn definities voor wat er gebeurt als er op enter wordt gedrukt, en ze zien er allemaal een beetje hetzelfde uit. parseInt check -> voeg toe of geef alert
        //bij de laatste is het wat ingewikkelder, ik zal daar ook een voetnoot bijschrijven
        //overal had je deze code al goed geschreven, enkel had je een aantal textfields door elkaar gehaald. Mijn naming scheme is nogal kortaf, dus als je deze wilt aanpassen naar meer verbose namen is dat ook goed

        // 1ste x
        tfax.setOnAction(e -> {
            try {
                Integer.parseInt(tfax.getText());

                root.add(lay, 0, 1);
                root.add(tfay, 1, 1);
            }
            catch(Exception ex) {
                tfax.clear();

                foutenboodschap.setTitle("Foute eerste x");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de eerste x waarde");
                foutenboodschap.showAndWait();
            }
        });

        // 1ste y
        tfay.setOnAction(e -> {
            try {
                Integer.parseInt(tfax.getText());

                root.add(lbx, 0, 2);
                root.add(tfbx, 1, 2);
            }
            catch(Exception ex) {
                tfay.clear();

                foutenboodschap.setTitle("Foute eerste y");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de eerste y waarde");
                foutenboodschap.showAndWait();
            }
        });

        //2de x
        tfbx.setOnAction(e -> {
            try {
                Integer.parseInt(tfbx.getText());

                root.add(lby, 0, 4);
                root.add(tfby, 1, 4);
            }
            catch(Exception ex) {
                tfbx.clear();

                foutenboodschap.setTitle("Foute tweede x");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de tweede x waarde");
                foutenboodschap.showAndWait();
            }
        });

        // 2de y
        tfby.setOnAction(e -> {
            try {
                Integer.parseInt(tfbx.getText());

                root.add(lcx, 0, 5);
                root.add(tfcx, 1, 5);
            }
            catch(Exception ex) {
                tfby.clear();

                foutenboodschap.setTitle("Foute tweede y");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de tweede y waarde");
                foutenboodschap.showAndWait();
            }
        });

        //3de x
        tfcx.setOnAction(e -> {
            try {
                Integer.parseInt(tfbx.getText());

                root.add(lcy, 0, 6);
                root.add(tfcy, 1, 6);
            }
            catch(Exception ex) {
                tfbx.clear();

                foutenboodschap.setTitle("Foute derde x");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de derde x waarde");
                foutenboodschap.showAndWait();
            }
        });

        //hier proberen we een nieuwe driehoek aan te maken. In dit geval mag je try catch een beetje uitgebreider zijn, dat je gemakkelijker de fout kan opsporen, maar dit is niet persé nodig hier
        //root.getChildren geeft je de directe lijst in root's gegevens terug, dus kan je deze clearen & root's children wipen
        //de rest is vrij vanzelfsprekend
        //indien er nog vragen zijn, stel ze mij of een coach gerust
        // 3de y
        tfcy.setOnAction(e -> {
            try {
                Driehoek driehoek = new Driehoek(new Punt(Integer.parseInt(tfax.getText()), Integer.parseInt(tfay.getText())),
                        new Punt(Integer.parseInt(tfbx.getText()), Integer.parseInt(tfby.getText())),
                        new Punt(Integer.parseInt(tfcx.getText()), Integer.parseInt(tfcy.getText())));

                root.getChildren().clear();
                Text t = new Text(driehoek.toString());
                root.add(t, 0, 0);
            }
            catch(Exception ex) {
                tfcy.clear();

                foutenboodschap.setTitle("Foute derde y");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de derde y waarde");
                foutenboodschap.showAndWait();
            }
        });
    }
}
