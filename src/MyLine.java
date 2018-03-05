import java.awt.*;

public class MyLine extends MyShape {
    public MyLine(int coordinate1,
                  int coordinate2,
                  int coordinate3,
                  int coordinate4,
                  Color fillColor,
                  Color outlineColor
    ) {
        super(coordinate1, coordinate2, coordinate3, coordinate4, fillColor, outlineColor);
    }

    @Override
    public void drawShape(Graphics2D graphics) {
        graphics.setColor(getOutlineColor());
        graphics.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}
