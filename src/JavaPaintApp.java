import javax.swing.*;
import java.awt.*;

public class JavaPaintApp {

    private JButton outlineColorButton;
    private JButton fillColorButton;
    private JComboBox comboBox1;
    private JPanel mainpanel;
    private JPanel drawingPanel;
    private JToolBar toolbar;

    public static void main(String[] args) {
        // Setup the form details
        JFrame frame = new JFrame("Java Paint Application)");
        frame.setContentPane(new JavaPaintApp().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        frame.setVisible(true);
        // center on page
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

    }


}
