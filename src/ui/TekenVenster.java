package ui;

import domain.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class TekenVenster {
    private Tekening tekening;

    public TekenVenster(Pane root, Tekening tekening){
        if (tekening == null) throw new UiException();
        this.tekening = tekening;
        this.teken(root);
    }

    public void teken(Pane root) {

        Cirkel boomkruin = new Cirkel(new Punt(50,50), 40);
        boomkruin.setKleur(Color.GREEN);
        LijnStuk boomstam = new LijnStuk(new Punt(50,90), new Punt(50,240));
        Rechthoek gebouw = new Rechthoek(new Punt(100, 90), 100, 150);
        Driehoek dak = new Driehoek(new Punt(100, 90), new Punt(200, 90), new Punt(150, 45));
        dak.setKleur(Color.RED);

        Tekening tekening = new Tekening("huis");
        tekening.voegToe(boomkruin);
        tekening.voegToe(boomstam);
        tekening.voegToe(gebouw);
        tekening.voegToe(dak);

        tekening.teken(root);
    }
}

