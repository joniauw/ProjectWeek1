package domain;

public class Woord {
    boolean moeilijk;
    String woord;

    public Woord(String woord) {
        this.woord = woord;
    }

    public void setMoeilijk(boolean isMoeilijk) {
        moeilijk = isMoeilijk;
    }

    public boolean isMoeilijk() {
        return moeilijk;
    }

    public String getWoord() {
        return woord;
    }
}
