import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

class DrawingPanel extends JPanel{
    private MyShape currentShape;
    static String selectedShape = "Line";
    private LinkedList<MyShape> myShapes; // stack of shapes
    private LinkedList<MyShape> clearedShapes; // stack of cleared shapes
    private int oldX, oldY, newX, newY;
    static Color fillColor = Color.decode("#FFFFCC");
    static Color outlineColor = Color.decode("#999999");


    private String lastAction = "Add";

    private JLabel mouseCoordinates;

    DrawingPanel(){
        myShapes = new LinkedList<>(); //initialize myShapes dynamic stack
        clearedShapes = new LinkedList<>(); //initialize clearedShapes dynamic stack
        mouseCoordinates = new JLabel("");

        setLayout(new BorderLayout()); //sets layout to border layout; default is flow layout
        setBackground( Color.WHITE ); //sets background color of panel to white
        add( mouseCoordinates, BorderLayout.NORTH );  //adds a status label to the south border


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseCoordinates.setText("Mouse Coordinates: " + e.getX() + ", " + e.getY());

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                // System.out.println("mouseDragged: " + e.getX() + ", " + e.getY());
                currentShape.setX2(e.getX());
                currentShape.setY2(e.getY());
                repaint();
            }
        });


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                newX = e.getX();
                newY = e.getY();
                currentShape.setX2(e.getX());
                currentShape.setY2(e.getY());

                myShapes.addFront(currentShape);
                currentShape = null;
                clearedShapes.makeEmpty();
                repaint();
                // System.out.println("mouseReleased: " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                drawShape(selectedShape, e);
                oldX = e.getX();
                oldY = e.getY();
                // System.out.println("mousePressed: " + e.getX() + ", " + e.getY());

            }

        });
    }

    @Override
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        // draw the shapes
        ArrayList<MyShape> shapeArray=myShapes.getArray();
        for ( int counter=shapeArray.size()-1; counter>=0; counter-- )
            shapeArray.get(counter).drawShape(g);

        //draws the current Shape Object if it is not null
        if (currentShape!=null)
            currentShape.drawShape( g);
    }

    public void clear() {
        if (! myShapes.isEmpty())
        {
            clearedShapes.addFront(myShapes.removeFront());
            repaint();
        }
    }

    public void clearAll()
    {
        myShapes.makeEmpty();
        clearedShapes.makeEmpty();
        repaint();
    }

    public void redo(){
        if (! clearedShapes.isEmpty())
        {
            myShapes.addFront(clearedShapes.removeFront());
            repaint();
        }
    }

    public void undo(){
        if (! clearedShapes.isEmpty())
        {
            myShapes.addFront(clearedShapes.removeFront());
            repaint();
        }
    }

    private void drawShape(String shape, MouseEvent event){
        switch (shape){
            case "Line":
                currentShape = new MyLine(event.getX(), event.getY(), event.getX(), event.getY(), outlineColor);
                break;
            case "Rectangle":
                currentShape = new MyRectangle(event.getX(), event.getY(), event.getX(), event.getY(),outlineColor, fillColor);
                break;
            case "Oval":
                currentShape = new MyOval(event.getX(), event.getY(), event.getX(), event.getY(), outlineColor, fillColor);
                break;
            case "Circle":
                currentShape = new MyCircle(event.getX(), event.getY(), event.getX(), event.getY(), outlineColor, fillColor);
                break;
            case "Triangle":
                currentShape = new MyTriangle(event.getX(), event.getY(), event.getX(), event.getY(), outlineColor, fillColor);
                break;
            case "Square":
                currentShape = new MySquare(event.getX(), event.getY(), event.getX(), event.getY(), outlineColor, fillColor);
                break;
            case "Rounded Rectangle":
                currentShape = new MyRoundedRectangle(event.getX(), event.getY(), event.getX(), event.getY(), outlineColor, fillColor);
                break;
            default:
                currentShape = new MyLine(event.getX(), event.getY(), event.getX(), event.getY(), outlineColor);
                break;
        }
    }
}
