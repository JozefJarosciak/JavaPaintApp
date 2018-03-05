import java.awt.*;

public class MyRoundedRectangle extends MyShape {
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
        graphics.fillRoundRect(getCoordinate1(),getCoordinate2(),getCoordinate3()-getCoordinate1(),getCoordinate4()-getCoordinate2(),20,20);

        // Then I create outline
        graphics.setColor( getOutlineColor() );
        graphics.drawRoundRect(getCoordinate1(),getCoordinate2(),getCoordinate3()-getCoordinate1(),getCoordinate4()-getCoordinate2(),20,20);

        //System.out.println(getCoordinate1() + " - "  + getCoordinate2()+ " - "  + getCoordinate3()+ " - "  + getCoordinate4());
}

}


