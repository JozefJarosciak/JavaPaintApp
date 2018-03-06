import java.awt.*;

public class MyOval extends MyRoundedShape {
    public MyOval(int x, int y, int x1, int y1, Color color, Color fill) {
        super(x, y, x1, y1, color, fill);
    }

    @Override
    public void drawShape(Graphics graphics){
        graphics.setColor(getOutlineColor());
        if(!getFillColor().equals(Color.WHITE)) {
            graphics.fillOval(getX1(), getY1(), getX2(), getY2());
        }else {
            graphics.drawOval(getX1(), getY1(), getX2(), getY2());
        }
    }
}
