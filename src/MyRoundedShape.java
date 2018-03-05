import java.awt.*;

abstract class MyRoundedShape extends MyShape {
    public MyRoundedShape(){
        super();
    }
    public MyRoundedShape(int x, int y, int x1, int y1, Color fillColor, Color outlineColor  ){
        super(x, y, x1, y1, fillColor, outlineColor );
    }
}
