package domain;

public class Punt implements Comparable {
    private int x;
    private int y;

    public Punt(int X, int Y){
        x = X;
        y = Y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public boolean equals(Object punt){
        if(punt == null || !(punt instanceof Punt)) return false;
        return x == ((Punt)punt).x && y == ((Punt)punt).y;

    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Punt)o);
    }

    public int compareTo(Punt punt) {
        if (punt.x < x || (punt.x >= x && punt.y < y)) {
            return -1;
        } else if ( x == punt.x && y == punt.y) {
            return 0;
        }
        return 1;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
