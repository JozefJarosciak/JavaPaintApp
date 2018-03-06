import java.awt.*;

//My Line inherits the elements from the MyShape class instances enhancing polymorphism
public class MyLine extends MyShape {
    //constructor
    public MyLine() {
        super();
    }
    public MyLine(int coordinate1,
                  int coordinate2,
                  int coordinate3,
                  int coordinate4,
                  Color color){
        super(coordinate1, coordinate2, coordinate3, coordinate4, color);
    }
//method instance to draw image implementation
    @Override
    public void drawShape(Graphics graphics){
        graphics.setColor(this.getOutlineColor());
        graphics.drawLine (getX1(), getY1(), getX2(), getY2());
    }
}
