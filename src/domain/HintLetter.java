package domain;

public class HintLetter {
    char letter;
    boolean isGeraden;

    public HintLetter(char letter) {
        this.letter = letter;
    }

    public boolean isGeraden() {
        return isGeraden;
    }

    public char getLetter() {
        return letter;
    }

    public boolean raad(char raadLetter) {
        //ik wil niet dat het raden afhangt van ofdat een letter een hoofdletter is of niet, dus ik converteer dit via Character.toLowerCase() langs bijde kanten
        raadLetter = Character.toLowerCase(raadLetter);
        if (raadLetter == Character.toLowerCase(letter) && !isGeraden) {
            isGeraden = true;
            return true;
        }
        return false;
    }

    public char toChar() {
        //de ternary operator is een versimpeling van if/else om iets te setten. In dit geval bepaald deze operator wat er gereturnet wordt (de letter als isGeraden true is, _ als niet)
        return isGeraden ? letter : '_';
    }
}
