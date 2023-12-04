package mobileshop.view.component;

import com.raven.swing.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import mobileshop.view.swing.ButtonOutLine;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCoverProduct extends javax.swing.JPanel {

    private MigLayout layout;
    private JLabel title1;
    private JLabel title2;
    private int fontSize = 16;
    
    public PanelCoverProduct() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap", "push[Left]push", "[]5[]push[]10[]10[]10[]10[]10[]push[]10[]10[]push");
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
        
        ButtonOutLine object = new ButtonOutLine();
        object.setFont(new Font("sansserif", 1, fontSize));
        object.setForeground(new Color(245, 245, 245));
        object.setBackground(new Color(7, 164, 121));
        object.setBorderPainted(false);
        object.setText("Sản phẩm");
        add(object);
        
        ButtonOutLine suplier = new ButtonOutLine();
        suplier.setFont(new Font("sansserif", 1, fontSize));
        suplier.setForeground(new Color(245, 245, 245));
        suplier.setBackground(new Color(7, 164, 121));
        suplier.setBorderPainted(false);
        suplier.setText("Nhà cung cấp");
        add(suplier);
        
        ButtonOutLine customer = new ButtonOutLine();
        customer.setFont(new Font("sansserif", 1, fontSize));
        customer.setForeground(new Color(245, 245, 245));
        customer.setBackground(new Color(7, 164, 121));
        customer.setBorderPainted(false);
        customer.setText("Khách hàng");
        add(customer);
        
        ButtonOutLine staff = new ButtonOutLine();
        staff.setFont(new Font("sansserif", 1, fontSize));
        staff.setForeground(new Color(245, 245, 245));
        staff.setBackground(new Color(7, 164, 121));
        staff.setBorderPainted(false);
        staff.setText("Nhân viên");
        add(staff);
        
        ButtonOutLine receipt_note = new ButtonOutLine();
        receipt_note.setFont(new Font("sansserif", 1, fontSize));
        receipt_note.setForeground(new Color(245, 245, 245));
        receipt_note.setBackground(new Color(7, 164, 121));
        receipt_note.setBorderPainted(false);
        receipt_note.setText("Phiếu nhập hàng");
        add(receipt_note);
        
        ButtonOutLine bill = new ButtonOutLine();
        bill.setFont(new Font("sansserif", 1, fontSize));
        bill.setForeground(new Color(245, 245, 245));
        bill.setBackground(new Color(7, 164, 121));
        bill.setBorderPainted(false);
        bill.setText("Hóa đơn");
        add(bill);
        
        ButtonOutLine change_info = new ButtonOutLine();
        change_info.setFont(new Font("sansserif", 1, fontSize));
        change_info.setForeground(new Color(245, 245, 245));
        change_info.setBackground(new Color(7, 164, 121));
        change_info.setBorderPainted(false);
        change_info.setText("Thay đổi thông tin");
        add(change_info);
        
        ButtonOutLine logout = new ButtonOutLine();
        logout.setFont(new Font("sansserif", 1, fontSize));
        logout.setForeground(new Color(245, 245, 245));
        logout.setBackground(new Color(7, 164, 121));
        logout.setBorderPainted(false);
        logout.setText("Đăng xuất");
        add(logout);
        
//        object.addActionListener(e ->);
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
            .addGap(0, 300, Short.MAX_VALUE)
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
