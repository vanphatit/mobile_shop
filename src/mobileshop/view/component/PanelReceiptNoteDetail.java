package mobileshop.view.component;

import mobileshop.dao.ReceiptNoteDetailDAO;
import mobileshop.model.ReceiptNote;
import mobileshop.model.ReceiptNoteDetail;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Frame.HAND_CURSOR;

public class PanelReceiptNoteDetail extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JTable receiptNoteDetail;
    private JScrollPane scrollPane;
    private JPanel receipt;
    private JPanel detail;
    private JPanel feature;
    private JPanel costPanel;
    private JPanel main;

    private ArrayList<ReceiptNote> receiptNotes;
    private ArrayList<ReceiptNoteDetail> receiptNoteDetails;

    public PanelReceiptNoteDetail() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap", "[grow]", "[grow]10[grow]10[grow]");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {

        //<editor-fold defaultstate="collapsed" desc="Panel">
        main = new JPanel();
        main.setBackground(new Color(255, 255, 255));
        main.setLayout(new MigLayout("wrap", "[grow]", "[grow]10[grow]10[grow]"));
        add(main, "width 100%, height 100%, wrap");
        costPanel = new JPanel();
        costPanel.setBackground(new Color(255, 255, 255));
        costPanel.setLayout(new MigLayout("wrap", "push[Left]push", "push[]10[]push"));
        receipt = new JPanel();
        receipt.setBackground(new Color(255, 255, 255));
        receipt.setLayout(new MigLayout("wrap", "[left]10[left]push", "push[]5[]5[]5[]push"));
        detail = new JPanel();
        detail.setBackground(new Color(255, 255, 255));
        detail.setLayout(new MigLayout("wrap"));
        feature = new JPanel();
        feature.setBackground(new Color(255, 255, 255));
        feature.setLayout(new MigLayout("wrap", "[center]10[center]10[center]25[]push", "push[]push"));

        //<editor-fold defaultstate="collapsed" desc="Feature">
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

        JLabel cost = new JLabel("Tổng tiền: ");
        cost.setFont(new Font("sansserif", 1, 20));
        cost.setForeground(new Color(7, 164, 121));
        costPanel.add(cost);
        JLabel txtCost = new JLabel();
        txtCost.setFont(new Font("sansserif", 1, 20));
        txtCost.setText("Tiền");
        txtCost.setForeground(new Color(228, 7, 7));
        costPanel.add(txtCost);
        feature.add(costPanel);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Receipt">
        
        JLabel id = new JLabel("Mã phiếu nhập");
        id.setFont(new Font("sansserif", 1, 14));
        id.setForeground(new Color(100, 100, 100));
        receipt.add(id);
        JTextField txtId = new JTextField();
        txtId.setFont(new Font("sansserif", 1, 14));
        txtId.setForeground(new Color(100, 100, 100));
        txtId.setBackground(new Color(255, 255, 255));
        txtId.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        receipt.add(txtId, "w 60%,wrap");

        JLabel idSuplier = new JLabel("Mã nhà cung cấp");
        idSuplier.setFont(new Font("sansserif", 1, 14));
        idSuplier.setForeground(new Color(100, 100, 100));
        receipt.add(idSuplier);
        JTextField txtIdSuplier = new JTextField();
        txtIdSuplier.setFont(new Font("sansserif", 1, 14));
        txtIdSuplier.setForeground(new Color(100, 100, 100));
        txtIdSuplier.setBackground(new Color(255, 255, 255));
        txtIdSuplier.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        receipt.add(txtIdSuplier, "w 60%,wrap");

        JLabel idStaff = new JLabel("Mã nhân viên");
        idStaff.setFont(new Font("sansserif", 1, 14));
        idStaff.setForeground(new Color(100, 100, 100));
        receipt.add(idStaff);
        JTextField txtIdStaff = new JTextField();
        txtIdStaff.setFont(new Font("sansserif", 1, 14));
        txtIdStaff.setForeground(new Color(100, 100, 100));
        txtIdStaff.setBackground(new Color(255, 255, 255));
        txtIdStaff.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        receipt.add(txtIdStaff, "w 60%,wrap");

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table">
        String[] columnNames = {"Giá thành", "Số lượng", "Mã sản phẩm", "Mã phiếu nhập"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);

        receiptNoteDetails = ReceiptNoteDetailDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (ReceiptNoteDetail receiptNoteDetail : receiptNoteDetails) {
                model.addRow(new Object[]{
                        receiptNoteDetail.getUnitPrice(),
                        receiptNoteDetail.getCount(),
                        receiptNoteDetail.getIdObject(),
                        receiptNoteDetail.getIdRecept()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        receiptNoteDetail = new JTable(model);
        scrollPane = new JScrollPane(receiptNoteDetail);
        scrollPane.setViewportView(receiptNoteDetail);

        receiptNoteDetail.setForeground(new Color(100, 100, 100));
        receiptNoteDetail.setFont(new Font("sansserif", 1, fontSize));
        receiptNoteDetail.setRowHeight(30);
        receiptNoteDetail.setFillsViewportHeight(true);
        receiptNoteDetail.setBackground(new Color(255, 255, 255));
        receiptNoteDetail.getTableHeader().setBackground(new Color(255, 255, 255));
        receiptNoteDetail.getTableHeader().setForeground(new Color(100, 100, 100));
        receiptNoteDetail.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) receiptNoteDetail.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        receiptNoteDetail.getTableHeader().setDefaultRenderer(renderer);

        detail.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        main.add(receipt, "width 100%, height 20%, wrap");
        main.add(detail, "width 100%, height 90%, wrap");
        main.add(feature, "width 100%, height 5%");


        //<editor-fold defaultstate="collapsed" desc="Event">
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
