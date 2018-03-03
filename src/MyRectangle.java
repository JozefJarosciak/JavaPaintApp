import java.awt.*;

public class MyRectangle extends MyBoundedShape {
    public MyRectangle(int coordinate1,
                       int coordinate2,
                       int coordinate3,int coordinate4,
                       Color choosencolor){
        super();
    }

    public MyRectangle(int x, int y, int x1, int y1, Color currentShapeColor, boolean currentShapeFilled) {
        super();
    }

    public void drawshape(Graphics graphics){
        graphics.setColor(getchoosencolor());
        graphics.drawLine (getcoordinate1(),getcoordinate2(),getcoordinate3(),getcoordinate4());
    }

}
