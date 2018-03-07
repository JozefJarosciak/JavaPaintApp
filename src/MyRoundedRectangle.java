import java.awt.*;

public class MyRoundedRectangle extends MyRoundedShape {

    public MyRoundedRectangle(int x, int y, int x1, int y1, Color color, Color fill) {
        super(x, y, x1, y1, color, fill);
    }

    @Override
    public void drawShape(Graphics graphics) {

        // First I draw the filled rectangle
        graphics.setColor(getFillColor());
        graphics.fillRoundRect(getX1(), getY1(), width(), height(), 20, 20);

        graphics.setColor(getOutlineColor());
        graphics.drawRoundRect(getX1(), getY1(), width(), height(), 20, 20);

    }

}


