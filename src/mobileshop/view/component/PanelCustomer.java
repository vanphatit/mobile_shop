package mobileshop.view.component;

import mobileshop.controller.CustomerController;
import mobileshop.dao.CustomerDAO;
import mobileshop.model.Customer;
import mobileshop.view.UI.AddCustomer;
import mobileshop.view.UI.EditCustomer;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Frame.HAND_CURSOR;

public class PanelCustomer extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel fsPanel;
    private JPanel mainPanel;
    private JTable customer;
    private JScrollPane scrollPane;
    private JPanel feature;
    private JPanel search;
    private JLabel title1;
    private JLabel title2;
    private JMenuBar featureMenu;
    private mobileshop.view.UI.AddCustomer addCustomer;
    private mobileshop.view.UI.EditCustomer editCustomer;

    private ArrayList<Customer> Customers;

    public PanelCustomer() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {
        mainPanel = new JPanel();
        fsPanel = new JPanel();
        feature = new JPanel();
        search = new JPanel();
        
        feature.setLayout(new MigLayout("wrap"));
        feature.setBackground(new Color(255,255,255));
        search.setLayout(new MigLayout("wrap 3", "[grow]10[grow]10[grow]", "[center]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap"));
        mainPanel.setBackground(new Color(255,255,255));
        fsPanel.setLayout(new MigLayout("wrap", "[Left]"));
        fsPanel.setBackground(new Color(255,255,255));
        
        title1 = new JLabel("Chức năng: ");
        title1.setFont(new Font("sansserif", 1, 14));
        title1.setForeground(new Color(0, 0, 0));
        feature.add(title1);
        
        featureMenu = new JMenuBar();
        feature.add(featureMenu);
        
        featureMenu.setBorder(new LineBorder(new Color(0,0,0)));

        //<editor-fold defaultstate="collapsed" desc="Menu">
        JButton btnAdd = new JButton();
        btnAdd.setFont(new Font("sansserif", 1, 14));
        btnAdd.setForeground(new Color(0, 0, 0));
        btnAdd.setBackground(new Color(255, 255, 255));
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnAdd.setText("Thêm");
        btnAdd.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_40px.png")));
        btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnAdd);
        
        JButton btnDel = new JButton();
        btnDel.setFont(new Font("sansserif", 1, 14));
        btnDel.setForeground(new Color(0, 0, 0));
        btnDel.setBackground(new Color(255, 255, 255));
        btnDel.setBorderPainted(false);
        btnDel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnDel.setText("Xóa");
        btnDel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_delete_40px.png")));
        btnDel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDel.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnDel);
        
        JButton btnEdit = new JButton();
        btnEdit.setFont(new Font("sansserif", 1, 14));
        btnEdit.setForeground(new Color(0, 0, 0));
        btnEdit.setBackground(new Color(255, 255, 255));
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnEdit.setText("Sửa");
        btnEdit.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_edit_40px.png")));
        btnEdit.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEdit.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnEdit);
        
        JButton btnImportExcel = new JButton();
        btnImportExcel.setFont(new Font("sansserif", 1, 14));
        btnImportExcel.setForeground(new Color(0, 0, 0));
        btnImportExcel.setBackground(new Color(255, 255, 255));
        btnImportExcel.setBorderPainted(false);
        btnImportExcel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnImportExcel.setText("Nhập Excel");
        btnImportExcel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_spreadsheet_file_40px.png")));
        btnImportExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnImportExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnImportExcel.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnImportExcel);
        
        JButton btnExportExcel = new JButton();
        btnExportExcel.setFont(new Font("sansserif", 1, 14));
        btnExportExcel.setForeground(new Color(0, 0, 0));
        btnExportExcel.setBackground(new Color(255, 255, 255));
        btnExportExcel.setBorderPainted(false);
        btnExportExcel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnExportExcel.setText("Xuất Excel");
        btnExportExcel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_xls_40px.png")));
        btnExportExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnExportExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnExportExcel.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnExportExcel);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Search">
        title2 = new JLabel("Tìm kiếm: ");
        title2.setFont(new Font("sansserif", 1, 14));
        title2.setForeground(new Color(0, 0, 0));
        search.add(title2, "span 3, align left, wrap");
        
        JComboBox area = new JComboBox();
        area.setFont(new Font("sansserif", 1, 14));
        area.setForeground(new Color(0, 0, 0));
        area.setBackground(new Color(255, 255, 255));
        area.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        area.addItem("Tất cả");
        area.setBorder(null);
        search.add(area, "w 30%, h 35%");
        
        MyTextField text = new MyTextField();
        text.setFont(new Font("sansserif", 1, 14));
        text.setForeground(new Color(0, 0, 0));
        text.setBackground(new Color(255, 255, 255));
        text.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        text.setBorder(new LineBorder(new Color(0, 0, 0)));
        search.add(text, "w 40%, h 35%");
        
        JButton btnReload = new JButton();
        btnReload.setFont(new Font("sansserif", 1, 14));
        btnReload.setForeground(new Color(0, 0, 0));
        btnReload.setBackground(new Color(255, 255, 255));
        btnReload.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnReload.setText("Làm mới");
        btnReload.setBorder(new LineBorder(new Color(0,0,0)));
        btnReload.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_reset_25px_1.png")));
        btnReload.setMargin(new Insets(10,20,10,20));
        search.add(btnReload, "w 30%, h 35%");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table">
        String[] columnNames = {"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Giới tính", "Ngày sinh", "Số điện thoại", "Mã loại khách hàng"};
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames);

        Customers = CustomerDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (Customer customer : Customers) {
                model.addRow(new java.lang.Object[]{
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getGender() ? "Nam" : "Nữ",
                        customer.getBirthday(),
                        customer.getPhone(),
                        customer.getIdCategory()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        customer = new JTable(model);
        scrollPane = new JScrollPane(customer);
        scrollPane.setViewportView(customer);
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setForeground(new Color(100, 100, 100));
        scrollPane.setFont(new Font("sansserif", 1, fontSize));
        customer.setForeground(new Color(100, 100, 100));
        customer.setFont(new Font("sansserif", 1, fontSize));
        mainPanel.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        add(fsPanel, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 80%, wrap");
        fsPanel.add(feature, "width 50%, pos 0al 0 n 100%");
        fsPanel.add(search, "width 48%, pos 1al 0 n 100%");

        //<editor-fold defaultstate="collapsed" desc="Event">
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer = new AddCustomer();
                addCustomer.show();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = customer.getSelectedRow();
                if(row == -1) {
                    return;
                }
                String id = customer.getValueAt(row, 0).toString();
                editCustomer = new EditCustomer(id);
                editCustomer.show();
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = customer.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần xóa!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String id = (String) customer.getValueAt(row, 0);
                    if(CustomerController.getInstance().delCustomer(id)) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        Customers = CustomerDAO.getInstance().selectAll();
                        model.setRowCount(0);
                        for (Customer customer : Customers) {
                            model.addRow(new java.lang.Object[]{
                                    customer.getId(),
                                    customer.getName(),
                                    customer.getAddress(),
                                    customer.getGender() ? "Nam" : "Nữ",
                                    customer.getBirthday(),
                                    customer.getPhone(),
                                    customer.getIdCategory()
                            });
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customers = CustomerDAO.getInstance().selectAll();
                model.setRowCount(0);
                for (Customer customer : Customers) {
                    model.addRow(new java.lang.Object[]{
                            customer.getId(),
                            customer.getName(),
                            customer.getAddress(),
                            customer.getGender() ? "Nam" : "Nữ",
                            customer.getBirthday(),
                            customer.getPhone(),
                            customer.getIdCategory()
                    });
                }
            }
        });
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
