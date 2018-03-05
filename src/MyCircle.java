import java.awt.*;

public class MyCircle extends MyRoundedShape {
    public MyCircle(int x, int y, int x1, int y1, Color fillColor, Color outlineColor){
        super(x, y, x1, y1, fillColor, outlineColor);
    }

    @Override
    public void drawShape(Graphics2D graphics){

        // First let's calculate the distance based on start and end point, which gives us the diameter of circle
        // It's based on Math.hypot, which returns: sqrt(x²+ y²) and that's a distance between x1,y1 and x2,y2
        int diameter = (int) (Math.hypot(getX1()- getX2(), getY1()- getY2()));

        // Let's draw the circle based on initial X/Y coordinates and calculated distance between start and end point
        graphics.setColor( getFillColor() );
        graphics.fillOval(topLeftX(), topLeftY(),diameter,diameter);

        // Then create the outline
        graphics.setColor( getOutlineColor() );
        graphics.drawOval(topLeftX(), topLeftY(),diameter,diameter);

        //System.out.println(getX1() + " - "  + getY1()+ " - "  + getX2()+ " - "  + getY2());
        //System.out.println(diameter );

    }
}
