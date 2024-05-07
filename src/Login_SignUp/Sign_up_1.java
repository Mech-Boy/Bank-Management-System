package Login_SignUp;

import Connection.SqlConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Sign_up_1 extends JFrame  {

    private final Random random;
    private final JLabel heading1, heading2, nameLabel, fatherNameLabel, dobLabel, emailLabel, cityLabel, genderLabel,
                         maritalStatusLabel, addressLabel, stateLabel, pincodeLabel;
    private final JTextField nameField, fatherNameField, addressField, cityField, stateField, pincodeField, emailField;
    private final JRadioButton maleRadio, femaleRadio, marriedRadio, unmarriedRadio, otherRadio;
    private final ButtonGroup genderGroup, maritalGroup;
    private final JButton nextButton;

    public Sign_up_1() {
        random = new Random();
        long formNumber = Math.abs((random.nextLong() % 9000L) + 1000L);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 800);
        setLocation(350, 10);
        setTitle("Detail Form");
        setLayout(null);

        // Headings
        heading1 = createLabel("Application Form NO. : " + formNumber, 200, 10, 450, 35, 30);
        heading2 = createLabel("Page 1: Personal Details", 250, 80, 400, 30, 24);

        // Text Fields
        nameLabel = createLabel("Name:", 100, 140, 200, 30, 20);
        nameField = createTextField(300, 140, 400, 30);

        fatherNameLabel = createLabel("Father's Name:", 100, 190, 200, 30, 20);
        fatherNameField = createTextField(300, 190, 400, 30);

        dobLabel = createLabel("Date of Birth:", 100, 240, 200, 30, 20);

        genderLabel = createLabel("Gender:", 100, 290, 200, 30, 20);
        maleRadio = createRadioButton("Male", 300, 290);
        femaleRadio = createRadioButton("Female", 460, 290);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        emailLabel = createLabel("Email:", 100, 340, 200, 30, 20);
        emailField = createTextField(300, 340, 400, 30);

        maritalStatusLabel = createLabel("Marital Status:", 100, 390, 200, 30, 20);
        marriedRadio = createRadioButton("Married", 300, 390);
        unmarriedRadio = createRadioButton("Unmarried", 460, 390);
        otherRadio = createRadioButton("Other", 620, 390);
        maritalGroup = new ButtonGroup();
        maritalGroup.add(marriedRadio);
        maritalGroup.add(unmarriedRadio);
        maritalGroup.add(otherRadio);

        addressLabel = createLabel("Address:", 100, 440, 200, 30, 20);
        addressField = createTextField(300, 440, 400, 30);

        cityLabel = createLabel("City:", 100, 490, 200, 30, 20);
        cityField = createTextField(300, 490, 400, 30);

        stateLabel = createLabel("State:", 100, 540, 200, 30, 20);
        stateField = createTextField(300, 540, 400, 30);

        pincodeLabel = createLabel("PIN Code:", 100, 590, 200, 30, 20);
        pincodeField = createTextField(300, 590, 400, 30);

        // Button
        nextButton = createButton("Next", 550, 680, 150, 30);
//        nextButton.addActionListener(this);

        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Raleway", Font.BOLD, fontSize));
        add(label);
        return label;
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sign_up_1::new);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            String formNo = "" + random;
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String dob=null;
            String gender = maleRadio.isSelected() ? "Male" : "Female";
            String email = emailField.getText();
            String maritalStatus;
            if (marriedRadio.isSelected()) {
                maritalStatus = "Married";
            } else if (unmarriedRadio.isSelected()) {
                maritalStatus = "Unmarried";
            } else {
                maritalStatus = "Other";
            }
            String address = addressField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String pincode = pincodeField.getText();

            // Form validation
            try {

//Form Validation
                if (name.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Name is required !");
                } else if (fatherName.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fathers Name is required !");
                } else if (email.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Email is required !");
                } else if (state.isEmpty()){
                    JOptionPane.showMessageDialog(null,"State is required !");
                } else if (pincode.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Pin-code is required !");
                } else if (address.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Address is required !");
                }

                else {
                    SqlConnection c=new SqlConnection();
                    String query=
                            "insert into signup values('"+formNo+"','"+name+"', '"+fatherName+"','"+dob+"','"+email+"','"+gender
                                    +"','"+maritalStatus+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";

                    c.s.executeUpdate(query);
                    this.setVisible(false);
                    new Sign_up_2(formNo).setVisible(true);
                }


            }catch (Exception e1){
                System.out.println(e1);
            }
        }
    }
}
