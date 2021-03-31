package domain;

import java.util.Objects;
import domain.Punt;

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

    @Override
    public String toString() {
        return "Rechthoek: linkerbovenhoek: " + linkerbovenhoek.toString() +
                " - breedte: " + breedte +
                " - hoogte: " + hoogte + "\n" +
                getOmhullende().toString();
    }

    public Omhullende getOmhullende() {
        return new Omhullende(linkerbovenhoek, breedte, hoogte);
    }
}
