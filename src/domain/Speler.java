package domain;

import java.util.Objects;

public class Speler {
    private String naam;
    private int Score;

    public Speler(String naam) {
        if (naam == null || naam.trim().length() == 0) {
            throw new DomainException("Naam mag niet leeg zijn");
        }
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public int getScore() {
        return Score;
    }

    public void addToScore(int Score) {
        if ((this.Score + Score) <= 0) {
            throw new DomainException("score mag niet kleiner zijn dan 0");
        }
        this.Score += Score;
    }

    public boolean equals(Object o) {
        if (o instanceof Speler) {
            return naam.equals(((Speler) o).naam) && Score == ((Speler) o).Score;
        }
        return false;
    }

    public String toString() {
        return naam + " heeft als score " + Score;
    }

}