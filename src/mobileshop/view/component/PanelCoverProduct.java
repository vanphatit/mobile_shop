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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class PanelCoverProduct extends javax.swing.JPanel {

    private MigLayout layout;
    private JLabel title1;
    private JLabel title2;
    private int fontSize = 16;
    private JTable product;
    
    public PanelCoverProduct() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap");
        setLayout(layout);
        init();
    }
    
    private void init() {
        DefaultTableModel model = new DefaultTableModel();
        product = new JTable(model);
        
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Trạng thái");
        model.addColumn("Nhà sản xuất");
        model.addColumn("Giá thành");
        model.addColumn("Mã loại sản phẩm");
        
        add(product, "w 100%, h 100%");
        
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
