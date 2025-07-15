package bank.management.system;

import com.toedter.calendar.JDateChooser;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;
import java.util.Date;

public class Register extends JFrame implements ActionListener {
    JLabel ageLabel;
    JTextField name, father, mother, email, add, state, surname;
    JDateChooser birth;
    Random ran = new Random();
    long num = Math.abs((ran.nextLong() % 9000L) + 1000L);
    String no = " " + num;
    JRadioButton g1, g2, g3, g4, m1, m2, m3;

    Register(){
        setTitle("Application Form");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(30,10,100,100);
        add(image);

        JLabel label1=new JLabel("APPLICATION FORM NO. : "+no);
        label1.setBounds(300,10,1000,70);
        label1.setFont(new Font("AvantGarde",Font.BOLD,50));
        add(label1);

        JLabel label2=new JLabel("Page no. 1 of 3");
        label2.setBounds(1085,722,1000,70);
        label2.setFont(new Font("Railway",Font.BOLD,26));
        add(label2);

        JLabel label3=new JLabel("<HTML><U>Personal Details</U></HTML>");
        label3.setBounds(570,75,300,70);
        label3.setFont(new Font("Railway",Font.BOLD,32));
        add(label3);

        JLabel labelname=new JLabel("NAME :");
        labelname.setBounds(300,160,300,40);
        labelname.setFont(new Font("Railway",Font.BOLD,28));
        add(labelname);

        name=new JTextField(50);
        name.setFont(new Font("Arial",Font.BOLD,28));
        name.setBounds(570,160,515,34);
        add(name);

        JLabel labelsurname=new JLabel("SURNAME :");
        labelsurname.setBounds(300,215,300,40);
        labelsurname.setFont(new Font("Railway",Font.BOLD,28));
        add(labelsurname);

        surname=new JTextField(50);
        surname.setFont(new Font("Arial",Font.BOLD,28));
        surname.setBounds(570,215,515,34);
        add(surname);

        JLabel labelfather=new JLabel("FATHER'S NAME :");
        labelfather.setBounds(300,270,300,40);
        labelfather.setFont(new Font("Railway",Font.BOLD,28));
        add(labelfather);

        father=new JTextField(50);
        father.setFont(new Font("Arial",Font.BOLD,28));
        father.setBounds(570,270,515,34);
        add(father);

        JLabel labelmother=new JLabel("MOTHER'S NAME :");
        labelmother.setBounds(300,325,300,40);
        labelmother.setFont(new Font("Railway",Font.BOLD,28));
        add(labelmother);

        mother=new JTextField(50);
        mother.setFont(new Font("Arial",Font.BOLD,28));
        mother.setBounds(570,325,515,34);
        add(mother);

        JLabel dob=new JLabel("DATE OF BIRTH :");
        dob.setBounds(300,380,300,40);
        dob.setFont(new Font("Railway",Font.BOLD,28));
        add(dob);

        birth=new JDateChooser();
        birth.setBounds(570,380,270,34);
        birth.setFont(new Font("Railway",Font.BOLD,18));
        add(birth);

        ageLabel = new JLabel("AGE: ");
        ageLabel.setBounds(860, 377, 300, 40);
        ageLabel.setFont(new Font("Railway", Font.BOLD, 28));
        add(ageLabel);

        birth.getDateEditor().addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                calculateAndValidateAge();
            }
        });

        JLabel gender=new JLabel("GENDER :");
        gender.setBounds(300,435,300,40);
        gender.setFont(new Font("Railway",Font.BOLD,28));
        add(gender);

        g1=new JRadioButton("MALE");
        g1.setFont(new Font("Arial",Font.BOLD,20));
        g1.setBackground(new Color(121, 232, 121));
        g1.setBounds(570,435,100,40);
        add(g1);

        g2=new JRadioButton("FEMALE");
        g2.setFont(new Font("Arial",Font.BOLD,20));
        g2.setBackground(new Color(121, 232, 121));
        g2.setBounds(690,435,110,40);
        add(g2);

        g3=new JRadioButton("OTHERS");
        g3.setFont(new Font("Arial",Font.BOLD,20));
        g3.setBackground(new Color(121, 232, 121));
        g3.setBounds(815,435,120,40);
        add(g3);

        g4=new JRadioButton("PREFER NOT TO SAY");
        g4.setFont(new Font("Arial",Font.BOLD,20));
        g4.setBackground(new Color(121, 232, 121));
        g4.setBounds(945,435,250,40);
        add(g4);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(g1);
        buttonGroup.add(g2);
        buttonGroup.add(g3);
        buttonGroup.add(g4);

        JLabel labelemail=new JLabel("EMAIL ADDRESS :");
        labelemail.setBounds(300,490,300,40);
        labelemail.setFont(new Font("Railway",Font.BOLD,28));
        add(labelemail);

        email =new JTextField(50);
        email.setFont(new Font("Arial",Font.BOLD,28));
        email.setBounds(570,490,515,34);
        add(email);

        JLabel labelmarry=new JLabel("MARITAL STATUS :");
        labelmarry.setBounds(300,545,300,40);
        labelmarry.setFont(new Font("Railway",Font.BOLD,28));
        add(labelmarry);

        m1=new JRadioButton("MARRIED");
        m1.setFont(new Font("Arial",Font.BOLD,20));
        m1.setBackground(new Color(121, 232, 121));
        m1.setBounds(570,545,130,40);
        add(m1);

        m2 =new JRadioButton("UNMARRIED");
        m2.setFont(new Font("Arial",Font.BOLD,20));
        m2.setBackground(new Color(121, 232, 121));
        m2.setBounds(715,545,150,40);
        add(m2);

        m3=new JRadioButton("DIVORCED");
        m3.setFont(new Font("Arial",Font.BOLD,20));
        m3.setBackground(new Color(121, 232, 121));
        m3.setBounds(880,545,150,40);
        add(m3);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel labeladd=new JLabel("ADDRESS :");
        labeladd.setBounds(300,600,300,40);
        labeladd.setFont(new Font("Railway",Font.BOLD,28));
        add(labeladd);

        add =new JTextField(150);
        add.setFont(new Font("Arial",Font.BOLD,28));
        add.setBounds(570,600,515,34);
        add(add);

        JLabel labelcity=new JLabel("STATE :");
        labelcity.setBounds(300,655,300,40);
        labelcity.setFont(new Font("Railway",Font.BOLD,28));
        add(labelcity);

        state =new JTextField(150);
        state.setFont(new Font("Arial",Font.BOLD,28));
        state.setBounds(570,655,515,34);
        add(state);

        JButton button=new JButton("Next Page");
        button.setFont(new Font("Railway",Font.BOLD,28));
        button.setBounds(560,700,200,60);
        button.setBackground(new Color(35, 175, 77));
        button.setForeground(Color.white);
        button.addActionListener(this);
        add(button);

        getContentPane().setBackground(new Color(197, 255, 197));
        setLayout(null);
        setSize(1300,820);
        setLocation(120,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    private int age;
    private void calculateAndValidateAge() {
        Date selectedDate = birth.getDate();
        if (selectedDate != null) {
            LocalDate birthDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDate = LocalDate.now();
            age = Period.between(birthDate, currentDate).getYears();

            ageLabel.setText("Age: " + age);

            if (age < 18) {
                JOptionPane.showMessageDialog(this,
                        "You are under 18 and cannot open a bank account!",
                        "Underage Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (age > 100) {
                JOptionPane.showMessageDialog(this,
                        "You are over 100 years old. Are you even alive?",
                        "Age Limit Exceeded",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = no;
        String user = name.getText();
        String sur = surname.getText();
        String fname = father.getText();
        String mname = mother.getText();

        String gender = "not Specified";
        if (g1.isSelected()) gender = "Male";
        else if (g2.isSelected()) gender = "Female";
        else if (g3.isSelected()) gender = "Others";
        else if (g4.isSelected()) gender = "Prefer not to Say";

        String mail = email.getText();
        String marital = "Not Specified";
        if (m1.isSelected()) marital = "Married";
        else if (m2.isSelected()) marital = "Unmarried";
        else if (m3.isSelected()) marital = "Divorced";

        String address = add.getText();
        String sheher = state.getText();
        String date = ((JTextField) birth.getDateEditor().getUiComponent()).getText();


        try {
            if (user.isEmpty() || sur.isEmpty() || fname.isEmpty() || mname.isEmpty()
                    || mail.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill all Fields");
                return;
            }

            if (!mail.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
                JOptionPane.showMessageDialog(null, "Invalid Email Format!");
                return;
            }

            Random rand = new Random();
            String generatedOTP = String.valueOf(100000 + rand.nextInt(999999));

            if (!sendOTPEmail(mail, generatedOTP)) {
                JOptionPane.showMessageDialog(null, "Failed to send OTP. Try again.");
                return;
            }

            String enteredOTP = JOptionPane.showInputDialog("Enter the OTP sent to " + mail);

            if (enteredOTP == null || !enteredOTP.equals(generatedOTP)) {
                JOptionPane.showMessageDialog(null, "Invalid OTP. Registration Failed.");
                return;
            }

            JOptionPane.showMessageDialog(null, "Email Verified Successfully!");
            Connect con = new Connect();
            String c = "INSERT INTO register VALUES('" + formno + "', '" + user + "', '" + sur + "', '" + fname + "', '" + mname + "', '"
                    + date + "','"+age+"', '" + gender + "', '" + mail + "', '" + marital + "', '" + address + "', '" + sheher + "')";
            con.statement.executeUpdate(c);

            new Register2(no);
            setVisible(false);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public boolean sendOTPEmail(String recipientEmail, String otp) throws MessagingException {
        final String senderEmail = "praneetpoojary217057@gmail.com";
        final String senderPassword = "nzex wvez cetz lhqq";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Your OTP for Email Verification");
            message.setText("Your OTP is: " + otp + "\n\nPlease enter this OTP to verify your email.");
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
