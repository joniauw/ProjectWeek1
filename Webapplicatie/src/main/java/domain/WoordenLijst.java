package domain;

import java.util.ArrayList;
import java.util.List;

public class WoordenLijst {
    ArrayList<Woord> list = new ArrayList<>();

    public void voegToe(Woord w) {
        list.add(w);
    }

    public void verwijder(Woord w) {
        list.remove(w);
    }

    public List<Woord> getAllWoorden() {
        return (List<Woord>)list.clone();
    }

    //voeg functies toe voor waarden te berekenen
}
