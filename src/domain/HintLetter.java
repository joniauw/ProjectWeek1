package domain;

public class HintLetter {
    char letter;
    boolean isGeraden;

    public HintLetter(char letter) {
        if (letter == ' ') isGeraden = true;
        this.letter = letter;
    }

    public boolean isGeraden() {
        return isGeraden;
    }

    public char getLetter() {
        return letter;
    }

    //zet de letters om naar lowercase & probeert ze te raden
    public boolean raad(char raadLetter) {
        //isGeraden == false & raadLetter == letter: return true
        //isGeraden == true & raadLetter == letter: return false
        //raadLetter != letter: return false
        raadLetter = Character.toLowerCase(raadLetter);
        if (raadLetter == Character.toLowerCase(letter) && !isGeraden) {
            isGeraden = true;
            return true;
        }
        return false;
    }

    public char toChar() {
        //hetzelfde als: if (isGeraden) return letter; else return '_';
        return isGeraden ? letter : '_';
    }
}
