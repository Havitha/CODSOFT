import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class A {

    public static void converter() { 

        // Exchange rate constant
        final double RATE = 65.25;

        // Creating a new frame
        JFrame f = new JFrame("Currency Converter"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close properly

        // Labels
        JLabel l1 = new JLabel("Rupees:"); 
        JLabel l2 = new JLabel("Dollars:"); 

        // TextFields
        JTextField t1 = new JTextField("0"); 
        JTextField t2 = new JTextField("0"); 

        // Buttons
        JButton b1 = new JButton("Convert to Dollar"); 
        JButton b2 = new JButton("Convert to Rupees"); 
        JButton b3 = new JButton("Close"); 

        // Panel with GridLayout for clean design
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add components to panel
        panel.add(l1); panel.add(t1);
        panel.add(l2); panel.add(t2);
        panel.add(b1); panel.add(b2);
        panel.add(new JLabel("")); panel.add(b3);

        // Action for INR → Dollar
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double rupees = Double.parseDouble(t1.getText());
                    double dollars = rupees / RATE;
                    t2.setText(String.format("%.2f", dollars)); // 2 decimals
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Enter a valid number!");
                }
            }
        });

        // Action for Dollar → INR
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double dollars = Double.parseDouble(t2.getText());
                    double rupees = dollars * RATE;
                    t1.setText(String.format("%.2f", rupees));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Enter a valid number!");
                }
            }
        });

        // Close button
        b3.addActionListener(e -> f.dispose());

        // Add panel to frame
        f.add(panel);
        f.pack();
        f.setVisible(true); 
    } 

    public static void main(String args[]) { 
        converter(); 
    } 
}


