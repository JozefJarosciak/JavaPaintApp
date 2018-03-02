import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class JavaPaintApp extends JPanel {

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
    private int coordinate1, coordinate2, coordinate3, coordinate4;
    private Graphics graphics;
    private String[] shapeType = {"Line", "Rectangle", "Oval"};


    public JavaPaintApp() {
        myShapes = new LinkedList<MyShape>();
        currentShapeColor = Color.BLACK;



        setBackground(Color.BLACK);

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

        drawingPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                this.mouseReleased(e);
            }


            @Override
            public void mousePressed(MouseEvent e) {
                this.mousePressed(e);
                System.out.println(e.getX());
                coordinate1 = e.getX();
                coordinate3 = e.getY();
                drawimages();
                coordinate2 = coordinate1;
                coordinate4 = coordinate3;
            }

        });
        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                this.mouseDragged(e);
                currentShapeObject = new MyLine( e.getX(), e.getY(),
                    e.getX(), e.getY(), currentShapeColor);
                currentShapeObject.setCoordinate2(e.getX());
                currentShapeObject.setcoordinate4(e.getY());
                //mouseCoordinates.setText(String.format("Mouse Coordinates X: %d Y: %d", e.getX(), e.getY()));
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseCoordinates.setText(String.format("Mouse Coordinates X: %d Y: %d", e.getX(), e.getY()));

                /*
                currentShapeObject = new MyLine( e.getX(), e.getY(), e.getX(), e.getY(), currentShapeColor);

                repaint();
                 */
            }
        });
    }

    private void drawimages() {
        graphics = getGraphics();
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
        if (currentShapeObject != null) {
            currentShapeObject.drawshape(graphics);
        }
    }

    public void createUIComponents(Graphics graphics) {
        // TODO: place custom component creation code here
    }


}
