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
