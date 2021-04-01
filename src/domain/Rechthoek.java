package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Rechthoek extends Vorm {
    private int breedte, hoogte;
    private Punt linkerbovenhoek;

    public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte) {
        setBreedte(breedte);
        setHoogte(hoogte);
        setLinkerBovenhoek(linkerbovenhoek);
    }

    private void setBreedte(int breedte) {
        if (breedte <= 0) throw new DomainException("breedte mag niet 0 of kleiner dan 0 zijn");
        this.breedte = breedte;
    }


    private void setHoogte(int hoogte) {
        if (hoogte <= 0) throw new DomainException("hoogte mag niet 0 of kleiner dan 0 zijn");
        this.hoogte = hoogte;
    }


    private void setLinkerBovenhoek(Punt linkerbovenhoek) {
        if (linkerbovenhoek == null) throw new DomainException("linkerbovenhoek mag niet 0 of kleiner dan 0 zijn");
        this.linkerbovenhoek = linkerbovenhoek;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerbovenhoek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rechthoek rechthoek = (Rechthoek) o;
        return breedte == rechthoek.breedte &&
                hoogte == rechthoek.hoogte &&
                linkerbovenhoek.equals(rechthoek.linkerbovenhoek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedte, hoogte, linkerbovenhoek);
    }

    public String toText() {
        return "Rechthoek: linkerbovenhoek: " + linkerbovenhoek.toString() +
                " - breedte: " + breedte +
                " - hoogte: " + hoogte;
    }

    public Omhullende getOmhullende() {
        return new Omhullende(linkerbovenhoek, breedte, hoogte);
    }

    @Override
    public void teken(Pane pane) {
        Rectangle rect = new Rectangle(linkerbovenhoek.getX(), linkerbovenhoek.getY(), breedte, hoogte);
        rect.setFill(getKleur());
        rect.setStroke(Color.BLACK);
        pane.getChildren().add(rect);
    }
}
