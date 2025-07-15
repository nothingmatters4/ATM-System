package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Card extends JFrame implements ActionListener {
    String no;
    Random ran = new Random();
    long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
    String cardno = "" + Math.abs(first7);

    long first3 = (ran.nextLong() % 9000L)+ 1000L;
    String pin = "" + Math.abs(first3);

    Card(String no){
        setTitle("Card Details");

        this.no=no;

        JLabel label1=new JLabel("APPLICATION FORM NO. : "+no);
        label1.setBounds(300,10,1000,70);
        label1.setFont(new Font("AvantGarde",Font.BOLD,50));
        add(label1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(30,10,100,100);
        add(image);

        JLabel card=new JLabel("CARD DETAILS : ");
        card.setBounds(300,250,1000,70);
        card.setFont(new Font("AvantGarde",Font.BOLD,50));
        add(card);

        JLabel num=new JLabel("CARD Number : "+cardno);
        num.setBounds(400,320,1000,70);
        num.setFont(new Font("AvantGarde",Font.BOLD,40));
        add(num);

        JLabel pass=new JLabel("PIN : "+pin);
        pass.setBounds(400,380,1000,70);
        pass.setFont(new Font("AvantGarde",Font.BOLD,40));
        add(pass);

        JLabel note=new JLabel("(Please remember the Card Details and the PIN Number.)");
        note.setBounds(350,450,1000,70);
        note.setFont(new Font("AvantGarde",Font.BOLD,28));
        add(note);
        
        JButton done=new JButton("DONE");
        done.setFont(new Font("Railway",Font.BOLD,28));
        done.setBounds(560,700,200,60);
        done.setBackground(new Color(117, 232, 244));
        done.addActionListener(this);
        add(done);


        getContentPane().setBackground(new Color(172, 248, 255));
        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Connect con = new Connect();
            String c = "insert into login values('" + no + "','" + cardno + "','" + pin + "')";
            con.statement.executeUpdate(c);
            new Deposit(pin);
            setVisible(false);
        } catch (Exception e1) {
            e1.toString();
        }
    }

    public static void main(String[] args) {
        new Card("");
    }
}
