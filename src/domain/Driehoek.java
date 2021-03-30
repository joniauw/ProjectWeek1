package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        ArrayList <Punt> puntenLijst = new ArrayList<>();

        puntenLijst.add(hoekPunt1);
        puntenLijst.add(hoekPunt2);
        puntenLijst.add(hoekPunt3);

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

    public String toString() {
        return "Driehoek: Hoekpunt 1: (" + hoekPunt1.getX() + ", " + hoekPunt1.getY() +
                ") - Hoekpunt 2: (" + hoekPunt2.getX() + ", "+ hoekPunt2.getY() +
                ") - Hoekpunt 3: (" + hoekPunt3.getX() + ", "+ hoekPunt3.getY() + ")";
    }
}
