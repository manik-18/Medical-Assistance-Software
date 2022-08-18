import java.awt.*;

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
import java.io.IOException;

public class medicine_recommendation extends Frame implements ActionListener {
    Choice c1;
    JFrame f1, f2, f3, f4;
    Label l1, l2, l3, l4;
    TextField tf1, tf2, tf3, tf4;
    JButton jb1, jb1a, jb2, jb3, jb4;
    ImageIcon i;

    medicine_recommendation() {
        JOptionPane.showMessageDialog(f1,
                "Medicine will recommend based on the choices you made. So, be careful and choose wisely",
                "ALERT",
                JOptionPane.INFORMATION_MESSAGE);
        f1 = new JFrame();
        c1 = new Choice();
        jb1 = new JButton("SUBMIT");
        jb1a = new JButton("Back");
        l1 = new Label("Medicine Recommendation");
        l2 = new Label("Choose correct option");
        l3 = new Label("Select the problem which you are facing: ");

        i = new ImageIcon("project images\\logo red cross.png");

        l1.setBounds(180, 10, 350, 50);
        l1.setBackground(Color.BLACK);
        l2.setBounds(260, 60, 200, 30);
        l2.setBackground(Color.BLACK);
        l3.setBounds(50, 140, 250, 30);
        l3.setBackground(Color.BLACK);

        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setForeground(Color.RED);

        l2.setFont(new Font("Serif", Font.ITALIC, 20));
        l2.setForeground(Color.green);

        l3.setForeground(Color.white);

        c1.add("Acidity");
        c1.add("Allergy");
        c1.add("Chest pain");
        c1.add("Chicken pox");
        c1.add("Common Cold");
        c1.add("Constipation");
        c1.add("Cough");
        c1.add("Cut in body part");
        c1.add("Dehydration");
        c1.add("Diabetes");
        c1.add("Dry mouth");
        c1.add("Fever in adults");
        c1.add("Fever in children");
        c1.add("Flu");
        c1.add("Food poisoning");
        c1.add("Fungal infection");
        c1.add("Hair Loss");
        c1.add("Head Lice");
        c1.add("Headache");
        c1.add("Irritation in eyes");
        c1.add("Leg cramps");
        c1.add("Loose motion");
        c1.add("Muscle pain");
        c1.add("Pain in ear");
        c1.add("Pain in eyes");
        c1.add("Sore throat");
        c1.add("Stomach ache");
        c1.add("Toothache");
        c1.add("Vomiting");
        c1.add("Other");

        c1.setFont(new Font("Serif", Font.PLAIN, 16));
        c1.setBounds(300, 140, 200, 30);

        jb1.setBounds(280, 210, 100, 40);
        jb1a.setBounds(50, 15, 70, 30);

        f1.setContentPane(new JLabel(new ImageIcon("project images\\thirteen.png")));

        f1.setSize(700, 500);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.add(jb1);
        f1.add(jb1a);
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(c1);
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
            try {
                audio();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
                e1.printStackTrace();
            }
            switch (c1.getItem(c1.getSelectedIndex())) {

                case "Other":
                    String[] connectopts = { "Ambulance booking", "Appointment booking", "Cancel" };
                    int response = JOptionPane.showOptionDialog(f1,
                            "If you have a major problem you can book Ambulance else\nyou can book appointment with a doctor also",
                            "Other",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, connectopts,
                            "Appointment booking");
                    switch (response) {
                        case 0:
                            f1.dispose();
                            new Ambulance();
                            break;
                        case 1:
                            f1.dispose();
                            new Appointment();
                            break;
                        default:
                            JOptionPane.getRootFrame().dispose();
                            break;
                    }
                    break;
                case "Acidity":
                    JOptionPane.showMessageDialog(this,
                            "Take Eno it is a Quick Acidity Remedy that\nProvides Quick Relief Without Causing Side\nEffects.Other medications such as omeprazole\nand ranitidine take longer to work, but may\nprovide more effective relief. See a doctor\nimmediately if you: Have chest pain along with\nsweating, shortness of breath or pain in the arm\nor jaw or Experiencing heartburn symptoms that\ndon't respond to antacids",
                            "Acidity",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Allergy":
                    JOptionPane.showMessageDialog(this,
                            "Take Cetirizine it is an antihistamine used\nto relieve allergy symptoms such as watery\neyes, runny nose, itching eyes/nose, sneezing,\nhives, and itching. Drowsiness, tiredness,\nand dry mouth may occur. Stomach pain may\nalso occur, especially in children. If any of\nthese effects last or get worse, tell your doctor\nor pharmacist promptly.",
                            "Allergy",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Chest pain":
                    JOptionPane.showMessageDialog(this,
                            "Take Aspirin it is used to reduce fever and\nrelieve mild to moderate pain from conditions\nsuch as muscle aches, toothaches, common cold,\nchest pain and headaches or It's best to\navoid lying down for at least two hours after\neating. Avoiding fats, chocolate and citrus\nfoods may also help. Seek emergency treatment\nimmediately if you think you may be having a\nheart attack and especially if your chest\npain is new, unexplained, or lasts more than\na few moments.",
                            "Chest pain",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Chicken pox":
                    JOptionPane.showMessageDialog(this,
                            "Calamine lotion and a cool bath with added \nbaking soda, uncooked oatmeal, or colloidal \noatmeal may help relieve some of the itching. Try\nto keep fingernails trimmed short and \nminimize scratching to prevent the virus from \nspreading to others and to help prevent skin\ninfections.Take Paracetamol to reduce fever\nand consult the doctor for medical advice.",
                            "Chicken Pox",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Common Cold":
                    JOptionPane.showMessageDialog(this,
                            "Use decongestant drops or sprays like otrivin\nwhich is used to relieve nasal congestion in\nthe upper respiratory tract. Adults can use for up\nto five days. Prolonged use can cause rebound\nsymptoms. Children younger than 6 years old\nshouldn't use decongestant drops or sprays.\nTalk to your doctor before using decongestants.",
                            "Common Cold",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Constipation":
                    JOptionPane.showMessageDialog(this,
                            "When you need gentle and fast-acting constipation\nrelief, in as little as 30 minutes, reach for \nDulcolax Liquid Laxative which contains the active\ningredient, magnesium hydroxide, which draws water\ninto the colon to help stool to pass.\nSee a doctor immediately if you have severe,\npersistent abdominal pain and bloating or Can't pass stool",
                            "Constipation",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Cough":
                    JOptionPane.showMessageDialog(this,
                            "Dextromethorphan is used to treat a cough and\nis available over the counter in syrup, capsule,\nspray, tablet. Honey and saltwater gargles are\npopular home remedies for coughing. You can also\ndrink herbal teas made of peppermint, ginger\netc. See your doctor if you experience \nchills,dehydration,fever more than 101°F, \nproductive cough that has foul-smelling, thick,\ngreen- or yellow-tinted phlegm and weakness.",
                            "Cough",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Cut in body part":
                    JOptionPane.showMessageDialog(this,
                            "Apply antibiotic ointments (Bacitracin, \nPolysporin, Neosporin) to prevent infection. Cover\nthe wound with a bandage to keep out harmful bacteria\nand dirt. Change the bandage 3 times a day and\nmonitor for signs of infection (the same\nsigns as in the cuts section). Change the bandage\nif it becomes wet or dirty.",
                            "Cut in body part",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Dehydration":
                    JOptionPane.showMessageDialog(this,
                            "Drinking water, oral rehydration solution\n(ORS) or sports drinks to replace lost fluids may\nhelp prevent dehydration. Finding a place to cool down\nmay also help. See a doctor immediately if you:\nBecome dizzy or confused, Feel extreme\nthirst, Don't urinate much or often, Shed no tears\nwhen you cry, Are tired or exhausted",
                            "Dehydration",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Diabetes":
                    JOptionPane.showMessageDialog(this,
                            "Metformin (Fortamet, Glumetza, others) is\ngenerally the first medication prescribed for diabetes.\nIt works primarily by lowering glucose production\nin the liver and improving your body's sensitivity\nto insulin so that your body uses insulin\nmore effectively.",
                            "Diabetes",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Dry mouth":
                    JOptionPane.showMessageDialog(this,
                            "If you have severe dry mouth, your doctor\nor dentist may: Prescribe medication that stimulates saliva.\nYour doctor may prescribe pilocarpine (Salagen)\nor cevimeline (Evoxac) to stimulate saliva\nproduction. See a doctor immediately if you Suddenly\ndevelop dry mouth Also urinate frequently or\nhave infections",
                            "Dry mouth",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Fever in adults":
                    JOptionPane.showMessageDialog(this,
                            "If you're uncomfortable, take acetaminophen\n(Tylenol, others), ibuprofen (Advil, Motrin IB, others)\nor aspirin. Read the label carefully for proper\ndosage, and be careful not to take more than one\nmedication containing acetaminophen, such as\nsome cough and cold medicines like paracetamol.",
                            "Fever in adults",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Fever in children":
                    JOptionPane.showMessageDialog(this,
                            "Medications such as paracetamol and ibuprofen\nmay help to ease discomfort. Avoid giving children aspirin\nbecause this may cause a rare, serious\ncondition. See a doctor immediately if your child has\nfever more than 101°F.",
                            "Fever in children",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Flu":
                    JOptionPane.showMessageDialog(this,
                            "Flu is primarily treated with rest and fluid\nintake to allow the body to fight the infection on its own.\nParacetamol may help cure the symptoms\nbut NSAIDs should be avoided. An annual vaccine can help\nprevent the flu and limit its complications.\nYou can take FDA-approved antiviral drugs like\nzanamivir or peramivir",
                            "Flu",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Food poisoning":
                    JOptionPane.showMessageDialog(this,
                            "Most food poisoning is mild and resolves without\ntreatment.In some cases, adults can take medicines such\nas loperamide link (Imodium) and bismuth\nsubsalicylate link (Pepto-Bismol, Kaopectate) to treat\ndiarrhea caused by food poisoning.",
                            "Food poisoning",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Fungal infection":
                    JOptionPane.showMessageDialog(this,
                            "Antifungal medicines are used to treat fungal \ninfections, which most commonly affect your \nskin, hair and nails. Antifungal medicines include:\nclotrimazole (Canesten), econazole, miconazole,  terbinafine\n (Lamisil), fluconazole (Diflucan), ketoconazole\n(Daktarin),  nystatin (Nystan), amphotericin.",
                            "Fungal infection",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Hair Loss":
                    JOptionPane.showMessageDialog(this,
                            "A dermatologist may recommend topical minoxidil,\nwhich is also available over the counter.\nA doctor might also prescribe oral finasteride for men.\nThese medications are FDA-approved for certain conditions\nthat cause hair loss. Biotin, also known as vitamin B7,\nis a complex B vitamin that is often touted for having\nhair growth benefits",
                            "Hair Loss",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Head Lice":
                    JOptionPane.showMessageDialog(this,
                            "Medicated shampoos like mediker or combing and\nremoving the nits from the hair is helpful.\nPermethrin lotion 1% is approved by the FDA for the treatment\nof head lice. Permethrin is safe and effective when\nused as directed. Permethrin kills live lice but not\nunhatched eggs. Permethrin may continue to kill newly hatched\nlice for several days after treatment.",
                            "Head Lice",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Headache":
                    JOptionPane.showMessageDialog(this,
                            "Remedies that may reduce headache pain include\naspirin, paracetamol and ibuprofen. Resting\nin a darkened room may also help. Make an appointment to see a\ndoctor if you: Start having frequent headaches, getting\nworse over time,Can't work, sleep or do daily\nactivities, Don't improve with self-treatment",
                            "Headache",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Irritation in eyes":
                    JOptionPane.showMessageDialog(this,
                            "Antihistamine pills and liquids work by blocking\nhistamine to relieve watery, itchy eyes.\nThey include cetirizine (Zyrtec), diphenhydramine (Benadryl),\nfexofenadine (Allegra), or loratadine (Alavert, Claritin),\namong others. Some may cause drowsiness.\nAntihistamine eye drops work well for itchy, watery\neyes.",
                            "Irritation in eyes",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Leg cramps":
                    JOptionPane.showMessageDialog(this,
                            "Stretching and massaging the muscle may help it relax\n. Applying heat or cold to the area may also help.\nYou can take Carisoprodol which is a muscle relaxant\nor Orphenadrine which relieves pain and stiffness in\nmuscles.",
                            "Leg cramps",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Loose motion":
                    JOptionPane.showMessageDialog(this,
                            "Replacing lost fluids with an oral rehydration solution\n(ORS) may help to prevent dehydration. Antidiarrhoeal\ndrugs such as loperamide may also help. Make an\nappointment to see a doctor if you have diarrhoea that\ndoesn't improve within two days or Pass stool\nthat's bloody or black",
                            "Loose motion",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Muscle pain":
                    JOptionPane.showMessageDialog(this,
                            "You can take paracetamol or Anaprox to relieve muscle\npain or you can apply ointments like volini and moov to\nget fast action. See a doctor immediately if the\npain is too much or you feel that the muscle is broken.",
                            "Muscle pain",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Pain in ear":
                    JOptionPane.showMessageDialog(this,
                            "Acetaminophen, ibuprofen, or naproxen can often relieve\nthe pain of an earache. See a doctor immediately if you:\nAre an adult, Have discharge from the ear, Feel\nsevere pain, Experience difficulty hearing",
                            "Pain in ear",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Pain in eyes":
                    JOptionPane.showMessageDialog(this,
                            "For mild cases of eye discomfort, rest the eyes, take \nover-the-counter pain relievers such as ibuprofen (Advil) \nor acetaminophen (Tylenol), and avoid bright light.",
                            "Pain in eyes",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Sore throat":
                    JOptionPane.showMessageDialog(this,
                            "Drinking plenty of liquids, gargling with warm salt water\nand if over four years old, sucking on lozenges may ease\na sore throat. Taking pain medication such as ibuprofen\nor paracetamol may also help. Avoid giving aspirin to children\nbecause this may cause a rare, serious condition.",
                            "Sore throat",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Stomach ache":
                    JOptionPane.showMessageDialog(this,
                            "Pepto Bismol can help ease symptoms of a stomach ache like\nnausea and diarrhea. You can help a stomach ache by taking\nmedications like Pepto Bismol, Gas-X, Gaviscon, Tums,\nand Rolaids. Pepto Bismol helps symptoms like nausea, Gaviscon\ncan help heartburn, and Gas X is best for stomach\naches caused by excess gas.",
                            "Stomach ache",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Toothache":
                    JOptionPane.showMessageDialog(this,
                            "Using medications such as ibuprofen (Advil, Motrin),\nacetaminophen (Tylenol), and aspirin can relieve minor pain\nfrom a toothache. Using numbing pastes or gels — often with\nbenzocaine — can help to dull the pain long enough for you to\nfall asleep. See a doctor immediately if you Develop\na fever or Have red, swollen gums or foul-smelling\ndischarge",
                            "Toothache",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Vomiting":
                    JOptionPane.showMessageDialog(this,
                            "Taking small sips of oral rehydration solution (ORS)\nmay help prevent dehydration. If fluids stay down, eating toast,\ncrackers, gelatin or other easy-to-digest foods may ease\nan upset stomach. See a doctor immediately if you: Have chest\npain, blurry vision, confusion, high fever or stiff\nneck or Notice blood, faecal matter or a green colour\nin your vomit",
                            "Vomiting",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

            }

        } else if (e.getSource() == jb1a) {
            f1.dispose();
            new Decision();
        }
    }

    private void audio() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        File file;
        file = new File("project audio\\aud5.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public static void main(String args[]) {
        new medicine_recommendation();
    }

}
