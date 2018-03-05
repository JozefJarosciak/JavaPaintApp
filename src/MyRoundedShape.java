import java.awt.*;

abstract class MyRoundedShape extends MyShape {
    public MyRoundedShape(){
        super();
    }
    public MyRoundedShape(int x, int y, int x1, int y1, Color fillColor, Color outlineColor  ){
        super(x, y, x1, y1, fillColor, outlineColor );
    }

    public int topLeftX() {
        return Math.min(getX1(), getX2());
    }

    public int topLeftY() {
        return Math.min(getY1(), getY2());
    }

    public int width() {
        return Math.abs(getX2()- getX1()); }

    public int height() {
        return Math.abs(getY2()- getY1());
    }

}
