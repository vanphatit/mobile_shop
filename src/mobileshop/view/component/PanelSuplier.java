package mobileshop.view.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

public class PanelSuplier extends javax.swing.JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel fsPanel;
    private JPanel mainPanel;
    private JTable suplier;
    private JScrollPane scrollPane;
    private JPanel feature;
    private JPanel search;
    private JLabel title1;
    private JLabel title2;
    private JMenuBar featureMenu;
    
    public PanelSuplier() {
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
        
        JButton addF = new JButton();
        addF.setFont(new Font("sansserif", 1, 14));
        addF.setForeground(new Color(0, 0, 0));
        addF.setBackground(new Color(255, 255, 255));
        addF.setBorderPainted(false);
        addF.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        addF.setText("Thêm");
        addF.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_40px.png")));
        addF.setVerticalTextPosition(SwingConstants.BOTTOM);
        addF.setHorizontalTextPosition(SwingConstants.CENTER);
        addF.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(addF);
        
        JButton delete = new JButton();
        delete.setFont(new Font("sansserif", 1, 14));
        delete.setForeground(new Color(0, 0, 0));
        delete.setBackground(new Color(255, 255, 255));
        delete.setBorderPainted(false);
        delete.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        delete.setText("Xóa");
        delete.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_delete_40px.png")));
        delete.setVerticalTextPosition(SwingConstants.BOTTOM);
        delete.setHorizontalTextPosition(SwingConstants.CENTER);
        delete.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(delete);
        
        JButton fix = new JButton();
        fix.setFont(new Font("sansserif", 1, 14));
        fix.setForeground(new Color(0, 0, 0));
        fix.setBackground(new Color(255, 255, 255));
        fix.setBorderPainted(false);
        fix.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        fix.setText("Sửa");
        fix.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_edit_40px.png")));
        fix.setVerticalTextPosition(SwingConstants.BOTTOM);
        fix.setHorizontalTextPosition(SwingConstants.CENTER);
        fix.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(fix);
        
        JButton addExcel = new JButton();
        addExcel.setFont(new Font("sansserif", 1, 14));
        addExcel.setForeground(new Color(0, 0, 0));
        addExcel.setBackground(new Color(255, 255, 255));
        addExcel.setBorderPainted(false);
        addExcel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        addExcel.setText("Nhập Excel");
        addExcel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_spreadsheet_file_40px.png")));
        addExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        addExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        addExcel.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(addExcel);
        
        JButton ExportExcel = new JButton();
        ExportExcel.setFont(new Font("sansserif", 1, 14));
        ExportExcel.setForeground(new Color(0, 0, 0));
        ExportExcel.setBackground(new Color(255, 255, 255));
        ExportExcel.setBorderPainted(false);
        ExportExcel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        ExportExcel.setText("Xuất Excel");
        ExportExcel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_xls_40px.png")));
        ExportExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        ExportExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        ExportExcel.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(ExportExcel);
        
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
        
        Object[][] data = {
                {"S001", "Apple", "0123456789", "Còn cung cấp"},
                {"S001", "Apple", "0123456789", "Còn cung cấp"},
                {"S001", "Apple", "0123456789", "Còn cung cấp"}
        };
        String[] columnNames = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        suplier = new JTable(model);
        scrollPane = new JScrollPane(suplier);
        scrollPane.setViewportView(suplier);
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setForeground(new Color(100, 100, 100));
        scrollPane.setFont(new Font("sansserif", 1, fontSize));
        suplier.setForeground(new Color(100, 100, 100));
        suplier.setFont(new Font("sansserif", 1, fontSize));
        mainPanel.add(scrollPane, "w 100%, h 100%");
        add(fsPanel, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 80%, wrap");
        fsPanel.add(feature, "width 50%, pos 0al 0 n 100%");
        fsPanel.add(search, "width 48%, pos 1al 0 n 100%");
        
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