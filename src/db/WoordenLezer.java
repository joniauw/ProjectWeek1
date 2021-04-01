package db;

import domain.WoordenLijst;

import java.io.File;
import java.util.Scanner;

public class WoordenLezer {
    WoordenLijst gelezenLijst = new WoordenLijst();

    public WoordenLezer(File woordTxt) {
        try {
            Scanner scanner = new Scanner(woordTxt);

            while (scanner.hasNext()) {
                gelezenLijst.voegToe(scanner.next());
            }
        } catch (Exception fileNotFound) {
        }
    }

    public WoordenLijst getGelezenLijst() {
        return gelezenLijst;
    }

    public String lees() {
        return gelezenLijst.getRandomWoord();
    }
}
