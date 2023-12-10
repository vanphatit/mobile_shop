package mobileshop.view.component;

import com.raven.swing.Button;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mobileshop.dao.StaffDAO;
import net.miginfocom.swing.MigLayout;

public class PanelCoverHome extends javax.swing.JPanel {

    private MigLayout layout;
    private JLabel title1;
    private JLabel title2;
    private int fontSize = 16;
    
    public PanelCoverHome(String idStaff) {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap", "30[Left]push", "25[]5[]push[]10[]10[]10[]10[]10[]10[]10[]push[]10[]10[]push");
        setLayout(layout);
        init(idStaff);
    }
    
    private void init(String idStaff) {
        title1 = new JLabel("Hi!");
        title1.setFont(new Font("sansserif", 1, 30));
        title1.setForeground(new Color(245, 245, 245));
        add(title1);
        
        title2 = new JLabel(StaffDAO.getInstance().selectById(idStaff).getName());
        title2.setFont(new Font("sansserif", 1, 30));
        title2.setForeground(new Color(245, 245, 245));
        add(title2);
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color backgroundColor = new Color(7, 164, 121);  // Màu nền mới
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
