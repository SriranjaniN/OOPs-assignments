package assignment5;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        // Create a FlowLayout with center alignment and horizontal/vertical gaps
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 20, 10); 
        frame.setLayout(layout);

        // Add buttons to the frame
        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("Button " + i);
            frame.add(button);
        }

        // Make the frame visible
        frame.setVisible(true);
    }
}
