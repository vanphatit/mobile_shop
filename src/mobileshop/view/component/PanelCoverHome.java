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
import net.miginfocom.swing.MigLayout;

public class PanelCoverHome extends javax.swing.JPanel {

    private MigLayout layout;
    private JLabel title1;
    private JLabel title2;
    private int fontSize = 16;
    
    public PanelCoverHome() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap", "push[Center]push", "25[]5[]push[]10[]10[]10[]10[]10[]10[]10[]10[]push[]10[]10[]push");
        setLayout(layout);
        init();
    }
    
    private void init() {
        title1 = new JLabel("Hi!");
        title1.setFont(new Font("sansserif", 1, 30));
        title1.setForeground(new Color(245, 245, 245));
        add(title1);
        
        title2 = new JLabel("Admin");
        title2.setFont(new Font("sansserif", 1, 30));
        title2.setForeground(new Color(245, 245, 245));
        add(title2);
        
        JButton object = new JButton();
        object.setFont(new Font("sansserif", 1, fontSize));
        object.setForeground(new Color(245, 245, 245));
        object.setBackground(new Color(7, 164, 121));
        object.setBorderPainted(false);
        object.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        object.setText("Sản phẩm");
        object.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_product_25px_2.png")));
        object.setHorizontalAlignment(SwingConstants.LEFT);
        add(object, "w 100%");
        
        JButton suplier = new JButton();
        suplier.setFont(new Font("sansserif", 1, fontSize));
        suplier.setForeground(new Color(245, 245, 245));
        suplier.setBackground(new Color(7, 164, 121));
        suplier.setBorderPainted(false);
        suplier.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        suplier.setText("Nhà cung cấp");
        suplier.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_supplier_25px.png")));
        suplier.setHorizontalAlignment(SwingConstants.LEFT);
        add(suplier, "w 100%");
        
        JButton customer = new JButton();
        customer.setFont(new Font("sansserif", 1, fontSize));
        customer.setForeground(new Color(245, 245, 245));
        customer.setBackground(new Color(7, 164, 121));
        customer.setBorderPainted(false);
        customer.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        customer.setText("Khách hàng");
        customer.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/customer_25px.png")));
        customer.setHorizontalAlignment(SwingConstants.LEFT);
        add(customer, "w 100%");
        
        JButton staff = new JButton();
        staff.setFont(new Font("sansserif", 1, fontSize));
        staff.setForeground(new Color(245, 245, 245));
        staff.setBackground(new Color(7, 164, 121));
        staff.setBorderPainted(false);
        staff.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        staff.setText("Nhân viên");
        staff.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/staff_25px.png")));
        staff.setHorizontalAlignment(SwingConstants.LEFT);
        add(staff, "w 100%");
        
        JButton receipt_note = new JButton();
        receipt_note.setFont(new Font("sansserif", 1, fontSize));
        receipt_note.setForeground(new Color(245, 245, 245));
        receipt_note.setBackground(new Color(7, 164, 121));
        receipt_note.setBorderPainted(false);
        receipt_note.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        receipt_note.setText("Phiếu nhập hàng");
        receipt_note.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_file_25px_2.png")));
        receipt_note.setHorizontalAlignment(SwingConstants.LEFT);
        add(receipt_note, "w 100%");
        
        JButton bill = new JButton();
        bill.setFont(new Font("sansserif", 1, fontSize));
        bill.setForeground(new Color(245, 245, 245));
        bill.setBackground(new Color(7, 164, 121));
        bill.setBorderPainted(false);
        bill.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        bill.setText("Hóa đơn");
        bill.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/bill_25px.png")));
        bill.setHorizontalAlignment(SwingConstants.LEFT);
        add(bill, "w 100%");
        
        JButton inventory = new JButton();
        inventory.setFont(new Font("sansserif", 1, fontSize));
        inventory.setForeground(new Color(245, 245, 245));
        inventory.setBackground(new Color(7, 164, 121));
        inventory.setBorderPainted(false);
        inventory.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        inventory.setText("Tồn kho");
        inventory.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-warehouse-25.png")));
        inventory.setHorizontalAlignment(SwingConstants.LEFT);
        add(inventory, "w 100%");
        
        JButton account = new JButton();
        account.setFont(new Font("sansserif", 1, fontSize));
        account.setForeground(new Color(245, 245, 245));
        account.setBackground(new Color(7, 164, 121));
        account.setBorderPainted(false);
        account.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        account.setText("Tài khoản");
        account.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_test_account_25px.png")));
        account.setHorizontalAlignment(SwingConstants.LEFT);
        add(account, "w 100%");
        
        JButton statistics = new JButton();
        statistics.setFont(new Font("sansserif", 1, fontSize));
        statistics.setForeground(new Color(245, 245, 245));
        statistics.setBackground(new Color(7, 164, 121));
        statistics.setBorderPainted(false);
        statistics.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        statistics.setText("Thống kê");
        statistics.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/statisticals.png")));
        statistics.setHorizontalAlignment(SwingConstants.LEFT);
        add(statistics, "w 100%");
        
        JButton change_info = new JButton();
        change_info.setFont(new Font("sansserif", 1, fontSize));
        change_info.setForeground(new Color(245, 245, 245));
        change_info.setBackground(new Color(7, 164, 121));
        change_info.setBorderPainted(false);
        change_info.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        change_info.setText("Thay đổi thông tin");
        change_info.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-information-25.png")));
        change_info.setHorizontalAlignment(SwingConstants.LEFT);
        add(change_info, "w 100%");
        
        JButton logout = new JButton();
        logout.setFont(new Font("sansserif", 1, fontSize));
        logout.setForeground(new Color(245, 245, 245));
        logout.setBackground(new Color(7, 164, 121));
        logout.setBorderPainted(false);
        logout.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        logout.setText("Đăng xuất");
        logout.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_shutdown_25px.png")));
        logout.setHorizontalAlignment(SwingConstants.LEFT);
        add(logout, "w 100%");
        
        object.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        object.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        suplier.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        suplier.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        staff.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        staff.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        receipt_note.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        receipt_note.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        statistics.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        statistics.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        change_info.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(0, 255, 213));
            }
        });
        change_info.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setBackground(new Color(7, 164, 121));
            }
        });
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
