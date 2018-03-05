import java.awt.*;

abstract class MyShape {
    private int coordinate1, coordinate2, coordinate3, coordinate4;
    private Color outlineColor, fillColor;

    //create a constructor for the myshape class instance
    public MyShape() {
        coordinate1 = 0;
        coordinate2 = 0;
        coordinate3 = 0;
        coordinate4 = 0;
    }

    public MyShape(int coordinate1, int coordinate2, int coordinate3, int coordinate4, Color fillColor, Color outlineColor) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
        this.coordinate3 = coordinate3;
        this.coordinate4 = coordinate4;
        this.fillColor = fillColor;
        this.outlineColor = outlineColor;
    }

    public int getX1() {
        return coordinate1;
    }

    public int getY1() {
        return coordinate2;
    }


    public int getX2() {
        return coordinate3;
    }


    public int getY2() {
        return coordinate4;
    }


    public Color getOutlineColor() {
        return outlineColor;
    }


    public Color getFillColor() {
        return fillColor;
    }

    public void drawShape(Graphics2D graphics) {
    }

}

