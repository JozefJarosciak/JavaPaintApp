import java.awt.*;

public class MyTriangle extends MyRoundedShape {
    public MyTriangle(int x, int y, int x1, int y1, Color color, Color fill) {
        super(x, y, x1, y1, color, fill);
    }

    @Override
    public void drawShape(Graphics graphics) {

        int x[] = {getX1(), getX2(), getX1() + ((getX2() - getX1()) / 2)};
        int y[] = {getY1(), getY1(), getY1() - ((getX2() - getX1()) / 2)};

        int n = 3;

        graphics.setColor(getFillColor());
        graphics.fillPolygon(x, y, n);

        graphics.setColor(getOutlineColor());
        graphics.drawPolygon(x, y, n);
    }
}
