import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JavaPaintApp extends JPanel {

     JButton selectOutlineColorButton;
     JButton selectFillColorButton;
     JComboBox comboBox1;
     JPanel mainpanel;
     JPanel drawingPanel;
     JToolBar toolbar;
     JLabel mouseCoordinates;
     JButton clearButton;
    Point startPoint, endPoint;
    String selectedShape = "Line";
    Color fillColor, outlineColor;
    JColorChooser outlineColorChooser = new JColorChooser();
    JColorChooser fillColorChooser = new JColorChooser();

    private JavaPaintApp() {




        selectOutlineColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = selectOutlineColorButton.getBackground();
                outlineColor = outlineColorChooser.showDialog(null,
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
                fillColor = fillColorChooser.showDialog(null,
                        "Shape Fill Color Picker", initialBackground);
                if (fillColor != null) {
                    selectFillColorButton.setBackground(fillColor);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemSelectable is = (ItemSelectable)e.getSource();
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
                //System.out.println("mouseDragged: " + e.getX() + ", " + e.getY());
            }
        });


        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                endPoint = e.getPoint();
                drawShape(selectedShape);
                //System.out.println("mouseReleased: " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    startPoint = e.getPoint();
               // System.out.println("mousePressed: " + e.getX() + ", " + e.getY());
            }

        });
        mainpanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
/*
                outlineColorChooser.setColor(Color.getColor("#4775BB"));
                fillColorChooser.setColor(Color.getColor("#F4F4B8"));

                outlineColor = outlineColorChooser.getColor();
                fillColor  = fillColorChooser.getColor();
*/
                comboBox1.requestFocusInWindow();
            }
        });
    }

    private String selectedString(ItemSelectable is) {
        Object selected[] = is.getSelectedObjects();
        return ((selected.length == 0) ? "null" : (String)selected[0]);
    }

    private void drawShape(String shape){
        MyShape myShape;
        Graphics2D graphics = (Graphics2D) drawingPanel.getGraphics();
        graphics.setColor(outlineColor);
        graphics.setPaint(fillColor);

        switch (shape){
            case "Select Shape":
                break;
            case "Line":
                myShape = new MyLine((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY(),fillColor, outlineColor);
                myShape.drawShape(graphics);
                break;
            case "Rectangle":
                myShape = new MyRectangle((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY(),fillColor, outlineColor);
                myShape.drawShape(graphics);
                break;
            case "Rounded Rectangle":
                myShape = new MyRoundedRectangle((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY(),fillColor, outlineColor);
                myShape.drawShape(graphics);
                break;
            case "Oval":
                myShape = new MyOval((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY(),fillColor, outlineColor);
                myShape.drawShape(graphics);
                break;
            case "Triangle":
                myShape = new MyTriangle((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY(),fillColor, outlineColor);
                myShape.drawShape(graphics);
                break;
            case "Circle":
                myShape = new MyCircle((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY(),fillColor, outlineColor);
                myShape.drawShape(graphics);
                break;
            default:
                drawingPanel.getGraphics().drawLine((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int) endPoint.getY());
                break;
        }
    }

    public void clear(){
        Graphics2D graphics2D = (Graphics2D) drawingPanel.getGraphics();
        graphics2D.setPaint(drawingPanel.getBackground());
        graphics2D.fillRect(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());
        graphics2D.setPaint(Color.black);
        repaint();
    }




    public static void main(String[] args) {

        // Setup the form details
        JFrame frame = new JFrame("Java Paint Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(650, 650);

        // center on page
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setContentPane(new JavaPaintApp().mainpanel);
        frame.setVisible(true);


    }


}
