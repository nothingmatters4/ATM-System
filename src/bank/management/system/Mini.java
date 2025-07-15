package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    Mini(String pin){
        this.pin = pin;

        setTitle("PassBook");
        getContentPane().setBackground(new Color(255, 255, 255, 255));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2 = new JLabel();
        label2.setFont(new Font("System", Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try{
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from login where PIN = '"+pin+"'");
            while (resultSet.next()){
                label3.setText("Card Number:  "+ resultSet.getString("Card_No").substring(0,4) + "XXXXXXXX"+ resultSet.getString("Card_No").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
            int balance =0;
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where PIN = '"+pin+"'");
            while (resultSet.next()){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("Dates")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("Transaction_Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("Transaction_Type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}