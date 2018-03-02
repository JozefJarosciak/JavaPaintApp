import java.awt.*;

abstract class MyShape {
    private int coordinate1,coordinate2,coordinate3,coordinate4;
    private Color choosencolor;
    //create a constructor for the myshape class instance
    public MyShape(){
        coordinate1=0;
        coordinate2=0;
        coordinate3=0;
        coordinate4=0;
        choosencolor = Color.BLUE;
    }
    public MyShape(int coordinate1, int coordinate2, int coordinate3, int coordinate4, Color choosencolor)
    {
        this.coordinate1=coordinate1;
        this.coordinate2=coordinate2;
        this.coordinate3=coordinate3;
        this.coordinate4=coordinate4;
        this.choosencolor=choosencolor;
    }
    public void setcoordinate1(int coordinate1)
    {
        this.coordinate1=coordinate1;
    }
    public void setCoordinate2(int coordinate2)
    {
        this.coordinate2=coordinate2;
    }
    public void setcoordinate3(int coordinate3)
    {
        this.coordinate3=coordinate3;
    }
    public void setcoordinate4(int coordinate4)
    {
        this.coordinate4=coordinate4;
    }
    public void setchoosencolor(Color choosencolor)
    {
        this.choosencolor=choosencolor;
    }
    public int getcoordinate1()
    {
        return coordinate1;
    }
    public int getcoordinate2()
    {
        return coordinate1;
    }
    public int getcoordinate3()
    {
        return coordinate1;
    }
    public int getcoordinate4()
    {
        return coordinate1;
    }
    public Color getchoosencolor()
    {
        return choosencolor;
    }
    abstract public void drawshape (Graphics graphics);


}

