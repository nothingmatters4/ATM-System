package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register3 extends JFrame implements ActionListener {
    String no;
    JRadioButton t1,t2,t3,t4,k1,k2,n1,n2;
    JCheckBox s1,s2,s3,s4,s5,s6,s7,s8,s9,terms;
    JButton button1,button2;
    Register3(String no){
        setTitle("Application Form");

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

        JLabel label2=new JLabel("Page no. 3 of 3");
        label2.setBounds(1085,722,1000,70);
        label2.setFont(new Font("Railway",Font.BOLD,26));
        add(label2);

        JLabel label3=new JLabel("<HTML><U>Account Details</U></HTML>");
        label3.setBounds(570,75,300,70);
        label3.setFont(new Font("Railway",Font.BOLD,32));
        add(label3);

        JLabel labeltype=new JLabel("ACCOUNT TYPE :");
        labeltype.setBounds(300,160,300,40);
        labeltype.setFont(new Font("Railway",Font.BOLD,28));
        add(labeltype);

        t1=new JRadioButton("Savings Account");
        t1.setFont(new Font("Arial",Font.BOLD,20));
        t1.setBackground(new Color(207, 148, 232));
        t1.setBounds(300,210,200,40);
        add(t1);

        t2=new JRadioButton("Fixed Deposit Account");
        t2.setFont(new Font("Arial",Font.BOLD,20));
        t2.setBackground(new Color(207, 148, 232));
        t2.setBounds(530,210,250,40);
        add(t2);

        t3=new JRadioButton("Current Account");
        t3.setFont(new Font("Arial",Font.BOLD,20));
        t3.setBackground(new Color(207, 148, 232));
        t3.setBounds(300,275,200,40);
        add(t3);

        t4=new JRadioButton("Recurring Deposit Account");
        t4.setFont(new Font("Arial",Font.BOLD,20));
        t4.setBackground(new Color(207, 148, 232));
        t4.setBounds(530,275,290,40);
        add(t4);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(t1);
        buttonGroup1.add(t2);
        buttonGroup1.add(t3);
        buttonGroup1.add(t4);

        JLabel labelkyc=new JLabel("KYC DOCUMENTS PROVIDED? :");
        labelkyc.setBounds(300,330,450,40);
        labelkyc.setFont(new Font("Railway",Font.BOLD,28));
        add(labelkyc);

        k1=new JRadioButton("Yes");
        k1.setFont(new Font("Arial",Font.BOLD,20));
        k1.setBackground(new Color(207, 148, 232));
        k1.setBounds(750,330,80,40);
        add(k1);

        k2=new JRadioButton("No");
        k2.setFont(new Font("Arial",Font.BOLD,20));
        k2.setBackground(new Color(207, 148, 232));
        k2.setBounds(850,330,80,40);
        add(k2);

        ButtonGroup buttonGroup2=new ButtonGroup();
        buttonGroup2.add(k1);
        buttonGroup2.add(k2);

        JLabel labelnomination=new JLabel("NOMINATION REQUIRED? :");
        labelnomination.setBounds(300,385,450,40);
        labelnomination.setFont(new Font("Railway",Font.BOLD,28));
        add(labelnomination);

        n1=new JRadioButton("Yes");
        n1.setFont(new Font("Arial",Font.BOLD,20));
        n1.setBackground(new Color(207, 148, 232));
        n1.setBounds(750,385,80,40);
        add(n1);

        n2=new JRadioButton("No");
        n2.setFont(new Font("Arial",Font.BOLD,20));
        n2.setBackground(new Color(207, 148, 232));
        n2.setBounds(850,385,80,40);
        add(n2);

        ButtonGroup buttonGroup3=new ButtonGroup();
        buttonGroup3.add(n1);
        buttonGroup3.add(n2);

        JLabel labelservices=new JLabel("SERVICES REQUIRED :");
        labelservices.setBounds(300,440,380,40);
        labelservices.setFont(new Font("Railway",Font.BOLD,28));
        add(labelservices);

        s1=new JCheckBox("ATM Card");
        s1.setFont(new Font("Arial",Font.BOLD,20));
        s1.setBackground(new Color(207, 148, 232));
        s1.setBounds(300,490,180,40);
        add(s1);

        s2=new JCheckBox("Mobile Banking");
        s2.setFont(new Font("Arial",Font.BOLD,20));
        s2.setBackground(new Color(207, 148, 232));
        s2.setBounds(300,545,180,40);
        add(s2);

        s3=new JCheckBox("Cheque Book");
        s3.setFont(new Font("Arial",Font.BOLD,20));
        s3.setBackground(new Color(207, 148, 232));
        s3.setBounds(300,600,180,40);
        add(s3);

        s4=new JCheckBox("Email-Alerts");
        s4.setFont(new Font("Arial",Font.BOLD,20));
        s4.setBackground(new Color(207, 148, 232));
        s4.setBounds(550,490,170,40);
        add(s4);

        s5=new JCheckBox("SMS-Alerts");
        s5.setFont(new Font("Arial",Font.BOLD,20));
        s5.setBackground(new Color(207, 148, 232));
        s5.setBounds(550,545,170,40);
        add(s5);

        s6=new JCheckBox("E-Statement");
        s6.setFont(new Font("Arial",Font.BOLD,20));
        s6.setBackground(new Color(207, 148, 232));
        s6.setBounds(550,600,170,40);
        add(s6);

        s7=new JCheckBox("Personal Loans Approval");
        s7.setFont(new Font("Arial",Font.BOLD,20));
        s7.setBackground(new Color(207, 148, 232));
        s7.setBounds(790,490,280,40);
        add(s7);

        s8=new JCheckBox("Insurance Products");
        s8.setFont(new Font("Arial",Font.BOLD,20));
        s8.setBackground(new Color(207, 148, 232));
        s8.setBounds(790,545,280,40);
        add(s8);

        s9=new JCheckBox("Locker Services");
        s9.setFont(new Font("Arial",Font.BOLD,20));
        s9.setBackground(new Color(207, 148, 232));
        s9.setBounds(790,600,280,40);
        add(s9);

        terms=new JCheckBox("I, hereby declare that above entered details are entered correctly and agree to all terms and conditions.",true);
        terms.setFont(new Font("Arial",Font.BOLD,15));
        terms.setBackground(new Color(233, 177, 255));
        terms.setBounds(200,650,6000,40);
        add(terms);

        button1=new JButton("SUBMIT");
        button1.setFont(new Font("Railway",Font.BOLD,28));
        button1.setBounds(400,700,200,60);
        button1.setBackground(new Color(207, 148, 232));
        button1.addActionListener(this);
        add(button1);

        button2=new JButton("CANCEL");
        button2.setFont(new Font("Railway",Font.BOLD,28));
        button2.setBounds(750,700,200,60);
        button2.setBackground(new Color(207, 148, 232));
        button2.addActionListener(this);
        add(button2);

        getContentPane().setBackground(new Color(233, 177, 255));
        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1) {
            String type = null;
            if (t1.isSelected())
                type = "Savings";
            if (t2.isSelected())
                type = "Fixed Deposit";
            if (t3.isSelected())
                type = "Current";
            if (t4.isSelected())
                type = "Recurring Deposit";
            String kyc = null;
            if (k1.isSelected())
                kyc = "Yes";
            if (k2.isSelected())
                kyc = "No";
            String nomination = null;
            if (n1.isSelected())
                nomination = "Yes";
            if (n2.isSelected())
                nomination = "No";
            String service = "";
            int i = 0;
            if (s1.isSelected()) {
                i++;
                service = service + i + ": ATM Card ";
            }
            if (s2.isSelected()) {
                i++;
                service = service + i + ": Mobile Banking ";
            }
            if (s3.isSelected()) {
                i++;
                service = service + i + ": Cheque Book ";
            }
            if (s4.isSelected()) {
                i++;
                service = service + i + ": Email Alerts ";
            }
            if (s5.isSelected()) {
                i++;
                service = service + i + ": SMS Alerts ";
            }
            if (s6.isSelected()) {
                i++;
                service = service + i + ": E-Statement ";
            }
            if (s7.isSelected()){
                i++;
                service = service +i+": Personal Loans Approval ";
            }
            if (s8.isSelected()) {
                i++;
                service = service + i + ": Insurance Products ";
            }
            if (s9.isSelected()) {
                i++;
                service = service + i + ": Locker Services ";
            }
            if(service.isEmpty())
                service = "No Service Choosed ";

            try {
                if (type == null || kyc == null || nomination == null)
                    JOptionPane.showMessageDialog(null, "Fill All Details");
                else if (!terms.isSelected())
                    JOptionPane.showMessageDialog(null, "You must agree to all the terms and conditions to proceed.");
                else {
                    Connect con = new Connect();
                    System.out.println("Length of services: " + service.length());

                    String c = "insert into register3 values('"+no+"','"+type+"','"+kyc+"','"+nomination+"','"+service+"')";
                    con.statement.executeUpdate(c);
                    new Card(no);
                    setVisible(false);
                }
            } catch (Exception e1) {
                e1.toString();
            }
        }
        else if(e.getSource()==button2)
            System.exit(0);

    }

    public static void main(String[] args) {

        new Register3("");
    }
}
