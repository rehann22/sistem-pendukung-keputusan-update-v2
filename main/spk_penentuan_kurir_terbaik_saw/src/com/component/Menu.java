package com.component;

import com.admin.controler.SessionAdmin;
import com.event.EventMenuSelected;
import com.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

      String logName = SessionAdmin.log_nama();
      String logId = SessionAdmin.log_idAdmin();
      private EventMenuSelected event;

      public void addEventMenuSelected(EventMenuSelected event) {
            this.event = event;
            listMenu1.addEventMenuSelected(event);
      }

      public Menu() {
            initComponents();
            setOpaque(false);
            listMenu1.setOpaque(false);
            init();
      }

      private void init() {
            listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("3", "Data Kriteria", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("5", "Proses Perhitungan", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("8", "Profile", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("9", "Keluar ", Model_Menu.MenuType.MENU));
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelMoving = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            listMenu1 = new com.swing.ListMenu<>();

            panelMoving.setOpaque(false);

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Admin");

            javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
            panelMoving.setLayout(panelMovingLayout);
            panelMovingLayout.setHorizontalGroup(
                  panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            );
            panelMovingLayout.setVerticalGroup(
                  panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jLabel1))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
            );
      }// </editor-fold>//GEN-END:initComponents

      @Override
      protected void paintChildren(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g = new GradientPaint(0, 0, Color.decode("#2314E2"), 0, getHeight(), Color.decode("#D112EB"));
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
            super.paintChildren(grphcs);
      }

      private int x;
      private int y;

      public void initMoving(JFrame fram) {
            panelMoving.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mousePressed(MouseEvent me) {
                        x = me.getX();
                        y = me.getY();
                  }

            });
            panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
                  @Override
                  public void mouseDragged(MouseEvent me) {
                        fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel jLabel1;
      private com.swing.ListMenu<String> listMenu1;
      private javax.swing.JPanel panelMoving;
      // End of variables declaration//GEN-END:variables
}
