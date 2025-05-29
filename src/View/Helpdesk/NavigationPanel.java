package View.Helpdesk;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class NavigationPanel extends JPanel {

    private Map<String, JButton> button;

    public NavigationPanel(String... label) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(40, 40, 40));
        setPreferredSize(new Dimension(180, 600));

        button = new HashMap<>();

        add(Box.createVerticalGlue());

        for (int i = 0; i < label.length; i++) {

            JButton b =  createNavButton(label[i]);
            button.put(label[i], b);
            add(b);
            if (i < label.length - 1) {
                add(Box.createVerticalStrut(10));
            }

        }

        add(Box.createVerticalGlue());
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(160, 40));
        return button;
    }

    public JButton getButton(String label) {
        return button.get(label);
    }

}
