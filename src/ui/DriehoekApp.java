package ui;

import domain.Driehoek;
import domain.Punt;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DriehoekApp {
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public DriehoekApp(GridPane root, Tekening tekening) {
        //label + textfield = een input voor de constructor van een Driehoek
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

        //voeg eerste input pair too aan root
        root.add(lax, 0, 0);
        root.add(tfax, 1, 0);

        //anonieme functie als parameter: in dit geval een "public void <zonder_naam>(EventHandler e)"
        //waarom? functies opslaan als data: heel handig! Gebruiker is niet benodigd om methodes te overriden in klassen, kan deze gewoon on the spot aanmaken
        //keten van calls: tfax.onAction -> tfay.onAction -> tfbx.onAction -> tfby.onAction -> tfcx.onAction -> tfcy.onAction

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

        //doel van deze anonieme functie: resultaat van inputs weergeven (deze staat aan de bodem van de keten van calls, dus er volgt niets op)
        // 3de y
        tfcy.setOnAction(e -> {
            try {
                Driehoek driehoek = new Driehoek(new Punt(Integer.parseInt(tfax.getText()), Integer.parseInt(tfay.getText())),
                        new Punt(Integer.parseInt(tfbx.getText()), Integer.parseInt(tfby.getText())),
                        new Punt(Integer.parseInt(tfcx.getText()), Integer.parseInt(tfcy.getText())));

                root.getChildren().clear();
                new FiguurApp(root, tekening);
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
