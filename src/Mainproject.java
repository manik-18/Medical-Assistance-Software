import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainproject extends JFrame implements ActionListener {
    JFrame f1;
    ImageIcon i;
    JLabel l1, l2, l3;
    JButton b1;

    Mainproject() {
        f1 = new JFrame();
        l1 = new JLabel("e-MAS");
        l2 = new JLabel("The 24x7 Medical Assistance Software");
        l3 = new JLabel("Click next to proceed");
        l1.setBounds(300, 50, 300, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setForeground(Color.RED);

        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l2.setForeground(Color.GREEN);
        l2.setBounds(205, 100, 700, 70);

        l3.setFont(new Font("Serif", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        l3.setBounds(255, 180, 700, 70);

        b1 = new JButton("Next");
        b1.setFont(new Font("Serif", Font.BOLD, 16));
        b1.setBounds(300, 305, 100, 30);
        b1.addActionListener(this);
        i = new ImageIcon("project images\\logo red cross.png");
        f1.setContentPane(new JLabel(new ImageIcon("project images\\first.png")));
        f1.setTitle("e-MAS");
        f1.setSize(700, 500);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
        f1.setIconImage(i.getImage());
        f1.setResizable(false);
        f1.setLayout(null);
        f1.add(b1);
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
    }

    public static void main(String[] args) {
        new Mainproject();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            f1.dispose();
            new Decision();
        }
    }
}
