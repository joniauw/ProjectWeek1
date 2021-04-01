package db;

import domain.WoordenLijst;

import java.io.File;
import java.util.Scanner;

public class WoordenLezer {
    WoordenLijst gelezenLijst = new WoordenLijst();

    public WoordenLezer(String woordTxt) {
        try {
            File file = new File(woordTxt);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String s = scanner.next();
                System.out.println(s);
                gelezenLijst.voegToe(s);
            }
        } catch (Exception fileNotFound) {
        }
    }

    public WoordenLijst getGelezenLijst() {
        return gelezenLijst;
    }

    public WoordenLijst lees() {
        return gelezenLijst;
    }
}
