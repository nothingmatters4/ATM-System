package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
        JButton depo,fast,pin_change,withdraw,mini,balance,logout,profile;
        String pin;
        Home(String pin){
        this.pin=pin;

        setTitle("Home");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
        Image i2=i1.getImage().getScaledInstance(1100,790,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1300,820);
        add(image);

        JLabel label1=new JLabel("PLEASE SELECT YOUR TRANSACTION");
        label1.setForeground(Color.white);
        label1.setBounds(325,180,600,30);
        label1.setFont(new Font("System",Font.BOLD,22));
        image.add(label1);

        depo =new JButton("DEPOSIT");
        depo.setBounds(320,268,160,35);
        depo.setBackground(new Color(30, 31, 34));
        depo.setFont(new Font("System",Font.BOLD,20));
        depo.setForeground(Color.white);
        depo.addActionListener(this);
        image.add(depo);

        fast =new JButton("FAST CASH");
        fast.setBounds(320,313,160,35);
        fast.setBackground(new Color(30, 31, 34));
        fast.setFont(new Font("System",Font.BOLD,20));
        fast.setForeground(Color.white);
        fast.addActionListener(this);
        image.add(fast);

        pin_change =new JButton("PIN CHANGE");
        pin_change.setBounds(320,358,160,35);
        pin_change.setBackground(new Color(30, 31, 34));
        pin_change.setFont(new Font("System",Font.BOLD,20));
        pin_change.setForeground(Color.white);
        pin_change.addActionListener(this);
        image.add(pin_change);

        profile =new JButton("PROFILE");
        profile.setBounds(320,403,160,35);
        profile.setBackground(new Color(30, 31, 34));
        profile.setFont(new Font("System",Font.BOLD,20));
        profile.setForeground(Color.white);
        profile.addActionListener(this);
        image.add(profile);


        withdraw =new JButton("CASH WITHDRAWAL");
        withdraw.setBounds(520,268,240,35);
        withdraw.setBackground(new Color(30, 31, 34));
        withdraw.setFont(new Font("System",Font.BOLD,20));
        withdraw.setForeground(Color.white);
        withdraw.addActionListener(this);
        image.add(withdraw);

        mini =new JButton("MINI STATEMENT");
        mini.setBounds(520,313,240,35);
        mini.setBackground(new Color(30, 31, 34));
        mini.setFont(new Font("System",Font.BOLD,20));
        mini.setForeground(Color.white);
        mini.addActionListener(this);
        image.add(mini);

        balance =new JButton("BALANCE ENQUIRY");
        balance.setBounds(520,358,240,35);
        balance.setBackground(new Color(30, 31, 34));
        balance.setFont(new Font("System",Font.BOLD,20));
        balance.setForeground(Color.white);
        balance.addActionListener(this);
        image.add(balance);

        logout =new JButton("LOGOUT" +"");
        logout.setBounds(630,403,130,35);
        logout.setBackground(new Color(30, 31, 34));
        logout.setFont(new Font("System",Font.BOLD,20));
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        image.add(logout);

        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==depo){
                new Deposit(pin);
                setVisible(false);
            }
            else if(e.getSource()==logout){
                new Login();
            }
            else if(e.getSource()==pin_change){
                new PinChange(pin);
                setVisible(false);
            }
            else if (e.getSource()==balance){
                new BalanceEnquiry(pin);
                setVisible(false);
            }
            else if(e.getSource()==withdraw){
                new Withdraw(pin);
                setVisible(false);
            }
            else if (e.getSource()==fast){
                new FastCash(pin);
                setVisible(false);
            }
            else if (e.getSource()==mini){
                new Mini(pin);

            }
            else if(e.getSource()==profile){
                new Profile(pin);
                setVisible(false);
            }
        }catch (Exception e1){
            e1.toString();
        }
    }

    public static void main(String[] args) {
            new Home("");
    }
}
