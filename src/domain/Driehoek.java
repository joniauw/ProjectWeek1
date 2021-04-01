package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Driehoek extends Vorm {
    private Punt hoekPunt1;
    private Punt hoekPunt2;
    private Punt hoekPunt3;

    public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
        if (punt1 == null || punt2 == null || punt3 == null) {
            throw new DomainException("Punt mag niet leeg zijn");
        } else if (punt1.equals(punt2) || punt2.equals(punt3) || punt3.equals(punt1)) {
            throw new DomainException("Punten mogen niet samen vallen");
        } else if (liggenOp1Lijn(punt1, punt2, punt3)) {
            throw new DomainException("Punten mogen niet op 1 lijn liggen");
        }

        this.hoekPunt1 = punt1;
        this.hoekPunt2 = punt2;
        this.hoekPunt3 = punt3;

        sorteerHoekpunten();
    }

    public Punt getHoekPunt1() {
        return hoekPunt1;
    }

    public Punt getHoekPunt2() {
        return hoekPunt2;
    }

    public Punt getHoekPunt3() {
        return hoekPunt3;
    }

    private boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3) {
        return (punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY()) ==
                (punt3.getX() - punt1.getX()) * (punt2.getY() - punt1.getY());
    }

    private void sorteerHoekpunten() {
        // hoekPunt1.compareTo(hoekPunt2) && hoekPunt2.compareTo(hoekPunt3) && hoekPunt3.compareTo(hoekPunt1)
        // -1 => 2 komt na 1, blijft onverandert
        // 0 => kijken naar y-waarde
        // 1 => 1 komt na 2, volgorde wisselt

        //we beginnen met een lijst aan te maken die we gaan sorteren, en we voegen alle hoekpunten hieraan toe
        ArrayList<Punt> puntenLijst = new ArrayList<>();

        puntenLijst.add(hoekPunt1);
        puntenLijst.add(hoekPunt2);
        puntenLijst.add(hoekPunt3);

        //we steunen op de Comparable interface zijn toCompare methode hier om alle elementen te sorteren
        //na het sorteren weten we dat de waarden in puntenLijst gesorteerd zijn, en geven we deze gesorteerde lijst terug aan de hoekpunten
        Collections.sort(puntenLijst);

        hoekPunt1 = puntenLijst.get(0);
        hoekPunt2 = puntenLijst.get(1);
        hoekPunt3 = puntenLijst.get(2);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driehoek driehoek = (Driehoek) o;
        return Objects.equals(hoekPunt1, driehoek.hoekPunt1) && Objects.equals(hoekPunt2, driehoek.hoekPunt2) && Objects.equals(hoekPunt3, driehoek.hoekPunt3);
    }

    public String toText() {
        return "Driehoek: Hoekpunt 1: " + hoekPunt1.toString() +
                " - Hoekpunt 2: " + hoekPunt2.toString() +
                " - Hoekpunt 3: " + hoekPunt3.toString();
    }

    public Omhullende getOmhullende() {
        // StartPunt bepalen
        int minimumX = Math.min(hoekPunt1.getX(), hoekPunt2.getX());
        int minimumY = Math.min(hoekPunt1.getY(), hoekPunt2.getY());
        minimumX = Math.min(minimumX, hoekPunt3.getX());
        minimumY = Math.min(minimumY, hoekPunt3.getY());

        // EindPunt bepalen
        int maximumX = Math.max(hoekPunt1.getX(), hoekPunt2.getX());
        int maximumY = Math.max(hoekPunt1.getY(), hoekPunt2.getY());
        maximumX = Math.max(maximumX, hoekPunt3.getX());
        maximumY = Math.max(maximumY, hoekPunt3.getY());

        // Lijnstuk maken
        Punt nieuwStartpunt = new Punt(minimumX, minimumY);
        Punt eindPunt = new Punt(maximumX, maximumY);

        LijnStuk nieuwLijnstuk = new LijnStuk(nieuwStartpunt, eindPunt);

        return nieuwLijnstuk.getOmhullende();
    }

    @Override
    public void teken(Pane pane) {
        Polyline driehoek = new Polyline();
        driehoek.setFill(Color.RED);
        driehoek.setStroke(Color.BLACK);
        driehoek.getPoints().addAll(new Double[]{ (double) hoekPunt1.getX(), (double) hoekPunt1.getY(), (double) hoekPunt2.getX(),
                (double) hoekPunt2.getY(), (double) hoekPunt3.getX(), (double) hoekPunt3.getY()});
        driehoek.setFill(getKleur());
        driehoek.setStroke(Color.BLACK);
        pane.getChildren().add(driehoek);
    }
}
