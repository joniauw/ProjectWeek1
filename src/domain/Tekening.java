package domain;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Tekening implements Drawable {

    private String naam;
    private List<Vorm> vormen = new ArrayList<>();
    public static final int MIN_X = 0;
    public static final int MAX_X = 399;
    public static final int MIN_Y = 0;
    public static final int MAX_Y = 399;


    public Tekening(String naamTekening) {
        if(!isValidNaam(naamTekening)){
            throw new IllegalArgumentException("naam van de tekening is null of leeg");
        }
        naam = naamTekening;
    }

    public static boolean isValidNaam(String naamTekening) {
        return naamTekening != null && !naamTekening.trim().isEmpty();
    }

    public String getNaam() {
        return naam;
    }

    //voegt toe enkel als de vorm zijn omhullende binnen de bounds ligt, en als
    public void voegToe(Vorm vorm) {
        Omhullende omhullende = vorm.getOmhullende();
        if (omhullende.getMinimumX() < MIN_X
        || omhullende.getMinimumY() < MIN_Y
        || omhullende.getMaximumX() > MAX_X
        || omhullende.getMaximumY() > MAX_Y)
            throw new DomainException("de omhullende van deze vorm ligt niet binnen de boundaries van de tekening");
        if (bevat(vorm))
            throw new DomainException("deze vorm zit al in de tekening");
        vormen.add(vorm);
    }

    public Vorm getVorm(int index){
        return vormen.get(index);
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void verwijder(Vorm v) {
        vormen.remove(v);
    }

    public boolean bevat(Vorm v) {
        return vormen.contains(v);
    }

    //equalt enkel als de gegeven tekening dezelfde vormen bevat als deze & ze hetzelfde aantal vormen bevatten
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Tekening)){
            return false;
        }

        //voor alle vormen: als deze vorm niet in de meegegeven tekening zit: niet gelijk
        boolean bevatVormen = true;
        Tekening vorm = (Tekening) o;
        for(Vorm v : vormen) {
            if (!vorm.bevat(v)) {
                bevatVormen = false;
            }
        }

        //bevat deze tekening zijn vormen & aantal vormen is gelijk = voldoende voorwaarden
        return bevatVormen && vorm.getAantalVormen() == vormen.size();
    }

    public String toString(){
        String s = "";
        for (Vorm v : vormen) {
            s += v.toString() + "\n";
        }
        return "Tekening:\n" + s;
    }

    @Override
    public void teken(Pane pane) {
        for (Vorm v : vormen) {
            if (v.isZichtbaar())
                v.teken(pane);
        }
    }
}
