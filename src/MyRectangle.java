import java.awt.*;

public class MyRectangle extends MyRoundedShape {
    public MyRectangle(){
        super();
    }

    public MyRectangle(int x, int y, int x1, int y1, Color fillColor, Color outlineColor) {
        super(x, y, x1, y1, fillColor, outlineColor);
    }

    @Override
    public void drawShape(Graphics2D graphics){

        // First I draw the filled rectangle
        graphics.setColor( getFillColor() );
        graphics.fillRect(topLeftX(), topLeftY(), width(), height());

        // Then I create outline
        graphics.setColor( getOutlineColor() );
        graphics.drawRect(topLeftX(), topLeftY(), width(), height());

        //System.out.println(getX1() + " - "  + getY1()+ " - "  + getX2()+ " - "  + getY2());
}

}
