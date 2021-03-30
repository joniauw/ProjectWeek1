package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LijnStukApp {
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public LijnStukApp(GridPane root) {
        Label lx = new Label("Geef de x coordinaat in voor het startpunt van het lijnstuk");
        TextField tfx = new TextField();
        Label ly = new Label("Geef de y coordinaat in voor het eindpunt van het lijnstuk");
        TextField tfy = new TextField();

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
                foutenboodschap.setContentText("Je moet een getal ingeven voor de X en Y waarde");
                foutenboodschap.showAndWait();
            }
        });
    }
}
