package ui;

import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RechthoekApp {
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public RechthoekApp(GridPane root, Tekening tekening) {
        Label lx = new Label("Geef de x coordinaat in voor de linkerbovenhoek van de rechthoek");
        TextField tfx = new TextField();
        Label ly = new Label("Geef de y coordinaat in voor de linkerbovenhoek van de rechthoek");
        TextField tfy = new TextField();
        Label lb = new Label("Geef de breedte in voor de rechthoek");
        TextField tfb = new TextField();
        Label lh = new Label("Geef de hoogte in voor de rechthoek");
        TextField tfh = new TextField();

        root.add(lx,  0, 0);
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

                root.add(lb, 0, 2);
                root.add(tfb, 1, 2);
            }
            catch(Exception ex){
                tfy.clear();

                foutenboodschap.setTitle("Foute y");
                foutenboodschap.setContentText("Je moet een getal ingeven voor de Y waarde");
                foutenboodschap.showAndWait();
            }
        });

        tfb.setOnAction(e -> {
            try {
                Integer.parseInt(tfb.getText());

                root.add(lh, 0, 3);
                root.add(tfh, 1, 3);
            }
            catch(Exception ex){
                tfb.clear();

                foutenboodschap.setTitle("Foute breedte");
                foutenboodschap.setContentText("Je moet een strikt positief getal ingeven voor de breedte");
                foutenboodschap.showAndWait();
            }
        });

        tfh.setOnAction(e -> {
            try {
                Rechthoek rechthoek = new Rechthoek(new Punt(Integer.parseInt(tfx.getText()), Integer.parseInt(tfy.getText())), Integer.parseInt(tfb.getText()), Integer.parseInt(tfh.getText()));
                root.getChildren().clear();

                new FiguurApp(root, tekening);
            }
            catch(Exception ex) {
                tfh.clear();

                foutenboodschap.setTitle("Foute hoogte");
                foutenboodschap.setContentText("Je moet een strikt positief getal ingeven voor de hoogte");
                foutenboodschap.showAndWait();
            }
        });
    }
}
