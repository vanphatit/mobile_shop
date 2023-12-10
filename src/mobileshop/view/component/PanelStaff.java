package mobileshop.view.component;

import mobileshop.dao.StaffDAO;
import mobileshop.model.Staff;
import mobileshop.view.UI.Add;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Frame.HAND_CURSOR;

public class PanelStaff extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel fsPanel;
    private JPanel mainPanel;
    private JTable staff;
    private JScrollPane scrollPane;
    private JPanel feature;
    private JPanel search;
    private JLabel title1;
    private JLabel title2;
    private JMenuBar featureMenu;
    private Add AddItem;

    private ArrayList<Staff> staffs;

    public PanelStaff() {
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
        
        JButton reload = new JButton();
        reload.setFont(new Font("sansserif", 1, 14));
        reload.setForeground(new Color(0, 0, 0));
        reload.setBackground(new Color(255, 255, 255));
        reload.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        reload.setText("Làm mới");
        reload.setBorder(new LineBorder(new Color(0,0,0)));
        reload.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_reset_25px_1.png")));
        reload.setMargin(new Insets(10,20,10,20));
        search.add(reload, "w 30%, h 35%");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table">
        String[] columnNames = {"Mã nhân viên", "Tên nhân viên", "Địa chỉ", "Giới tính", "Ngày sinh", "Số điện thoại", "Quyền truy cập","Ca trực"};
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames);

        staffs = StaffDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (Staff staff : staffs) {
                model.addRow(new java.lang.Object[]{
                        staff.getId(),
                        staff.getName(),
                        staff.getAddress(),
                        staff.getGender() ? "Nam" : "Nữ",
                        staff.getBirthday(),
                        staff.getPhone(),
                        staff.getRole(),
                        staff.getIdShift()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        staff = new JTable(model);
        scrollPane = new JScrollPane(staff);
        scrollPane.setViewportView(staff);

        staff.setForeground(new Color(100, 100, 100));
        staff.setFont(new Font("sansserif", 1, fontSize));
        staff.setRowHeight(30);
        staff.setFillsViewportHeight(true);
        staff.setBackground(new Color(255, 255, 255));
        staff.getTableHeader().setBackground(new Color(255, 255, 255));
        staff.getTableHeader().setForeground(new Color(100, 100, 100));
        staff.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) staff.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        staff.getTableHeader().setDefaultRenderer(renderer);

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
                AddItem = new Add();
                AddItem.show();
            }
        });
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
