import java.awt.*;
import java.util.Calendar;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class Ambulance extends Frame implements ActionListener, KeyListener {
    Choice c1, c2, c3, c5, c4, c6, c7, c8;
    Random r, a;
    JFrame f1;

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
    Calendar ca = Calendar.getInstance();
    String fname = "project Bookings\\Ambulance bookings.txt";
    File f;
    int b, c;

    Ambulance() {
        f1 = new JFrame();
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
        tf5 = new TextField();
        tf6 = new TextField();
        tf7 = new TextField();
        tf8 = new TextField();
        jb1 = new JButton("SUBMIT");
        jb1a = new JButton("Back");
        l1 = new Label("Ambulance Reservation");
        l2 = new Label("Patient details");
        l3 = new Label("Name");
        l4 = new Label("Blood group");
        l5 = new Label("Contact number");
        l6 = new Label("House number");
        l7 = new Label("City");
        l8 = new Label("Pincode");

        i = new ImageIcon("project images\\logo red cross.png");

        l1.setBounds(210, 10, 400, 50);
        l2.setBounds(280, 60, 160, 30);
        l3.setBounds(50, 110, 100, 50);
        l4.setBounds(400, 110, 100, 50);
        l5.setBounds(50, 170, 100, 50);
        l6.setBounds(50, 230, 100, 50);
        l7.setBounds(400, 230, 50, 50);
        l8.setBounds(50, 290, 100, 50);

        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setForeground(Color.RED);

        l2.setFont(new Font("Serif", Font.ITALIC, 20));

        jb1.setBounds(250, 350, 200, 50);
        jb1a.setBounds(50, 15, 70, 30);

        tf1.setBounds(180, 120, 200, 25);
        tf2.setBounds(500, 120, 100, 25);
        tf3.setBounds(180, 180, 300, 25);
        tf4.setBounds(180, 240, 200, 25);
        tf5.setBounds(450, 240, 200, 25);
        tf6.setBounds(180, 300, 100, 25);

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

        f1.setContentPane(new JLabel(new ImageIcon("project images\\fourth.png")));

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
        f1.add(l6);
        f1.add(l7);
        f1.add(l8);
        f1.add(tf1);
        f1.add(tf2);
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

            if (tf1.getText().length() == 0 || tf2.getText().length() == 0 || tf3.getText().length() == 0
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
            } else if (tf2.getText().equalsIgnoreCase("A+") || tf2.getText().equalsIgnoreCase("B+")
                    || tf2.getText().equalsIgnoreCase("AB+") || tf2.getText().equalsIgnoreCase("O+")
                    || tf2.getText().equalsIgnoreCase("A-") || tf2.getText().equalsIgnoreCase("B-")
                    || tf2.getText().equalsIgnoreCase("AB-") || tf2.getText().equalsIgnoreCase("O-")) {
                f1.dispose();
                f2 = new JFrame();

                c1 = new Choice();
                c2 = new Choice();
                c3 = new Choice();
                c4 = new Choice();
                c5 = new Choice();
                c6 = new Choice();

                jb2 = new JButton("Proceed");

                l9 = new Label("Select Ambulance Type and Schedule");
                l10 = new Label("Choose what type of ambulance you want");
                l11 = new Label("SELECT DATE");
                l12 = new Label("Day");
                l13 = new Label("Month");
                l14 = new Label("SELECT TIME");
                l15 = new Label("Hours");
                l16 = new Label("Minutes");
                l17 = new Label("AM/PM");

                i = new ImageIcon("project images\\logo red cross.png");

                l9.setBounds(110, 10, 500, 50);
                l10.setBounds(175, 70, 700, 30);
                l11.setBounds(20, 180, 150, 40);
                l12.setBounds(250, 150, 50, 40);
                l13.setBounds(400, 150, 50, 40);
                l14.setBounds(20, 280, 150, 40);
                l15.setBounds(250, 250, 50, 40);
                l16.setBounds(400, 250, 70, 40);
                l17.setBounds(550, 250, 700, 40);

                l9.setFont(new Font("Serif", Font.BOLD, 30));
                l9.setForeground(Color.RED);

                l10.setFont(new Font("Serif", Font.ITALIC, 20));
                l11.setFont(new Font("Serif", Font.ITALIC, 20));
                l14.setFont(new Font("Serif", Font.ITALIC, 20));

                c1.add("PATIENT TRANSPORT");
                c1.add("LIFE SUPPORT");
                c1.add("MORTUARY VAN");
                c1.add("AIR AMBULANCE SERVICES");
                c1.setFont(new Font("Serif", Font.PLAIN, 23));
                c1.setBounds(150, 100, 400, 50);

                c2.add("01");
                c2.add("02");
                c2.add("03");
                c2.add("04");
                c2.add("05");
                c2.add("06");
                c2.add("07");
                c2.add("08");
                c2.add("09");
                c2.add("10");
                c2.add("11");
                c2.add("12");
                c2.add("13");
                c2.add("14");
                c2.add("15");
                c2.add("16");
                c2.add("17");
                c2.add("18");
                c2.add("19");
                c2.add("20");
                c2.add("21");
                c2.add("22");
                c2.add("23");
                c2.add("24");
                c2.add("25");
                c2.add("26");
                c2.add("27");
                c2.add("28");
                c2.add("29");
                c2.add("30");
                c2.add("31");
                c2.setFont(new Font("Serif", Font.PLAIN, 23));
                c2.setBounds(240, 180, 50, 30);

                c3.add("Jan");
                c3.add("Feb");
                c3.add("Mar");
                c3.add("Apr");
                c3.add("May");
                c3.add("Jun");
                c3.add("Jul");
                c3.add("Aug");
                c3.add("Sept");
                c3.add("Oct");
                c3.add("Nov");
                c3.add("Dec");
                c3.setFont(new Font("Serif", Font.PLAIN, 23));
                c3.setBounds(390, 180, 70, 30);

                c4.add("01");
                c4.add("02");
                c4.add("03");
                c4.add("04");
                c4.add("05");
                c4.add("06");
                c4.add("07");
                c4.add("08");
                c4.add("09");
                c4.add("10");
                c4.add("11");
                c4.add("12");
                c4.setFont(new Font("Serif", Font.PLAIN, 23));
                c4.setBounds(240, 280, 50, 30);

                c5.add("00");
                c5.add("01");
                c5.add("02");
                c5.add("03");
                c5.add("04");
                c5.add("05");
                c5.add("06");
                c5.add("07");
                c5.add("08");
                c5.add("09");
                c5.add("10");
                c5.add("11");
                c5.add("12");
                c5.add("13");
                c5.add("14");
                c5.add("15");
                c5.add("16");
                c5.add("17");
                c5.add("18");
                c5.add("19");
                c5.add("20");
                c5.add("21");
                c5.add("22");
                c5.add("23");
                c5.add("24");
                c5.add("25");
                c5.add("26");
                c5.add("27");
                c5.add("28");
                c5.add("29");
                c5.add("30");
                c5.add("31");
                c5.add("32");
                c5.add("33");
                c5.add("34");
                c5.add("35");
                c5.add("36");
                c5.add("37");
                c5.add("38");
                c5.add("39");
                c5.add("40");
                c5.add("41");
                c5.add("42");
                c5.add("43");
                c5.add("44");
                c5.add("45");
                c5.add("46");
                c5.add("47");
                c5.add("48");
                c5.add("49");
                c5.add("50");
                c5.add("51");
                c5.add("52");
                c5.add("53");
                c5.add("54");
                c5.add("55");
                c5.add("56");
                c5.add("57");
                c5.add("58");
                c5.add("59");
                c5.setFont(new Font("Serif", Font.PLAIN, 23));
                c5.setBounds(400, 280, 50, 30);

                c6.add("Am");
                c6.add("Pm");
                c6.setFont(new Font("Serif", Font.PLAIN, 23));
                c6.setBounds(550, 280, 60, 30);

                jb2.setFont(new Font("Serif", Font.BOLD, 16));
                jb2.setBounds(250, 380, 200, 50);
                jb2.setBackground(Color.LIGHT_GRAY);
                jb2.addActionListener(this);

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
                f2.add(c2);
                f2.add(c3);
                f2.add(c4);
                f2.add(c5);
                f2.add(c6);
                f2.add(l9);
                f2.add(l10);
                f2.add(l11);
                f2.add(l12);
                f2.add(l13);
                f2.add(l14);
                f2.add(l15);
                f2.add(l16);
                f2.add(l17);
            }

            else {
                JOptionPane.showMessageDialog(f1, "Enter only A+/O+/B+/AB-/A-/O-/B-/AB-", "Blood group error",
                        JOptionPane.ERROR_MESSAGE);

            }

        } else if (e.getSource() == jb1a) {
            f1.dispose();
            new Decision();

        } else if (e.getSource() == jb1b) {
            f3.dispose();
            new Decision();

        } else if (e.getSource() == jb2) {
            if (c2.getItem(c2.getSelectedIndex()) == "31" && c3.getItem(c3.getSelectedIndex()) == "Feb"
                    || c2.getItem(c2.getSelectedIndex()) == "30" && c3.getItem(c3.getSelectedIndex()) == "Feb"
                    || c2.getItem(c2.getSelectedIndex()) == "31" && c3.getItem(c3.getSelectedIndex()) == "Apr"
                    || c2.getItem(c2.getSelectedIndex()) == "31" && c3.getItem(c3.getSelectedIndex()) == "Jun"
                    || c2.getItem(c2.getSelectedIndex()) == "31" && c3.getItem(c3.getSelectedIndex()) == "Sept"
                    || c2.getItem(c2.getSelectedIndex()) == "31" && c3.getItem(c3.getSelectedIndex()) == "Nov") {
                JOptionPane.showMessageDialog(f2, "Select correct date", "Date error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                f2.dispose();
                f3 = new JFrame();
                jb1b = new JButton("Menu");
                jb4 = new JButton("Print");

                r = new Random();
                a = new Random();

                b = r.nextInt(999999);
                c = a.nextInt(9);

                l18 = new Label("Booking Successful");
                l19 = new Label("Booking Details");
                l20 = new Label("Reference id : " + String.format("%06d", b));
                l21 = new Label("Ambulance number : JK-100" + String.format("%01d", c));
                l22 = new Label("Patient name : " + tf1.getText().toUpperCase());
                l23 = new Label("Patient's Blood group : " + tf2.getText().toUpperCase());
                l24 = new Label("Contact number : " + tf3.getText());
                l25 = new Label("House number : " + tf4.getText().toUpperCase());
                l26 = new Label("City : " + tf5.getText().toUpperCase());
                l27 = new Label("Pincode : " + tf6.getText());
                l28 = new Label(
                        "Date : " + c2.getItem(c2.getSelectedIndex()) + " - " + c3.getItem(c3.getSelectedIndex()));
                l29 = new Label(
                        "Time : " + c4.getItem(c4.getSelectedIndex()) + " : " + c5.getItem(c5.getSelectedIndex())
                                + " " + c6.getItem(c6.getSelectedIndex()));
                l30 = new Label("Ambulance Type : " + c1.getItem(c1.getSelectedIndex()));
                l31 = new Label("Thank you for the booking, the payment will charge after service");

                i = new ImageIcon("project images\\logo red cross.png");

                l18.setBounds(220, 9, 500, 50);
                l19.setBounds(270, 60, 500, 30);
                l20.setBounds(35, 100, 400, 20);
                l21.setBounds(35, 120, 400, 20);
                l22.setBounds(35, 140, 400, 20);
                l23.setBounds(35, 160, 400, 20);
                l24.setBounds(35, 180, 400, 20);
                l25.setBounds(35, 200, 400, 20);
                l26.setBounds(35, 220, 400, 20);
                l27.setBounds(35, 240, 400, 20);
                l28.setBounds(35, 260, 400, 20);
                l29.setBounds(35, 280, 400, 20);
                l30.setBounds(35, 300, 400, 20);
                l31.setBounds(95, 380, 600, 30);

                l18.setForeground(Color.RED);

                l18.setFont(new Font("Serif", Font.BOLD, 30));
                l19.setFont(new Font("Serif", Font.ITALIC, 20));
                l31.setFont(new Font("Serif", Font.ITALIC, 20));
                jb1b.setBounds(50, 15, 70, 30);
                jb1b.addActionListener(this);
                jb4.setBounds(320, 430, 80, 20);
                jb4.addActionListener(this);

                try {
                    audio();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
                    e1.printStackTrace();
                }

                f3.setContentPane(new JLabel(new ImageIcon("project images\\third.png")));

                f3.setSize(700, 500);
                f3.setLayout(null);
                f3.setVisible(true);
                f3.setIconImage(i.getImage());
                f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f3.setTitle("e-MAS");
                f3.setLocationRelativeTo(null);
                f3.setResizable(false);
                f3.setLayout(null);
                f3.add(l18);
                f3.add(l19);
                f3.add(l20);
                f3.add(l21);
                f3.add(l22);
                f3.add(l23);
                f3.add(l24);
                f3.add(l25);
                f3.add(l26);
                f3.add(l27);
                f3.add(l28);
                f3.add(l29);
                f3.add(l30);
                f3.add(l31);
                f3.add(jb4);
                f3.add(jb1b);

            }
        } else if (e.getSource() == jb4) {
            JOptionPane.showMessageDialog(this, "Details saved in your device successfully", "Printed",
                    JOptionPane.INFORMATION_MESSAGE);
            f = new File(fname);

            try {
                if (!f.exists()) {
                    f.createNewFile();
                }
                Writer output = new FileWriter(fname, true);
                output.append("\nReference id : " + String.format("%06d", b));
                output.append("\nAmbulance number : JK-100" + String.format("%01d", c));
                output.append("\nPatient name : " + tf1.getText().toUpperCase());
                output.append("\nPatient's Blood group : " + tf2.getText().toUpperCase());
                output.append("\nContact number : " + tf3.getText());
                output.append("\nHouse number : " + tf4.getText().toUpperCase());
                output.append("\nCity : " + tf5.getText().toUpperCase());
                output.append("\nPincode : " + tf6.getText());
                output.append(
                        "\nDate : " + c2.getItem(c2.getSelectedIndex()) + " - " +
                                c3.getItem(c3.getSelectedIndex()));
                output.append(
                        "\nTime : " + c4.getItem(c4.getSelectedIndex()) + " : " +
                                c5.getItem(c5.getSelectedIndex())
                                + " " + c6.getItem(c6.getSelectedIndex()));
                output.append("\nAmbulance Type : " + c1.getItem(c1.getSelectedIndex()));
                output.append("\nBooking date and time : " + ca.getTime());
                output.append("\n********************************************************************************\n");
                output.close();

            } catch (IOException p) {
                p.printStackTrace();
            }

        }

    }

    private void audio() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        File file;
        file = new File("project audio\\aud1.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public static void main(String args[]) {
        new Ambulance();
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
