import java.awt.*;

public class MyOval extends MyBoundedShape {
    public MyOval(int x, int y, int x1, int y1, Color currentShapeColor, boolean currentShapeFilled) {
        super();
    }

    public void drawshape(Graphics graphics){
        graphics.setColor(getchoosencolor());
        graphics.drawLine (getcoordinate1(),getcoordinate2(),getcoordinate3(),getcoordinate4());
    }
}
