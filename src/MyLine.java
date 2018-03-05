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
                  int coordinate4){
        super(coordinate1, coordinate2, coordinate3, coordinate4);
    }
    //method instance to draw image implementation
    @Override
    public void drawShape(Graphics2D graphics){
        graphics.drawLine (getCoordinate1(),getCoordinate2(),getCoordinate3(),getCoordinate4());
    }
}
