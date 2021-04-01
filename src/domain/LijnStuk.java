package domain;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LijnStuk extends Vorm {
    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt startpunt, Punt eindpunt) {
        setStartEnEindPunt(startpunt, eindpunt);
    }

    private void setStartEnEindPunt(Punt startpunt, Punt eindpunt) {
        if (startpunt == null || eindpunt == null) {
            throw new DomainException("Start of eindpunt mag niet null zijn");
        }
        if (startpunt == eindpunt) {
            throw new DomainException("Startpunt is gelijk aan eindpunt");
        }
        this.startPunt = startpunt;
        this.eindPunt = eindpunt;
    }

    public Punt getStartPunt() {
        return this.startPunt;
    }

    public Punt getEindPunt() {
        return this.eindPunt;
    }

    public boolean equals(Object o) {
        if (!(o instanceof LijnStuk)) return false;
        else {
            LijnStuk lijnStuk = (LijnStuk) o;
            return lijnStuk.getStartPunt().equals(this.startPunt) && lijnStuk.getEindPunt().equals(this.eindPunt) ||
                    lijnStuk.getStartPunt().equals(this.eindPunt) && lijnStuk.getEindPunt().equals(this.startPunt);
        }
    }

    public String toText() {
        return "Lijn: startpunt: " + startPunt + " - eindpunt: " + eindPunt;
    }

    public Omhullende getOmhullende() {
        Punt nieuwStartpunt = new Punt(Math.min(startPunt.getX(), eindPunt.getX()), Math.min(startPunt.getY(), eindPunt.getY()));

        return new Omhullende(nieuwStartpunt, Math.abs(eindPunt.getX() - startPunt.getX()), Math.abs(eindPunt.getY() - startPunt.getY()));
    }

    @Override
    public void teken(Pane pane) {
        Line lijn = new Line(startPunt.getX(), startPunt.getY(), eindPunt.getX(), eindPunt.getY());
        lijn.setStrokeWidth(5);
        lijn.setFill(getKleur());
        pane.getChildren().add(lijn);
    }
}
