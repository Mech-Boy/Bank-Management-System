package Login_SignUp;
import Connection.SqlConnection;
import Services.Transactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

   private static  JButton Login,Sign_up,Clear;
   private static JTextField cardTextfield;
   private static  JPasswordField pinPassfield;
    public Login(){

        // Setting the Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,480);
        this.setLocation(350,200);
        this.setTitle("Banking System");
        this.setLayout(null);

        // Adding Icon to the frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(70,10,100,100);
        getContentPane().setBackground(Color.white);
        this.add(l1);

        //Heading of the login page
        JLabel text=new JLabel("Welcome to the Bank ");
        createJLabel(text,270,45,400,40);
        text.setFont(new Font("Osward",Font.BOLD,30));

        JLabel cardNo=new JLabel("CARD NO :");
        createJLabel(cardNo,120,150,150,30);

        JLabel pin=new JLabel("PIN :");
        createJLabel(pin,120,220,150,30);

        // Creating TextField
        cardTextfield=new JTextField();
        createTextField(cardTextfield,300,150,250,30);

        pinPassfield=new JPasswordField();
        createTextField(pinPassfield,300,220,250,30);

        // Creating Buttons
        Login=new JButton("Login");
        createButton(Login,300,295,120,30);

        Clear=new JButton("Clear");
        createButton(Clear,430,295,120,30);

        Sign_up=new JButton("Sign up");
        createButton(Sign_up,300,340,250,30);



        this.setVisible(true);

    }
    public void createButton(JButton btn, int a, int b, int c, int d){
        btn.setFocusable(false);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.white);
        btn.setBounds(a,b,c,d);
//      btn.addActionListener(this);
        this.add(btn);
    }
    public void createTextField(JTextField field, int a, int b, int c, int d){
        field.setBounds(a,b,c,d);
        field.setFont(new Font("Arial",Font.BOLD,18));
        this.add(field);
    }
    public void createJLabel(JLabel label, int a, int b , int c, int d){
        label.setBounds(a,b,c,d);
        label.setFont(new Font("Osward",Font.BOLD,25));
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Login){

            SqlConnection conn=new SqlConnection();

            String cardNo=cardTextfield.getText();
            String pinNo=pinPassfield.getText();

            String query="select * from login where cardno= '"+cardNo+"'and pin='"+pinNo+"'";
            try{
                ResultSet rs= conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Card Number or PIN is wrong");
                }

            }catch (Exception e1){
                System.out.println(e1);
            }


        } else if(e.getSource()==Clear){
            cardTextfield.setText("");
            pinPassfield.setText("");

        }else if(e.getSource()==Sign_up){
            this.setVisible(false);
            new Sign_up_1().setVisible(true);
        }
    }
}
