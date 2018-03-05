import java.awt.*;

public class MySquare extends MyRoundedShape {
    public MySquare(int x, int y, int x1, int y1, Color fillColor, Color outlineColor) {
        super(x, y, x1, y1, fillColor, outlineColor);
    }

    @Override
    public void drawShape(Graphics2D graphics) {

        // First I draw the filled rectangle
        graphics.setColor(getFillColor());
        graphics.fillRect(topLeftX(), topLeftY(), width(), width());

        // Then I create outline
        graphics.setColor(getOutlineColor());
        graphics.drawRect(topLeftX(), topLeftY(), width(), width());
    }
}
