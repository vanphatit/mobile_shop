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
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.miginfocom.swing.MigLayout;

public class PanelCoverSuplier extends javax.swing.JPanel {

    private MigLayout layout;
    private JLabel title1;
    private JLabel title2;
    private int fontSize = 16;
    private JTable suplier;
    private JScrollPane scrollPane;
    
    public PanelCoverSuplier() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {
        Object[][] data = {
                {"S001", "Apple", "0123456789", "Còn cung cấp"},
                {"S001", "Apple", "0123456789", "Còn cung cấp"},
                {"S001", "Apple", "0123456789", "Còn cung cấp"}
        };
        String[] columnNames = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Trạng thái"};
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        suplier = new JTable(model);
        scrollPane = new JScrollPane(suplier);
        scrollPane.setViewportView(suplier);
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setForeground(new Color(100, 100, 100));
        scrollPane.setFont(new Font("sansserif", 1, fontSize));
        suplier.setForeground(new Color(100, 100, 100));
        suplier.setFont(new Font("sansserif", 1, fontSize));
        add(scrollPane, "w 100%, h 100%");
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
