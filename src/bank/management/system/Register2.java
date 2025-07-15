package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Register2 extends JFrame implements ActionListener {
    String no;
    JRadioButton s1,s2,e1,e2;
    JComboBox combo2,combo3,combo4,combo5;
    JTextField pan,aadhar;
    Register2(String no){

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

        JLabel label2=new JLabel("Page no. 2 of 3");
        label2.setBounds(1085,722,1000,70);
        label2.setFont(new Font("Railway",Font.BOLD,26));
        add(label2);

        JLabel label3=new JLabel("<HTML><U>Additional Details</U></HTML>");
        label3.setBounds(570,75,300,70);
        label3.setFont(new Font("Railway",Font.BOLD,32));
        add(label3);





        JLabel labelcategory=new JLabel("CATEGORY :");
        labelcategory.setBounds(300,215,300,40);
        labelcategory.setFont(new Font("Railway",Font.BOLD,28));
        add(labelcategory);

        String category []={"","General","OBC","SC","ST","VJNT","Others"};
        combo2=new JComboBox(category);
        combo2.setBackground(new Color(237, 215, 99));
        combo2.setBounds(570,215,515,34);
        combo2.setFont(new Font("Arial",Font.CENTER_BASELINE,24));
        add(combo2);

        JLabel labelincome=new JLabel("ANNUAL INCOME :");
        labelincome.setBounds(300,271,300,40);
        labelincome.setFont(new Font("Railway",Font.BOLD,28));
        add(labelincome);

        String income []={"","Less than Rs 30000",">30000 And <80000",">80000 And <1.5 Lakhs",">1.5 Lakhs And <5 Lakhs",">5 Lakhs And <8 Lakhs",">12 Lakhs And <20 Lakhs","More Than 20 Lakhs"};
        combo3=new JComboBox(income);
        combo3.setBackground(new Color(237, 215, 99));
        combo3.setBounds(570,271,515,34);
        combo3.setFont(new Font("Arial",Font.CENTER_BASELINE,24));
        add(combo3);

        JLabel labeleducation=new JLabel("EDUCATION :");
        labeleducation.setBounds(300,325,300,40);
        labeleducation.setFont(new Font("Railway",Font.BOLD,28));
        add(labeleducation);

        String education []={"","12th Pass","Non-Graduate","Under-Graduate","Graduate","Post-Graduate","Doctorate"};
        combo4=new JComboBox(education);
        combo4.setBackground(new Color(237, 215, 99));
        combo4.setBounds(570,325,515,34);
        combo4.setFont(new Font("Arial",Font.CENTER_BASELINE,24));
        add(combo4);

        JLabel labeloccupation=new JLabel("OCCUPATION :");
        labeloccupation.setBounds(300,380,300,40);
        labeloccupation.setFont(new Font("Railway",Font.BOLD,28));
        add(labeloccupation);

        String occupation []={"","Student","Unemployed","Self-Employed","Private Service","Government Service","Freelancer","Intern","Retired"};
        combo5=new JComboBox(occupation);
        combo5.setBackground(new Color(237, 215, 99));
        combo5.setBounds(570,380,515,34);
        combo5.setFont(new Font("Arial",Font.CENTER_BASELINE,24));
        add(combo5);

        JLabel labelpan=new JLabel("PAN NUMBER :");
        labelpan.setBounds(300,435,300,40);
        labelpan.setFont(new Font("Railway",Font.BOLD,28));
        add(labelpan);

        pan=new JTextField();
        pan.setBounds(570,435,515,34);
        pan.setFont(new Font("Arial",Font.BOLD,28));
        add(pan);

        JLabel labelaadhar=new JLabel("AADHAR CARD NO.:");
        labelaadhar.setBounds(300,490,300,40);
        labelaadhar.setFont(new Font("Railway",Font.BOLD,28));
        add(labelaadhar);

        aadhar=new JTextField();
        aadhar.setBounds(570,490,515,34);
        aadhar.setFont(new Font("Arial",Font.BOLD,28));
        add(aadhar);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(s1);
        buttonGroup1.add(s2);

        JLabel labelexisting=new JLabel("EXISTING ACC?:");
        labelexisting.setBounds(300,545,300,40);
        labelexisting.setFont(new Font("Railway",Font.BOLD,28));
        add(labelexisting);

        e1=new JRadioButton("YES, I HAVE");
        e1.setFont(new Font("Arial",Font.BOLD,20));
        e1.setBackground(new Color(237, 215, 99));
        e1.setBounds(570,545,165,40);
        add(e1);

        e2=new JRadioButton("NO, I DON'T");
        e2.setFont(new Font("Arial",Font.BOLD,20));
        e2.setBackground(new Color(237, 215, 99));
        e2.setBounds(770,545,165,40);
        add(e2);

        ButtonGroup buttonGroup2=new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        JButton button=new JButton("Next Page");
        button.setFont(new Font("Railway",Font.BOLD,28));
        button.setBounds(560,700,200,60);
        button.setBackground(new Color(227, 214, 74));
        button.addActionListener(this);
        add(button);

        getContentPane().setBackground(new Color(228, 204, 67));
        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String caste=(String) combo2.getSelectedItem();
        String money=(String) combo3.getSelectedItem();
        String padhai=(String) combo4.getSelectedItem();
        String job=(String) combo5.getSelectedItem();
        String Pan=pan.getText();
        String Aadhar=aadhar.getText();

        String existing="";
        if(e1.isSelected())
            existing="Yes";
        else
            existing="No";
        boolean aadhaarValid = Aadhar.matches("^[2-9]{1}[0-9]{11}$");
        boolean panValid = Pan.matches("^[A-Z]{5}[0-9]{4}[A-Z]{1}$");
        try{
            if(combo2.getSelectedIndex() <= 0||combo3.getSelectedIndex() <= 0||combo4.getSelectedIndex() <= 0||combo5.getSelectedIndex() <= 0||pan.getText().equals("")||aadhar.getText().equals("")||existing==null)
            {
                JOptionPane.showMessageDialog(null,"Fill All Fields");
            }
            else if (!aadhaarValid) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhaar Number! It should be 12 digits and not start with 0 or 1.");
            } else if (!panValid) {
                JOptionPane.showMessageDialog(null, "Invalid PAN Number! It should be in format ABCDE1234F.");
            }
            else{
                Connect con=new Connect();
                String c="insert into register2 values('"+no+"','"+caste+"','"+money+"','"+padhai+"','"+job+"','"+Pan+"','"+Aadhar+"','"+existing+"')";
                con.statement.executeUpdate(c);
                new Register3(no);
                setVisible(false);
            }

        }catch(Exception e1){
            e1.toString();
        }
    }

    public static void main(String[] args) {
        new Register2("");
    }
}
