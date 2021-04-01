package ui;

import domain.Tekening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class FiguurApp {
    private ComboBox<String> keuzeMenu;
    private ObservableList<String> mogelijkeFiguren;

    public FiguurApp(GridPane root, Tekening tekening) {
        //observableArrayLst: veranderingen = JavaFx objecten updaten
        //normale lijst: veranderingen != JavaFx objecten updaten
        mogelijkeFiguren = FXCollections.observableArrayList("Cirkel", "Rechthoek", "Lijnstuk", "Driehoek");
        keuzeMenu = new ComboBox(mogelijkeFiguren);
        root.add(keuzeMenu, 0, 0);

        //doel anonieme functie: kijken wat de waarde is en een app hiervoor opstarten
        keuzeMenu.setOnAction(eventKeuze -> {
            keuzeMenu.setVisible(false);
            if (keuzeMenu.getValue() != null) {
                if (keuzeMenu.getValue().equals("Cirkel")) {
                    new CirkelApp(root, tekening);
                } else if (keuzeMenu.getValue().equals("Rechthoek")) {
                    new RechthoekApp(root, tekening);
                } else if (keuzeMenu.getValue().equals("Lijnstuk")) {
                    new LijnStukApp(root, tekening);
                } else if (keuzeMenu.getValue().equals("Lijnstuk")) {
                    new DriehoekApp(root, tekening);
                }
            }
        });
    }
}

