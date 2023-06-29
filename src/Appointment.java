import java.awt.*;
import java.util.*;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Appointment extends Frame implements ActionListener, KeyListener {
    Choice c1, c2, c3, c5, c4, c6, c7, c8;
    Random r, a;
    JFrame f1;
    Calendar ca = Calendar.getInstance();
    JFrame f2;
    JFrame f3;
    ImageIcon i;
    TextField tf1, tf2;
    TextField tf3;
    TextField tf4;
    TextField tf5;
    TextField tf6;
    TextField tf7;
    TextField tf8;
    Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24,
            l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35;
    JButton jb1, jb1a, jb1b, jb2, jb3, jb4;
    String fname = "project bookings\\Appointment bookings.txt";
    File f;
    int b;

    Appointment() {
        f1 = new JFrame();
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf6 = new TextField();
        jb1 = new JButton("SUBMIT");
        jb1a = new JButton("Back");
        l1 = new Label("Appointment Booking");
        l2 = new Label("Patient details");
        l3 = new Label("Name");
        l4 = new Label("Gender");
        l5 = new Label("Contact number");
        l8 = new Label("Age");

        i = new ImageIcon("project images\\logo red cross.png");

        l1.setBounds(210, 10, 400, 50);
        l2.setBounds(280, 60, 160, 30);
        l3.setBounds(50, 110, 100, 50);
        l4.setBounds(400, 110, 100, 50);
        l5.setBounds(50, 170, 100, 50);
        l8.setBounds(400, 170, 100, 50);

        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setForeground(Color.RED);
        l1.setBackground(Color.decode("#C9E265"));

        l2.setFont(new Font("Serif", Font.ITALIC, 20));
        l2.setBackground(Color.decode("#C9E265"));

        l3.setBackground(Color.decode("#C9E265"));
        l4.setBackground(Color.decode("#C9E265"));
        l5.setBackground(Color.decode("#C9E265"));
        l8.setBackground(Color.decode("#C9E265"));

        jb1.setBounds(250, 230, 200, 50);
        jb1a.setBounds(50, 15, 70, 30);

        tf1.setBounds(180, 120, 200, 25);
        tf2.setBounds(500, 120, 100, 25);
        tf3.setBounds(180, 180, 200, 25);
        tf6.setBounds(500, 180, 100, 25);

        tf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if (Character.isDigit(ch)) {
                    JOptionPane.showMessageDialog(f1, "Enter Alphabets only", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

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

        tf3.addKeyListener(this);
        tf6.addKeyListener(this);

        f1.setContentPane(new JLabel(new ImageIcon("project images\\fifth.png")));

        f1.setSize(700, 500);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.add(jb1);
        f1.add(jb1a);
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l8);
        f1.add(tf1);
        f1.add(tf2);
        f1.add(tf3);
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

            if (tf1.getText().length() == 0 || tf2.getText().length() == 0 || tf3.getText().length() == 0
                    || tf6.getText().length() == 0) {
                JOptionPane.showMessageDialog(f1, "Enter complete patient details to proceed", "Data not Found",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (tf3.getText().length() != 10) {
                JOptionPane.showMessageDialog(f1, "Enter 10 digit mobile number", "Wrong Contact number",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (tf6.getText().length() > 3) {
                JOptionPane.showMessageDialog(f1, "Invalid age", "Age Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (tf2.getText().equalsIgnoreCase("M") || tf2.getText().equalsIgnoreCase("F")
                    || tf2.getText().equalsIgnoreCase("O")) {
                f1.dispose();
                f2 = new JFrame();

                c1 = new Choice();

                jb2 = new JButton("Proceed");

                l9 = new Label("Select Doctor Type and Schedule");
                l10 = new Label("Choose what type of doctor you want");

                i = new ImageIcon("project images\\logo red cross.png");

                l9.setBounds(133, 10, 500, 50);

                l10.setBounds(180, 70, 700, 30);

                l9.setFont(new Font("Serif", Font.BOLD, 30));
                l9.setForeground(Color.RED);
                l9.setBackground(Color.decode("#FFA6A6"));

                l10.setFont(new Font("Serif", Font.ITALIC, 20));
                l10.setBackground(Color.decode("#FFA6A6"));

                c1.add("Dentist");
                c1.add("ENT specialist");
                c1.add("Cardiologist");
                c1.add("Audiologist");
                c1.add("Gynaecologist");
                c1.add("Orthopaedic surgeon");
                c1.add("Paediatrician");
                c1.add("Psychiatrists");
                c1.add("Veterinarian");
                c1.add("Radiologist");
                c1.add("Pulmonologist");
                c1.add("Endocrinologist");
                c1.add("Oncologist");
                c1.add("Neurologist");
                c1.add("Cardiothoracic surgeon");
                c1.add("Child specialist");
                c1.add("Allergist");
                c1.add("Nephrologist");
                c1.add("Gastroenterologist");
                c1.add("Emergency doctor");
                c1.add("Other");

                c1.setFont(new Font("Serif", Font.PLAIN, 23));
                c1.setBounds(150, 300, 400, 50);

                jb2.setFont(new Font("Serif", Font.BOLD, 16));
                jb2.setBounds(250, 380, 200, 50);
                jb2.setBackground(Color.LIGHT_GRAY);
                jb2.addActionListener(this);

                f2.setContentPane(new JLabel(new ImageIcon("project images\\sixth.png")));
                f2.setTitle("e-MAS");
                f2.setSize(700, 500);
                f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f2.setVisible(true);
                f2.setLocationRelativeTo(null);
                f2.setIconImage(i.getImage());
                f2.setResizable(false);
                f2.setLayout(null);
                f2.add(jb2);
                f2.add(c1);

                f2.add(l9);
                f2.add(l10);

            }

            else {
                JOptionPane.showMessageDialog(f1, "Enter only\nM - for male\nF - for female\nO - for others",
                        "Gender error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == jb1a) {

            f1.dispose();
            new Decision();

        } else if (e.getSource() == jb1b) {
            f3.dispose();
            new Decision();

        } else if (e.getSource() == jb2) {

            f2.dispose();
            jb4 = new JButton("Print");
            f3 = new JFrame();
            jb1b = new JButton("Menu");
            r = new Random();
            a = new Random();

            b = r.nextInt(999999);

            l18 = new Label("Booking Successful");
            l19 = new Label("Booking Details");
            l20 = new Label("Booking id : " + String.format("%06d", b));
            l22 = new Label("Patient name : " + tf1.getText().toUpperCase());
            l23 = new Label("Patient's Gender : " + tf2.getText().toUpperCase());
            l24 = new Label("Contact number : " + tf3.getText());
            l27 = new Label("Age : " + tf6.getText());
            l28 = new Label(
                    "Date and Time : " + ca.getTime());
            l30 = new Label("Doctor Type : " + c1.getItem(c1.getSelectedIndex()));
            l31 = new Label("Thank you for booking appointment, the doctor will consult you shortly");

            i = new ImageIcon("project images\\logo red cross.png");
            jb4.setBounds(320, 430, 80, 20);
            jb4.addActionListener(this);
            jb1b.setBounds(50, 15, 70, 30);
            jb1b.addActionListener(this);

            l18.setBounds(220, 9, 500, 50);
            l19.setBounds(270, 90, 150, 30);
            l20.setBounds(35, 130, 400, 20);
            l22.setBounds(35, 150, 400, 20);
            l23.setBounds(35, 170, 400, 20);
            l24.setBounds(35, 190, 400, 20);
            l27.setBounds(35, 210, 400, 20);
            l28.setBounds(35, 230, 400, 20);
            l30.setBounds(35, 250, 400, 20);
            l31.setBounds(35, 350, 600, 30);

            l18.setForeground(Color.RED);

            l18.setFont(new Font("Serif", Font.BOLD, 30));
            l19.setFont(new Font("Serif", Font.ITALIC, 20));
            l31.setFont(new Font("Serif", Font.ITALIC, 20));

            l18.setBackground(Color.decode("#D1FCFF"));
            l19.setBackground(Color.decode("#D1FCFF"));
            l20.setBackground(Color.decode("#D1FCFF"));
            l22.setBackground(Color.decode("#D1FCFF"));
            l23.setBackground(Color.decode("#D1FCFF"));
            l24.setBackground(Color.decode("#D1FCFF"));
            l27.setBackground(Color.decode("#D1FCFF"));
            l28.setBackground(Color.decode("#D1FCFF"));
            l30.setBackground(Color.decode("#D1FCFF"));
            l31.setBackground(Color.decode("#D1FCFF"));

            try {
                audio();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
                e1.printStackTrace();
            }

            f3.setContentPane(new JLabel(new ImageIcon("project images\\seventh.png")));

            f3.setSize(700, 500);
            f3.setLayout(null);
            f3.setVisible(true);
            f3.setIconImage(i.getImage());
            f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f3.setTitle("e-MAS");
            f3.setLocationRelativeTo(null);
            f3.setResizable(false);
            f3.setLayout(null);
            f3.add(jb4);
            f3.add(jb1b);
            f3.add(l18);
            f3.add(l19);
            f3.add(l20);
            f3.add(l22);
            f3.add(l23);
            f3.add(l24);
            f3.add(l27);
            f3.add(l28);
            f3.add(l30);
            f3.add(l31);
        } else if (e.getSource() == jb4) {
            JOptionPane.showMessageDialog(this, "Details saved in your device successfully", "Printed",
                    JOptionPane.INFORMATION_MESSAGE);
            f = new File(fname);

            try {
                if (!f.exists()) {
                    f.createNewFile();
                }
                Writer output = new FileWriter(fname, true);
                output.append("\nBooking id : " + String.format("%06d", b));
                output.append("\nPatient name : " + tf1.getText().toUpperCase());
                output.append("\nPatient's Gender : " + tf2.getText().toUpperCase());
                output.append("\nContact number : " + tf3.getText());
                output.append("\nAge : " + tf6.getText());
                output.append(
                        "\nDate and Time : " + ca.getTime());
                output.append("\nDoctor Type : " + c1.getItem(c1.getSelectedIndex()));
                output.append("\n********************************************************************************\n");
                output.close();

            } catch (IOException p) {
                p.printStackTrace();
            }

        }

    }

    private void audio() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        File file;
        file = new File("project audio\\aud2.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public static void main(String args[]) {
        new Appointment();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String value = tf3.getText();
        String value2 = tf6.getText();
        value.length();
        value2.length();
        if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            tf3.setEditable(true);
            tf6.setEditable(true);

        } else {
            tf3.setEditable(false);
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
