package domain;

public class Punt {
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

    public String toString(){
        return "(" + x + "," + y + ")";
    }

}
