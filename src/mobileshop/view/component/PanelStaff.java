package mobileshop.view.component;

import mobileshop.dao.StaffDAO;
import mobileshop.model.Staff;
import mobileshop.view.UI.AddItem;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
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
    private JPanel search;
    private JPanel featureMenu;
    private mobileshop.view.UI.AddItem AddItem;

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
        search = new JPanel();

        search.setLayout(new MigLayout("fill, wrap", "[200][500][150]", "[50]"));
        search.setBackground(new Color(255,255,255));
        search.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0)), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0,0,0)));

        mainPanel.setLayout(new MigLayout("wrap"));
        mainPanel.setBackground(new Color(255,255,255));
        fsPanel.setLayout(new MigLayout("wrap", "[100%]10[100%]", "[100%]"));
        fsPanel.setBackground(new Color(255,255,255));

        featureMenu = new JPanel();
        featureMenu.setBackground(new Color(255,255,255));
        featureMenu.setLayout(new MigLayout("wrap 3", "[100][100][100]", "[50]"));
        
        featureMenu.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0)), "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0,0,0)));

        //<editor-fold defaultstate="collapsed" desc="Menu">
        JButton btnAdd = new JButton();
        btnAdd.setFont(new Font("sansserif", 1, 12));
        btnAdd.setForeground(new Color(0, 0, 0));
        btnAdd.setBackground(new Color(255, 255, 255));
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnAdd.setText("Thêm");
        btnAdd.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_40px.png")));
        btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnAdd,"grow");
        
        JButton btnDel = new JButton();
        btnDel.setFont(new Font("sansserif", 1, 12));
        btnDel.setForeground(new Color(0, 0, 0));
        btnDel.setBackground(new Color(255, 255, 255));
        btnDel.setBorderPainted(false);
        btnDel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnDel.setText("Xóa");
        btnDel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_delete_40px.png")));
        btnDel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDel.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnDel,"grow");
        
        JButton btnEdit = new JButton();
        btnEdit.setFont(new Font("sansserif", 1, 12));
        btnEdit.setForeground(new Color(0, 0, 0));
        btnEdit.setBackground(new Color(255, 255, 255));
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnEdit.setText("Sửa");
        btnEdit.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_edit_40px.png")));
        btnEdit.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEdit.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnEdit,"grow");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Search">

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
        search.add(text,"grow");
        
        JButton reload = new JButton();
        reload.setFont(new Font("sansserif", 1, 14));
        reload.setForeground(new Color(0, 0, 0));
        reload.setBackground(new Color(255, 255, 255));
        reload.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        reload.setText("Làm mới");
        reload.setBorder(new LineBorder(new Color(0,0,0)));
        reload.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_reset_25px_1.png")));
        reload.setMargin(new Insets(10,20,10,20));
        search.add(reload,"grow");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table">
        String[] columnNames = {"Mã nhân viên", "Tên nhân viên", "Địa chỉ", "Giới tính", "Ngày sinh", "Số điện thoại", "Quyền truy cập","Ca trực"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);

        staffs = StaffDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (Staff staff : staffs) {
                model.addRow(new Object[]{
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
        staff.getColumn("Tên nhân viên").setPreferredWidth(200);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) staff.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        staff.getTableHeader().setDefaultRenderer(renderer);
        staff.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        staff.setRowSelectionAllowed(true);
        staff.setEnabled(false);
        staff.getTableHeader().setReorderingAllowed(false);
        staff.getTableHeader().setResizingAllowed(false);

        mainPanel.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        add(fsPanel, "width 100%, height 10%, wrap");
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
