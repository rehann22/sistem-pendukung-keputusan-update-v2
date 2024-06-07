package com.admin.debug;
import javax.swing.*;
import java.awt.*;

public class ScrollablePanelExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Scrollable JPanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Create a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1)); // Set layout to vertical

        // Add some components to the panel
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel("Label " + i);
            panel.add(label);
        }

        // Add the panel to the scroll pane
        scrollPane.setViewportView(panel);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}