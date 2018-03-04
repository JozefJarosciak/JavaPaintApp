import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaPaintApp extends JPanel {

    private JButton selectOutlineColorButton;
    private JButton selectFillColorButton;
    private JComboBox comboBox1;
    private JPanel mainpanel;
    private JPanel drawingPanel;
    private JToolBar toolbar;
    private JLabel mouseCoordinates;
    private JButton REDOButton;
    private JButton CLEARButton;
    private MyShape currentShape; //stores the current shape object
    private Graphics g;
    Point startPoint, endPoint;
    String selectedShape = "Line";
    Color fillColor, outlineColor;


    public JavaPaintApp() {


        selectOutlineColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = selectOutlineColorButton.getBackground();
                outlineColor = JColorChooser.showDialog(null,
                        "Shape Outline Color Picker", initialBackground);
                if (outlineColor != null) {
                    selectOutlineColorButton.setBackground(outlineColor);
                }
            }
        });

        selectFillColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = selectFillColorButton.getBackground();
                fillColor = JColorChooser.showDialog(null,
                        "Shape Fill Color Picker", initialBackground);
                if (fillColor != null) {
                    selectFillColorButton.setBackground(fillColor);
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemSelectable is = (ItemSelectable)e.getSource();
                System.out.println("Cmd: "+ e.getActionCommand());
                System.out.println(selectedString(is));
                selectedShape = selectedString(is);
            }
        });


        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseCoordinates.setText("Mouse Coordinates: " + e.getX() + ", " + e.getY());

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                System.out.println("mouseDragged: " + e.getX() + ", " + e.getY());
                currentShape = new MyRectangle( e.getX(), e.getY(),e.getX(), e.getY(), Color.green);
                currentShape.setCoordinate2(e.getX());
                currentShape.setcoordinate4(e.getY());
                //currentShape.drawshape(drawingPanel.getGraphics());
                //drawingPanel.repaint();
            }
        });


        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                endPoint = e.getPoint();
                //drawingPanel.getGraphics().drawRect((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY());

                drawShape(selectedShape);
                System.out.println("mouseReleased: " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                startPoint = e.getPoint();
                System.out.println("mousePressed: " + e.getX() + ", " + e.getY());

            }

        });
    }

    /*
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
           if (currentShape != null) {
            currentShape.drawshape(drawingPanel.getGraphics());
        }
    }
*/
    private String selectedString(ItemSelectable is) {
        Object selected[] = is.getSelectedObjects();
        return ((selected.length == 0) ? "null" : (String)selected[0]);
    }

    private void drawShape(String shape){
        Graphics graphics = drawingPanel.getGraphics();
        graphics.setColor(outlineColor);
        switch (shape){
            case "Line":
                graphics.drawLine((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY());
                break;
            case "Rectangle":
                graphics.drawRect((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY());
                break;
            case "Oval":
                graphics.drawOval((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY());
                break;
            case "Circle":
                graphics.drawOval((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY());
                break;
            default:
                drawingPanel.getGraphics().drawLine((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY());
                break;
        }
    }

    public static void main(String[] args) {

        // Setup the form details
        JFrame frame = new JFrame("Java Paint Application)");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);


        // center on page
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setContentPane(new JavaPaintApp().mainpanel);
        frame.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
