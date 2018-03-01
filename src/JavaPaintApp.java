import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaPaintApp {

    private JButton selectOutlineColorButton;
    private JButton selectFillColorButton;
    private JComboBox comboBox1;
    private JPanel mainpanel;
    private JPanel drawingPanel;
    private JToolBar toolbar;


    public JavaPaintApp() {

        selectOutlineColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = selectOutlineColorButton.getBackground();
                Color background = JColorChooser.showDialog(null,
                    "JColorChooser Sample", initialBackground);
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
                    "JColorChooser Sample", initialBackground);
                if (background != null) {
                    selectFillColorButton.setBackground(background);
                }
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


}
