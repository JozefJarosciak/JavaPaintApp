import java.awt.*;

public class MyRectangle extends MyShape {
    public MyRectangle(){
        super();
    }

    public MyRectangle(int x, int y, int x1, int y1) {
        super(x, y, x1, y1);
    }

    @Override
    public void drawShape(Graphics2D graphics){
        graphics.fillRect(getCoordinate1(),getCoordinate2(),getCoordinate1(),getCoordinate2());
}

}
