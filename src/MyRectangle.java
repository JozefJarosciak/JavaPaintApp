import java.awt.*;

public class MyRectangle extends MyShape {
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
        graphics.fillRect(getCoordinate1(),getCoordinate2(),getCoordinate3()-getCoordinate1(),getCoordinate4()-getCoordinate2());

        // Then I create outline
        graphics.setColor( getOutlineColor() );
        graphics.drawRect(getCoordinate1(),getCoordinate2(),getCoordinate3()-getCoordinate1(),getCoordinate4()-getCoordinate2());

        //System.out.println(getCoordinate1() + " - "  + getCoordinate2()+ " - "  + getCoordinate3()+ " - "  + getCoordinate4());
}

}
