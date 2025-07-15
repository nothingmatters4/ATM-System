package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;
    JLabel label2;
    JButton back;
    BalanceEnquiry(String pin){
        this.pin =pin;

        setTitle("Balance");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
        Image i2=i1.getImage().getScaledInstance(1100,790,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1300,820);
        add(image);

        JLabel label1 = new JLabel("Your Current Balance is ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 19));
        label1.setBounds(430,180,700,35);
        image.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 19));
        label2.setBounds(430,220,400,35);
        image.add(label2);

        back=new JButton("BACK");
        back.setBounds(590,403,167,35);
        back.setBackground(new Color(30, 31, 34));
        back.setFont(new Font("System",Font.BOLD,26));
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        int balance =0;
        try{
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where PIN = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("Transaction_Type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }
        }catch (Exception e){
            e.toString();
        }

        label2.setText("Rs "+balance);

        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Home(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}