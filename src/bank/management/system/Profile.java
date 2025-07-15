package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Profile extends JFrame {
    public Profile(String pin) {
        setTitle("User Profile");
        setSize(1300, 820);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/PROFILE.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1300, 820);
        add(image);


        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setBounds(115, 350, 100, 30);
        image.add(nameLabel);

        JLabel nameValue = new JLabel();
        nameValue.setFont(new Font("Arial", Font.PLAIN, 20));
        nameValue.setBounds(185, 350, 300, 30);
        image.add(nameValue);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
        emailLabel.setBounds(115, 400, 100, 30);
        image.add(emailLabel);

        JLabel emailValue = new JLabel();
        emailValue.setFont(new Font("Arial", Font.PLAIN, 20));
        emailValue.setBounds(185, 400, 300, 30);
        image.add(emailValue);

        JLabel DOBLabel = new JLabel("DOB: ");
        DOBLabel.setFont(new Font("Arial", Font.BOLD, 20));
        DOBLabel.setBounds(115, 450, 100, 30);
        image.add(DOBLabel);

        JLabel dobValue = new JLabel();
        dobValue.setFont(new Font("Arial", Font.PLAIN, 20));
        dobValue.setBounds(185, 450, 300, 30);
        image.add(dobValue);

        JLabel addressLabel = new JLabel("Address: ");
        addressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addressLabel.setBounds(500, 200, 120, 30);
        image.add(addressLabel);

        JLabel addressValue = new JLabel();
        addressValue.setFont(new Font("Arial", Font.PLAIN, 20));
        addressValue.setBounds(630, 200, 400, 30);
        image.add(addressValue);

        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        genderLabel.setBounds(500, 250, 100, 30);
        image.add(genderLabel);

        JLabel genderValue = new JLabel();
        genderValue.setFont(new Font("Arial", Font.PLAIN, 20));
        genderValue.setBounds(630, 250, 300, 30);
        image.add(genderValue);

        JLabel panLabel = new JLabel("PAN No: ");
        panLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panLabel.setBounds(500, 300, 100, 30);
        image.add(panLabel);

        JLabel panValue = new JLabel();
        panValue.setFont(new Font("Arial", Font.PLAIN, 20));
        panValue.setBounds(630, 300, 300, 30);
        image.add(panValue);

        JLabel aadhaarLabel = new JLabel("Aadhaar No: ");
        aadhaarLabel.setFont(new Font("Arial", Font.BOLD, 20));
        aadhaarLabel.setBounds(500, 350, 150, 30);
        image.add(aadhaarLabel);

        JLabel aadhaarValue = new JLabel();
        aadhaarValue.setFont(new Font("Arial", Font.PLAIN, 20));
        aadhaarValue.setBounds(660, 350, 300, 30);
        image.add(aadhaarValue);

        JLabel accTypeLabel = new JLabel("Account Type: ");
        accTypeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        accTypeLabel.setBounds(500, 400, 150, 30);
        image.add(accTypeLabel);

        JLabel accTypeValue = new JLabel();
        accTypeValue.setFont(new Font("Arial", Font.PLAIN, 20));
        accTypeValue.setBounds(660, 400, 300, 30);
        image.add(accTypeValue);

        JLabel serviceLabel = new JLabel("Service: ");
        serviceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        serviceLabel.setBounds(500, 450, 100, 30);
        image.add(serviceLabel);

        JLabel serviceValue = new JLabel();
        serviceValue.setFont(new Font("Arial", Font.PLAIN, 20));
        serviceValue.setBounds(630, 450, 1000, 30);
        image.add(serviceValue);

        JButton back = new JButton("BACK");
        back.setBounds(1050, 660, 150, 40);
        back.setBackground(new Color(30, 31, 34));
        back.setFont(new Font("System", Font.BOLD, 18));
        back.setForeground(Color.white);
        image.add(back);

        back.addActionListener(e -> {
            new Home(pin);
            setVisible(false);
        });


        try {



            Connect conn = new Connect();


            String formNoQuery = "SELECT Form_No FROM login WHERE PIN = ?";
            PreparedStatement formNoStmt = conn.connection.prepareStatement(formNoQuery);
            formNoStmt.setString(1, pin);
            ResultSet formNoRs = formNoStmt.executeQuery();

            String formNo = null;
            if (formNoRs.next()) {
                formNo = formNoRs.getString("Form_No");
            } else {
                JOptionPane.showMessageDialog(null, "User not found!");
                return;
            }


            String query = "SELECT Holder_Name, Email, Date_Of_Birth, Address, Gender FROM register WHERE Form_No = ?";
            PreparedStatement pst = conn.connection.prepareStatement(query);
            pst.setString(1, formNo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nameValue.setText(rs.getString("Holder_Name"));
                emailValue.setText(rs.getString("Email"));
                dobValue.setText(rs.getString("Date_Of_Birth"));
                addressValue.setText(rs.getString("Address"));
                genderValue.setText(rs.getString("Gender"));
            }

            String query2 = "SELECT PAN_No, Aadhar_No FROM register2 WHERE Form_No = ?";
            PreparedStatement pst2 = conn.connection.prepareStatement(query2);
            pst2.setString(1, formNo);
            ResultSet rs2 = pst2.executeQuery();


            if (rs2.next()) {
                panValue.setText(rs2.getString("PAN_No"));
                aadhaarValue.setText(rs2.getString("Aadhar_No"));
            } else {
                panValue.setText("Not Found");
                aadhaarValue.setText("Not Found");
            }


            String query3 = "SELECT Account_Type, Services FROM register3 WHERE Form_No = ?";
            PreparedStatement pst3 = conn.connection.prepareStatement(query3);
            pst3.setString(1, formNo);
            ResultSet rs3 = pst3.executeQuery();


            if (rs3.next()) {
                accTypeValue.setText(rs3.getString("Account_Type"));
                serviceValue.setText(rs3.getString("Services"));
            } else {
                accTypeValue.setText("Not Found");
                serviceValue.setText("Not Found");
            }





            formNoRs.close();
            formNoStmt.close();
            rs.close();
            pst.close();
            rs2.close();
            pst2.close();
            rs3.close();
            pst3.close();
            conn.connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        setVisible(true);
    }

    public static void main(String[] args) {
        new Profile("");
    }
}
