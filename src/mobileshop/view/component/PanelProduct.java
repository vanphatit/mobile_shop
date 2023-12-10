package mobileshop.view.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import mobileshop.controller.ProductController;
import mobileshop.dao.ObjectDAO;
import mobileshop.model.Object;
import mobileshop.view.UI.EditItem;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;
import mobileshop.view.UI.AddItem;

public class PanelProduct extends javax.swing.JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel fsPanel;
    private JPanel mainPanel;
    private JTable product;
    private JScrollPane scrollPane;
    private JPanel search;
    private JPanel featureMenu;
    private mobileshop.view.UI.AddItem AddItem;
    private mobileshop.view.UI.EditItem editItem;

    private ArrayList<Object> products;
    
    public PanelProduct() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("fill, wrap", "[100%]", "[20%][80%]");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {
        mainPanel = new JPanel();
        fsPanel = new JPanel();
        search = new JPanel();
        featureMenu = new JPanel();

        search.setLayout(new MigLayout("fill, wrap", "[200][300][150]", "[75]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap"));
        mainPanel.setBackground(new Color(255,255,255));
        fsPanel.setLayout(new MigLayout("fill, wrap", "[300][1000]", "[75]"));
        fsPanel.setBackground(new Color(255,255,255));

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
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames);

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

        add(fsPanel, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 80%, wrap");
        fsPanel.add(featureMenu, "width 30%, pos 0al 0 n 75%");
        fsPanel.add(search, "width 68%, pos 1al 0 n 75%");

        //<editor-fold defaultstate="collapsed" desc="Event">
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddItem = new AddItem();
                AddItem.show();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = product.getSelectedRow();
                if(row == -1) {
                    return;
                }
                String id = (String) product.getValueAt(row, 0);
                editItem = new EditItem(id);
                editItem.show();
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = product.getSelectedRow();
                if(row == -1) {
                    return;
                }
                String id = (String) product.getValueAt(row, 0);
                if(ProductController.getInstance().delProduct(id)) {
                    model.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Xóa thành công!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                } catch (Exception ex) {
                    System.out.println(ex);
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
