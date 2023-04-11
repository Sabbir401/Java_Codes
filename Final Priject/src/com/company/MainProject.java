package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainProject extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon("D:\\JAVA IDEA\\Project\\logo.png");
    JLabel logo = new JLabel(img);
    JLabel sp = new JLabel(" ");
    JLabel sp1 = new JLabel(" ");
    JLabel gap = new JLabel("   ");
    JLabel head = new JLabel("Computer Science & Engineering");

    String arr[] = {"CSE 103", "CSE 105", "CSE 201", "CSE 203", "CSE 205", "CSE 207", "CSE 303", "CSE 309", "CSE 311", "CSE 313"};
    JComboBox box = new JComboBox(arr);
    JButton btn = new JButton("All Courses");

    JTextArea area = new JTextArea(12, 25);
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    MainProject(String title) {
        super(title);
        setSize(450, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        head.setFont(new Font("Cooper Black", Font.BOLD, 20));
        area.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        panel.add(logo);
        panel1.add(head);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(btn);
        panel2.add(gap);
        panel2.add(box);
        panel3.add(area);

        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.add(panel);

        panel4.add(panel1);
        panel4.add(sp1);
        panel4.add(panel2);
        panel4.add(sp);
        panel4.add(panel3);
        add(panel4);
        btn.addActionListener(this);
        box.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Graph obj = new Graph();

        if (e.getSource() == btn) {
            area.setText(obj.display());
        } else if (e.getSource() == box) {
            if (box.getSelectedItem().equals("CSE 103")) {
                area.setText(obj.Prerequisite(10));
            } else if (box.getSelectedItem().equals("CSE 105")) {
                area.setText(obj.Prerequisite(9));
            } else if (box.getSelectedItem().equals("CSE 201")) {
                area.setText(obj.Prerequisite(8));
            } else if (box.getSelectedItem().equals("CSE 203")) {
                area.setText(obj.Prerequisite(7));
            } else if (box.getSelectedItem().equals("CSE 205")) {
                area.setText(obj.Prerequisite(6));
            } else if (box.getSelectedItem().equals("CSE 207")) {
                area.setText(obj.Prerequisite(5));
            } else if (box.getSelectedItem().equals("CSE 303")) {
                area.setText(obj.Prerequisite(4));
            } else if (box.getSelectedItem().equals("CSE 309")) {
                area.setText(obj.Prerequisite(3));
            } else if (box.getSelectedItem().equals("CSE 311")) {
                area.setText(obj.Prerequisite(2));
            } else if (box.getSelectedItem().equals("CSE 313")) {
                area.setText(obj.Prerequisite(1));
            }
        }
    }
}
