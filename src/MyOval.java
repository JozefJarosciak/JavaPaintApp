import java.awt.*;

public class MyOval extends MyRoundedShape {
    public MyOval(int x, int y, int x1, int y1) {
        super(x, y, x1, y1);
    }

    @Override
    public void drawShape(Graphics2D graphics){
        graphics.fillOval (getCoordinate1(),getCoordinate2(),getCoordinate3(),getCoordinate4());
    }
}
