package domain;

import java.util.Objects;

public class Omhullende {
    int breedte, hoogte;
    Punt positieLinksBoven;

    public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
        setBreedte(breedte);
        setHoogte(hoogte);
        setPositieLinksBoven(positieLinksBoven);
    }

    private void setBreedte(int breedte) {
        if (breedte < 0) throw new DomainException("breedte mag niet 0 of kleiner dan 0 zijn");
        this.breedte = breedte;
    }

    private void setHoogte(int hoogte) {
        if (hoogte < 0) throw new DomainException("hoogte mag niet 0 of kleiner dan 0 zijn");
        this.hoogte = hoogte;
    }

    private void setPositieLinksBoven(Punt positieLinksBoven) {
        if (positieLinksBoven == null) throw new DomainException("positieLinksBoven mag niet 0 of kleiner dan 0 zijn");
        this.positieLinksBoven = positieLinksBoven;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return positieLinksBoven;
    }

    public int getMaximumX() {
        return positieLinksBoven.getX() + breedte;
    }

    public int getMaximumY() {
        return positieLinksBoven.getY() + hoogte;
    }

    public int getMinimumX() {
        return positieLinksBoven.getX();
    }

    public int getMinimumY() {
        return positieLinksBoven.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Omhullende omhullende = (Omhullende) o;
        return breedte == omhullende.breedte &&
                hoogte == omhullende.hoogte &&
                positieLinksBoven.equals(omhullende.positieLinksBoven);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedte, hoogte, positieLinksBoven);
    }

    @Override
    public String toString() {
        return "Omhullende: " + positieLinksBoven.toString() +
                " - " + breedte +
                " - " + hoogte;
    }
}
