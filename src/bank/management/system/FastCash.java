package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String pin;
    FastCash(String pin){
        this.pin =pin;

        setTitle("Fast Cash");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
        Image i2=i1.getImage().getScaledInstance(1100,790,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1300,820);
        add(image);

        JLabel label1=new JLabel("SELECT WITHDRAWAL AMOUNT");
        label1.setForeground(Color.white);
        label1.setBounds(325,180,600,30);
        label1.setFont(new Font("System",Font.BOLD,22));
        image.add(label1);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(30, 31, 34));
        b1.setBounds(320,268,160,35);
        b1.setFont(new Font("System",Font.BOLD,22));
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(30, 31, 34));
        b2.setBounds(600,268,160,35);
        b2.setFont(new Font("System",Font.BOLD,22));
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(30, 31, 34));
        b3.setBounds(320,313,160,35);
        b3.setFont(new Font("System",Font.BOLD,22));
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(30, 31, 34));
        b4.setBounds(600,313,160,35);
        b4.setFont(new Font("System",Font.BOLD,22));
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(30, 31, 34));
        b5.setBounds(320,358,160,35);
        b5.setFont(new Font("System",Font.BOLD,22));
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(30, 31, 34));
        b6.setBounds(600,358,160,35);
        b6.setFont(new Font("System",Font.BOLD,22));
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(30, 31, 34));
        b7.setBounds(600,403,160,35);
        b7.setFont(new Font("System",Font.BOLD,22));
        b7.addActionListener(this);
        image.add(b7);

        b8 = new JButton("Rs. 20000");
        b8.setForeground(Color.WHITE);
        b8.setBackground(new Color(30, 31, 34));
        b8.setBounds(320,403,160,35);
        b8.setFont(new Font("System",Font.BOLD,22));
        b8.addActionListener(this);
        image.add(b8);

        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7) {
            setVisible(false);
            new Home(pin);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Connect c = new Connect();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from bank where PIN = '"+pin+"'");
                int balance =0;
                while (resultSet.next()){
                    if (resultSet.getString("Transaction_Type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("Amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("Amount"));
                    }
                }

                if (e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
            }catch (Exception E){
                E.toString();
            }
            setVisible(false);
            new Home(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}