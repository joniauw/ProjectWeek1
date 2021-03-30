package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DriehoekApp {
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public DriehoekApp(GridPane root) {
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

        // TODO: 30/03/2021   Onderstaande code graag eens nakijken aub

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
        tfay.setOnAction(e -> {
            try {
                Integer.parseInt(tfbx.getText());

                root.add(lcx, 0, 5);
                root.add(tfcx, 1, 5);
            }
            catch(Exception ex) {
                tfcy.clear();

                foutenboodschap.setTitle("Foute tweede y");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de tweede y waarde");
                foutenboodschap.showAndWait();
            }
        });

        //3de x
        tfbx.setOnAction(e -> {
            try {
                Integer.parseInt(tfbx.getText());

                root.add(lby, 0, 4);
                root.add(tfby, 1, 4);
            }
            catch(Exception ex) {
                tfbx.clear();

                foutenboodschap.setTitle("Foute derde x");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de derde x waarde");
                foutenboodschap.showAndWait();
            }
        });

        // 3de y
        tfay.setOnAction(e -> {
            try {
                Integer.parseInt(tfbx.getText());

                root.add(lcx, 0, 5);
                root.add(tfcx, 1, 5);
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
