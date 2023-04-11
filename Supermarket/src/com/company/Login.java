package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    CheckOut co = new CheckOut();
    String N, NO;
    ImageIcon img = new ImageIcon("D:\\JAVA IDEA\\SuperMarket\\rsz_1panda.png");
    JLabel logo = new JLabel(img);

    JLabel wel = new JLabel("Welcome to Panda Mart");
    JLabel sp2 = new JLabel(" ");
    JLabel Name = new JLabel("Name           :    ");
    JTextField NameF = new JTextField(15);
    JLabel Contact = new JLabel("Contact No :    ");
    JTextField ContactF  = new JTextField(15);
    JButton btn = new JButton("LOGIN");

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    Login(String title){
        super(title);
        setSize(400,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Constantia", Font.BOLD,15);
        wel.setFont(new Font("Cooper Black", Font.BOLD, 25));
        Name.setFont(font);
        NameF.setFont(font);
        Contact.setFont(font);
        ContactF.setFont(font);
        btn.setFont(font);

        panel1.add(Name); panel1.add(NameF);
        panel2.add(Contact); panel2.add(ContactF);
        panel4.add(btn);
        panel5.add(logo);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(panel5); panel3.add(wel); panel3.add(sp2); panel3.add(panel1);panel3.add(panel2); panel3.add(panel4);
        add(panel3);

        btn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            N = NameF.getText();
            NO = ContactF.getText();
            co.out(N, NO);
            LinkedList list = new LinkedList();
            MainMenu obj = new MainMenu("Supermarket Billing System", list);
            setVisible(false);
            obj.setVisible(true);

        }catch(Exception ex){
            NameF.setText("Please enter your name.");
            ContactF.setText("Please enter your number.");
        }

    }
}

