import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Decision extends JFrame implements ActionListener {

    JFrame f1;
    ImageIcon i;
    JLabel l1, l2;
    JButton b1;
    Choice c1;

    Decision() {
        f1 = new JFrame();
        c1 = new Choice();
        c1.add("Medicine Recommendation");
        c1.add("Ambulance Reservation");
        c1.add("Lab Test Booking");
        c1.add("Appointment to a Doctor");
        c1.add("Medicine or medical equipments");
        c1.setFont(new Font("Serif", Font.PLAIN, 23));
        c1.setBounds(80, 200, 400, 50);
        l1 = new JLabel("Welcome user");
        l2 = new JLabel("Select a valid option from below to proceed");
        l1.setBounds(250, 50, 300, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setForeground(Color.RED);
        l2.setFont(new Font("Serif", Font.ITALIC, 20));

        l2.setBounds(175, 80, 700, 70);
        b1 = new JButton("Proceed");
        b1.setFont(new Font("Serif", Font.BOLD, 16));
        b1.setBounds(500, 205, 100, 30);
        b1.setBackground(Color.LIGHT_GRAY);
        b1.addActionListener(this);
        i = new ImageIcon("project images\\logo red cross.png");
        f1.setContentPane(new JLabel(new ImageIcon("project images\\second.png")));
        f1.setTitle("e-MAS");
        f1.setSize(700, 500);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
        f1.setIconImage(i.getImage());
        f1.setResizable(false);
        f1.setLayout(null);
        f1.add(b1);
        f1.add(c1);
        f1.add(l1);
        f1.add(l2);
    }

    public static void main(String[] args) {
        new Decision();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (c1.getItem(c1.getSelectedIndex()) == "Ambulance Reservation") {
                f1.dispose();
                new Ambulance();
            } else if (c1.getItem(c1.getSelectedIndex()) == "Appointment to a Doctor") {
                f1.dispose();
                new Appointment();
            } else if (c1.getItem(c1.getSelectedIndex()) == "Medicine or medical equipments") {
                f1.dispose();
                new Medicine_and_equipments();
            } else if (c1.getItem(c1.getSelectedIndex()) == "Lab Test Booking") {
                f1.dispose();
                new LabTest();
            } else {
                f1.dispose();
                new medicine_recommendation();
            }
        }
    }
}