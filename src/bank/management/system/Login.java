package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;
    Login(){
        setTitle("Login");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(600,10,100,100);
        add(image);

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("images/card.png"));
        Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel iimage=new JLabel(ii3);
        iimage.setBounds(1050,660,100,100);
        add(iimage);

        label1=new JLabel("BANK TRANSACTION SYSTEM");
        label1.setFont(new Font("AvantGarde",Font.BOLD,50));
//        label1.setFont(new Font("AvantGarde",Font.ITALIC,40));
        label1.setForeground(Color.black);
        label1.setBounds(310,125,4500,40);
        add(label1);

        label2=new JLabel("CARD NO.: ");
        label2.setFont(new Font("Railway",Font.BOLD,38));
        label2.setForeground(Color.black);
        label2.setBounds(400,300,375,40);
        add(label2);

        textField2=new JTextField(18);
        textField2.setForeground(Color.black);
        textField2.setBounds(620,300,400,35);
        textField2.setFont(new Font("Arial",Font.BOLD,34));
        add(textField2);

        label3=new JLabel("PIN: ");
        label3.setFont(new Font("Railway",Font.BOLD,38));
        label3.setForeground(Color.black);
        label3.setBounds(400,405,375,40);
        add(label3);

        passwordField3=new JPasswordField(18);
        passwordField3.setForeground(Color.black);
        passwordField3.setFont(new Font("Arial",Font.BOLD,38));
        passwordField3.setBounds(620,405,400,35);
        add(passwordField3);

        button1=new JButton("LOGIN");
        button1.setFont(new Font("Arial",Font.BOLD,24));
        button1.setBackground(Color.cyan);
        button1.setForeground(Color.black);
        button1.setBounds(570,510,120,50);
        button1.addActionListener(this);
        add(button1);

        button2=new JButton("CLEAR ALL");
        button2.setFont(new Font("Arial",Font.BOLD,24));
        button2.setBackground(Color.cyan);
        button2.setForeground(Color.black);
        button2.setBounds(710,510,170,50);
        button2.addActionListener(this);
        add(button2);

        button3=new JButton("NEW REGISTER");
        button3.setFont(new Font("Arial",Font.BOLD,24));
        button3.setBackground(Color.cyan);
        button3.setForeground(Color.black);
        button3.setBounds(570,590,310,50);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("images/backbg.png"));
        Image iii2=iii1.getImage().getScaledInstance(1300,820,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel iiimage=new JLabel(iii3);
        iiimage.setBounds(0,0,1300,820);
        add(iiimage);

        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()== button1){
                Connect con = new Connect();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String c = "select * from login where Card_No= '"+cardno+"' and  PIN = '"+pin+"'";
                ResultSet resultSet = con.statement.executeQuery(c);
                if (resultSet.next()) {
                    setVisible(false);
                    new Home(pin);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }
            else if (e.getSource()==button2){
                textField2.setText("");
                passwordField3.setText("");
            }
            else {
                new Register();
                setVisible(false);
            }
        }catch (Exception e1){
            e1.toString();
        }
    }
    public static void main(String[] args) {
        new Login();
    }

}


