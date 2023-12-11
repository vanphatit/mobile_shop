package mobileshop.view.component;

import java.awt.*;

import static java.awt.Frame.HAND_CURSOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import mobileshop.controller.StaffController;
import mobileshop.controller.SuplierController;
import mobileshop.dao.StaffDAO;
import mobileshop.dao.SuplierDAO;
import mobileshop.model.Staff;
import mobileshop.model.Suplier;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

public class PanelSuplier extends javax.swing.JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel fsPanel;
    private JPanel mainPanel;
    private JTable suplier;
    private JScrollPane scrollPane;
    private JPanel search;
    private JPanel featureMenu;
    private JPanel addSuplier;
    private ArrayList<Suplier> supliers;
    
    public PanelSuplier() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("fill, wrap", "[grow]", "[grow][grow][grow]");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {
        mainPanel = new JPanel();
        fsPanel = new JPanel();
        search = new JPanel();
        featureMenu = new JPanel();
        addSuplier = new JPanel();

        search.setLayout(new MigLayout("fill, wrap", "[200][300][150]", "[75]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap", "[1000]", "[1000]"));
        mainPanel.setBackground(new Color(255,255,255));
        fsPanel.setLayout(new MigLayout("fill, wrap", "[300][1000]", "[75]"));
        fsPanel.setBackground(new Color(255,255,255));
        addSuplier.setLayout(new MigLayout("fill, wrap", "30[33.33%][33.33%][33.33%]30", "10[33.33%][33.33%]10"));
        addSuplier.setBackground(new Color(255,255,255));
        addSuplier.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thông tin nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));

        //<editor-fold defaultstate="collapsed" desc="Menu">
        featureMenu.setLayout(new MigLayout("fill, wrap", "[100][100][100]", "[75]"));
        featureMenu.setBackground(new Color(255,255,255));
        featureMenu.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));

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
        featureMenu.add(btnAdd, "grow");

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
        featureMenu.add(btnDel, "grow");

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
        featureMenu.add(btnEdit, "grow");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Search">
        search.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));

        JComboBox area = new JComboBox();
        area.setFont(new Font("sansserif", 1, 14));
        area.setForeground(new Color(0, 0, 0));
        area.setBackground(new Color(255, 255, 255));
        area.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        area.addItem("Tất cả");
        area.addItem("Mã nhà cung cấp");
        area.addItem("Tên nhà cung cấp");
        area.addItem("Trạng thái");
        area.setBorder(null);
        search.add(area,"grow");

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
        String[] columnNames = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        supliers = SuplierDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (Suplier suplier : supliers) {
                model.addRow(new java.lang.Object[]{
                        suplier.getId(),
                        suplier.getName(),
                        suplier.getAddress(),
                        suplier.getPhoneNumber(),
                        suplier.getStatus() ? "Còn hàng" : "Hết hàng"
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        suplier = new JTable(model);
        scrollPane = new JScrollPane(suplier);
        scrollPane.setViewportView(suplier);

        suplier.setForeground(new Color(100, 100, 100));
        suplier.setFont(new Font("sansserif", 1, fontSize));
        suplier.setRowHeight(30);
        suplier.setFillsViewportHeight(true);
        suplier.setBackground(new Color(255, 255, 255));
        suplier.getTableHeader().setBackground(new Color(255, 255, 255));
        suplier.getTableHeader().setForeground(new Color(100, 100, 100));
        suplier.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) suplier.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        suplier.getTableHeader().setDefaultRenderer(renderer);
        suplier.getTableHeader().setReorderingAllowed(false);
        suplier.getTableHeader().setResizingAllowed(false);
        mainPanel.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Add suplier">
        JPanel id = new JPanel();
        id.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        id.setBackground(new Color(255,255,255));
        id.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField idText = new JTextField();
        idText.setFont(new Font("sansserif", 1, 14));
        idText.setForeground(new Color(0, 0, 0));
        idText.setBackground(new Color(255, 255, 255));
        idText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idText.setBorder(null);
        id.add(idText, "grow");
        addSuplier.add(id, "grow");

        JPanel name = new JPanel();
        name.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        name.setBackground(new Color(255,255,255));
        name.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tên nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField nameText = new JTextField();
        nameText.setFont(new Font("sansserif", 1, 14));
        nameText.setForeground(new Color(0, 0, 0));
        nameText.setBackground(new Color(255, 255, 255));
        nameText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        nameText.setBorder(null);
        name.add(nameText, "grow");
        addSuplier.add(name, "grow");

        JPanel address = new JPanel();
        address.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        address.setBackground(new Color(255,255,255));
        address.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Địa chỉ", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField addressText = new JTextField();
        addressText.setFont(new Font("sansserif", 1, 14));
        addressText.setForeground(new Color(0, 0, 0));
        addressText.setBackground(new Color(255, 255, 255));
        addressText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        addressText.setBorder(null);
        address.add(addressText, "grow");
        addSuplier.add(address, "grow");

        JPanel phone = new JPanel();
        phone.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        phone.setBackground(new Color(255,255,255));
        phone.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Số điện thoại", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField phoneText = new JTextField();
        phoneText.setFont(new Font("sansserif", 1, 14));
        phoneText.setForeground(new Color(0, 0, 0));
        phoneText.setBackground(new Color(255, 255, 255));
        phoneText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        phoneText.setBorder(null);
        phone.add(phoneText, "grow");
        addSuplier.add(phone, "grow");

        JPanel statusJP = new JPanel();
        statusJP.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        statusJP.setBackground(new Color(255,255,255));
        statusJP.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Trạng thái", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JComboBox status = new JComboBox();
        status.setFont(new Font("sansserif", 1, 14));
        status.setForeground(new Color(0, 0, 0));
        status.setBackground(new Color(255, 255, 255));
        status.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        status.addItem("Còn hoạt động");
        status.addItem("Hết hoạt động");
        status.setBorder(null);
        statusJP.add(status, "grow");
        addSuplier.add(statusJP,"grow");

        //</editor-fold>

        add(fsPanel, "width 100%, height 20%, wrap");
        add(addSuplier, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 60%, wrap");
        fsPanel.add(featureMenu, "width 30%, pos 0al 0 n 100%");
        fsPanel.add(search, "width 68%, pos 1al 0 n 100%");

        //<editor-fold defaultstate="collapsed" desc="Event">
        suplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = suplier.getSelectedRow();
                if(row == -1) {
                    return;
                }
                idText.setText(suplier.getValueAt(row, 0).toString());
                nameText.setText(suplier.getValueAt(row, 1).toString());
                addressText.setText(suplier.getValueAt(row, 2).toString());
                phoneText.setText(suplier.getValueAt(row, 3).toString());
                status.setSelectedItem(suplier.getValueAt(row, 4).toString());
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText();
                    String name = nameText.getText();
                    String address = addressText.getText();
                    String phone = phoneText.getText();
                    Boolean statusB = status.getSelectedItem().toString().equals("Còn hoạt động") ? true : false;

                    if((SuplierController.getInstance().addSuplier(id, name, address, phone, statusB))) {
                    }
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                }
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(suplier.getSelectedRow() >= 0) {
                    int row = suplier.getSelectedRow();
                    if(row == -1) {
                        return;
                    }
                    String id = suplier.getValueAt(row, 0).toString();
                    if(SuplierController.getInstance().deleteSuplierById(id)){
                        supliers = SuplierDAO.getInstance().selectAll();
                        try {
                            model.setRowCount(0);
                            for (Suplier suplier1 : supliers) {
                                model.addRow(new java.lang.Object[]{
                                        suplier1.getId(),
                                        suplier1.getName(),
                                        suplier1.getAddress(),
                                        suplier1.getPhoneNumber(),
                                        suplier1.getStatus() ? "Còn hoạt động" : "Hết hoạt động"
                                });
                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText();
                    String name = nameText.getText();
                    String address = addressText.getText();
                    String phone = phoneText.getText();
                    Boolean statusB = status.getSelectedItem().toString().equals("Còn hoạt động") ? true : false;
                    if(SuplierController.getInstance().updateSuplier(id, name, address, phone, statusB)) {
                    }
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                }
            };
        });

        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supliers = SuplierDAO.getInstance().selectAll();
                try {
                    model.setRowCount(0);
                    for (Suplier suplier1 : supliers) {
                        model.addRow(new java.lang.Object[]{
                                suplier1.getId(),
                                suplier1.getName(),
                                suplier1.getAddress(),
                                suplier1.getPhoneNumber(),
                                suplier1.getStatus() ? "Còn hoạt động" : "Hết hoạt động"
                        });
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                idText.setText("");
                nameText.setText("");
                addressText.setText("");
                phoneText.setText("");
                status.setSelectedIndex(0);
            }
        });

        area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supliers = SuplierDAO.getInstance().selectAll();
                String textS = text.getText();
                String areaS = (String) area.getSelectedItem();
                boolean check = false;
                if (areaS.equals("Tất cả")) {
                    try {
                        model.setRowCount(0);
                        for (Suplier suplier : supliers) {
                            model.addRow(new java.lang.Object[]{
                                    suplier.getId(),
                                    suplier.getName(),
                                    suplier.getAddress(),
                                    suplier.getPhoneNumber(),
                                    suplier.getStatus() ? "Còn hoạt động" : "Hết hoạt động"
                            });
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (areaS.equals("Mã nhà cung cấp")) {
                    try {
                        model.setRowCount(0);
                        for (Suplier suplier : supliers) {
                            if (suplier.getId().toLowerCase().contains(textS.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        suplier.getId(),
                                        suplier.getName(),
                                        suplier.getAddress(),
                                        suplier.getPhoneNumber(),
                                        suplier.getStatus() ? "Còn hoạt động" : "Hết hoạt động"
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
                } else if (areaS.equals("Tên nhà cung cấp")) {
                    try {
                        model.setRowCount(0);
                        for (Suplier suplier : supliers) {
                            if (suplier.getName().toLowerCase().contains(textS.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        suplier.getId(),
                                        suplier.getName(),
                                        suplier.getAddress(),
                                        suplier.getPhoneNumber(),
                                        suplier.getStatus() ? "Còn hoạt động" : "Hết hoạt động"
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
                } else if (areaS.equals("Trạng thái")) {
                    try {
                        model.setRowCount(0);
                        for (Suplier suplier : supliers) {
                            if (suplier.getStatus() == true && textS.equals("Còn hoạt động")) {
                                model.addRow(new java.lang.Object[]{
                                        suplier.getId(),
                                        suplier.getName(),
                                        suplier.getAddress(),
                                        suplier.getPhoneNumber(),
                                        suplier.getStatus() ? "Còn hoạt động" : "Hết hoạt động"
                                });
                                check = true;
                            } else if (suplier.getStatus() == false && textS.equals("Hết hoạt động")) {
                                model.addRow(new java.lang.Object[]{
                                        suplier.getId(),
                                        suplier.getName(),
                                        suplier.getAddress(),
                                        suplier.getPhoneNumber(),
                                        suplier.getStatus() ? "Còn hoạt động" : "Hết hoạt động"
                                });
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
