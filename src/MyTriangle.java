import java.awt.*;

public class MyTriangle extends MyRoundedShape {
    public MyTriangle(int x, int y, int x1, int y1, Color fillColor, Color outlineColor) {
        super(x, y, x1, y1, fillColor, outlineColor);
    }

    @Override
    public void drawShape(Graphics2D graphics){

        int x[] = {getCoordinate1(), getCoordinate3(), getCoordinate1()+((getCoordinate3()-getCoordinate1())/2)};
        int y[] = {getCoordinate2(), getCoordinate2(), getCoordinate2()-((getCoordinate3()-getCoordinate1())/2)};

        int n = 3;

        // First I draw the filled rectangle
        graphics.setColor( getFillColor() );
        graphics.fillPolygon(x,y,n);

        // Then I create outline
        graphics.setColor( getOutlineColor() );
        graphics.drawPolygon(x,y,n);

    }
}
