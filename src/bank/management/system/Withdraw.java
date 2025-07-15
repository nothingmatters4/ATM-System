package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton withdraw,back;
    Withdraw(String pin){
        this.pin=pin;

        setTitle("Withdraw");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
        Image i2=i1.getImage().getScaledInstance(1100,790,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1300,820);
        add(image);

        JLabel label1=new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW");
        label1.setForeground(Color.white);
        label1.setBounds(318,180,600,30);
        label1.setFont(new Font("System",Font.BOLD,19));
        image.add(label1);

        JLabel label2=new JLabel("Rs ");
        label2.setForeground(Color.white);
        label2.setBounds(318,230,45,26);
        label2.setFont(new Font("System",Font.BOLD,26));
        image.add(label2);

        textField=new JTextField(50);
        textField.setFont(new Font("System",Font.BOLD,26));
        textField.setBounds(363,230,300,26);
        textField.setBackground(new Color(0,0,0));
        textField.setForeground(Color.white);
        textField.setOpaque(false);
        image.add(textField);

        JLabel note1=new JLabel("(Minimum Limit of Withdrawal is Rs 1000)");
        note1.setForeground(Color.white);
        note1.setBounds(318,260,600,26);
        note1.setFont(new Font("System",Font.BOLD,16));
        image.add(note1);

        JLabel note=new JLabel("(Maximum Limit of Withdrawal is Rs 20000)");
        note.setForeground(Color.white);
        note.setBounds(318,285,600,26);
        note.setFont(new Font("System",Font.BOLD,16));
        image.add(note);

        withdraw=new JButton("WITHDRAW");
        withdraw.setBounds(575,358,185,35);
        withdraw.setBackground(new Color(30, 31, 34));
        withdraw.setFont(new Font("System",Font.BOLD,26));
        withdraw.setForeground(Color.white);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("BACK");
        back.setBounds(575,403,185,35);
        back.setBackground(new Color(30, 31, 34));
        back.setFont(new Font("System",Font.BOLD,26));
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==withdraw) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    Connect con = new Connect();
                    ResultSet resultSet = con.statement.executeQuery("select * from bank where PIN = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("Transaction_Type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("Amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("Amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    else if(Integer.parseInt(amount)>20000) {
                        JOptionPane.showMessageDialog(null, "Maximum Withdrawal Limit is Rs 20000");
                        return;
                    }
                    else if(Integer.parseInt(amount)<1000) {
                        JOptionPane.showMessageDialog(null, "Minimum Withdrawal Limit is Rs 1000");
                        return;
                    }

                    con.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawed Successfully");
                    setVisible(false);
                    new Home(pin);

                }
            } catch (Exception E) {
                E.toString();
            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new Home(pin);
        }
    }

    public static void main(String[] args) {

        new Withdraw("");
    }
}

