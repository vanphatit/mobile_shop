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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;

public class PanelCoverFeature extends javax.swing.JPanel {

    private MigLayout layout;
    private int fontSize = 10;
    private JMenuBar feature;
    private JLabel title;
    
    public PanelCoverFeature() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap");
        setLayout(layout);
        init();
    }
    
    private void init() {
        title = new JLabel("Chức năng: ");
        title.setFont(new Font("sansserif", 1, fontSize));
        title.setForeground(new Color(0, 0, 0));
        add(title);
        
        feature = new JMenuBar();
        add(feature);
        
        feature.setBorder(new LineBorder(new Color(0,0,0)));
        
        JButton addF = new JButton();
        addF.setFont(new Font("sansserif", 1, fontSize));
        addF.setForeground(new Color(0, 0, 0));
        addF.setBackground(new Color(255, 255, 255));
        addF.setBorderPainted(false);
        addF.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        addF.setText("Thêm");
        addF.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_40px.png")));
        addF.setVerticalTextPosition(SwingConstants.BOTTOM);
        addF.setHorizontalTextPosition(SwingConstants.CENTER);
        addF.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(addF);
        
        JButton delete = new JButton();
        delete.setFont(new Font("sansserif", 1, fontSize));
        delete.setForeground(new Color(0, 0, 0));
        delete.setBackground(new Color(255, 255, 255));
        delete.setBorderPainted(false);
        delete.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        delete.setText("Xóa");
        delete.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_delete_40px.png")));
        delete.setVerticalTextPosition(SwingConstants.BOTTOM);
        delete.setHorizontalTextPosition(SwingConstants.CENTER);
        delete.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(delete);
        
        JButton fix = new JButton();
        fix.setFont(new Font("sansserif", 1, fontSize));
        fix.setForeground(new Color(0, 0, 0));
        fix.setBackground(new Color(255, 255, 255));
        fix.setBorderPainted(false);
        fix.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        fix.setText("Sửa");
        fix.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_edit_40px.png")));
        fix.setVerticalTextPosition(SwingConstants.BOTTOM);
        fix.setHorizontalTextPosition(SwingConstants.CENTER);
        fix.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(fix);
        
        JButton detail = new JButton();
        detail.setFont(new Font("sansserif", 1, fontSize));
        detail.setForeground(new Color(0, 0, 0));
        detail.setBackground(new Color(255, 255, 255));
        detail.setBorderPainted(false);
        detail.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        detail.setText("Sửa");
        detail.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_eye_40px.png")));
        detail.setVerticalTextPosition(SwingConstants.BOTTOM);
        detail.setHorizontalTextPosition(SwingConstants.CENTER);
        detail.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(detail);
        
        JButton addExcel = new JButton();
        addExcel.setFont(new Font("sansserif", 1, fontSize));
        addExcel.setForeground(new Color(0, 0, 0));
        addExcel.setBackground(new Color(255, 255, 255));
        addExcel.setBorderPainted(false);
        addExcel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        addExcel.setText("Nhập Excel");
        addExcel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_spreadsheet_file_40px.png")));
        addExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        addExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        addExcel.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(addExcel);
        
        JButton ExportExcel = new JButton();
        ExportExcel.setFont(new Font("sansserif", 1, fontSize));
        ExportExcel.setForeground(new Color(0, 0, 0));
        ExportExcel.setBackground(new Color(255, 255, 255));
        ExportExcel.setBorderPainted(false);
        ExportExcel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        ExportExcel.setText("Xuất Excel");
        ExportExcel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_xls_40px.png")));
        ExportExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        ExportExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        ExportExcel.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(ExportExcel);
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
