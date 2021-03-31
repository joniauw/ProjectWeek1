package domain;

import java.util.List;

public class Tekening {

    private String naam;
    private List<Vorm> vormen;
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

    public void voegToe(Vorm vorm) {
        vormen.add(vorm);
    }

    public Vorm getVorm(int index){
        return vormen.get(index);
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void verwijder(Vorm schouwNietInTekening) {
        vormen.remove(schouwNietInTekening);
    }

    public boolean bevat(Vorm deur) {
        return vormen.contains(deur);
    }

    public boolean equals(Object o){
        if(!(o instanceof Vorm)){
            return false;
        }
        Tekening vorm = (Tekening) o;
        return vorm.getAantalVormen() == vormen.size();
    }

    public String toString(){
        return "";
    }




}
