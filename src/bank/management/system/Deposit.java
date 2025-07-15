package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton depo,back;
    Deposit(String pin){
        this.pin=pin;

        setTitle("Deposit");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
        Image i2=i1.getImage().getScaledInstance(1100,790,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1300,820);
        add(image);

        JLabel label1=new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.white);
        label1.setBounds(320,180,600,30);
        label1.setFont(new Font("System",Font.BOLD,19));
        image.add(label1);

        JLabel label2=new JLabel("Rs ");
        label2.setForeground(Color.white);
        label2.setBounds(320,230,45,26);
        label2.setFont(new Font("System",Font.BOLD,26));
        image.add(label2);

        textField=new JTextField(50);
        textField.setFont(new Font("System",Font.BOLD,26));
        textField.setBounds(365,230,300,26);
        textField.setBackground(new Color(0,0,0));
        textField.setForeground(Color.white);
        textField.setOpaque(false);
        image.add(textField);

        depo=new JButton("DEPOSIT");
        depo.setBounds(590,358,167,35);
        depo.setBackground(new Color(30, 31, 34));
        depo.setFont(new Font("System",Font.BOLD,26));
        depo.setForeground(Color.white);
        depo.addActionListener(this);
        image.add(depo);

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
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource() == depo) {
                if(textField.getText().isEmpty())
                    JOptionPane.showMessageDialog(null,"Please enter the amount to be deposited");
                else{
                    Connect con=new Connect();
                    String c="insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')";
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" is deposited successfully");
                    con.statement.executeUpdate(c);
                    new Home(pin);
                    setVisible(false);
                }
            }
            else if(e.getSource()==back){
                new Home(pin);
                setVisible(false);
            }
        }catch(Exception e1){
            e1.toString();
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
