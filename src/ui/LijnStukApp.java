package ui;

import domain.LijnStuk;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnStukApp {
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public LijnStukApp(GridPane root) {
        Label lsx = new Label("Geef de x coordinaat in voor het startpunt van het lijnstuk");
        TextField tfsx = new TextField();
        Label lsy = new Label("Geef de y coordinaat in voor het startpunt van het lijnstuk");
        TextField tfsy = new TextField();
        Label lex = new Label("Geef de x coordinaat in voor het eindpunt van het lijnstuk");
        TextField tfex = new TextField();
        Label ley = new Label("Geef de y coordinaat in voor het eindpunt van het lijnstuk");
        TextField tfey = new TextField();

        root.add(lsx, 0, 0);
        root.add(tfsx, 1, 0);

        tfsx.setOnAction(e -> {
            try {
                Integer.parseInt(tfsx.getText());

                root.add(lsy, 0, 1);
                root.add(tfsy, 1, 1);
            }
            catch(Exception ex) {
                tfsx.clear();

                foutenboodschap.setTitle("Foute start x");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de start x waarde");
                foutenboodschap.showAndWait();
            }
        });

        tfsy.setOnAction(e -> {
            try {
                Integer.parseInt(tfsx.getText());

                root.add(lex, 0, 2);
                root.add(tfex, 1, 2);
            }
            catch(Exception ex) {
                tfsy.clear();

                foutenboodschap.setTitle("Foute start y");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de start y waarde");
                foutenboodschap.showAndWait();
            }
        });

        tfex.setOnAction(e -> {
            try {
                Integer.parseInt(tfex.getText());

                root.add(ley, 0, 3);
                root.add(tfey, 1, 3);
            }
            catch(Exception ex) {
                tfex.clear();

                foutenboodschap.setTitle("Foute x");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de eind x waarde");
                foutenboodschap.showAndWait();
            }
        });

        tfey.setOnAction(e -> {
            try {
                LijnStuk lijnStuk = new LijnStuk(new Punt(Integer.parseInt(tfsx.getText()), Integer.parseInt(tfsy.getText())),new Punt(Integer.parseInt(tfex.getText()), Integer.parseInt(tfey.getText())));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnStuk.toString());
                root.add(uitvoer, 0, 0);
            }
            catch(Exception ex) {
                tfsx.clear();

                foutenboodschap.setTitle("Foute x");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de eind Y waarde");
                foutenboodschap.showAndWait();
            }
        });
    }
}
