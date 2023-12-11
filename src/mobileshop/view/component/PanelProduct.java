package mobileshop.view.component;

import java.awt.*;

import static java.awt.Frame.HAND_CURSOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import mobileshop.controller.ProductController;
import mobileshop.controller.SuplierController;
import mobileshop.dao.ObjectCategoryDAO;
import mobileshop.dao.ObjectDAO;
import mobileshop.dao.SuplierDAO;
import mobileshop.model.Object;
import mobileshop.model.ObjectCategory;
import mobileshop.model.Suplier;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

public class PanelProduct extends javax.swing.JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel fsPanel;
    private JPanel mainPanel;
    private JTable product;
    private JScrollPane scrollPane;
    private JPanel search;
    private JPanel featureMenu;
    private JPanel addProduct;

    private ArrayList<Object> products;
    private ArrayList<ObjectCategory> listCate;
    
    public PanelProduct() {
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
        addProduct = new JPanel();

        search.setLayout(new MigLayout("fill, wrap", "[200][300][150]", "[75]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap", "[1000]", "[1000]"));
        mainPanel.setBackground(new Color(255,255,255));
        fsPanel.setLayout(new MigLayout("fill, wrap", "[300][1000]", "[75]"));
        fsPanel.setBackground(new Color(255,255,255));
        addProduct.setLayout(new MigLayout("fill, wrap", "30[33.33%][33.33%][33.33%]30", "10[33.33%][33.33%]10"));
        addProduct.setBackground(new Color(255,255,255));
        addProduct.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thông tin sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));

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
        area.addItem("Mã sản phẩm");
        area.addItem("Trạng thái");
        area.addItem("Nhà sản xuất");
        area.addItem("Giá thành");
        area.addItem("Mã loại sản phẩm");
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
        String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Trạng thái", "Nhà sản xuất", "Giá thành", "Mã loại sản phẩm"};
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        products = ObjectDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (Object product : products) {
                model.addRow(new java.lang.Object[]{
                        product.getId(),
                        product.getName(),
                        product.getStatus(),
                        product.getManufacturer(),
                        product.getUnitPrice(),
                        product.getIdCategory()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        product = new JTable(model);
        scrollPane = new JScrollPane(product);

        product.setForeground(new Color(100, 100, 100));
        product.setFont(new Font("sansserif", 1, fontSize));
        product.setRowHeight(30);
        product.setFillsViewportHeight(true);
        product.setBackground(new Color(255, 255, 255));
        product.getTableHeader().setBackground(new Color(255, 255, 255));
        product.getTableHeader().setForeground(new Color(100, 100, 100));
        product.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) product.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        product.getTableHeader().setDefaultRenderer(renderer);
        product.getTableHeader().setResizingAllowed(false);
        product.getTableHeader().setReorderingAllowed(false);

        scrollPane.setViewportView(product);
        mainPanel.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Add staff">
        JPanel id = new JPanel();
        id.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        id.setBackground(new Color(255,255,255));
        id.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField idText = new JTextField();
        idText.setFont(new Font("sansserif", 1, 14));
        idText.setForeground(new Color(0, 0, 0));
        idText.setBackground(new Color(255, 255, 255));
        idText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idText.setBorder(null);
        id.add(idText, "grow");
        addProduct.add(id, "grow");

        JPanel name = new JPanel();
        name.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        name.setBackground(new Color(255,255,255));
        name.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tên sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField nameText = new JTextField();
        nameText.setFont(new Font("sansserif", 1, 14));
        nameText.setForeground(new Color(0, 0, 0));
        nameText.setBackground(new Color(255, 255, 255));
        nameText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        nameText.setBorder(null);
        name.add(nameText, "grow");
        addProduct.add(name, "grow");

        JPanel status = new JPanel();
        status.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        status.setBackground(new Color(255,255,255));
        status.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "trạng thái", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField statusText = new JTextField();
        statusText.setFont(new Font("sansserif", 1, 14));
        statusText.setForeground(new Color(0, 0, 0));
        statusText.setBackground(new Color(255, 255, 255));
        statusText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        statusText.setBorder(null);
        status.add(statusText, "grow");
        addProduct.add(status, "grow");

        JPanel manufacture = new JPanel();
        manufacture.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        manufacture.setBackground(new Color(255,255,255));
        manufacture.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Nhà sản xuất", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField manufactureText = new JTextField();
        manufactureText.setFont(new Font("sansserif", 1, 14));
        manufactureText.setForeground(new Color(0, 0, 0));
        manufactureText.setBackground(new Color(255, 255, 255));
        manufactureText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        manufactureText.setBorder(null);
        manufacture.add(manufactureText, "grow");
        addProduct.add(manufacture, "grow");

        JPanel unitPrice = new JPanel();
        unitPrice.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        unitPrice.setBackground(new Color(255,255,255));
        unitPrice.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Giá thành", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField unitPriceText = new JTextField();
        unitPriceText.setFont(new Font("sansserif", 1, 14));
        unitPriceText.setForeground(new Color(0, 0, 0));
        unitPriceText.setBackground(new Color(255, 255, 255));
        unitPriceText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        unitPriceText.setBorder(null);
        unitPrice.add(unitPriceText, "grow");
        addProduct.add(unitPrice, "grow");

        JPanel idCategory = new JPanel();
        idCategory.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        idCategory.setBackground(new Color(255,255,255));
        idCategory.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã loại sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JComboBox idCategoryText = new JComboBox();
        idCategoryText.setFont(new Font("sansserif", 1, 14));
        idCategoryText.setForeground(new Color(0, 0, 0));
        idCategoryText.setBackground(new Color(255, 255, 255));
        idCategoryText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idCategoryText.setBorder(null);
        listCate = ObjectCategoryDAO.getInstance().selectAll();
        for (ObjectCategory objectCategory : listCate) {
            idCategoryText.addItem(objectCategory.getId());
        }
        idCategory.add(idCategoryText, "grow");
        addProduct.add(idCategory, "grow");

        //</editor-fold>

        add(fsPanel, "width 100%, height 20%, wrap");
        add(addProduct, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 60%, wrap");
        fsPanel.add(featureMenu, "width 30%, pos 0al 0 n 100%");
        fsPanel.add(search, "width 68%, pos 1al 0 n 100%");

        //<editor-fold defaultstate="collapsed" desc="Event">
        product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = product.getSelectedRow();
                if(row == -1) {
                    return;
                }
                idText.setText(product.getValueAt(row, 0).toString());
                nameText.setText(product.getValueAt(row, 1).toString());
                statusText.setText(product.getValueAt(row, 2).toString());
                manufactureText.setText(product.getValueAt(row, 3).toString());
                unitPriceText.setText(product.getValueAt(row, 4).toString());
                listCate = ObjectCategoryDAO.getInstance().selectAll();
                for (ObjectCategory objectCategory : listCate) {
                    if (objectCategory.getId().equals(product.getValueAt(row, 5).toString())) {
                        idCategoryText.setSelectedItem(objectCategory.getId());
                    }
                }

            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText();
                    String name = nameText.getText();
                    String manufacture = manufactureText.getText();
                    String unitPrice = unitPriceText.getText();
                    String cate = idCategoryText.getSelectedItem().toString();
                    listCate = ObjectCategoryDAO.getInstance().selectAll();
                    for (ObjectCategory objectCategory : listCate) {
                        if (objectCategory.getId().equals(idCategoryText.getSelectedItem().toString())) {
                            cate = objectCategory.getId();
                        }
                    }
                    if((ProductController.getInstance().addProduct(id, name, statusText.getText(), manufacture, unitPrice, cate))) {
                    }
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                }
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(product.getSelectedRow() >= 0) {
                    int row = product.getSelectedRow();
                    if(row == -1) {
                        return;
                    }
                    String id = product.getValueAt(row, 0).toString();
                    if(ProductController.getInstance().deleteObjectById(id)){
                        products = ObjectDAO.getInstance().selectAll();
                        try {
                            model.setRowCount(0);
                            for (Object object : products) {
                                model.addRow(new java.lang.Object[]{
                                        object.getId(),
                                        object.getName(),
                                        object.getStatus(),
                                        object.getManufacturer(),
                                        object.getUnitPrice(),
                                        object.getIdCategory()
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
                    String status = statusText.getText();
                    String manufacture = manufactureText.getText();
                    String phone = unitPriceText.getText();
                    String cate = idCategoryText.getSelectedItem().toString();
                    listCate = ObjectCategoryDAO.getInstance().selectAll();
                    for (ObjectCategory objectCategory : listCate) {
                        if (objectCategory.getId().equals(idCategoryText.getSelectedItem().toString())) {
                            cate = objectCategory.getId();
                        }
                    }
                    if(ProductController.getInstance().updateObject(id, name, status, manufacture, phone, cate)) {
                    }
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                }
            };
        });

        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                products = ObjectDAO.getInstance().selectAll();
                try {
                    model.setRowCount(0);
                    for (Object object : products) {
                        model.addRow(new java.lang.Object[]{
                                object.getId(),
                                object.getName(),
                                object.getStatus(),
                                object.getManufacturer(),
                                object.getUnitPrice(),
                                object.getIdCategory()
                        });
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                idText.setText("");
                nameText.setText("");
                statusText.setText("");
                manufactureText.setText("");
                unitPriceText.setText("");
                idCategoryText.setSelectedIndex(0);
            }
        });

        area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                products = ObjectDAO.getInstance().selectAll();
                String textS = text.getText();
                String areaS = (String) area.getSelectedItem();
                boolean check = false;
                if (areaS.equals("Tất cả")) {
                    try {
                        model.setRowCount(0);
                        for (Object product : products) {
                            model.addRow(new java.lang.Object[]{
                                    product.getId(),
                                    product.getName(),
                                    product.getStatus(),
                                    product.getManufacturer(),
                                    product.getUnitPrice(),
                                    product.getIdCategory()
                            });
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (areaS.equals("Mã sản phẩm")) {
                    try {
                        model.setRowCount(0);
                        for (Object product : products) {
                            if (product.getId().equals(textS)) {
                                check = true;
                                model.addRow(new java.lang.Object[]{
                                        product.getId(),
                                        product.getName(),
                                        product.getStatus(),
                                        product.getManufacturer(),
                                        product.getUnitPrice(),
                                        product.getIdCategory()
                                });
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
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
                        for (Object product : products) {
                            if (product.getStatus().equals(textS)) {
                                check = true;
                                model.addRow(new java.lang.Object[]{
                                        product.getId(),
                                        product.getName(),
                                        product.getStatus(),
                                        product.getManufacturer(),
                                        product.getUnitPrice(),
                                        product.getIdCategory()
                                });
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (areaS.equals("Nhà sản xuất")) {
                    try {
                        model.setRowCount(0);
                        for (Object product : products) {
                            if (product.getManufacturer().equals(textS)) {
                                check = true;
                                model.addRow(new java.lang.Object[]{
                                        product.getId(),
                                        product.getName(),
                                        product.getStatus(),
                                        product.getManufacturer(),
                                        product.getUnitPrice(),
                                        product.getIdCategory()
                                });
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (areaS.equals("Giá thành")) {
                    try {
                        model.setRowCount(0);
                        for (Object product : products) {
                            if (String.valueOf(product.getUnitPrice()).equals(textS)) {
                                check = true;
                                model.addRow(new java.lang.Object[]{
                                        product.getId(),
                                        product.getName(),
                                        product.getStatus(),
                                        product.getManufacturer(),
                                        product.getUnitPrice(),
                                        product.getIdCategory()
                                });
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (areaS.equals("Mã loại sản phẩm")) {
                    try {
                        model.setRowCount(0);
                        for (Object product : products) {
                            if (product.getIdCategory().equals(textS)) {
                                check = true;
                                model.addRow(new java.lang.Object[]{
                                        product.getId(),
                                        product.getName(),
                                        product.getStatus(),
                                        product.getManufacturer(),
                                        product.getUnitPrice(),
                                        product.getIdCategory()
                                });
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
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