package domain;

import java.util.ArrayList;
import java.util.Random;

public class WoordenLijst {
    ArrayList <String> Woordenlijst = new ArrayList<>();
    Random randomWoord = new Random();

    public void voegToe(String woord) {
        if (woord == null || woord.length() == 0) {
            throw new DomainException("Woord mag niet leeg zijn");
        }
        if (Woordenlijst.contains(woord)) {
             throw new DomainException("Woord staat reeds in Woordenlijst");
        }
        Woordenlijst.add(woord);
    }

    public int getAantalWoorden() {
       return Woordenlijst.size();
    }

    public String getRandomWoord() {
       return Woordenlijst.get(randomWoord.nextInt(Woordenlijst.size()));
    }
}
