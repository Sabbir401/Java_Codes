package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    String num, quanity;
    ReadItems read = new ReadItems();
    LinkedList list = new LinkedList();

    ImageIcon img = new ImageIcon("D:\\JAVA IDEA\\SuperMarket\\1panda.png");
    JLabel logo = new JLabel(img);
    JLabel Name = new JLabel("Panda Mart");
    JLabel sp1 = new JLabel(" ");

    JLabel gap2 = new JLabel("   ");
    JLabel gap3 = new JLabel("   ");
    JLabel gap4 = new JLabel("   ");
    JButton cart = new JButton("CART");
    JButton del = new JButton("DELETE");
    JButton cout = new JButton("CHECK OUT");
    JLabel sp2 = new JLabel(" ");

    String[] cat = {"Fresh Goods", "Frozen", "Dairy", "Spices", "Snacks", "Grains"};
    JComboBox cBox = new JComboBox(cat);
    JLabel no = new JLabel("     No:   ");
    JTextField n = new JTextField(5);
    JLabel quan = new JLabel("     Quantity:   ");
    JTextField q = new JTextField(5);
    JLabel sp3 = new JLabel(" ");

    JLabel ck1 = new JLabel("Display:   ");
    JTextField ck2 = new JTextField(20);
    JButton add = new JButton("ADD");
    JLabel sp4 = new JLabel(" ");

    JTextArea area = new JTextArea(25, 32);
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();


    MainMenu(String title, LinkedList L) {
        super(title);
        list = L;
        setSize(500, 730);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Name.setFont(new Font("Cooper Black", Font.BOLD, 50));
        Font fon = new Font("Constantia", Font.BOLD,15);


        panel.add(logo);
        panel.add(Name);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.add(cBox);
        panel1.add(gap4);
        panel1.add(cart);
        panel1.add(gap2);
        panel1.add(del);
        panel1.add(gap3);
        panel1.add(cout);
        cart.addActionListener(this);
        del.addActionListener(this);
        cout.addActionListener(this);
        add(panel1);

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(no);
        panel2.add(n);
        panel2.add(quan);
        panel2.add(q);
        no.setFont(fon);
        n.setFont(fon);
        quan.setFont(fon);
        q.setFont(fon);
        cBox.addActionListener(this);
        add(panel2);
        ck2.setFont(fon);
        ck1.setFont(fon);
        panel4.add(ck1);
        panel4.add(ck2);
        panel4.add(add);
        panel5.add(area);

        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(panel);
        panel3.add(sp1);
        panel3.add(panel1);
        panel3.add(sp2);
        panel3.add(panel2);
        panel3.add(sp3);
        panel3.add(panel4);
        panel3.add(sp4);
        panel3.add(panel5);
        add.addActionListener(this);

        Font font = new Font("Cooper Black", Font.PLAIN,15);
        area.setFont(font);
        add(panel3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cart){
            area.setText(list.display());
            ck2.setText("Showing Cart");
        }
        else if(e.getSource() == del){
            try{
                num = (n.getText());
                n.setText(null);
                list.del(num);
                area.setText(list.display());
                ck2.setText("Deleting");
            }catch(Exception ex){
                ck2.setText("Enter no of Item to Delete");
            }
        }
        else if(e.getSource() == cout){
            area.setText(read.Name()+list.display()+list.total()+list.vat()+list.NetAmount());
            ck2.setText("Money Receipt Including (5%)VAT");
        }
        else if(e.getSource() == add){
            try{
                num = (n.getText());
                quanity = (q.getText());
                n.setText(null);
                q.setText(null);
                Add obj = new Add();
                obj.AddToList(num, quanity, list);
                if(Integer.parseInt(num)> 43){
                    ck2.setText("Invalid Input");
                }else{
                    ck2.setText("Successfully Added");
                }
            }catch(Exception ex){
                ck2.setText("Enter No of Item & Quantity to Add");
            }
        }

        else if (e.getSource() == cBox) {
            if (cBox.getSelectedItem().equals("Fresh Goods")) {
                area.setText(read.FreshItem());
                ck2.setText("Showing Fresh Goods");
            }
            else if (cBox.getSelectedItem().equals("Frozen")){
                area.setText(read.FrozenItem());
                ck2.setText("Showing Frozen Item");
            }
            else if (cBox.getSelectedItem().equals("Dairy")){
                area.setText(read.DairyItem());
                ck2.setText("Showing Dairy Item");
            }
            else if (cBox.getSelectedItem().equals("Spices")){
                area.setText(read.SpiceItem());
                ck2.setText("Showing Spices Item");
            }
            else if (cBox.getSelectedItem().equals("Snacks")){
                area.setText(read.SnackItem());
                ck2.setText("Showing Snacks Item");
            }
            else if (cBox.getSelectedItem().equals("Grains")){
                area.setText(read.GrainsItem());
                ck2.setText("Showing Grains Item");
            }
        }
    }
}

