package Login_SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign_up_2 extends JFrame implements ActionListener {

    private final JLabel heading2, religion, category, income, education, occupation, panNo, adharNO, seniorCitizen, existingAcc;
    private final JTextField panT, adharT;
    private final JComboBox<String> religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    private final JRadioButton yesAcc, noAcc, yesCitizen, noCitizen;

    private final ButtonGroup accGroup, citizenGroup;
    private final JButton next;
    private final String formno;

    Sign_up_2(String formno) {
        this.formno = formno;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 800);
        setLocation(350, 10);
        setTitle("Detail Form");
        setLayout(null);

        heading2 = createLabel("Page 2: Additional Details", 250, 80, 400, 30, 24);
        add(heading2);

        // Remaining Text
        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian"};
        religion = createLabel("Religion:", 100, 140, 200, 30, 20);
        religionBox = createComboBox(valReligion, 300, 140, 400, 30);

        String[] valCategory = {"Open", "EWS", "SEBC", "OBC", "SC/ST", "Other"};
        category = createLabel("Category:", 100, 190, 200, 30, 20);
        categoryBox = createComboBox(valCategory, 300, 190, 400, 30);

        String[] valIncome = {"Null", "< 1,00,000", "< 5,00,000", "< 8,00,000", "> 8,00,000"};
        income = createLabel("Income:", 100, 240, 200, 30, 20);
        incomeBox = createComboBox(valIncome, 300, 240, 400, 30);

        String[] valEducation = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        education = createLabel("Education:", 100, 290, 200, 30, 20);
        educationBox = createComboBox(valEducation, 300, 290, 400, 30);

        String[] valOccupation = {"Un-Employed", "Employed", "Businessmen", "Student", "Other"};
        occupation = createLabel("Occupation:", 100, 340, 200, 30, 20);
        occupationBox = createComboBox(valOccupation, 300, 340, 400, 30);

        panNo = createLabel("PAN No:", 100, 390, 200, 30, 20);
        panT = createTextField(300, 390, 400, 30);

        adharNO = createLabel("Adhar No:", 100, 440, 200, 30, 20);
        adharT = createTextField(300, 440, 400, 30);

        seniorCitizen = createLabel("Senior Citizen:", 100, 490, 200, 30, 20);
        yesCitizen = createRadioButton("Yes", 300, 490);
        noCitizen = createRadioButton("NO", 460, 490);
        citizenGroup = new ButtonGroup();
        citizenGroup.add(yesCitizen);
        citizenGroup.add(noCitizen);

        existingAcc = createLabel("Existing Account:", 100, 540, 200, 30, 20);
        yesAcc = createRadioButton("Yes", 300, 540);
        noAcc = createRadioButton("NO", 460, 540);
        accGroup = new ButtonGroup();
        accGroup.add(yesAcc);
        accGroup.add(noAcc);

        next = createButton("Next", 550, 680, 150, 30);
        next.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Raleway", Font.BOLD, fontSize));
        add(label);
        return label;
    }

    private JComboBox<String> createComboBox(String[] values, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(values);
        comboBox.setBounds(x, y, width, height);
        comboBox.setBackground(Color.WHITE);
        add(comboBox);
        return comboBox;
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(new Font("Raleway", Font.BOLD, 15));
        add(textField);
        return textField;
    }

    private JRadioButton createRadioButton(String text, int x, int y) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 150, 30);
        add(radioButton);
        return radioButton;
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFocusable(false);
        button.setBackground(Color.BLACK);
        button.setForeground(new Color(255, 151, 38));
        button.setBounds(x, y, width, height);
        add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle Next Button Action
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Sign_up_2("FormNo"));
    }
}
