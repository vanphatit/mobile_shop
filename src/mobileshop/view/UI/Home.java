package mobileshop.view.UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mobileshop.view.component.*;

import net.miginfocom.swing.MigLayout;


public class Home extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCoverHome cover;
    private PanelProduct Product;
    private PanelSuplier Suplier;
    private PanelStaff Staff;
    private PanelCustomer Customer;
    private PanelReceiptNote ReceiptNote;
    private PanelBill Bill;
    private PanelBillDetail BillDetail;
    private PanelStatistics Statistics;
    public  JPanel main;
    private int fontSize = 16;

    public static final Color DEFAULT_FOREGROUND = new Color(245,245,245);
    public static final Color DEFAULT_BACKGROUND = new Color(7,164,121);
    public static final Color HOVER_FOREGROUND = new Color(255,255,255);
    public static final Color HOVER_BACKGROUND = new Color(0,255,213);
   
    
    public Home(String idStaff) {
        setTitle("Phần mềm quản lý Mobile Shop!");
        initComponents();
        init(idStaff);
    }

    private void init(String idStaff)
    {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverHome(idStaff);
        Product = new PanelProduct();
        Suplier = new PanelSuplier();
        Staff = new PanelStaff();
        Customer = new PanelCustomer();
        ReceiptNote = new PanelReceiptNote();
        Bill = new PanelBill();
        BillDetail = new PanelBillDetail();
        Statistics = new PanelStatistics();
        main = new JPanel();
        main.setBackground(new Color(255,255,255));

        bg.setLayout(new MigLayout("fill, wrap", "[Left]", "150[]10[]10[]10[]10[]10[]10[]10[]push[]10[]10[]push"));
        main.setLayout(new MigLayout("fill, wrap", "[Center]", "[Center]"));

        bg.add(cover, "width 20%, pos 0al 0 n 100%");
        bg.add(main, "width 78%, pos 1al 0 n 100%");

        // <editor-fold defaultstate="collapsed" desc="Home">
        JButton object = new JButton();
        object.setFont(new Font("sansserif", 1, fontSize));
        object.setForeground(new Color(245, 245, 245));
        object.setBackground(new Color(7, 164, 121));
        object.setBorderPainted(false);
        object.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        object.setText("Sản phẩm");
        object.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_product_25px_2.png")));
        object.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(object, "w 100%");

        JButton suplier = new JButton();
        suplier.setFont(new Font("sansserif", 1, fontSize));
        suplier.setForeground(new Color(245, 245, 245));
        suplier.setBackground(new Color(7, 164, 121));
        suplier.setBorderPainted(false);
        suplier.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        suplier.setText("Nhà cung cấp");
        suplier.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_supplier_25px.png")));
        suplier.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(suplier, "w 100%");

        JButton customer = new JButton();
        customer.setFont(new Font("sansserif", 1, fontSize));
        customer.setForeground(new Color(245, 245, 245));
        customer.setBackground(new Color(7, 164, 121));
        customer.setBorderPainted(false);
        customer.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        customer.setText("Khách hàng");
        customer.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/customer_25px.png")));
        customer.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(customer, "w 100%");

        JButton staff = new JButton();
        staff.setFont(new Font("sansserif", 1, fontSize));
        staff.setForeground(new Color(245, 245, 245));
        staff.setBackground(new Color(7, 164, 121));
        staff.setBorderPainted(false);
        staff.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        staff.setText("Nhân viên");
        staff.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/staff_25px.png")));
        staff.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(staff, "w 100%");

        JButton receipt_note = new JButton();
        receipt_note.setFont(new Font("sansserif", 1, fontSize));
        receipt_note.setForeground(new Color(245, 245, 245));
        receipt_note.setBackground(new Color(7, 164, 121));
        receipt_note.setBorderPainted(false);
        receipt_note.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        receipt_note.setText("Phiếu nhập hàng");
        receipt_note.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_file_25px_2.png")));
        receipt_note.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(receipt_note, "w 100%");

        JButton bill = new JButton();
        bill.setFont(new Font("sansserif", 1, fontSize));
        bill.setForeground(new Color(245, 245, 245));
        bill.setBackground(new Color(7, 164, 121));
        bill.setBorderPainted(false);
        bill.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        bill.setText("Hóa đơn");
        bill.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/bill_25px.png")));
        bill.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(bill, "w 100%");

        JButton statistics = new JButton();
        statistics.setFont(new Font("sansserif", 1, fontSize));
        statistics.setForeground(new Color(245, 245, 245));
        statistics.setBackground(new Color(7, 164, 121));
        statistics.setBorderPainted(false);
        statistics.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        statistics.setText("Thống kê");
        statistics.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/statisticals.png")));
        statistics.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(statistics, "w 100%");

        JButton change_info = new JButton();
        change_info.setFont(new Font("sansserif", 1, fontSize));
        change_info.setForeground(new Color(245, 245, 245));
        change_info.setBackground(new Color(7, 164, 121));
        change_info.setBorderPainted(false);
        change_info.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        change_info.setText("Thay đổi thông tin");
        change_info.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-information-25.png")));
        change_info.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(change_info, "w 100%");

        JButton logout = new JButton();
        logout.setFont(new Font("sansserif", 1, fontSize));
        logout.setForeground(new Color(245, 245, 245));
        logout.setBackground(new Color(7, 164, 121));
        logout.setBorderPainted(false);
        logout.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        logout.setText("Đăng xuất");
        logout.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_shutdown_25px.png")));
        logout.setHorizontalAlignment(SwingConstants.LEFT);
        cover.add(logout, "w 100%");

        main.add(Statistics, "w 100%, h 100% , wrap");

        object.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));

                main.removeAll();
                main.repaint();
                main.add(Product, "w 100%, h 100% , wrap");
                main.revalidate();
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                object.setForeground(HOVER_FOREGROUND);
                object.setBackground(HOVER_BACKGROUND);
                suplier.setForeground(DEFAULT_FOREGROUND);
                suplier.setBackground(DEFAULT_BACKGROUND);
                customer.setForeground(DEFAULT_FOREGROUND);
                customer.setBackground(DEFAULT_BACKGROUND);
                staff.setForeground(DEFAULT_FOREGROUND);
                staff.setBackground(DEFAULT_BACKGROUND);
                receipt_note.setForeground(DEFAULT_FOREGROUND);
                receipt_note.setBackground(DEFAULT_BACKGROUND);
                bill.setForeground(DEFAULT_FOREGROUND);
                bill.setBackground(DEFAULT_BACKGROUND);
                statistics.setForeground(DEFAULT_FOREGROUND);
                statistics.setBackground(DEFAULT_BACKGROUND);
                change_info.setForeground(DEFAULT_FOREGROUND);
                change_info.setBackground(DEFAULT_BACKGROUND);
                logout.setForeground(DEFAULT_FOREGROUND);
                logout.setBackground(DEFAULT_BACKGROUND);
            }
        });
        suplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));

                main.removeAll();
                main.repaint();
                main.add(Suplier, "w 100%, h 100% , wrap");
                main.revalidate();
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suplier.setForeground(HOVER_FOREGROUND);
                suplier.setBackground(HOVER_BACKGROUND);
                object.setForeground(DEFAULT_FOREGROUND);
                object.setBackground(DEFAULT_BACKGROUND);
                customer.setForeground(DEFAULT_FOREGROUND);
                customer.setBackground(DEFAULT_BACKGROUND);
                staff.setForeground(DEFAULT_FOREGROUND);
                staff.setBackground(DEFAULT_BACKGROUND);
                receipt_note.setForeground(DEFAULT_FOREGROUND);
                receipt_note.setBackground(DEFAULT_BACKGROUND);
                bill.setForeground(DEFAULT_FOREGROUND);
                bill.setBackground(DEFAULT_BACKGROUND);
                statistics.setForeground(DEFAULT_FOREGROUND);
                statistics.setBackground(DEFAULT_BACKGROUND);
                change_info.setForeground(DEFAULT_FOREGROUND);
                change_info.setBackground(DEFAULT_BACKGROUND);
                logout.setForeground(DEFAULT_FOREGROUND);
                logout.setBackground(DEFAULT_BACKGROUND);
            }
        });
        staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));

                main.removeAll();
                main.repaint();
                main.add(Staff, "w 100%, h 100% , wrap");
                main.revalidate();
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                staff.setForeground(HOVER_FOREGROUND);
                staff.setBackground(HOVER_BACKGROUND);
                object.setForeground(DEFAULT_FOREGROUND);
                object.setBackground(DEFAULT_BACKGROUND);
                suplier.setForeground(DEFAULT_FOREGROUND);
                suplier.setBackground(DEFAULT_BACKGROUND);
                customer.setForeground(DEFAULT_FOREGROUND);
                customer.setBackground(DEFAULT_BACKGROUND);
                receipt_note.setForeground(DEFAULT_FOREGROUND);
                receipt_note.setBackground(DEFAULT_BACKGROUND);
                bill.setForeground(DEFAULT_FOREGROUND);
                bill.setBackground(DEFAULT_BACKGROUND);
                statistics.setForeground(DEFAULT_FOREGROUND);
                statistics.setBackground(DEFAULT_BACKGROUND);
                change_info.setForeground(DEFAULT_FOREGROUND);
                change_info.setBackground(DEFAULT_BACKGROUND);
                logout.setForeground(DEFAULT_FOREGROUND);
                logout.setBackground(DEFAULT_BACKGROUND);
            }
        });
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));

                main.removeAll();
                main.repaint();
                main.add(Customer, "w 100%, h 100% , wrap");
                main.revalidate();
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customer.setForeground(HOVER_FOREGROUND);
                customer.setBackground(HOVER_BACKGROUND);
                object.setForeground(DEFAULT_FOREGROUND);
                object.setBackground(DEFAULT_BACKGROUND);
                suplier.setForeground(DEFAULT_FOREGROUND);
                suplier.setBackground(DEFAULT_BACKGROUND);
                staff.setForeground(DEFAULT_FOREGROUND);
                staff.setBackground(DEFAULT_BACKGROUND);
                receipt_note.setForeground(DEFAULT_FOREGROUND);
                receipt_note.setBackground(DEFAULT_BACKGROUND);
                bill.setForeground(DEFAULT_FOREGROUND);
                bill.setBackground(DEFAULT_BACKGROUND);
                statistics.setForeground(DEFAULT_FOREGROUND);
                statistics.setBackground(DEFAULT_BACKGROUND);
                change_info.setForeground(DEFAULT_FOREGROUND);
                change_info.setBackground(DEFAULT_BACKGROUND);
                logout.setForeground(DEFAULT_FOREGROUND);
                logout.setBackground(DEFAULT_BACKGROUND);
            }
        });
        receipt_note.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));

                main.removeAll();
                main.repaint();
                main.add(ReceiptNote, "width 100%, pos 0al 0 n 100%");
                main.revalidate();
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receipt_note.setForeground(HOVER_FOREGROUND);
                receipt_note.setBackground(HOVER_BACKGROUND);
                object.setForeground(DEFAULT_FOREGROUND);
                object.setBackground(DEFAULT_BACKGROUND);
                suplier.setForeground(DEFAULT_FOREGROUND);
                suplier.setBackground(DEFAULT_BACKGROUND);
                staff.setForeground(DEFAULT_FOREGROUND);
                staff.setBackground(DEFAULT_BACKGROUND);
                customer.setForeground(DEFAULT_FOREGROUND);
                customer.setBackground(DEFAULT_BACKGROUND);
                bill.setForeground(DEFAULT_FOREGROUND);
                bill.setBackground(DEFAULT_BACKGROUND);
                statistics.setForeground(DEFAULT_FOREGROUND);
                statistics.setBackground(DEFAULT_BACKGROUND);
                change_info.setForeground(DEFAULT_FOREGROUND);
                change_info.setBackground(DEFAULT_BACKGROUND);
                logout.setForeground(DEFAULT_FOREGROUND);
                logout.setBackground(DEFAULT_BACKGROUND);
            }
        });
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));

                main.removeAll();
                main.repaint();
                main.add(Bill, "width 50%, pos 0al 0 n 100%");
                main.add(BillDetail, "width 50%, pos 1al 0 n 100%");
                main.revalidate();
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bill.setForeground(HOVER_FOREGROUND);
                bill.setBackground(HOVER_BACKGROUND);
                object.setForeground(DEFAULT_FOREGROUND);
                object.setBackground(DEFAULT_BACKGROUND);
                suplier.setForeground(DEFAULT_FOREGROUND);
                suplier.setBackground(DEFAULT_BACKGROUND);
                staff.setForeground(DEFAULT_FOREGROUND);
                staff.setBackground(DEFAULT_BACKGROUND);
                customer.setForeground(DEFAULT_FOREGROUND);
                customer.setBackground(DEFAULT_BACKGROUND);
                receipt_note.setForeground(DEFAULT_FOREGROUND);
                receipt_note.setBackground(DEFAULT_BACKGROUND);
                statistics.setForeground(DEFAULT_FOREGROUND);
                statistics.setBackground(DEFAULT_BACKGROUND);
                change_info.setForeground(DEFAULT_FOREGROUND);
                change_info.setBackground(DEFAULT_BACKGROUND);
                logout.setForeground(DEFAULT_FOREGROUND);
                logout.setBackground(DEFAULT_BACKGROUND);
            }
        });
        statistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));

                main.removeAll();
                main.repaint();
                main.add(Statistics, "w 100%, h 100% , wrap");
                main.revalidate();
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                statistics.setForeground(HOVER_FOREGROUND);
                statistics.setBackground(HOVER_BACKGROUND);
                object.setForeground(DEFAULT_FOREGROUND);
                object.setBackground(DEFAULT_BACKGROUND);
                suplier.setForeground(DEFAULT_FOREGROUND);
                suplier.setBackground(DEFAULT_BACKGROUND);
                staff.setForeground(DEFAULT_FOREGROUND);
                staff.setBackground(DEFAULT_BACKGROUND);
                customer.setForeground(DEFAULT_FOREGROUND);
                customer.setBackground(DEFAULT_BACKGROUND);
                receipt_note.setForeground(DEFAULT_FOREGROUND);
                receipt_note.setBackground(DEFAULT_BACKGROUND);
                bill.setForeground(DEFAULT_FOREGROUND);
                bill.setBackground(DEFAULT_BACKGROUND);
                change_info.setForeground(DEFAULT_FOREGROUND);
                change_info.setBackground(DEFAULT_BACKGROUND);
                logout.setForeground(DEFAULT_FOREGROUND);
                logout.setBackground(DEFAULT_BACKGROUND);
            }
        });
        // </editor-fold>

    }

    public void setReceiptNoteDetail() {
        main.removeAll();
//        main.repaint();
//        main.add(ReceiptNote, "width 50%, pos 0al 0 n 100%");
//        main.add(ReceiptNoteDetail, "width 50%, pos 1al 0 n 100%");
//        main.revalidate();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
