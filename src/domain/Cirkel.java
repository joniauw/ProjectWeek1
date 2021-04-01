package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Objects;

public class Cirkel extends Vorm {
    private int radius;
    private Punt middelpunt;

    public Cirkel(Punt middelpunt, int radius) {
        setMiddelpunt(middelpunt);
        setRadius(radius);
    }

    private void setMiddelpunt(Punt middelpunt) {
        if (middelpunt == null) throw new DomainException("middelpunt mag niet null");
        this.middelpunt = middelpunt;
    }

    private void setRadius(int radius) {
        if (radius <= 0) throw new DomainException("radius moet strikt positief zijn");
        this.radius = radius;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Cirkel)) return false;
        else {
            Cirkel cirkel = (Cirkel) o;
            return cirkel.getMiddelpunt().equals(middelpunt) && cirkel.getRadius() == radius;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, middelpunt);
    }

    public String toText() {
        return "Cirkel: middelpunt: " +  middelpunt.toString() + " - straal: " + radius;
    }

    public Omhullende getOmhullende() {
        Punt nieuwStartpunt = new Punt(middelpunt.getX() - radius, middelpunt.getY() - radius);

        return new Omhullende(nieuwStartpunt, radius * 2, radius * 2);
    }

    @Override
    public void teken(Pane pane) {
        Circle cirkel = new Circle(middelpunt.getX(), middelpunt.getY(), radius);
        cirkel.setFill(getKleur());
        cirkel.setStroke(Color.BLACK);
        pane.getChildren().add(cirkel);
    }
}
