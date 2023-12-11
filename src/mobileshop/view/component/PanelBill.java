package mobileshop.view.component;

import mobileshop.controller.BillController;
import mobileshop.controller.ReceiptNoteController;
import mobileshop.dao.BillDAO;
import mobileshop.dao.ReceiptNoteDAO;
import mobileshop.model.Bill;
import mobileshop.model.ReceiptNote;
import mobileshop.view.UI.AddBill;
import mobileshop.view.UI.BillDetail;
import mobileshop.view.UI.ReceiptNoteDetail;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static java.awt.Frame.HAND_CURSOR;

public class PanelBill extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel mainPanel;
    private JTable bill;
    private JScrollPane scrollPane;
    private JPanel feature;
    private JPanel search;
    private BillDetail billDetail;

    private ArrayList<Bill> bills;

    public PanelBill() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap", "[grow]", "[grow]10[grow]10[grow]");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {
        mainPanel = new JPanel();
        feature = new JPanel();
        search = new JPanel();

        feature.setLayout(new MigLayout("wrap", "push[]10[]10[]10[]push"));
        feature.setBackground(new Color(255,255,255));
        search.setLayout(new MigLayout("wrap 3", "[grow]10[grow]10[grow]", "[center]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap"));
        mainPanel.setBackground(new Color(255,255,255));

        //<editor-fold defaultstate="collapsed" desc="Menu">
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

        JButton btnDetail = new JButton();
        btnDetail.setFont(new Font("sansserif", 1, 14));
        btnDetail.setForeground(new Color(100, 100, 100));
        btnDetail.setBackground(new Color(255, 255, 255));
        btnDetail.setBorderPainted(false);
        btnDetail.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnDetail.setText("Xem");
        btnDetail.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-information-25.png")));
        btnDetail.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDetail.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDetail.setHorizontalAlignment(SwingConstants.LEFT);
        feature.add(btnDetail);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Search">

        search.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        JComboBox area = new JComboBox();
        area.setFont(new Font("sansserif", 1, 14));
        area.setForeground(new Color(0, 0, 0));
        area.setBackground(new Color(255, 255, 255));
        area.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        area.addItem("Mã bill");
        area.addItem("Trạng thái");
        area.addItem("Ngày");
        area.addItem("Mã nhân viên");
        area.addItem("Mã khách hàng");
        area.setBorder(null);
        search.add(area, "w 30%, h 100%");
        
        MyTextField txtSearch = new MyTextField();
        txtSearch.setFont(new Font("sansserif", 1, 14));
        txtSearch.setForeground(new Color(0, 0, 0));
        txtSearch.setBackground(new Color(255, 255, 255));
        txtSearch.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        txtSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
        search.add(txtSearch, "w 40%, h 100%");
        
        JButton btnReload = new JButton();
        btnReload.setFont(new Font("sansserif", 1, 14));
        btnReload.setForeground(new Color(0, 0, 0));
        btnReload.setBackground(new Color(255, 255, 255));
        btnReload.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnReload.setText("Làm mới");
        btnReload.setBorder(new LineBorder(new Color(0,0,0)));
        btnReload.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_reset_25px_1.png")));
        btnReload.setMargin(new Insets(10,20,10,20));
        search.add(btnReload, "w 30%, h 100%");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table">
        String[] columnNames = {"Mã bill", "Ngày tạo bill", "Trạng thái", "Mã khách hàng", "Mã nhân viên"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);

        bills = BillDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (Bill bill : bills) {
                model.addRow(new Object[]{
                        bill.getId(),
                        bill.getDate(),
                        bill.getStatus(),
                        bill.getIdCustomer(),
                        bill.getIdStaff()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        bill = new JTable(model);
        scrollPane = new JScrollPane(bill);
        bill.setForeground(new Color(100, 100, 100));
        bill.setFont(new Font("sansserif", 1, fontSize));
        bill.setRowHeight(30);
        bill.setFillsViewportHeight(true);
        bill.setBackground(new Color(255, 255, 255));
        bill.getTableHeader().setBackground(new Color(255, 255, 255));
        bill.getTableHeader().setForeground(new Color(100, 100, 100));
        bill.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) bill.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        bill.getTableHeader().setDefaultRenderer(renderer);

        scrollPane.setViewportView(bill);
        mainPanel.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        add(search, "width 100%, height 5%, wrap");
        add(mainPanel, "width 100%, height 85%, wrap");
        add(feature, "width 100%, height 20%, top");

        btnAdd.addActionListener(e -> {
            AddBill addBill = new AddBill();
            addBill.setVisible(true);
            addBill.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                    reloadTable();
                }
            });
        });

        btnEdit.addActionListener(e -> {
            if (bill.getSelectedRow() >= 0) {
                int row = bill.getSelectedRow();
                if(row == -1) {
                    return;
                }
                String id = (String) bill.getValueAt(row, 0);

                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date invoiceDate = null;
                try {
                    invoiceDate = formatDate.parse(bill.getValueAt(row, 1).toString());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                java.sql.Date date = new java.sql.Date(invoiceDate.getTime());
                String status = (String) bill.getValueAt(row, 2);
                String idCustomer = (String) bill.getValueAt(row, 3);
                String idStaff = (String) bill.getValueAt(row, 4);
                if(BillController.getInstance().updateBill(id, date, status, idCustomer, idStaff)){
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    reloadTable();
                }
            }
        });

        btnDel.addActionListener(e -> {
            if (bill.getSelectedRow() >= 0) {
                int row = bill.getSelectedRow();
                if(row == -1) {
                    return;
                }
                String id = (String) bill.getValueAt(row, 0);
                if(BillController.getInstance().deleteBill(id)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    reloadTable();
                }
            }
        });

        btnDetail.addActionListener(e -> {
            if (bill.getSelectedRow() >= 0) {
                int row = bill.getSelectedRow();
                if(row == -1) {
                    return;
                }
                String id = (String) bill.getValueAt(row, 0);
                billDetail = new BillDetail(id);
                billDetail.setVisible(true);
            }
        });
        area.addActionListener(e -> {
            String selected = (String) area.getSelectedItem();
            Boolean check = false;
            if(selected.equals("Mã bill")) {
                model.setRowCount(0);
                for (Bill bill : bills) {
                    if(bill.getId().contains(txtSearch.getText())) {
                        check = true;
                        model.addRow(new Object[]{
                                bill.getId(),
                                bill.getDate(),
                                bill.getStatus(),
                                bill.getIdCustomer(),
                                bill.getIdStaff()
                        });
                    }
                }
                if(!check) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
            } else if(selected.equals("Trạng thái")) {
                model.setRowCount(0);
                for (Bill bill : bills) {
                    if(bill.getStatus().contains(txtSearch.getText())) {
                        check = true;
                        model.addRow(new Object[]{
                                bill.getId(),
                                bill.getDate(),
                                bill.getStatus(),
                                bill.getIdCustomer(),
                                bill.getIdStaff()
                        });
                    }
                }
                if(!check) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
            } else if(selected.equals("Ngày")) {
                model.setRowCount(0);
                for (Bill bill : bills) {
                    if(bill.getDate().toString().contains(txtSearch.getText())) {
                        check = true;
                        model.addRow(new Object[]{
                                bill.getId(),
                                bill.getDate(),
                                bill.getStatus(),
                                bill.getIdCustomer(),
                                bill.getIdStaff()
                        });
                    }
                }
                if(!check) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
            } else if(selected.equals("Mã nhân viên")) {
                model.setRowCount(0);
                for (Bill bill : bills) {
                    if(bill.getIdStaff().contains(txtSearch.getText())) {
                        check = true;
                        model.addRow(new Object[]{
                                bill.getId(),
                                bill.getDate(),
                                bill.getStatus(),
                                bill.getIdCustomer(),
                                bill.getIdStaff()
                        });
                    }
                }
                if(!check) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
            } else if(selected.equals("Mã khách hàng")) {
                model.setRowCount(0);
                for (Bill bill : bills) {
                    if (bill.getIdCustomer().contains(txtSearch.getText())) {
                        check = true;
                        model.addRow(new Object[]{
                                bill.getId(),
                                bill.getDate(),
                                bill.getStatus(),
                                bill.getIdCustomer(),
                                bill.getIdStaff()
                        });
                    }
                }
                if (!check) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
            } else {
                model.setRowCount(0);
                for (Bill bill : bills) {
                    model.addRow(new Object[]{
                            bill.getId(),
                            bill.getDate(),
                            bill.getStatus(),
                            bill.getIdCustomer(),
                            bill.getIdStaff()
                    });
                }
            }
        });
    }

    public void reloadTable(){
        bills = BillDAO.getInstance().selectAll();
        DefaultTableModel model = (DefaultTableModel) bill.getModel();
        model.setRowCount(0);
        for (Bill bill : bills) {
            model.addRow(new Object[]{
                    bill.getId(),
                    bill.getDate(),
                    bill.getStatus(),
                    bill.getIdCustomer(),
                    bill.getIdStaff()
            });
        }
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
