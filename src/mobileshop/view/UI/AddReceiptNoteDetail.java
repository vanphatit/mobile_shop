package mobileshop.view.UI;

import mobileshop.controller.ReceiptNoteController;
import mobileshop.dao.ReceiptNoteDAO;
import mobileshop.model.ReceiptNote;
import mobileshop.model.ReceiptNoteDetail;
import mobileshop.view.component.PanelCoverAddReceiptNoteDetail;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReceiptNoteDetail extends JFrame {

    private MigLayout layout;
    private PanelCoverAddReceiptNoteDetail cover;
    private JPanel addPanel;
    private int fonsize = 14;
    private JPanel panelBtn;

    private ReceiptNote receiptNote;

    public AddReceiptNoteDetail(String id) {

        receiptNote = ReceiptNoteDAO.getInstance().selectById(id);

        initComponents();
        setTitle("Thêm chi tiết phiếu nhập mới");
        setLocationRelativeTo(null);
        initComponents();
        init();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void init()
    {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverAddReceiptNoteDetail();
        addPanel = new JPanel();
        bg.setLayout(layout);
        addPanel.setLayout(new MigLayout("wrap", "push[center]push", "15[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]25"));
        addPanel.setBackground(new Color(255, 255, 255));

        JLabel idReceipt = new JLabel("Mã phiếu nhập: ");
        idReceipt.setForeground(new Color(100, 100, 100));
        idReceipt.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(idReceipt, "w 60%");
        JTextField txtIDReceipt = new JTextField();
        txtIDReceipt.setFont(new Font("sansserif", 1, fonsize));
        txtIDReceipt.setText(receiptNote.getId());
        txtIDReceipt.setEditable(false);
        addPanel.add(txtIDReceipt, "wrap, width 60%");

        JLabel idProduct = new JLabel("Nhập id sản phẩm: ");
        idProduct.setForeground(new Color(100, 100, 100));
        idProduct.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(idProduct, "w 60%");
        JTextField txtIDProduct = new JTextField();
        txtIDProduct.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtIDProduct, "wrap, width 60%");

        JLabel count = new JLabel("Nhập số lượng: ");
        count.setForeground(new Color(100, 100, 100));
        count.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(count, "w 60%");
        JTextField txtCount = new JTextField();
        txtCount.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtCount, "wrap, width 60%");

        JLabel unitPrice = new JLabel("Nhập đơn giá: ");
        unitPrice.setForeground(new Color(100, 100, 100));
        unitPrice.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(unitPrice, "w 60%");
        JTextField txtPrice = new JTextField();
        txtPrice.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtPrice, "wrap, width 60%");

        panelBtn = new JPanel();
        panelBtn.setBackground(new Color(255, 255, 255));
        panelBtn.setLayout(new MigLayout("wrap", "push[center]10[center]push"));
        addPanel.add(panelBtn, "width 60%, wrap");

        JButton btnAdd = new JButton();
        btnAdd.setText("Thêm sản phẩm");
        btnAdd.setFont(new Font("sansserif", 1, fonsize));
        btnAdd.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(7, 164, 121));
        btnAdd.setMargin(new Insets(10,20,10,20));
        panelBtn.add(btnAdd);

        JButton btnCancel = new JButton();
        btnCancel.setText("Hủy");
        btnCancel.setFont(new Font("sansserif", 1, fonsize));
        btnCancel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnCancel.setForeground(new Color(255, 255, 255));
        btnCancel.setBackground(new Color(225, 35, 35));
        btnCancel.setMargin(new Insets(10,20,10,20));
        panelBtn.add(btnCancel);
        
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(255, 255, 255));
            }
        });
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(255, 255, 255));
                source.setBackground(new Color(225, 35, 35));
            }
        });

        bg.add(cover, "height 20%, width 100%, wrap");
        bg.add(addPanel, "height 80%, width 100%");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReceiptNoteDetail receiptNoteDetail =
                            new ReceiptNoteDetail(Integer.parseInt(txtPrice.getText()),
                                    Integer.parseInt(txtCount.getText()), txtIDProduct.getText(),
                                    txtIDReceipt.getText());
                    if(ReceiptNoteController.getInstance().addReceiptNoteDetail(receiptNoteDetail))
                        dispose();

                } catch (HeadlessException ex) {
                    System.out.println(ex);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));

        bg.setBackground(new Color(255, 255, 255));
        bg.setOpaque(false);

        GroupLayout bgLayout = new GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel bg;
    // End of variables declaration//GEN-END:variables
}
