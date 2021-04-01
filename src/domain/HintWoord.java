package domain;

public class HintWoord {
    HintLetter[] hintwoord;
    String woord;

    public HintWoord(String hintwoord) {
        if (hintwoord == null || hintwoord.length() == 0) throw new DomainException("woord mag niet leeg of null zijn");
        //getWoord() = woord
        //toString() = hintwoord

        this.hintwoord = new HintLetter[hintwoord.length()];
        for (int i = 0; i < hintwoord.length(); i++) {
            this.hintwoord[i] = new HintLetter(Character.toLowerCase(hintwoord.charAt(i)));
        }

        this.woord = hintwoord.toLowerCase();
    }

    //roept raad aan voor elke letter
    public boolean raad(char letter) {
        //geen hintletter.raad(letter) == true: return false
        //1 of meer hintletter.raad(letter) == true: return true
        boolean raad = false;
        for (HintLetter el : hintwoord) {
            boolean temp = el.raad(letter);
            if (raad == false) raad = temp;
        }
        return raad;
    }

    //roept isGeraden aan voor elke letter TOT het een letter vind die false geeft voor isGeraden
    public boolean isGeraden() {
        //geen hintletter.raad(letter) == false: return true
        //1 of meer hintletter.raad(letter) == false: return false
        boolean raad = true;
        for (HintLetter el : hintwoord) {
            if (!el.isGeraden()) return false;
        }
        return true;
    }

    public String getWoord() {
        return woord;
    }

    @Override
    public String toString() {
        String s = "";
        for (HintLetter el : hintwoord) {
            s += el.toChar() + " ";
        }
        return s.trim();
    }
}
