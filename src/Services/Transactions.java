package Services;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    public JLabel heading;
    public JButton deposit, cashWithdraw, fastCash, minStatement, pinChange, balance, exit;

    public String pinNO;

    public Transactions(String pinno) {
        // Initialize JFrame
        super("Transaction");
        setSize(700, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Set background color
        getContentPane().setBackground(new Color(208, 206, 206));

        // Create and add components
        initializeComponents(pinno);

        // Make frame visible
        setVisible(true);

        pinNO=pinno;
    }

    private void initializeComponents(String pinno) {

        heading = new JLabel("Welcome to our Bank");
        heading.setBounds(470, 70, 200, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 15));
        heading.setForeground(Color.black);
        add(heading);

        JTextField tf = new JTextField("       Please Select Your Transaction");
        tf.setBounds(125, 150, 475, 50);
        tf.setFont(new Font("Raleway", Font.BOLD, 25));
        Color backgroundColor = tf.getBackground();
        tf.setCaretColor(backgroundColor);
        tf.setEditable(false);
        add(tf);

        // Buttons
        deposit = createButton("Deposit", 125, 250);
        cashWithdraw = createButton("Cash Withdraw", 400, 250);
        fastCash = createButton("Fast Cash", 125, 320);
        minStatement = createButton("Minimum Statement", 400, 320);
        pinChange = createButton("PIN Change", 125, 390);
        balance = createButton("Balance", 400, 390);
        exit = createButton("Exit", 125, 460);
        exit.setBounds(150,500,400,50);
    }

    private JButton createButton(String label, int x, int y) {
        JButton button = new JButton(label);
        button.setBounds(x, y, 200, 50);
        button.setFont(new Font("Raleway", Font.BOLD, 16));
//        button.setForeground(Color.white);
        button.addActionListener(this);
        button.setFocusable(false);
//        button.setBackground(Color.darkGray);
        add(button);
        return button;
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinNO).setVisible(true);
        } else if (e.getSource()==cashWithdraw) {
            setVisible(false);
            new Withdraw(pinNO).setVisible(true);
        }else if (e.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinNO).setVisible(true);
        }else if (e.getSource()==pinChange) {
            setVisible(false);
            new PinChange(pinNO).setVisible(true);
        }else if (e.getSource()==balance) {
            setVisible(false);
            new Balance(pinNO).setVisible(true);
        }else if (e.getSource()==minStatement) {
            setVisible(false);
            new MiniStatement(pinNO).setVisible(true);
        }
=======
//        if (e.getSource() == exit) {
//            System.exit(0);
//        } else if (e.getSource()==deposit) {
//            setVisible(false);
//            new Deposit(pinNO).setVisible(true);
//        } else if (e.getSource()==cashWithdraw) {
//            setVisible(false);
//            new Withdraw(pinNO).setVisible(true);
//        }else if (e.getSource()==fastCash) {
//            setVisible(false);
//            new fastcash(pinNO).setVisible(true);
//        }else if (e.getSource()==pinChange) {
//            setVisible(false);
//            new pinChange(pinNO).setVisible(true);
//        }else if (e.getSource()==balance) {
//            setVisible(false);
//            new BalanceEnquiry(pinNO).setVisible(true);
//        }else if (e.getSource()==minStatement) {
//            setVisible(false);
//            new miniStatement(pinNO).setVisible(true);
//        }
>>>>>>> parent of 5dcb38c (Files Added)
    }
}
