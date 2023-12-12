package mobileshop.view.component;

import mobileshop.controller.ReceiptNoteController;
import mobileshop.dao.ReceiptNoteDAO;
import mobileshop.dao.ReceiptNoteDetailDAO;
import mobileshop.dao.StaffDAO;
import mobileshop.model.ReceiptNote;
import mobileshop.model.Staff;
import mobileshop.model.Suplier;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private JPanel fsPanel;
    private JPanel addReceiptNote;
    private ReceiptNoteDetail receiptNoteDetail;

    private ArrayList<ReceiptNote> receiptNotes;
    private ArrayList<Suplier> supliers;
    private ArrayList<Staff> staffs;

    boolean eventHandled = false;

    public PanelReceiptNote() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("fill, wrap", "[grow]", "[grow][grow][grow]");
        setLayout(layout);
        init();
        setVisible(true);
    }

    private void init() {
        mainPanel = new JPanel();
        feature = new JPanel();
        search = new JPanel();
        fsPanel = new JPanel();
        addReceiptNote = new JPanel();

        fsPanel.setLayout(new MigLayout("fill, wrap", "[150][1000]", "[50]"));
        fsPanel.setBackground(new Color(255,255,255));
        feature.setLayout(new MigLayout("fill, wrap", "[50][50][50]", "[50]"));
        feature.setBackground(new Color(255,255,255));
        search.setLayout(new MigLayout("fill, wrap", "[200][300][150]", "[50]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap", "[1000]", "[1000]"));
        mainPanel.setBackground(new Color(255,255,255));
        search.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        feature.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        addReceiptNote.setLayout(new MigLayout("fill, wrap", "30[33.33%][33.33%][33.33%]30", "10[33.33%][33.33%]10"));
        addReceiptNote.setBackground(new Color(255,255,255));
        addReceiptNote.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thông tin phiếu nhập", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));


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
        btnAdd.setHorizontalAlignment(SwingConstants.CENTER);
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
        btnDel.setHorizontalAlignment(SwingConstants.CENTER);
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
        btnEdit.setHorizontalAlignment(SwingConstants.CENTER);
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
        String[] columnNames = {"Mã phiếu nhập", "Ngày nhập", "Chi tiết", "Mã nhà cung cấp", "Mã nhân viên"};
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

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

        mainPanel.add(scrollPane, "grow");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Add Receipt Note">
        JPanel idReceiptNote = new JPanel();
        idReceiptNote.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        idReceiptNote.setBackground(new Color(255,255,255));
        idReceiptNote.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã phiếu nhập", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField idText = new JTextField();
        idText.setFont(new Font("sansserif", 1, 14));
        idText.setForeground(new Color(0, 0, 0));
        idText.setBackground(new Color(255, 255, 255));
        idText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idText.setBorder(null);
        idReceiptNote.add(idText, "grow");
        addReceiptNote.add(idReceiptNote, "grow");

        JPanel date = new JPanel();
        date.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        date.setBackground(new Color(255,255,255));
        date.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ngày nhập (dd/MM/yyyy)", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField dateText = new JFormattedTextField(format);
        dateText.setFont(new Font("sansserif", 1, 14));
        dateText.setForeground(new Color(0, 0, 0));
        dateText.setBackground(new Color(255, 255, 255));
        dateText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        dateText.setBorder(null);
        date.add(dateText, "grow");
        addReceiptNote.add(date, "grow");

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

        JPanel moreInfo = new JPanel();
        moreInfo.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        moreInfo.setBackground(new Color(255,255,255));
        moreInfo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Chi tiết", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField moreInfoText = new JTextField();
        moreInfoText.setFont(new Font("sansserif", 1, 14));
        moreInfoText.setForeground(new Color(0, 0, 0));
        moreInfoText.setBackground(new Color(255, 255, 255));
        moreInfoText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        moreInfoText.setBorder(null);
        moreInfo.add(moreInfoText, "grow");
        addReceiptNote.add(moreInfo, "grow");

        JPanel idSuplier = new JPanel();
        idSuplier.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        idSuplier.setBackground(new Color(255,255,255));
        idSuplier.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JComboBox idSuplierText = new JComboBox();
        idSuplierText.setFont(new Font("sansserif", 1, 14));
        idSuplierText.setForeground(new Color(0, 0, 0));
        idSuplierText.setBackground(new Color(255, 255, 255));
        idSuplierText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idSuplierText.setBorder(null);
        supliers = mobileshop.dao.SuplierDAO.getInstance().selectAll();
        for (Suplier suplier : supliers) {
            idSuplierText.addItem(suplier.getId());
        }
        idSuplier.add(idSuplierText, "grow");
        addReceiptNote.add(idSuplier, "grow");

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
        staffs = mobileshop.dao.StaffDAO.getInstance().selectAll();
        for (Staff staff : staffs) {
            idStaffText.addItem(staff.getId());
        }
        idStaff.add(idStaffText, "grow");
        addReceiptNote.add(idStaff, "grow");

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
        addReceiptNote.add(btnPanel, "grow");

        //</editor-fold>

        add(fsPanel, "width 100%, height 5%, wrap");
        add(addReceiptNote, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 75%, wrap");
        fsPanel.add(feature, "width 30%, pos 0al 0 n 100%");
        fsPanel.add(search, "width 68%, pos 1al 0 n 100%");

        //<editor-fold defaultstate="collapsed" desc="Event">
        receiptNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = receiptNote.getSelectedRow();
                if(row == -1) {
                    return;
                }
                idText.setText(receiptNote.getValueAt(row, 0).toString());
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                dateText.setText(format.format(receiptNote.getValueAt(row, 1)));
                moreInfoText.setText(receiptNote.getValueAt(row, 2).toString());
                idSuplierText.setSelectedItem(receiptNote.getValueAt(row, 3).toString());
                idStaffText.setSelectedItem(receiptNote.getValueAt(row, 4).toString());
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText().toString();
                    java.util.Date invoiceDate = format.parse(dateText.getText());
                    java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
                    String moreInfo = moreInfoText.getText().toString();
                    String idSuplier = idSuplierText.getSelectedItem().toString();
                    String idStaff = idStaffText.getSelectedItem().toString();
                    if(ReceiptNoteController.getInstance().addReceiptNote(id, sqlDate, moreInfo, idSuplier, idStaff)) {
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
                if(receiptNote.getSelectedRow() >= 0) {
                    int row = receiptNote.getSelectedRow();
                    if(row == -1) {
                        return;
                    }
                    String id = receiptNote.getValueAt(row, 0).toString();
                    for (mobileshop.model.ReceiptNoteDetail receiptNoteDetail : ReceiptNoteDetailDAO.getInstance().selectAll()) {
                        if (receiptNoteDetail.getIdRecept().equals(id)) {
                            ReceiptNoteDetailDAO.getInstance().delete(receiptNoteDetail);
                            JOptionPane.showMessageDialog(null, "Đã xóa chi tiết phiếu nhập!",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    if(ReceiptNoteController.getInstance().deleteReceiptNoteById(id)){
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
                    String moreInfo = moreInfoText.getText().toString();
                    String idSuplier = idSuplierText.getSelectedItem().toString();
                    String idStaff = idStaffText.getSelectedItem().toString();
                    if(ReceiptNoteController.getInstance().updateReceiptNote(id, sqlDate, moreInfo, idSuplier, idStaff)){}
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                reloadTable();
            };
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

        area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receiptNotes = ReceiptNoteDAO.getInstance().selectAll();
                String comBoBox = area.getSelectedItem().toString();
                String textSearch = text.getText();
                Boolean check = false;
                if (comBoBox.equals("Tất cả")) {
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
                else if (comBoBox.equals("Mã phiếu nhập")) {
                    try {
                        model.setRowCount(0);
                        for (ReceiptNote receiptNote : receiptNotes) {
                            if (receiptNote.getId().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        receiptNote.getId(),
                                        receiptNote.getDate(),
                                        receiptNote.getMoreInfo(),
                                        receiptNote.getIdSuplier(),
                                        receiptNote.getIdStaff()
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
                        for (ReceiptNote receiptNote : receiptNotes) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            String date = sdf.format(receiptNote.getDate());
                            if (date.toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        receiptNote.getId(),
                                        receiptNote.getDate(),
                                        receiptNote.getMoreInfo(),
                                        receiptNote.getIdSuplier(),
                                        receiptNote.getIdStaff()
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
                        for (ReceiptNote receiptNote : receiptNotes) {
                            if (receiptNote.getMoreInfo().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        receiptNote.getId(),
                                        receiptNote.getDate(),
                                        receiptNote.getMoreInfo(),
                                        receiptNote.getIdSuplier(),
                                        receiptNote.getIdStaff()
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
                        for (ReceiptNote receiptNote : receiptNotes) {
                            if (receiptNote.getIdSuplier().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        receiptNote.getId(),
                                        receiptNote.getDate(),
                                        receiptNote.getMoreInfo(),
                                        receiptNote.getIdSuplier(),
                                        receiptNote.getIdStaff()
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
                        for (ReceiptNote receiptNote : receiptNotes) {
                            if (receiptNote.getIdStaff().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new Object[]{
                                        receiptNote.getId(),
                                        receiptNote.getDate(),
                                        receiptNote.getMoreInfo(),
                                        receiptNote.getIdSuplier(),
                                        receiptNote.getIdStaff()
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