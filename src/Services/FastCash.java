package Services;

import Connection.SqlConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    private JLabel heading;
    private JButton a1, a2, a3, a4, a5, a7, back;

    private String pinNO;

    public FastCash(String pinno) {
        // Initialize JFrame
        super("Transaction");
        setSize(700, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Set background color
        getContentPane().setBackground(new Color(164, 162, 162));

        // Create and add components
        initializeComponents(pinno);

        // Make frame visible
        setVisible(true);

        pinNO=pinno;
    }

    private void initializeComponents(String pinNO) {

        heading = new JLabel("Welcome to our Bank");
        heading.setBounds(470, 70, 200, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 15));
        heading.setForeground(Color.white);
        add(heading);

        JTextField tf = new JTextField("    Please Select Transaction Amount");
        tf.setBounds(150, 150, 450, 50);
        tf.setFont(new Font("Raleway", Font.BOLD, 25));
        Color backgroundColor = tf.getBackground();
        tf.setCaretColor(backgroundColor);
        tf.setEditable(false);
        add(tf);

        // Buttons
        a1 = createButton("Rs.100", 150, 250);
        a2 = createButton("Rs.500 ", 400, 250);
        a3 = createButton("Rs.1000", 150, 320);
        a4 = createButton("Rs.2000 ", 400, 320);
        a5 = createButton("Rs.5000", 150, 390);
        a7 = createButton("Rs.10000", 400, 390);
        back = createButton(" Back", 400, 460);
    }

    private JButton createButton(String label, int x, int y) {
        JButton button = new JButton(label);
        button.setBounds(x, y, 200, 50);
        button.setFont(new Font("Raleway", Font.BOLD, 16));
//        button.setForeground(Color.white);
        button.addActionListener(this);
//        button.setBackground(Color.darkGray);
        add(button);
        return button;
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinNO).setVisible(true);
        } else {
            String fastCashAmount=((JButton)e.getSource()).getText().substring(3);
            Date date=new Date();
            SqlConnection con=new SqlConnection();
            try{
                ResultSet rs= con.s.executeQuery("select * from bank where pin='"+pinNO+"' ");
                int bankBalance=0;
                while (rs.next()){
                    if (rs.getString("type").equals("deposit")){
                        bankBalance+=Integer.parseInt(rs.getString("amount"));
                    }else {
                        bankBalance-=Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (e.getSource()!= back && bankBalance<Integer.parseInt(fastCashAmount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }else {
                    String query="insert into bank values('"+pinNO+"','"+date+"','withdraw','"+fastCashAmount+"')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs."+fastCashAmount+" Debited Successfully");
                    setVisible(false);
                    new Transactions(pinNO).setVisible(true);
                }

            }catch (Exception e1){
                System.out.println(e1);
            }
        }
    }
}



