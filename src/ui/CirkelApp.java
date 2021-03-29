package ui;

import domain.Cirkel;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CirkelApp {
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public CirkelApp(GridPane root) {
        Label lx = new Label("Geef de x coordinaat in voor het middelpunt van de cirkel");
        TextField tfx = new TextField();
        Label ly = new Label("Geef de y coordinaat in voor het middelpunt van de cirkel");
        TextField tfy = new TextField();
        Label lr = new Label("Geef de straal in voor het middelpunt van de cirkel");
        TextField tfr = new TextField();

        root.add(lx, 0, 0);
        root.add(tfx, 1, 0);

        tfx.setOnAction(e -> {
            try {
                Integer.parseInt(tfx.getText());

                root.add(ly, 0, 1);
                root.add(tfy, 1, 1);
            }
            catch(Exception ex) {
                tfx.clear();

                foutenboodschap.setTitle("Foute x");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de X waarde");
                foutenboodschap.showAndWait();
            }
        });

        tfy.setOnAction(e -> {
            try {
                Integer.parseInt(tfy.getText());

                root.add(lr, 0, 2);
                root.add(tfr, 1, 2);
            }
            catch(Exception ex){
                tfx.clear();

                foutenboodschap.setTitle("Foute y");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de Y waarde");
                foutenboodschap.showAndWait();
            }
        });

        tfr.setOnAction(e -> {
            try {
                Cirkel cirkel = new Cirkel(new Punt(Integer.parseInt(tfx.getText()), Integer.parseInt(tfy.getText())), Integer.parseInt(tfr.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(cirkel.toString());
                root.add(uitvoer, 0, 0);
            }
            catch(Exception ex) {
                tfx.clear();

                foutenboodschap.setTitle("Foute radius");
                foutenboodschap.setContentText("Je moet een strikt positief getal ingeven voor de radius waarde");
                foutenboodschap.showAndWait();
            }
        });
    }
}
