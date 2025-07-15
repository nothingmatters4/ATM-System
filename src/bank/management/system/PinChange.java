package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton changepin,back;
    JPasswordField p1,p2;
    String pin;
    PinChange(String pin){
        this.pin =pin;

        setTitle("Change Pin");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
        Image i2=i1.getImage().getScaledInstance(1100,790,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1300,820);
        add(image);

        JLabel label1=new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.white);
        label1.setBounds(320,180,600,30);
        label1.setFont(new Font("System",Font.BOLD,19));
        image.add(label1);


        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 19));
        label2.setBounds(320,220,150,35);
        image.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(500,220,180,25);
        p1.setFont(new Font("Railway", Font.BOLD,22));
        image.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 19));
        label3.setBounds(320,250,400,35);
        image.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(500,255,180,25);
        p2.setFont(new Font("Railway", Font.BOLD,22));
        image.add(p2);

        changepin=new JButton("CHANGE");
        changepin.setBounds(590,358,167,35);
        changepin.setBackground(new Color(30, 31, 34));
        changepin.setFont(new Font("System",Font.BOLD,26));
        changepin.setForeground(Color.white);
        changepin.addActionListener(this);
        image.add(changepin);

        back=new JButton("BACK");
        back.setBounds(590,403,167,35);
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
        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();
            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (e.getSource()==changepin){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                Connect con = new Connect();
                String q1 = "update bank set PIN = '"+pin1+"' where PIN = '"+pin+"'";
                String q2 = "update login set PIN = '"+pin1+"' where PIN = '"+pin+"'";

                con.statement.executeUpdate(q1);
                con.statement.executeUpdate(q2);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Login();
            } else if (e.getSource()==back) {
                new Home(pin);
                setVisible(false);
            }

        }catch (Exception E){
            E.toString();
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}