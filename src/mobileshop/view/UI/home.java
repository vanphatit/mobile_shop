package mobileshop.view.UI;

import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import mobileshop.view.component.PanelCoverHome;
import mobileshop.view.component.PanelCoverProduct;
import mobileshop.view.component.PanelCoverSuplier;
import mobileshop.view.component.PanelProduct;
import mobileshop.view.swing.MyTextField;

import net.miginfocom.swing.MigLayout;


public class home extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCoverHome cover;
    private PanelProduct product;
    private JPanel main;
    private int fontSize = 16;
   
    
    public home() {
        setTitle("Phần mềm quản lý mobile shop!");
        initComponents();
        init();
    }

    private void init()
    {
       layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverHome();
        product = new PanelProduct();
        main = new JPanel();
        main.setBackground(new Color(255,255,255));
        
        // <editor-fold defaultstate="collapsed" desc="Home"> 
        Dimension containerSize = bg.getSize();
        int newWidth = (int) (containerSize.width * 0.19);
        JButton object = new JButton();
        object.setFont(new Font("sansserif", 1, fontSize));
        object.setForeground(new Color(245, 245, 245));
        object.setBackground(new Color(7, 164, 121));
        object.setBorderPainted(false);
        object.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        object.setText("Sản phẩm");
        object.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_product_25px_2.png")));
        object.setHorizontalAlignment(SwingConstants.LEFT);
        object.setPreferredSize(new Dimension(newWidth, object.getPreferredSize().height));
        bg.add(object);
        
        JButton suplier = new JButton();
        suplier.setFont(new Font("sansserif", 1, fontSize));
        suplier.setForeground(new Color(245, 245, 245));
        suplier.setBackground(new Color(7, 164, 121));
        suplier.setBorderPainted(false);
        suplier.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        suplier.setText("Nhà cung cấp");
        suplier.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_supplier_25px.png")));
        suplier.setHorizontalAlignment(SwingConstants.LEFT);
        suplier.setPreferredSize(new Dimension(newWidth, suplier.getPreferredSize().height));
        bg.add(suplier, "w 100%");
        
        JButton customer = new JButton();
        customer.setFont(new Font("sansserif", 1, fontSize));
        customer.setForeground(new Color(245, 245, 245));
        customer.setBackground(new Color(7, 164, 121));
        customer.setBorderPainted(false);
        customer.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        customer.setText("Khách hàng");
        customer.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/customer_25px.png")));
        customer.setHorizontalAlignment(SwingConstants.LEFT);
        customer.setPreferredSize(new Dimension(newWidth, customer.getPreferredSize().height));
        bg.add(customer, "w 100%");
        
        JButton staff = new JButton();
        staff.setFont(new Font("sansserif", 1, fontSize));
        staff.setForeground(new Color(245, 245, 245));
        staff.setBackground(new Color(7, 164, 121));
        staff.setBorderPainted(false);
        staff.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        staff.setText("Nhân viên");
        staff.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/staff_25px.png")));
        staff.setHorizontalAlignment(SwingConstants.LEFT);
        staff.setPreferredSize(new Dimension(newWidth, staff.getPreferredSize().height));
        bg.add(staff, "w 100%");
        
        JButton receipt_note = new JButton();
        receipt_note.setFont(new Font("sansserif", 1, fontSize));
        receipt_note.setForeground(new Color(245, 245, 245));
        receipt_note.setBackground(new Color(7, 164, 121));
        receipt_note.setBorderPainted(false);
        receipt_note.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        receipt_note.setText("Phiếu nhập hàng");
        receipt_note.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_file_25px_2.png")));
        receipt_note.setHorizontalAlignment(SwingConstants.LEFT);
        receipt_note.setPreferredSize(new Dimension(newWidth, receipt_note.getPreferredSize().height));
        bg.add(receipt_note, "w 100%");
        
        JButton bill = new JButton();
        bill.setFont(new Font("sansserif", 1, fontSize));
        bill.setForeground(new Color(245, 245, 245));
        bill.setBackground(new Color(7, 164, 121));
        bill.setBorderPainted(false);
        bill.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        bill.setText("Hóa đơn");
        bill.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/bill_25px.png")));
        bill.setHorizontalAlignment(SwingConstants.LEFT);
        bill.setPreferredSize(new Dimension(newWidth, bill.getPreferredSize().height));
        bg.add(bill, "w 100%");
        
        JButton account = new JButton();
        account.setFont(new Font("sansserif", 1, fontSize));
        account.setForeground(new Color(245, 245, 245));
        account.setBackground(new Color(7, 164, 121));
        account.setBorderPainted(false);
        account.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        account.setText("Tài khoản");
        account.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_test_account_25px.png")));
        account.setHorizontalAlignment(SwingConstants.LEFT);
        account.setPreferredSize(new Dimension(newWidth, account.getPreferredSize().height));
        bg.add(account, "w 100%");
        
        JButton statistics = new JButton();
        statistics.setFont(new Font("sansserif", 1, fontSize));
        statistics.setForeground(new Color(245, 245, 245));
        statistics.setBackground(new Color(7, 164, 121));
        statistics.setBorderPainted(false);
        statistics.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        statistics.setText("Thống kê");
        statistics.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/statisticals.png")));
        statistics.setHorizontalAlignment(SwingConstants.LEFT);
        statistics.setPreferredSize(new Dimension(newWidth, statistics.getPreferredSize().height));
        bg.add(statistics, "w 100%");
        
        JButton change_info = new JButton();
        change_info.setFont(new Font("sansserif", 1, fontSize));
        change_info.setForeground(new Color(245, 245, 245));
        change_info.setBackground(new Color(7, 164, 121));
        change_info.setBorderPainted(false);
        change_info.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        change_info.setText("Thay đổi thông tin");
        change_info.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-information-25.png")));
        change_info.setHorizontalAlignment(SwingConstants.LEFT);
        change_info.setPreferredSize(new Dimension(newWidth, change_info.getPreferredSize().height));
        bg.add(change_info, "w 100%");
        
        JButton logout = new JButton();
        logout.setFont(new Font("sansserif", 1, fontSize));
        logout.setForeground(new Color(245, 245, 245));
        logout.setBackground(new Color(7, 164, 121));
        logout.setBorderPainted(false);
        logout.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        logout.setText("Đăng xuất");
        logout.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_shutdown_25px.png")));
        logout.setHorizontalAlignment(SwingConstants.LEFT);
        logout.setPreferredSize(new Dimension(newWidth, logout.getPreferredSize().height));
        bg.add(logout, "w 100%");
        
        object.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        object.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        object.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        suplier.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        suplier.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        suplier.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        staff.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        staff.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        receipt_note.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        receipt_note.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        statistics.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        statistics.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        change_info.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        change_info.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        // </editor-fold> 
        
        bg.setLayout(new MigLayout("wrap", "[Left]", "150[]10[]10[]10[]10[]10[]10[]10[]push[]10[]10[]push"));
        main.setLayout(layout);
        
        bg.add(cover, "width 20%, pos 0al 0 n 100%");
        bg.add(main, "width 80%, pos 1al 0 n 100%");
        main.add(product, "w 100%, h 100%, wrap");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1321, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new home().setVisible(true);
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
