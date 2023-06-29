import java.awt.*;
import java.util.Calendar;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.awt.event.*;

public class Medicine_and_equipments extends Frame implements ActionListener, KeyListener {
    Choice c1, c2, c3, c5, c4, c6, c7, c8;
    Random r, a;
    JFrame f1;
    Calendar ca = Calendar.getInstance();
    JFrame f2;
    JFrame f3, f4, f5;
    ImageIcon i;
    TextField tf1;
    TextField tf3;
    TextField tf4;
    TextField tf5;
    TextField tf6;
    TextField tf7;
    TextField tf8;
    JCheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19,
            cb20, cb21, cb22, cb23, cb24;
    Label l1, l2, l3, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l24,
            l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35;
    JButton jb1, jb1a, jb1b, jb2, jb3, jb4, jb5, jb6, jb7, jb8, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13,
            b14,
            b15,
            b16, b17, b18, b19, b20, b21, b22, b23, b24, b25;
    JFrame f6;
    String fname = "project bookings\\Medical item bookings.txt";
    File f;
    float amount;
    int b;
    String msg;

    Medicine_and_equipments() {
        f1 = new JFrame();
        tf1 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
        tf5 = new TextField();
        tf6 = new TextField();
        tf7 = new TextField();
        tf8 = new TextField();
        jb1 = new JButton("SUBMIT");
        jb1a = new JButton("Back");
        l1 = new Label("Chemist Shop");
        l2 = new Label("Customer details");
        l3 = new Label("Name");
        l5 = new Label("Contact number");
        l6 = new Label("House number");
        l7 = new Label("City");
        l8 = new Label("Pincode");

        i = new ImageIcon("project images\\logo red cross.png");

        l1.setBounds(260, 10, 300, 50);
        l2.setBounds(280, 60, 160, 30);
        l3.setBounds(50, 110, 100, 50);

        l5.setBounds(50, 170, 100, 50);
        l6.setBounds(50, 230, 100, 50);
        l7.setBounds(400, 230, 50, 50);
        l8.setBounds(50, 290, 100, 40);

        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setForeground(Color.RED);

        l2.setFont(new Font("Serif", Font.ITALIC, 20));

        l1.setBackground(Color.decode("#FFDE59"));
        l2.setBackground(Color.decode("#FFDE59"));
        l3.setBackground(Color.decode("#FFDE59"));

        l5.setBackground(Color.decode("#FFDE59"));
        l6.setBackground(Color.decode("#FFDE59"));
        l7.setBackground(Color.decode("#FFDE59"));
        l8.setBackground(Color.decode("#FFDE59"));

        jb1.setBounds(250, 350, 200, 50);
        jb1a.setBounds(50, 15, 70, 30);

        tf1.setBounds(180, 120, 200, 25);

        tf3.setBounds(180, 180, 300, 25);
        tf4.setBounds(180, 240, 200, 25);
        tf5.setBounds(450, 240, 200, 25);
        tf6.setBounds(180, 300, 100, 25);

        tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if (!(Character.isAlphabetic(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE
                        || ch == KeyEvent.VK_SPACE)) {
                    JOptionPane.showMessageDialog(f1, "Enter correct name", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tf5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if (!(Character.isAlphabetic(ch) || (ch == KeyEvent.VK_BACK_SPACE) || ch == KeyEvent.VK_DELETE
                        || ch == KeyEvent.VK_SPACE)) {
                    JOptionPane.showMessageDialog(f1, "Enter correct city name", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tf3.addKeyListener(this);
        tf4.addKeyListener(this);
        tf6.addKeyListener(this);

        f1.setContentPane(new JLabel(new ImageIcon("project images\\eighth.png")));

        f1.setSize(700, 500);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.add(jb1);
        f1.add(jb1a);
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);

        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(l8);
        f1.add(tf1);
        f1.add(tf3);
        f1.add(tf4);
        f1.add(tf5);
        f1.add(tf6);

        f1.setIconImage(i.getImage());
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setTitle("e-MAS");
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setLayout(null);
        jb1.addActionListener(this);
        jb1a.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jb1) {

            if (tf1.getText().length() == 0 || tf3.getText().length() == 0
                    || tf4.getText().length() == 0 || tf5.getText().length() == 0 || tf6.getText().length() == 0) {
                JOptionPane.showMessageDialog(f1, "Enter complete patient details to proceed", "Data not Found",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (tf3.getText().length() != 10) {
                JOptionPane.showMessageDialog(f1, "Enter 10 digit mobile number", "Wrong Contact number",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (tf6.getText().length() != 6) {
                JOptionPane.showMessageDialog(f1, "Enter 6 digit pincode", "Pincode error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                f1.dispose();
                Frameone();
            }

        } else if (e.getSource() == jb3) {
            f3.dispose();
            Framesecond();

        } else if (e.getSource() == jb4) {
            f4.dispose();
            Frameone();
        } else if (e.getSource() == jb5) {
            f4.dispose();
            Framethird();
        } else if (e.getSource() == jb6) {
            f5.dispose();
            Framesecond();
        } else if (e.getSource() == jb7) {
            f5.dispose();
            jb1b = new JButton("Menu");
            f6 = new JFrame();
            jb8 = new JButton("Print");
            r = new Random();
            amount = 0;
            msg = "";
            b = r.nextInt(999999);
            if (cb1.isSelected()) {
                amount += 297;
                msg += "Cloth mask @297\n";
            }
            if (cb2.isSelected()) {
                amount += 249;
                msg += "Surgical mask @249\n";
            }
            if (cb3.isSelected()) {
                amount += 380;
                msg += "Covid Testing kit @380\n";
            }
            if (cb4.isSelected()) {
                amount += 307;
                msg += "Dettol Antiseptic @307\n";
            }
            if (cb5.isSelected()) {
                amount += 152;
                msg += "Glucose @152\n";
            }
            if (cb6.isSelected()) {
                amount += 129;
                msg += "Volini Spray @129\n";
            }
            if (cb7.isSelected()) {
                amount += 122;
                msg += "Vicks-Vaporub @122\n";
            }
            if (cb8.isSelected()) {
                amount += 200;
                msg += "Thermometer @200\n";
            }
            if (cb9.isSelected()) {
                amount += 18;
                msg += "ORS @18\n";
            }
            if (cb10.isSelected()) {
                amount += 80;
                msg += "Hand Sanitizer @80\n";
            }
            if (cb11.isSelected()) {
                amount += 999;
                msg += "B.P. machine @999\n";
            }
            if (cb12.isSelected()) {
                amount += 250;
                msg += "Dr.Ortho @250\n";
            }
            if (cb13.isSelected()) {
                amount += 580;
                msg += "Oximeter @580\n";
            }
            if (cb14.isSelected()) {
                amount += 241;
                msg += "Otrivin @241\n";
            }
            if (cb15.isSelected()) {
                amount += 186;
                msg += "Bandage @186\n";
            }
            if (cb16.isSelected()) {
                amount += 185;
                msg += "Band-aid @185\n";
            }
            if (cb17.isSelected()) {
                amount += 26;
                msg += "Paracetamol @26\n";
            }
            if (cb18.isSelected()) {
                amount += 75;
                msg += "Pudin Hara @75\n";
            }
            if (cb19.isSelected()) {
                amount += 36;
                msg += "ENO @36\n";
            }
            if (cb20.isSelected()) {
                amount += 168;
                msg += "Digene @168\n";
            }
            if (cb21.isSelected()) {
                amount += 189;
                msg += "Bourn-Vita @189\n";
            }
            if (cb22.isSelected()) {
                amount += 42;
                msg += "Soframycin @42\n";
            }
            if (cb23.isSelected()) {
                amount += 142;
                msg += "Moov @142\n";
            }
            msg += "-----------------------------------------\n";

            JOptionPane.showMessageDialog(this, msg + "Total: " + amount, "Bill", JOptionPane.PLAIN_MESSAGE);

            l18 = new Label("Order Successful");
            l19 = new Label("Order Details");
            l20 = new Label("Booking id : " + String.format("%06d", b));

            l22 = new Label("Customer name : " + tf1.getText().toUpperCase());
            l24 = new Label("Contact number : " + tf3.getText());
            l25 = new Label("Delivery Address : H.no: " + tf4.getText().toUpperCase() + ", City: "
                    + tf5.getText().toUpperCase() + ", Pincode: " + tf6.getText());
            l26 = new Label(
                    "Booking Date and Time : " + ca.getTime());
            l27 = new Label("Total Amount: " + amount);
            l28 = new Label("Payment method: Cash on Delivery");
            l31 = new Label(
                    "Thank you for ordering be ready with the cash your order will reach within next 10 minutes");

            i = new ImageIcon("project images\\logo red cross.png");
            jb1b.setBounds(50, 15, 70, 30);
            jb1b.addActionListener(this);
            jb8.setBounds(520, 22, 80, 20);
            jb8.addActionListener(this);
            l18.setBounds(220, 9, 500, 50);
            l19.setBounds(270, 60, 250, 30);
            l20.setBounds(35, 120, 400, 20);
            l22.setBounds(35, 140, 400, 20);

            l24.setBounds(35, 160, 400, 20);
            l25.setBounds(35, 180, 400, 20);
            l26.setBounds(35, 200, 400, 20);
            l27.setBounds(35, 220, 400, 20);
            l28.setBounds(35, 240, 400, 20);
            l31.setBounds(35, 430, 600, 20);
            l18.setForeground(Color.RED);

            l18.setFont(new Font("Serif", Font.BOLD, 30));
            l19.setFont(new Font("Serif", Font.ITALIC, 20));
            l31.setFont(new Font("Serif", Font.ITALIC, 16));

            try {
                audio();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
                e1.printStackTrace();
            }

            l18.setBackground(Color.decode("#FFABE5"));
            l19.setBackground(Color.decode("#FFABE5"));
            l20.setBackground(Color.decode("#FFABE5"));
            l22.setBackground(Color.decode("#FFABE5"));

            l24.setBackground(Color.decode("#FFABE5"));
            l25.setBackground(Color.decode("#FFABE5"));
            l26.setBackground(Color.decode("#FFABE5"));
            l27.setBackground(Color.decode("#FFABE5"));
            l28.setBackground(Color.decode("#FFABE5"));
            l31.setBackground(Color.decode("#FFABE5"));

            f6.setContentPane(new JLabel(new ImageIcon("project images\\ninth.png")));

            f6.setSize(700, 500);
            f6.setLayout(null);
            f6.setVisible(true);
            f6.setIconImage(i.getImage());
            f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f6.setTitle("e-MAS");
            f6.setLocationRelativeTo(null);
            f6.setResizable(false);
            f6.setLayout(null);
            f6.add(jb8);
            f6.add(l18);
            f6.add(l19);
            f6.add(l20);
            f6.add(l22);
            f6.add(l24);
            f6.add(l25);
            f6.add(l26);
            f6.add(l27);
            f6.add(l28);
            f6.add(l31);
            f6.add(jb1b);

        } else if (e.getSource() == jb1a) {
            f1.dispose();
            new Decision();

        } else if (e.getSource() == jb1b) {
            f6.dispose();
            new Decision();

        } else if (e.getSource() == jb8) {
            JOptionPane.showMessageDialog(this, "Details saved in your device successfully", "Printed",
                    JOptionPane.INFORMATION_MESSAGE);
            f = new File(fname);

            try {
                if (!f.exists()) {
                    f.createNewFile();
                }
                Writer output = new FileWriter(fname, true);
                output.append("\nBooking id : " + String.format("%06d", b));

                output.append("\nCustomer name : " + tf1.getText().toUpperCase());
                output.append("\nContact number : " + tf3.getText());
                output.append("\nDelivery Address : H.no: " + tf4.getText().toUpperCase() + ", City: "
                        + tf5.getText().toUpperCase() + ", Pincode: " + tf6.getText());
                output.append(
                        "\nBooking Date and Time : " + ca.getTime());
                output.append("\nItems: \n" + msg);
                output.append("\nTotal Amount: " + amount);
                output.append("\nPayment method: Cash on Delivery");
                output.append(
                        "\n<-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><->\n");
                output.close();

            } catch (IOException p) {
                p.printStackTrace();
            }

        }

    }

    private void Framethird() {
        f5 = new JFrame();
        jb6 = new JButton("Back");
        jb7 = new JButton("Next");
        cb17 = new JCheckBox("Paracetamol @26");
        cb18 = new JCheckBox("Pudin Hara @75");
        cb19 = new JCheckBox("ENO @36");
        cb20 = new JCheckBox("Digene @168");
        cb21 = new JCheckBox("Bourn-Vita @189");
        cb22 = new JCheckBox("Soframycin @42");
        cb23 = new JCheckBox("Moov @142");

        i = new ImageIcon("project images\\logo red cross.png");

        jb6.setBounds(30, 435, 70, 20);
        jb6.setBackground(Color.LIGHT_GRAY);
        jb6.addActionListener(this);

        jb7.setBounds(580, 435, 70, 20);
        jb7.setBackground(Color.LIGHT_GRAY);
        jb7.addActionListener(this);

        cb17.setBounds(20, 170, 130, 20);
        cb18.setBounds(190, 170, 130, 20);
        cb19.setBounds(370, 170, 100, 20);
        cb20.setBounds(540, 170, 110, 20);
        cb21.setBounds(20, 390, 130, 20);
        cb22.setBounds(210, 390, 150, 20);
        cb23.setBounds(480, 390, 120, 20);

        f5.setContentPane(new JLabel(new ImageIcon("project images\\product3.png")));

        f5.setSize(700, 500);
        f5.setLayout(null);
        f5.setVisible(true);
        f5.setIconImage(i.getImage());
        f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f5.setTitle("e-MAS");
        f5.setLocationRelativeTo(null);
        f5.setResizable(false);
        f5.add(jb6);
        f5.add(jb7);
        f5.add(cb17);
        f5.add(cb18);
        f5.add(cb19);
        f5.add(cb20);
        f5.add(cb21);
        f5.add(cb22);
        f5.add(cb23);
    }

    private void Framesecond() {
        f4 = new JFrame();
        jb4 = new JButton("Back");
        jb5 = new JButton("Next");
        cb9 = new JCheckBox("ORS @18");
        cb10 = new JCheckBox("Hand Sanitizer @80");
        cb11 = new JCheckBox("B.P. Machine @999");
        cb12 = new JCheckBox("Dr. Ortho @250");
        cb13 = new JCheckBox("Oximeter @580");
        cb14 = new JCheckBox("Otrivin @241");
        cb15 = new JCheckBox("Bandage @186");
        cb16 = new JCheckBox("Band-aid @185");
        i = new ImageIcon("project images\\logo red cross.png");

        jb4.setBounds(30, 435, 70, 20);
        jb4.setBackground(Color.LIGHT_GRAY);
        jb4.addActionListener(this);

        jb5.setBounds(580, 435, 70, 20);
        jb5.setBackground(Color.LIGHT_GRAY);
        jb5.addActionListener(this);

        cb9.setBounds(20, 170, 130, 20);
        cb10.setBounds(170, 170, 150, 20);
        cb11.setBounds(350, 170, 160, 20);
        cb12.setBounds(520, 170, 150, 20);
        cb13.setBounds(20, 390, 130, 20);
        cb14.setBounds(170, 390, 150, 20);
        cb15.setBounds(350, 390, 150, 20);
        cb16.setBounds(520, 390, 150, 20);

        f4.setContentPane(new JLabel(new ImageIcon("project images\\product2.png")));

        f4.setSize(700, 500);
        f4.setLayout(null);
        f4.setVisible(true);
        f4.setIconImage(i.getImage());
        f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f4.setTitle("e-MAS");
        f4.setLocationRelativeTo(null);
        f4.setResizable(false);
        f4.add(jb4);
        f4.add(jb5);
        f4.add(cb9);
        f4.add(cb10);
        f4.add(cb11);
        f4.add(cb12);
        f4.add(cb13);
        f4.add(cb14);
        f4.add(cb15);
        f4.add(cb16);
    }

    private void Frameone() {
        f3 = new JFrame();
        jb3 = new JButton("Next");
        cb1 = new JCheckBox("Cloth Mask @297");
        cb2 = new JCheckBox("Surgical Mask @249");
        cb3 = new JCheckBox("Covid Testing Kit @380");
        cb4 = new JCheckBox("Dettol Antiseptic @307");
        cb5 = new JCheckBox("Glucose @152");
        cb6 = new JCheckBox("Volini Spray @129");
        cb7 = new JCheckBox("Vicks Vaporub @122");
        cb8 = new JCheckBox("Thermometer @200");

        i = new ImageIcon("project images\\logo red cross.png");

        jb3.setBounds(580, 435, 70, 20);
        jb3.setBackground(Color.LIGHT_GRAY);
        jb3.addActionListener(this);

        cb1.setBounds(20, 170, 130, 20);
        cb2.setBounds(170, 170, 150, 20);
        cb3.setBounds(350, 170, 160, 20);
        cb4.setBounds(520, 170, 170, 20);
        cb5.setBounds(20, 390, 130, 20);
        cb6.setBounds(170, 390, 150, 20);
        cb7.setBounds(350, 390, 150, 20);
        cb8.setBounds(520, 390, 150, 20);

        f3.setContentPane(new JLabel(new ImageIcon("project images\\product1.png")));

        f3.setSize(700, 500);
        f3.setVisible(true);
        f3.setIconImage(i.getImage());
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f3.setTitle("e-MAS");
        f3.setLocationRelativeTo(null);
        f3.setResizable(false);
        f3.setLayout(null);
        f3.add(jb3);
        f3.add(cb1);
        f3.add(cb2);
        f3.add(cb3);
        f3.add(cb4);
        f3.add(cb5);
        f3.add(cb6);
        f3.add(cb6);
        f3.add(cb7);
        f3.add(cb8);
    }

    private void audio() throws LineUnavailableException,
            UnsupportedAudioFileException, IOException {
        File file;
        file = new File("project audio\\aud3.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public static void main(String args[]) {
        new Medicine_and_equipments();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String value = tf3.getText();
        String value1 = tf4.getText();
        String value2 = tf6.getText();
        value.length();
        value1.length();
        value2.length();
        if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            tf3.setEditable(true);
            tf4.setEditable(true);
            tf6.setEditable(true);

        } else {
            tf3.setEditable(false);
            tf4.setEditable(false);
            tf6.setEditable(false);
            JOptionPane.showMessageDialog(f1, "Characters not allowed", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
