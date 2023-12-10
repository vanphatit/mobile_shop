package mobileshop.view.component;

import mobileshop.controller.ReceiptNoteController;
import mobileshop.dao.ReceiptNoteDAO;
import mobileshop.model.ReceiptNote;
import mobileshop.view.UI.Add;
import mobileshop.view.UI.AddReceiptNote;
import mobileshop.view.UI.ReceiptNoteDetail;
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

public class PanelReceiptNote extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel mainPanel;
    private JTable receiptNote;
    private JScrollPane scrollPane;
    private JPanel feature;
    private JPanel search;
    private ReceiptNoteDetail receiptNoteDetail;

    private ArrayList<ReceiptNote> receiptNotes;

    boolean eventHandled = false;

    public PanelReceiptNote() {
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
        
        JComboBox area = new JComboBox();
        area.setFont(new Font("sansserif", 1, 14));
        area.setForeground(new Color(0, 0, 0));
        area.setBackground(new Color(255, 255, 255));
        area.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        area.addItem("Tất cả");
        area.setBorder(null);
        search.add(area, "w 30%, h 100%");
        
        MyTextField text = new MyTextField();
        text.setFont(new Font("sansserif", 1, 14));
        text.setForeground(new Color(0, 0, 0));
        text.setBackground(new Color(255, 255, 255));
        text.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        text.setBorder(new LineBorder(new Color(0, 0, 0)));
        search.add(text, "w 40%, h 100%");
        
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
        String[] columnNames = {"Mã phiếu nhập", "Ngày nhập", "Chi tiết", "Mã nhà cung cấp", "Mã nhân viên"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);

        receiptNotes = ReceiptNoteDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (ReceiptNote receiptNote : receiptNotes) {
                model.addRow(new Object[]{
                        receiptNote.getId(),
                        receiptNote.getDate(),
                        receiptNote.getMoreInfo(),
                        receiptNote.getIdSuplier(),
                        receiptNote.getIdStaff()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        receiptNote = new JTable(model);
        scrollPane = new JScrollPane(receiptNote);
        scrollPane.setViewportView(receiptNote);

        receiptNote.setForeground(new Color(100, 100, 100));
        receiptNote.setFont(new Font("sansserif", 1, fontSize));
        receiptNote.setRowHeight(30);
        receiptNote.setFillsViewportHeight(true);
        receiptNote.setBackground(new Color(255, 255, 255));
        receiptNote.getTableHeader().setBackground(new Color(255, 255, 255));
        receiptNote.getTableHeader().setForeground(new Color(100, 100, 100));
        receiptNote.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) receiptNote.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        receiptNote.getTableHeader().setDefaultRenderer(renderer);

        mainPanel.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        add(search, "width 100%, height 5%, wrap");
        add(mainPanel, "width 100%, height 85%, wrap");
        add(feature, "width 100%, height 20%, top");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddReceiptNote addReceiptNote = new AddReceiptNote();
                addReceiptNote.setVisible(true);
                addReceiptNote.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        reloadTable();
                    }
                });
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(receiptNote.getSelectedRow() >= 0) {
                    int row = receiptNote.getSelectedRow();
                    if(row == -1) {
                        return;
                    }
                    String id = receiptNote.getValueAt(row, 0).toString();
                    String date = receiptNote.getValueAt(row, 1).toString();
                    String moreInfo = receiptNote.getValueAt(row, 2).toString();
                    String idSuplier = receiptNote.getValueAt(row, 3).toString();
                    String idStaff = receiptNote.getValueAt(row, 4).toString();
                    if(ReceiptNoteController.getInstance().updateReceiptNote(id, date, moreInfo, idSuplier, idStaff)){
                        reloadTable();
                    }
                }
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(receiptNote.getSelectedRow() >= 0) {
                    int row = receiptNote.getSelectedRow();
                    if(row == -1) {
                        return;
                    }
                    String id = receiptNote.getValueAt(row, 0).toString();
                    if(ReceiptNoteController.getInstance().deleteReceiptNoteById(id)){
                        reloadTable();
                    }
                }
            }
        });

        btnDetail.addActionListener(e -> {
            if (receiptNote.getSelectedRow() >= 0) {
                int row = receiptNote.getSelectedRow();
                if(row == -1) {
                    return;
                }
                String id = (String) receiptNote.getValueAt(row, 0);
                receiptNoteDetail = new ReceiptNoteDetail(id);
                receiptNoteDetail.setVisible(true);
            }
        });

        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadTable();
            }
        });
    }

    public void reloadTable() {
        receiptNotes = ReceiptNoteDAO.getInstance().selectAll();
        DefaultTableModel model = (DefaultTableModel) receiptNote.getModel();
        try {
            model.setRowCount(0);
            for (ReceiptNote receiptNote : receiptNotes) {
                model.addRow(new Object[]{
                        receiptNote.getId(),
                        receiptNote.getDate(),
                        receiptNote.getMoreInfo(),
                        receiptNote.getIdSuplier(),
                        receiptNote.getIdStaff()
                });
            }
        } catch (Exception ex) {
            System.out.println(ex);
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
