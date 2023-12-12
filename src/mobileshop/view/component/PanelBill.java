package mobileshop.view.component;

import mobileshop.controller.BillController;
import mobileshop.controller.ReceiptNoteController;
import mobileshop.dao.*;
import mobileshop.model.*;
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
import java.awt.event.*;
import java.lang.Object;
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
    private JPanel fsPanel;
    private JPanel addBill;
    private ArrayList<Customer> customers;
    private ArrayList<Staff> staffs;
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
        fsPanel = new JPanel();
        addBill = new JPanel();

        fsPanel.setLayout(new MigLayout("fill, wrap", "[300][1000]", "[50]"));
        fsPanel.setBackground(new Color(255,255,255));
        feature.setLayout(new MigLayout("fill, wrap", "[100][100][100]", "[50]"));
        feature.setBackground(new Color(255,255,255));
        search.setLayout(new MigLayout("fill, wrap", "[200][300][150]", "[50]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap", "[1000]", "[1000]"));
        mainPanel.setBackground(new Color(255,255,255));
        search.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        feature.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        addBill.setLayout(new MigLayout("fill, wrap", "30[33.33%][33.33%][33.33%]30", "10[33.33%][33.33%]10"));
        addBill.setBackground(new Color(255,255,255));
        addBill.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thông tin phiếu nhập", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));

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
        feature.add(btnAdd, "grow");

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
        feature.add(btnDel, "grow");

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
        feature.add(btnEdit, "grow");

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Search">

        JComboBox area = new JComboBox();
        area.setFont(new Font("sansserif", 1, 14));
        area.setForeground(new Color(0, 0, 0));
        area.setBackground(new Color(255, 255, 255));
        area.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        area.addItem("Tất cả");
        area.addItem("Mã phiếu nhập");
        area.addItem("Ngày nhập");
        area.addItem("Chi tiết");
        area.addItem("Mã nhà cung cấp");
        area.addItem("Mã nhân viên");
        area.setBorder(null);
        search.add(area, "grow");

        MyTextField text = new MyTextField();
        text.setFont(new Font("sansserif", 1, 14));
        text.setForeground(new Color(0, 0, 0));
        text.setBackground(new Color(255, 255, 255));
        text.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        text.setBorder(new LineBorder(new Color(0, 0, 0)));
        search.add(text, "grow");

        JButton btnReload = new JButton();
        btnReload.setFont(new Font("sansserif", 1, 14));
        btnReload.setForeground(new Color(0, 0, 0));
        btnReload.setBackground(new Color(255, 255, 255));
        btnReload.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnReload.setText("Làm mới");
        btnReload.setBorder(new LineBorder(new Color(0,0,0)));
        btnReload.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_reset_25px_1.png")));
        btnReload.setMargin(new Insets(10,20,10,20));
        search.add(btnReload, "grow");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table">
        String[] columnNames = {"Mã bill", "Ngày tạo bill", "Trạng thái", "Mã khách hàng", "Mã nhân viên"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

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

        //<editor-fold defaultstate="collapsed" desc="Add Bill">
        JPanel id = new JPanel();
        id.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        id.setBackground(new Color(255,255,255));
        id.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã bill", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField idText = new JTextField();
        idText.setFont(new Font("sansserif", 1, 14));
        idText.setForeground(new Color(0, 0, 0));
        idText.setBackground(new Color(255, 255, 255));
        idText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idText.setBorder(null);
        id.add(idText, "grow");
        addBill.add(id, "grow");

        JPanel date = new JPanel();
        date.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        date.setBackground(new Color(255,255,255));
        date.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ngày xuất (dd/MM/yyyy)", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField dateText = new JFormattedTextField(format);
        dateText.setFont(new Font("sansserif", 1, 14));
        dateText.setForeground(new Color(0, 0, 0));
        dateText.setBackground(new Color(255, 255, 255));
        dateText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        dateText.setBorder(null);
        date.add(dateText, "grow");
        addBill.add(date, "grow");

        dateText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập theo định dạng: dd/MM/yyyy");
                    e.consume();
                }
            }
        });

        JPanel status = new JPanel();
        status.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        status.setBackground(new Color(255,255,255));
        status.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Trạng thái", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JComboBox statusText = new JComboBox();
        statusText.setFont(new Font("sansserif", 1, 14));
        statusText.setForeground(new Color(0, 0, 0));
        statusText.setBackground(new Color(255, 255, 255));
        statusText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        statusText.setBorder(null);
        statusText.addItem("Đã thanh toán");
        statusText.addItem("Chưa thanh toán");
        status.add(statusText, "grow");
        addBill.add(status, "grow");

        JPanel idCustomer = new JPanel();
        idCustomer.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        idCustomer.setBackground(new Color(255,255,255));
        idCustomer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã khách hàng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JComboBox idCustomerText = new JComboBox();
        idCustomerText.setFont(new Font("sansserif", 1, 14));
        idCustomerText.setForeground(new Color(0, 0, 0));
        idCustomerText.setBackground(new Color(255, 255, 255));
        idCustomerText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idCustomerText.setBorder(null);
        customers = CustomerDAO.getInstance().selectAll();
        for (Customer customer : customers) {
            idCustomerText.addItem(customer.getId());
        }
        idCustomer.add(idCustomerText, "grow");
        addBill.add(idCustomer, "grow");

        JPanel idStaff = new JPanel();
        idStaff.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        idStaff.setBackground(new Color(255,255,255));
        idStaff.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã nhân viên", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JComboBox idStaffText = new JComboBox();
        idStaffText.setFont(new Font("sansserif", 1, 14));
        idStaffText.setForeground(new Color(0, 0, 0));
        idStaffText.setBackground(new Color(255, 255, 255));
        idStaffText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idStaffText.setBorder(null);
        staffs = StaffDAO.getInstance().selectAll();
        for (Staff staff : staffs) {
            idStaffText.addItem(staff.getId());
        }
        idStaff.add(idStaffText, "grow");
        addBill.add(idStaff, "grow");

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        btnPanel.setBackground(new Color(255,255,255));
        JButton btnDetail = new JButton();
        btnDetail.setFont(new Font("sansserif", 1, 16));
        btnDetail.setForeground(new Color(255, 255, 255));
        btnDetail.setBackground(new Color(7, 164, 121));
        btnDetail.setBorderPainted(false);
        btnDetail.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnDetail.setText("Xem chi tiết");
        btnPanel.add(btnDetail, "grow");
        addBill.add(btnPanel, "grow");
        //</editor-fold>

        add(fsPanel, "width 100%, height 5%, wrap");
        add(addBill, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 75%, wrap");
        fsPanel.add(feature, "width 40%, pos 0al 0 n 100%");
        fsPanel.add(search, "width 58%, pos 1al 0 n 100%");

        //<editor-fold defaultstate="collapsed" desc="Event">
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = bill.getSelectedRow();
                if(row == -1) {
                    return;
                }
                idText.setText(bill.getValueAt(row, 0).toString());
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                dateText.setText(format.format(bill.getValueAt(row, 1)));
                statusText.setSelectedItem(bill.getValueAt(row, 2));
                idCustomerText.setSelectedItem(bill.getValueAt(row, 3));
                idStaffText.setSelectedItem(bill.getValueAt(row, 4));
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText().toString();
                    java.util.Date invoiceDate = format.parse(dateText.getText());
                    java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
                    String status = statusText.getSelectedItem().toString();
                    String idCustomer = idCustomerText.getSelectedItem().toString();
                    String idStaff = idStaffText.getSelectedItem().toString();
                    if(BillController.getInstance().addBill(new Bill(id, sqlDate, status, idCustomer, idStaff))){
                    }
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                reloadTable();
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bill.getSelectedRow() >= 0) {
                    int row = bill.getSelectedRow();
                    if(row == -1) {
                        return;
                    }
                    String id = bill.getValueAt(row, 0).toString();
                    for (mobileshop.model.BillDetail billDetail : BillDetailDAO.getInstance().selectAll()) {
                        if (billDetail.getIdBill().equals(id)) {
                            BillDetailDAO.getInstance().delete(billDetail);
                            JOptionPane.showMessageDialog(null, "Đã xóa chi tiết bill!",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    if(BillController.getInstance().deleteBillById(id)){
                        reloadTable();
                    }
                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText().toString();
                    java.util.Date invoiceDate = format.parse(dateText.getText());
                    java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
                    String status = statusText.getSelectedItem().toString();
                    String idCustomer = idCustomerText.getSelectedItem().toString();
                    String idStaff = idStaffText.getSelectedItem().toString();
                    if(BillController.getInstance().updateBill(id, sqlDate, status, idCustomer, idStaff)){
                    }
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                reloadTable();
            };
        });

        btnDetail.addActionListener(e -> {
            if (bill.getSelectedRow() >= 0) {
                int row = bill.getSelectedRow();
                if(row == -1) {
                    return;
                }
                String idBill = (String) bill.getValueAt(row, 0);
                billDetail = new BillDetail(idBill);
                billDetail.setVisible(true);
            }
        });

        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadTable();
            }
        });

        area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bills = BillDAO.getInstance().selectAll();
                String comBoBox = area.getSelectedItem().toString();
                String textSearch = text.getText();
                Boolean check = false;
                if (comBoBox.equals("Tất cả")) {
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
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (comBoBox.equals("Mã phiếu nhập")) {
                    try {
                        model.setRowCount(0);
                        for (Bill bill : bills) {
                            if (bill.getId().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        bill.getId(),
                                        bill.getDate(),
                                        bill.getStatus(),
                                        bill.getIdCustomer(),
                                        bill.getIdStaff()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (comBoBox.equals("Ngày nhập")) {
                    try {
                        model.setRowCount(0);
                        for (Bill bill : bills) {
                            if (bill.getDate().toString().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        bill.getId(),
                                        bill.getDate(),
                                        bill.getStatus(),
                                        bill.getIdCustomer(),
                                        bill.getIdStaff()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (comBoBox.equals("Chi tiết")) {
                    try {
                        model.setRowCount(0);
                        for (Bill bill : bills) {
                            if (bill.getStatus().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        bill.getId(),
                                        bill.getDate(),
                                        bill.getStatus(),
                                        bill.getIdCustomer(),
                                        bill.getIdStaff()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (comBoBox.equals("Mã nhà cung cấp")) {
                    try {
                        model.setRowCount(0);
                        for (Bill bill : bills) {
                            if (bill.getIdCustomer().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        bill.getId(),
                                        bill.getDate(),
                                        bill.getStatus(),
                                        bill.getIdCustomer(),
                                        bill.getIdStaff()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (comBoBox.equals("Mã nhân viên")) {
                    try {
                        model.setRowCount(0);
                        for (Bill bill : bills) {
                            if (bill.getIdStaff().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        bill.getId(),
                                        bill.getDate(),
                                        bill.getStatus(),
                                        bill.getIdCustomer(),
                                        bill.getIdStaff()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy!",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        //</editor-fold>

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
