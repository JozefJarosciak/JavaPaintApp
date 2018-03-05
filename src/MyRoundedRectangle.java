import java.awt.*;

public class MyRoundedRectangle extends MyRoundedShape {
    public MyRoundedRectangle(){
        super();
    }

    public MyRoundedRectangle(int x, int y, int x1, int y1, Color fillColor, Color outlineColor) {
        super(x, y, x1, y1, fillColor, outlineColor);
    }

    @Override
    public void drawShape(Graphics2D graphics){

        // First I draw the filled rectangle
        graphics.setColor( getFillColor() );
        graphics.fillRoundRect(topLeftX(), topLeftY(), width(), height(),20,20);

        // Then I create outline
        graphics.setColor( getOutlineColor() );
        graphics.drawRoundRect(topLeftX(), topLeftY(), width(), height(),20,20);

        //System.out.println(getX1() + " - "  + getY1()+ " - "  + getX2()+ " - "  + getY2());
}

}


