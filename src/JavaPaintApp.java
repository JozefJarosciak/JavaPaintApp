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


    public JavaPaintApp() {


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

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseCoordinates.setText("Mouse Coordinates: " + e.getX() + ", " + e.getY());
                currentShape = new MyRectangle( e.getX(), e.getY(),e.getX(), e.getY(), Color.green);
                currentShape.setCoordinate2(e.getX());
                currentShape.setcoordinate4(e.getY());
                //currentShape.drawshape(drawingPanel.getGraphics());
                //drawingPanel.repaint();
                drawingPanel.getGraphics().drawRect(e.getX(), e.getY(),e.getX(), e.getY());
                //  repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                System.out.println("mouseDragged: " + e.getX() + ", " + e.getY());
            }
        });


        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println("mouseReleased: " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
