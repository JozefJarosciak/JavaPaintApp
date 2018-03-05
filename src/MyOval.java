import java.awt.*;

public class MyOval extends MyRoundedShape {
    public MyOval(int x, int y, int x1, int y1, Color fillColor, Color outlineColor) {
        super(x, y, x1, y1, fillColor, outlineColor);
    }

    @Override
    public void drawShape(Graphics2D graphics) {

        // First I draw the filled MyOval
        graphics.setColor(getFillColor());
        graphics.fillOval(topLeftX(), topLeftY(), width(), height());

        // Then I create outline
        graphics.setColor(getOutlineColor());
        graphics.drawOval(topLeftX(), topLeftY(), width(), height());


    }
}
