import java.awt.*;

public class MyRectangle extends MyRoundedShape {
    public MyRectangle(){
        super();
    }

    public MyRectangle(int x, int y, int x1, int y1, Color color, Color fill) {
        super(x, y, x1, y1, color, fill);
    }

    @Override
    public void drawShape(Graphics graphics){
        graphics.setColor(getFillColor());
        graphics.fillRect(getX1(), getY1(), getX2(), getY2());

        graphics.setColor(getOutlineColor());
        graphics.drawRect(getX1(), getY1(), getX2(), getY2());
    }

}
