import java.awt.*;

public class MySquare extends MyRoundedShape {
    public MySquare(int x, int y, int x1, int y1, Color color, Color fill) {
        super(x, y, x1, y1, color, fill);
    }

    @Override
    public void drawShape(Graphics graphics) {
        graphics.setColor(getFillColor());
        graphics.fillRect(getX1(), getY1(), width(), width());

        graphics.setColor(getOutlineColor());
        graphics.drawRect(getX1(), getY1(), width(), width());
    }
}
