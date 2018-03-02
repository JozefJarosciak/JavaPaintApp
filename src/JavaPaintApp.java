import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class JavaPaintApp extends JPanel{

    private JButton selectOutlineColorButton;
    private JButton selectFillColorButton;
    private JComboBox comboBox1;
    private JPanel mainpanel;
    private JPanel drawingPanel;
    private JToolBar toolbar;
    private JLabel mouseCoordinates;
    private JButton CLEARButton;
    private JButton UNDOButton;
    private JButton RESETButton;
    public MyShape currentShapeObject;
    public String currentShapeType;
    private Color currentShapeColor;
    private LinkedList<MyShape> myShapes;
    private JavaPaintApp2 javaPaintApp2;
    private int coordinate1,coordinate2,coordinate3,coordinate4;
    private Graphics graphics;
    private String[] shapeType= {"Line","Rectangle","Oval" };
    public JavaPaintApp() {
        myShapes = new LinkedList<MyShape>();
        currentShapeColor=Color.BLACK;
        setBackground(Color.BLACK);
        MouseHandler handler = new MouseHandler();
        addMouseListener( handler );
        addMouseMotionListener( handler );
        selectOutlineColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = selectOutlineColorButton.getBackground();
                Color background = JColorChooser.showDialog(null,
                        "Shape Outline Color Picker", initialBackground);
                if (background != null) {
                    selectOutlineColorButton.setBackground(background);
                }
            }
        });

        selectFillColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = selectFillColorButton.getBackground();
                Color background = JColorChooser.showDialog(null,
                        "Shape Fill Color Picker", initialBackground);
                if (background != null) {
                    selectFillColorButton.setBackground(background);
                }
            }
        });

    }
    private void drawimages(){
        graphics=getGraphics();
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            coordinate1 = event.getX();
            coordinate3 = event.getY();
            drawimages();
            coordinate2 = coordinate1;
            coordinate4 = coordinate3;
        }


        public void mouseReleased(MouseEvent event) {


        }


        public void mouseMoved(MouseEvent event) {
            mouseCoordinates.setText(String.format("Mouse Coordinates X: %d Y: %d", event.getX(), event.getY()));
        }


        public void mouseDragged(MouseEvent event) {

            currentShapeObject.setCoordinate2(event.getX());
            currentShapeObject.setcoordinate4(event.getY());
            mouseCoordinates.setText(String.format("Mouse Coordinates X: %d Y: %d", event.getX(), event.getY()));

            repaint();

        }



    }
    public static void main(String[] args) {

        // Setup the form details
        JFrame frame = new JFrame("Java Paint Application)");
        frame.setContentPane(new JavaPaintApp().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        frame.setVisible(true);
        // center on page
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (currentShapeObject != null)
            currentShapeObject.drawshape(graphics);
    }

    public void createUIComponents(Graphics graphics) {
        // TODO: place custom component creation code here
    }





}
