import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class JavaPaintApp {

    private JButton selectOutlineColorButton;
    private JButton selectFillColorButton;
    private JComboBox comboBox1;
    private JPanel mainpanel;
    private JPanel drawingPanel;
    private JToolBar toolbar;
    private JLabel mouseCoordinates;
    private JButton REDOButton;
    private JButton CLEARButton;


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
            }
        });
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


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
