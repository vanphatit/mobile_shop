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

public class PanelCoverProduct extends javax.swing.JPanel {

    private MigLayout layout;
    private JLabel title1;
    private JLabel title2;
    private int fontSize = 16;
    private JTable product;
    private JScrollPane scrollPane;
    
    public PanelCoverProduct() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {
        Object[][] data = {
                {"OJ01", "IPhone", "Còn hàng", "Apple", "32000000", "OJC01"},
                {"OJ01", "IPhone", "Còn hàng", "Apple", "32000000", "OJC01"},
                {"OJ01", "IPhone", "Còn hàng", "Apple", "32000000", "OJC01"},
                {"OJ01", "IPhone", "Còn hàng", "Apple", "32000000", "OJC01"}
        };
        String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Trạng thái", "Nhà sản xuất", "Giá thành", "Mã loại sản phẩm"};
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        product = new JTable(model);
        scrollPane = new JScrollPane(product);
        scrollPane.setViewportView(product);
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setForeground(new Color(100, 100, 100));
        scrollPane.setFont(new Font("sansserif", 1, fontSize));
        product.setForeground(new Color(100, 100, 100));
        product.setFont(new Font("sansserif", 1, fontSize));
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
