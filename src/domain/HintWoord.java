package domain;

import java.util.Arrays;

public class HintWoord {
    HintLetter[] hintwoord;
    String woord;

    public HintWoord(String hintwoord) {
        if (hintwoord == null || hintwoord.length() == 0) throw new DomainException("woord mag niet leeg of null zijn");
        //ik sla het woord op naast de hintletter array, omdat ik graag het hele woord direct zou willen klaarhebben voor getWoord (wat een string is)
        //daarnaast maak ik het woord dat is meegegeven volledig lowercase (maar dit is niet nodig en is gewoon voor veiligheids concerns)
        this.hintwoord = new HintLetter[hintwoord.length()];
        for (int i = 0; i < hintwoord.length(); i++) {
            this.hintwoord[i] = new HintLetter(Character.toLowerCase(hintwoord.charAt(i)));
        }

        this.woord = hintwoord.toLowerCase();
    }

    public boolean raad(char letter) {
        //een letter raden in hangman betekent dat je elke letter die voorkomt in het woord weergeeft, dus raad je voor elke letter een keer
        //ik mag wel niet stoppen totdat elke letter raad heeft uitgevoerd, dus ik moet raad bijhouden in een locale variabele of deze geraden is
        boolean raad = false;
        for (HintLetter el : hintwoord) {
            boolean temp = el.raad(letter);
            if (raad == false) raad = temp;
        }
        return raad;
    }

    public boolean isGeraden() {
        //het woord is geraden als elke letter geraden is
        //DUS als er één letter niet geraden is, mag deze niet doordoen
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
