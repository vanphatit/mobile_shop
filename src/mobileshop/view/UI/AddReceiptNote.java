package mobileshop.view.UI;

import mobileshop.controller.CustomerController;
import mobileshop.controller.ReceiptNoteController;
import mobileshop.dao.CustomerCategoryDAO;
import mobileshop.model.CustomerCategory;
import mobileshop.view.component.PanelCoverAddReceiptNote;
import mobileshop.view.component.PanelReceiptNote;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AddReceiptNote extends JFrame {

    private MigLayout layout;
    private PanelCoverAddReceiptNote cover;
    private JPanel addPanel;
    private int fonsize = 14;
    private JPanel panelBtn;

    public AddReceiptNote() {
        initComponents();
        setTitle("Thêm phiếu nhập mới");
        setLocationRelativeTo(null);
        initComponents();
        init();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void init()
    {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverAddReceiptNote();
        addPanel = new JPanel();
        bg.setLayout(layout);
        addPanel.setLayout(new MigLayout("wrap", "push[center]push", "15[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]25"));
        addPanel.setBackground(new Color(255, 255, 255));

        JLabel id = new JLabel("Nhập mã phiếu nhập: ");
        id.setForeground(new Color(100, 100, 100));
        id.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(id, "w 60%");
        JTextField txtID = new JTextField();
        txtID.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtID, "wrap, width 60%");

        JLabel date = new JLabel("Nhập ngày nhập hàng: (dd/MM/yyyy)");
        date.setForeground(new Color(100, 100, 100));
        date.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(date, "w 60%");
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField txtDate = new JFormattedTextField(formatDate);
        txtDate.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtDate, "wrap, width 60%");

        txtDate.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập theo định dạng: MM/dd/yyyy");
                    e.consume();
                }
            }
        });

        JLabel moreInfo = new JLabel("Nhập thông tin thêm: ");
        moreInfo.setForeground(new Color(100, 100, 100));
        moreInfo.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(moreInfo, "w 60%");
        JTextField txtMoreInfo = new JTextField();
        txtMoreInfo.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtMoreInfo, "wrap, width 60%");

        JLabel idSuplier = new JLabel("Nhập mã nhà cung cấp: ");
        idSuplier.setForeground(new Color(100, 100, 100));
        idSuplier.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(idSuplier, "w 60%");
        JTextField txtIDSuplier = new JTextField();
        txtIDSuplier.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtIDSuplier, "wrap, width 60%");

        JLabel idStaff = new JLabel("Nhập mã nhân viên: ");
        idStaff.setForeground(new Color(100, 100, 100));
        idStaff.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(idStaff, "w 60%");
        JTextField txtIDStaff = new JTextField();
        txtIDStaff.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtIDStaff, "wrap, width 60%");

        panelBtn = new JPanel();
        panelBtn.setBackground(new Color(255, 255, 255));
        panelBtn.setLayout(new MigLayout("wrap", "push[center]10[center]push"));
        addPanel.add(panelBtn, "width 60%, wrap");

        JButton btnAdd = new JButton();
        btnAdd.setText("Thêm phiếu nhập");
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
                    String id = txtID.getText();
                    java.util.Date invoiceDate = formatDate.parse(txtDate.getText());
                    java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
                    String moreInfo = txtMoreInfo.getText();
                    String idSuplier = txtIDSuplier.getText();
                    String idStaff = txtIDStaff.getText();

                    if (ReceiptNoteController.getInstance().addReceiptNote(id, sqlDate, moreInfo, idSuplier, idStaff))
                    {
                        dispose();
                    }
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
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

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddReceiptNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReceiptNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReceiptNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReceiptNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReceiptNote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel bg;
    // End of variables declaration//GEN-END:variables
}
