
package com.raven.component;

import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;


public class Chat_Body extends javax.swing.JPanel {

   
    public Chat_Body() {
        initComponents();
        init();
        addItemRight("Send a text message to a group of contacts. Include photos");
        addItemRight("hello\nHi");
        addItemLeft("Simpletext started as a passion projectu.", "Sabbir");
        addDate("05/01/2023");
        addItemLeft("hello\nerererew\newewe", "Raven");
        addItemRight("hello\nerererew\newewe", new ImageIcon(getClass().getResource("/com/raven/icon/pic.jpg")));
        addItemLeft("Hello this is my friend", "Jonh", new ImageIcon(getClass().getResource("/com/raven/icon/dog.jpg")), new ImageIcon(getClass().getResource("/com/raven/icon/pic.jpg")));
        addDate("Today");
        addItemRight("hello\nerererew\newewe");
        addItemLeft("", "Ro", new ImageIcon(getClass().getResource("/com/raven/icon/pic.jpg")));
    }
    
    private void init() {
        body.setLayout(new MigLayout("fillx","","0[]0"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    }
    
    public void addItemLeft(String text, String user, Icon... image) {
        Chat_Left item = new Chat_Left();
        item.setText(text);
        item.setImage(image);
        item.setTime();
//        item.setUserProfile(user);
        body.add(item, "wrap, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }

    public void addItemRight(String text, Icon... image) {
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setImage(image);
        body.add(item, "wrap, al right, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    
    public void addDate(String date) {
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        body.add(item, "wrap, al center");
        body.repaint();
        body.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 934, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents
//    private void initComponents() {
//
//        sp = new javax.swing.JScrollPane();
//        body = new javax.swing.JPanel();
//
//        sp.setBorder(null);
//        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//
//        body.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
//        body.setLayout(bodyLayout);
//        bodyLayout.setHorizontalGroup(
//            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 826, Short.MAX_VALUE)
//        );
//        bodyLayout.setVerticalGroup(
//            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 555, Short.MAX_VALUE)
//        );
//
//        sp.setViewportView(body);
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(sp)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(sp)
//        );
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
