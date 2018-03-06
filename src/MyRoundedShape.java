import java.awt.*;

abstract class MyRoundedShape extends MyShape {
    private Color fillColor;
    public MyRoundedShape(){
        super();
        fillColor = Color.WHITE;
    }
    public MyRoundedShape(int x, int y, int x1, int y1, Color color, Color fillColor){
        super(x, y, x1, y1, color);
        this.fillColor = fillColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * gets the upper left x
     */
    public int topLeftX()
    {
        return Math.min(getX1(), getY1());
    }

    /**
     * gets the upper left y
     */
    public int topLeftY()
    {
        return Math.min(getX2(), getY2());
    }

    /**
     * gets width
     */
    public int width()
    {
        return Math.abs(getX1()- getX2());
    }

    //Accessor methods

    /**
     * gets height
     */
    public int height()
    {
        return Math.abs(getY1()- getY2());
    }

    abstract public void drawShape(Graphics g);
}
