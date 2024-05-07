package Services;

import Connection.SqlConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    private String pinNo;

    private JLabel heading,Pin,RePin;
    private JTextField pin,repin;
    private JButton submit,back;

    PinChange(String pinno){
        super("PIN Change");
        setSize(700, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        pinNo=pinno;
        // Set background color
        getContentPane().setBackground(new Color(164, 162, 162));

        // Create and add components
        initializeComponents(pinNo);
    }

    private void  initializeComponents(String pinNo){
        //Labels
        heading = createLabel("Welcome to out Bank ",470, 70, 200, 30,15);
        Pin=createLabel("PIN : ",70, 200, 100, 40,27);
        RePin=createLabel("Re-Enter PIN : ",70, 300, 200, 40,27);

        pin = createTextField(300, 200, 300, 50,18);
        repin =createTextField(300, 300, 300, 50,18);

        submit=createButton("Submit",400,460);
        back=createButton("Back",400,520);

    }
    private JLabel createLabel(String label, int a,int b,int c, int d, int size){
        JLabel l1 =new JLabel(label);
        l1.setBounds(a,b,c,d);
        l1.setFont(new Font("Arial", Font.BOLD, size));
        l1.setForeground(Color.white);
        this.add(l1);
        return l1;
    }

    private JTextField createTextField(int a,int b,int c, int d, int size){
        JTextField j1=new JTextField();
        j1.setBounds(a,b,c,d);
        j1.setFont(new Font("Raleway", Font.BOLD, size));
        j1.setEditable(true);
        add(j1);
        return j1;
    }

    private JButton createButton(String label, int x, int y) {
        JButton button = new JButton(label);
        button.setBounds(x, y, 200, 50);
        button.setFont(new Font("Raleway", Font.BOLD, 16));
        button.addActionListener(this);
        button.setFocusable(false);
        add(button);
        return button;
    }


    public static void main(String[] args) {
     new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }else if(e.getSource()==submit)
       {

//checking for empty and non-matching pin
            if(pin.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Enter the pin");
            } else if(repin.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Re-Enter the pin");
            } else if (!pin.getText().equals(repin.getText())){
                JOptionPane.showMessageDialog(null,"Pin and Re-Entered pin don't match");
            }


            try {
                SqlConnection con=new SqlConnection();
                String query1 = "update bank set pin='"+repin.getText()+"' where pin='"+pinNo+"'" ;
                String query2 = "update login set pin='"+repin.getText()+"' where pin='"+pinNo+"'" ;
                String query3 = "update signupthree set pin='"+repin.getText()+"' where pin='"+pinNo+"'" ;


                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                setVisible(false);
                new Transactions(pinNo).setVisible(true);


            }catch (Exception e1){
                System.out.println(e1);
            }

        }
    }
}

