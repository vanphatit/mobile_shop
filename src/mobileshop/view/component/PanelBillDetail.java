package mobileshop.view.component;

import mobileshop.dao.*;
import mobileshop.model.Bill;
import mobileshop.model.BillDetail;
import mobileshop.model.ReceiptNote;
import mobileshop.model.ReceiptNoteDetail;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Frame.HAND_CURSOR;

public class PanelBillDetail extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JTable billDetail;
    private JScrollPane scrollPane;
    private JPanel receipt;
    private JPanel detail;
    private JPanel feature;
    private JPanel costPanel;
    private JPanel main;
    JLabel txtCost;

    private ArrayList<Bill> bills;
    private ArrayList<BillDetail> billDetails;
    private Bill bill;
    private mobileshop.model.Object products;

    private int billCost = 0;

    public PanelBillDetail(String id) {
        if(id != null)
            bill = BillDAO.getInstance().selectById(id);
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap", "[grow]", "[grow]10[grow]10[grow]");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {

        //<editor-fold defaultstate="collapsed" desc="Panel">
        main = new JPanel();
        main.setBackground(new Color(255, 255, 255));
        main.setLayout(new MigLayout("wrap", "[grow]", "[grow]10[grow]10[grow]"));
        add(main, "width 100%, height 100%, wrap");
        costPanel = new JPanel();
        costPanel.setBackground(new Color(255, 255, 255));
        costPanel.setLayout(new MigLayout("wrap", "push[Left]push", "push[]10[]push"));
        receipt = new JPanel();
        receipt.setBackground(new Color(255, 255, 255));
        receipt.setLayout(new MigLayout("wrap", "[Left]10[Left]push", "push[]5[]5[]5[]push"));
        detail = new JPanel();
        detail.setBackground(new Color(255, 255, 255));
        detail.setLayout(new MigLayout("wrap"));
        feature = new JPanel();
        feature.setBackground(new Color(255, 255, 255));
        feature.setLayout(new MigLayout("wrap", "[center]10[center]10[center]25[]push", "push[]push"));

        //<editor-fold defaultstate="collapsed" desc="Feature">
        JButton btnAdd = new JButton();
        btnAdd.setFont(new Font("sansserif", 1, 14));
        btnAdd.setForeground(new Color(100, 100, 100));
        btnAdd.setBackground(new Color(255, 255, 255));
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnAdd.setText("Thêm");
        btnAdd.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_25px_5.png")));
        btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(btnAdd);
        
        JButton btnDel = new JButton();
        btnDel.setFont(new Font("sansserif", 1, 14));
        btnDel.setForeground(new Color(100, 100, 100));
        btnDel.setBackground(new Color(255, 255, 255));
        btnDel.setBorderPainted(false);
        btnDel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnDel.setText("Xóa");
        btnDel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_delete_25px_1.png")));
        btnDel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDel.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(btnDel);
        
        JButton btnEdit = new JButton();
        btnEdit.setFont(new Font("sansserif", 1, 14));
        btnEdit.setForeground(new Color(100, 100, 100));
        btnEdit.setBackground(new Color(255, 255, 255));
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnEdit.setText("Sửa");
        btnEdit.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_edit_25px.png")));
        btnEdit.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEdit.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(btnEdit);

        JLabel cost = new JLabel("Tổng tiền: ");
        cost.setFont(new Font("sansserif", 1, 20));
        cost.setForeground(new Color(7, 164, 121));
        costPanel.add(cost);
        txtCost = new JLabel();
        txtCost.setFont(new Font("sansserif", 1, 20));
        billDetails = BillDetailDAO.getInstance().selectAll();
        updateCost(billDetails);
        txtCost.setForeground(new Color(228, 7, 7));
        costPanel.add(txtCost);
        feature.add(costPanel);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Receipt">
        
        JLabel id = new JLabel("Mã hóa đơn");
        id.setFont(new Font("sansserif", 1, 14));
        id.setForeground(new Color(100, 100, 100));
        receipt.add(id);
        JTextField txtId = new JTextField();
        txtId.setFont(new Font("sansserif", 1, 14));
        txtId.setForeground(new Color(100, 100, 100));
        txtId.setBackground(new Color(255, 255, 255));
        txtId.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        txtId.setText(bill.getId());
        txtId.setEditable(false);
        receipt.add(txtId, "w 60%,wrap");

        JLabel CustomerName = new JLabel("Tên khách hàng");
        CustomerName.setFont(new Font("sansserif", 1, 14));
        CustomerName.setForeground(new Color(100, 100, 100));
        receipt.add(CustomerName);
        JTextField txtIdObject = new JTextField();
        txtIdObject.setFont(new Font("sansserif", 1, 14));
        txtIdObject.setForeground(new Color(100, 100, 100));
        txtIdObject.setBackground(new Color(255, 255, 255));
        txtIdObject.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        txtIdObject.setText(CustomerDAO.getInstance().selectById(bill.getIdCustomer()).getName());
        txtIdObject.setEditable(false);
        receipt.add(txtIdObject, "w 60%,wrap");

        JLabel StaffName = new JLabel("Tên nhân viên");
        StaffName.setFont(new Font("sansserif", 1, 14));
        StaffName.setForeground(new Color(100, 100, 100));
        receipt.add(StaffName);
        JTextField txtStaffName = new JTextField();
        txtStaffName.setFont(new Font("sansserif", 1, 14));
        txtStaffName.setForeground(new Color(100, 100, 100));
        txtStaffName.setBackground(new Color(255, 255, 255));
        txtStaffName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        txtStaffName.setText(StaffDAO.getInstance().selectById(bill.getIdStaff()).getName());
        txtStaffName.setEditable(false);
        receipt.add(txtStaffName, "w 60%,wrap");

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table">
        String[] columnNames = {"Mã sản phẩm", "Số lượng", "Đơn giá"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);

        try {
            model.setRowCount(0);
            for (BillDetail billDetail : billDetails) {
                if(billDetail.getIdBill().equals(bill.getId())){
                    products = ObjectDAO.getInstance().selectById(billDetail.getIdObject());
                    model.addRow(new Object[]{
                            billDetail.getIdObject(),
                            billDetail.getCount(),
                            products.getUnitPrice()
                    });
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        billDetail = new JTable(model);
        scrollPane = new JScrollPane(billDetail);

        billDetail.setForeground(new Color(100, 100, 100));
        billDetail.setFont(new Font("sansserif", 1, fontSize));
        billDetail.setRowHeight(30);
        billDetail.setFillsViewportHeight(true);
        billDetail.setBackground(new Color(255, 255, 255));
        billDetail.getTableHeader().setBackground(new Color(255, 255, 255));
        billDetail.getTableHeader().setForeground(new Color(100, 100, 100));
        billDetail.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) billDetail.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        billDetail.getTableHeader().setDefaultRenderer(renderer);

        scrollPane.setViewportView(billDetail);
        detail.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        main.add(receipt, "width 100%, height 20%, wrap");
        main.add(detail, "width 100%, height 90%, wrap");
        main.add(feature, "width 100%, height 5%");

        btnAdd.addActionListener(e -> {
            String idObject = JOptionPane.showInputDialog("Nhập mã sản phẩm");
            String count = JOptionPane.showInputDialog("Nhập số lượng");
            BillDetail billDetail1 = new BillDetail(Integer.parseInt(count), idObject, bill.getId());
            if(BillDetailDAO.getInstance().insert(billDetail1) == 1){
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                updateTable();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
            }
        });

        btnEdit.addActionListener(e -> {
            int row = billDetail.getSelectedRow();
            String idObject = billDetail.getValueAt(row, 0).toString();
            String count = billDetail.getValueAt(row, 1).toString();
            BillDetail billDetail1 = new BillDetail(Integer.parseInt(count), idObject, bill.getId());
            if(BillDetailDAO.getInstance().update(billDetail1) == 1){
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                updateTable();
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại");
            }
        });

        btnDel.addActionListener(e -> {
            int row = billDetail.getSelectedRow();
            String idObject = billDetail.getValueAt(row, 0).toString();
            String count = billDetail.getValueAt(row, 1).toString();
            BillDetail billDetail1 = new BillDetail(Integer.parseInt(count), idObject, bill.getId());
            if(BillDetailDAO.getInstance().delete(billDetail1) == 1){
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                updateTable();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        });
        //<editor-fold defaultstate="collapsed" desc="Event">
    }

    private void updateTable(){
        billDetails = BillDetailDAO.getInstance().selectAll();
        DefaultTableModel model = (DefaultTableModel) billDetail.getModel();

        try {
            model.setRowCount(0);
            for (BillDetail billDetail : billDetails) {
                if(billDetail.getIdBill().equals(bill.getId())){
                    products = ObjectDAO.getInstance().selectById(billDetail.getIdObject());
                    model.addRow(new Object[]{
                            billDetail.getIdObject(),
                            billDetail.getCount(),
                            products.getUnitPrice()
                    });
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        updateCost(billDetails);
    }

    public void updateCost(ArrayList<BillDetail> billDetails){
        billCost = 0;
        for (BillDetail billDetail : billDetails) {
            if(billDetail.getIdBill().equals(bill.getId())){
                billCost += billDetail.getCount() * ObjectDAO.getInstance().
                        selectById(billDetail.getIdObject()).getUnitPrice();
            }
        }

        txtCost.setText(billCost + " VNĐ");
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
