package mobileshop.view.component;

import mobileshop.dao.*;
import mobileshop.model.*;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Frame.HAND_CURSOR;

public class PanelStatistics extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel mainPanel;
    private JPanel statisticsPanel;
    private JPanel productPanel;
    private JPanel countProductPanel;
    private JLabel productLabel;
    private JPanel supplierPanel;
    private JPanel countSupplierPanel;
    private JLabel supplierLabel;
    private JPanel customerPanel;
    private JPanel countCustomerPanel;
    private JLabel customerLabel;


    public PanelStatistics() {
        initComponents();
        setOpaque(false);
        init();
        layout = new MigLayout("debug, wrap");
        setLayout(layout);
        setVisible(true);
    }
    
    private void init() {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(new MigLayout("wrap", "[grow]push", "[grow][grow]"));

        statisticsPanel = new JPanel();
        statisticsPanel.setBackground(new Color(255, 255, 255));
        statisticsPanel.setLayout(new MigLayout("wrap", "[grow]5[grow]5[grow]", "[grow]"));



        //<editor-fold defaultstate="collapsed" desc="Statistics">
        productPanel = new JPanel();
        productPanel.setBackground(new Color(255, 213, 0));
        productPanel.setLayout(new MigLayout("wrap", "[]5[]"));
        statisticsPanel.add(productPanel, "w 33.33%, h 100%, grow, push");

        supplierPanel = new JPanel();
        supplierPanel.setBackground(new Color(255, 115, 0));
        supplierPanel.setLayout(new MigLayout("wrap", "[]5[]"));
        statisticsPanel.add(supplierPanel, "w 33.33%, h 100%, grow, push");

        customerPanel = new JPanel();
        customerPanel.setBackground(new Color(0, 204, 255));
        customerPanel.setLayout(new MigLayout("wrap", "[]5[]"));
        statisticsPanel.add(customerPanel, "w 33.33%, h 100%, grow, push");

        ImageIcon productIcon = new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-monitor-80.png"));
        productPanel.add(new JLabel(productIcon), "w 50%, h 100%, grow, push");

        countProductPanel = new JPanel();
        countProductPanel.setBackground(new Color(255, 213, 0));
        countProductPanel.setLayout(new MigLayout("wrap", "[Left]", "[]5[]"));
        productPanel.add(countProductPanel, "w 50%, h 100%, grow, push");

        ImageIcon supplierIcon = new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-supplier-80.png"));
        supplierPanel.add(new JLabel(supplierIcon), "w 50%, h 100%, grow, push");

        countSupplierPanel = new JPanel();
        countSupplierPanel.setBackground(new Color(255, 115, 0));
        countSupplierPanel.setLayout(new MigLayout("wrap", "[Left]", "[]5[]"));
        supplierPanel.add(countSupplierPanel, "w 50%, h 100%, grow, push");

        ImageIcon customerIcon = new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-account-80.png"));
        customerPanel.add(new JLabel(customerIcon), "w 50%, h 100%, grow, push");

        countCustomerPanel = new JPanel();
        countCustomerPanel.setBackground(new Color(0, 204, 255));
        countCustomerPanel.setLayout(new MigLayout("wrap", "[Left]", "[]5[]"));
        customerPanel.add(countCustomerPanel, "w 50%, h 100%, grow, push");

        int countProductInBill = 0;
        ArrayList<BillDetail> billDetails = BillDetailDAO.getInstance().selectAll();
        for (BillDetail billDetail : billDetails) {
            countProductInBill += billDetail.getCount();
        }
        int countProductInReceiptNote = 0;
        ArrayList<ReceiptNoteDetail> receiptNoteDetails = ReceiptNoteDetailDAO.getInstance().selectAll();
        for (ReceiptNoteDetail receiptNoteDetail : receiptNoteDetails) {
            countProductInReceiptNote += receiptNoteDetail.getCount();
        }

        int countProduct = countProductInReceiptNote - countProductInBill;
        JLabel countProductLabel = new JLabel(String.valueOf(countProduct));
        countProductLabel.setForeground(new Color(255, 255, 255));
        countProductLabel.setFont(new Font("sansserif", 1, 30));
        countProductPanel.add(countProductLabel, "w 100%, h 50%, wrap, grow, push");
        productLabel = new JLabel("Sản phẩm trong kho.");
        productLabel.setForeground(new Color(255, 255, 255));
        productLabel.setFont(new Font("sansserif", 1, fontSize));
        countProductPanel.add(productLabel, "w 100%, h 50%, grow, push");

        int countSupplier = 0;
        ArrayList<Suplier> supliers = SuplierDAO.getInstance().selectAll();
        for (Suplier suplier : supliers) {
            countSupplier += 1;
        }

        JLabel countSupplierLabel = new JLabel(String.valueOf(countSupplier));
        countSupplierLabel.setForeground(new Color(255, 255, 255));
        countSupplierLabel.setFont(new Font("sansserif", 1, 30));
        countSupplierPanel.add(countSupplierLabel, "w 100%, h 50%, wrap, grow, push");
        supplierLabel = new JLabel("Nhà cung cấp.");
        supplierLabel.setForeground(new Color(255, 255, 255));
        supplierLabel.setFont(new Font("sansserif", 1, fontSize));
        countSupplierPanel.add(supplierLabel, "w 100%, h 50%, grow, push");

        int countCustomer = 0;
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        for (Customer customer : customers) {
            countCustomer += 1;
        }

        JLabel countCustomerLabel = new JLabel(String.valueOf(countCustomer));
        countCustomerLabel.setForeground(new Color(255, 255, 255));
        countCustomerLabel.setFont(new Font("sansserif", 1, 30));
        countCustomerPanel.add(countCustomerLabel, "w 100%, h 50%, wrap, grow, push");
        customerLabel = new JLabel("Khách hàng.");
        customerLabel.setForeground(new Color(255, 255, 255));
        customerLabel.setFont(new Font("sansserif", 1, fontSize));
        countCustomerPanel.add(customerLabel, "w 100%, h 50%, grow, push");
        //</editor-fold>

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255, 255, 255));
        menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        menuBar.setLayout(new MigLayout("fill, insets 0"));
        mainPanel.add(menuBar, "w 100%, h 5%, wrap, grow, push");

        JMenu productMenu = new JMenu("Sản phẩm");
        productMenu.setFont(new Font("sansserif", 1, fontSize));
        menuBar.add(productMenu, "w 20%, h 100%, grow, push");
        productMenu.setCursor(new Cursor(HAND_CURSOR));

        JMenu receiptNoteMenu = new JMenu("Phiếu nhập");
        receiptNoteMenu.setFont(new Font("sansserif", 1, fontSize));
        menuBar.add(receiptNoteMenu, "w 20%, h 100%, grow, push");
        receiptNoteMenu.setCursor(new Cursor(HAND_CURSOR));

        JMenu billMenu = new JMenu("Hóa đơn");
        billMenu.setFont(new Font("sansserif", 1, fontSize));
        menuBar.add(billMenu, "w 20%, h 100%, grow, push");
        billMenu.setCursor(new Cursor(HAND_CURSOR));

        JPanel search = new JPanel();
        search.setBackground(new Color(255, 255, 255));
        search.setLayout(new MigLayout("wrap", "[grow]5[grow]"));
        search.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        search.setBorder(new TitledBorder("Tìm kiếm"));
        mainPanel.add(search, "w 100%, h 5%, wrap, grow, push");


        MyTextField text = new MyTextField();
        text.setFont(new Font("sansserif", 1, 14));
        text.setForeground(new Color(0, 0, 0));
        text.setBackground(new Color(255, 255, 255));
        text.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        text.setBorder(new LineBorder(new Color(0, 0, 0)));
        search.add(text, "w 70%, h 100%, grow, push");

        JButton reload = new JButton();
        reload.setFont(new Font("sansserif", 1, 14));
        reload.setForeground(new Color(0, 0, 0));
        reload.setBackground(new Color(255, 255, 255));
        reload.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        reload.setText("Làm mới");
        reload.setBorder(new LineBorder(new Color(0,0,0)));
        reload.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_reset_25px_1.png")));
        reload.setMargin(new Insets(10,20,10,20));
        search.add(reload, "w 30%, h 100%, grow, push");

        add(statisticsPanel, "height 20%, width 100%, wrap, grow, push");
        add(mainPanel, "height 80%, width 20%, grow, push");
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
