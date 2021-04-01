package domain;

import ui.TekeningHangMan;

public class HangMan {
    Speler speler;
    TekeningHangMan hangMan;
    WoordenLijst woordenLijst;
    HintWoord hintWoord;
    boolean gewonnen;

    public HangMan(Speler speler, WoordenLijst woordenlijst) {

        this.woordenLijst = woordenlijst;
        hangMan = new TekeningHangMan();

        if (speler == null) {
            throw new DomainException("speler mag niet leeg zijn");
        }
        this.speler = speler;

        if (woordenlijst == null || woordenlijst.getAantalWoorden() == 0) {
            throw new DomainException("woordenlijst mag niet leeg zijn");
        }

        hintWoord = new HintWoord(woordenlijst.getRandomWoord());
    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return hangMan;
    }

    public String getHint() {
        return hintWoord.toString();
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public boolean isGameOver() {
        if (hangMan.getAantalOnzichtbaar() == 0) {
            return true;
        }
        return false;
    }

    public boolean raad(char c) {
        if (!hintWoord.raad(c)) {
            hangMan.zetVolgendeZichtbaar();
            return false;
        }

        if (hintWoord.isGeraden()) {
            gewonnen = true;
            return true;
        }
        return true;
    }
}
