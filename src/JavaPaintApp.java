import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaPaintApp {
    JButton clearButton, clearAllButton, redoButton, undoButton, fillButton, outlineButton;
    JComboBox<String> shapeCombo;
    JToolBar menu;
    DrawingPanel drawingPanel;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearButton) {
                drawingPanel.clear();
            } else if (e.getSource() == clearAllButton) {
                drawingPanel.clearAll();
            } else if (e.getSource() == redoButton) {
                drawingPanel.redo();
            } else if (e.getSource() == undoButton) {
                drawingPanel.undo();
            } else if (e.getSource() == fillButton) {
                Color initialBackground = fillButton.getBackground();
                drawingPanel.fillColor = JColorChooser.showDialog(null,
                        "Shape Outline Color Picker", initialBackground);
                if (drawingPanel.fillColor != null) {
                    fillButton.setBackground(drawingPanel.fillColor);
                }

            } else if (e.getSource() == outlineButton) {
                Color initialBackground = outlineButton.getBackground();
                drawingPanel.outlineColor = JColorChooser.showDialog(null,
                        "Shape Outline Color Picker", initialBackground);
                if (drawingPanel.outlineColor != null) {
                    outlineButton.setBackground(drawingPanel.outlineColor);
                }
            } else if (e.getSource() == shapeCombo) {
                ItemSelectable is = (ItemSelectable) e.getSource();
                drawingPanel.selectedShape = selectedString(is);
            }

        }
    };

    public static void main(String[] args) {
        new JavaPaintApp().createComponents();
    }

    public void createComponents() {
        // Setup the form details
        JFrame frame = new JFrame("Java Paint Application");
        Container content = frame.getContentPane();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);


        // center on page
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        //frame.setContentPane(new DrawingPanel());

        drawingPanel = new DrawingPanel();
        // create controls to select colors and shape, clear, undo etc
        content.add(drawingPanel, BorderLayout.CENTER);
        menu = new JToolBar("Menu", 0);
        menu.setBorderPainted(true);
        menu.setBorder( BorderFactory.createTitledBorder("Menu"));
        clearButton = new JButton("Clear");
        clearButton.addActionListener(actionListener);
        clearAllButton = new JButton("Clear All");
        clearAllButton.addActionListener(actionListener);
        redoButton = new JButton("Redo");
        redoButton.addActionListener(actionListener);
        undoButton = new JButton("Undo");
        undoButton.addActionListener(actionListener);
        fillButton = new JButton("Choose");
        fillButton.addActionListener(actionListener);
        outlineButton = new JButton("Choose");
        outlineButton.addActionListener(actionListener);

        shapeCombo = new JComboBox<String>(new String[]{"Select Shape", "Line", "Rectangle", "Rounded Rectangle", "Oval", "Circle", "Triangle", "Square"});
        shapeCombo.addActionListener(actionListener);

        JLabel fillLabel = new JLabel(" Fill Color: ");
        JLabel outlineLabel = new JLabel("Outline Color: ");
        // add controls to the menu toolbar
        menu.add(outlineLabel);
        menu.add(outlineButton);
        menu.add(fillLabel);
        menu.add(fillButton);
        menu.add(shapeCombo);
        menu.add(clearButton);
        menu.add(clearAllButton);
        //menu.add(redoButton);
        menu.add(undoButton);

        // add menubar to top of frame
        content.add(menu, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    private String selectedString(ItemSelectable is) {
        Object selected[] = is.getSelectedObjects();
        return ((selected.length == 0) ? "null" : (String) selected[0]);
    }
}
