package domain;

public abstract class Vorm {
    @Override
    public String toString() {
        return toText() + " - " + getOmhullende().toString();
    }

    public abstract Omhullende getOmhullende();

    public abstract String toText();
}
