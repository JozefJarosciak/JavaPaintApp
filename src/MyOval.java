import java.awt.*;

public class MyOval extends MyRoundedShape {
    public MyOval(int x, int y, int x1, int y1,Color fillColor, Color outlineColor) {
        super(x, y, x1, y1, fillColor, outlineColor);
    }

    @Override
    public void drawShape(Graphics2D graphics){

        // First I draw the filled oval
        graphics.setColor( getFillColor() );
        graphics.fillOval(getCoordinate1(),getCoordinate2(),getCoordinate3(),getCoordinate4());

        // Then I create outline
        graphics.setColor( getOutlineColor() );
        graphics.drawOval(getCoordinate1(),getCoordinate2(),getCoordinate3(),getCoordinate4());

    }
}
