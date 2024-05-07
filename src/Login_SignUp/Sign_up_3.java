package Login_SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Sign_up_3 extends JFrame implements ActionListener {

    private JLabel heading, account, card, cardno, cdetail, pin, pinno, pdetail, service;
    private JButton submit, cancel;
    private JRadioButton r1, r2, r3, r4;
    private ButtonGroup b1;
    private JCheckBox c1, c2, c3, c4, c5, c6, c7;
    private String formno;

    public Sign_up_3(String formno) {
        this.formno = formno;

        setTitle("Account Details");
        setSize(850, 820);
        setLocation(350, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        initializeComponents();

        setVisible(true);
    }

    private void initializeComponents() {
        heading = createLabel("Page 3: Account Details", 270, 80, 400, 30, 24);
        account = createLabel("Account Type :", 100, 160, 200, 40, 22);

        r1 = createRadioButton("Saving Account", 100, 210);
        r2 = createRadioButton("Fixed Deposit Account", 350, 210);
        r3 = createRadioButton("Current Account", 100, 260);
        r4 = createRadioButton("Recurring Deposit Account", 350, 260);
        r4.setBounds(350, 260,300,20);
        b1 = new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);
        b1.add(r4);

        card = createLabel("Card Number :", 100, 320, 200, 30, 22);
        cardno = createLabel("XXXX-XXXX-XXXX-5954", 310, 320, 300, 30, 22);
        cdetail = createLabel("Your 16 Digit Card Number", 100, 350, 300, 20, 12);

        pin = createLabel("PIN :", 100, 400, 200, 30, 22);
        pinno = createLabel("XXXX", 310, 400, 100, 30, 22);
        pdetail = createLabel("Your 4 Digit Password", 100, 430, 300, 20, 12);

        service = createLabel("Service Required", 100, 470, 200, 30, 22);

        c1 = createCheckBox("ATM Card", 100, 530);
        c2 = createCheckBox("Internet Banking", 350, 530);
        c3 = createCheckBox("Mobile Banking", 100, 570);
        c4 = createCheckBox("Email & SMS Alerts", 350, 570);

        c5 = createCheckBox("Cheque Book", 100, 610);
        c6 = createCheckBox("E-Statement", 350, 610);

        c7 = createCheckBox("I hereby declare that the details above are correct to the best of my acknowledgment.", 100, 665);
        c7.setBounds(100, 665,700,20);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));

        submit = createButton("Submit", Color.BLACK, new Color(255, 151, 38), 600, 710);
        cancel = createButton("Cancel", Color.WHITE, new Color(241, 91, 0), 450, 710);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Osward", Font.BOLD, fontSize));
        add(label);
        return label;
    }

    private JRadioButton createRadioButton(String label, int x, int y) {
        JRadioButton radioButton = new JRadioButton(label);
        radioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        radioButton.setBounds(x, y, 200, 20);
        radioButton.setBackground(Color.WHITE);
        radioButton.setFocusable(false);
        add(radioButton);
        return radioButton;
    }

    private JCheckBox createCheckBox(String label, int x, int y) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBox.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox.setBounds(x, y, 200, 20);
        checkBox.setBackground(Color.WHITE);
        checkBox.setFocusable(false);
        add(checkBox);
        return checkBox;
    }

    private JButton createButton(String label, Color bgColor, Color fgColor, int x, int y) {
        JButton button = new JButton(label);
        button.setFocusable(false);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setBounds(x, y, 100, 30);
        button.addActionListener(this);
        add(button);
        return button;
    }

    public static void main(String[] args) {
        new Sign_up_3("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            // Handle submit action
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}

