import java.awt.*;
//My Line inherits the elements from the MyShape class instances enhancing polymorphism
public class MyLine extends MyShape {
    //constructor
    public MyLine(int coordinate1,
                  int coordinate2,
                  int coordinate3,int coordinate4,
                  Color choosencolor){
        super();
    }
//method instance to draw image implementation

    public void drawshape(Graphics graphics){
        graphics.setColor(getchoosencolor());
        graphics.drawLine (getcoordinate1(),getcoordinate2(),getcoordinate3(),getcoordinate4());
    }
}
