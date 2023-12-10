package mobileshop.view.UI;

import mobileshop.controller.SuplierController;
import mobileshop.dao.SuplierDAO;
import mobileshop.model.Suplier;
import mobileshop.view.component.PanelCoverAddSuplier;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSuplier extends JFrame {

    private MigLayout layout;
    private PanelCoverAddSuplier cover;
    private JPanel addPanel;
    private int fonsize = 14;
    private JPanel panelBtn;

    public AddSuplier() {
        initComponents();
        setTitle("Thêm nhà cung cấp mới");
        setLocationRelativeTo(null);
        initComponents();
        init();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void init()
    {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverAddSuplier();
        addPanel = new JPanel();
        bg.setLayout(layout);
        addPanel.setLayout(new MigLayout("wrap", "push[center]push", "15[]5[]5[]5[]5[]5[]5[]5[]5[]5[]25"));
        addPanel.setBackground(new Color(255, 255, 255));

        JLabel id = new JLabel("Nhập mã nhà cung cấp: ");
        id.setForeground(new Color(100, 100, 100));
        id.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(id, "w 60%");
        JTextField txtID = new JTextField();
        txtID.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtID, "wrap, width 60%");
        
        JLabel name = new JLabel("Nhập tên nhà cung cấp: ");
        name.setForeground(new Color(100, 100, 100));
        name.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(name, "w 60%");
        JTextField txtName = new JTextField();
        txtName.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtName, "wrap, width 60%");

        JLabel address = new JLabel("Nhập địa chỉ: ");
        address.setForeground(new Color(100, 100, 100));
        address.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(address, "w 60%");
        JTextField txtAddress = new JTextField();
        txtAddress.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtAddress, "wrap, width 60%");
        
        JLabel phone = new JLabel("Nhập số điện thoại: ");
        phone.setForeground(new Color(100, 100, 100));
        phone.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(phone, "w 60%");
        JTextField txtPhone = new JTextField();
        txtPhone.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtPhone, "wrap, width 60%");

        JLabel status = new JLabel("Nhập trạng thái: ");
        status.setForeground(new Color(100, 100, 100));
        status.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(status, "w 60%");
        JComboBox cbbStatus = new JComboBox();
        cbbStatus.setForeground(new Color(100, 100, 100));
        cbbStatus.setFont(new Font("sansserif", 1, fonsize));
        cbbStatus.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        cbbStatus.setBackground(new Color(255, 255, 255));
        cbbStatus.addItem("Còn hoạt động");
        cbbStatus.addItem("Không hoạt động");
        addPanel.add(cbbStatus, "w 60%");

        panelBtn = new JPanel();
        panelBtn.setBackground(new Color(255, 255, 255));
        panelBtn.setLayout(new MigLayout("wrap", "push[center]10[center]push"));
        addPanel.add(panelBtn, "width 60%, wrap");

        JButton btnAdd = new JButton();
        btnAdd.setText("Thêm nhà cung cấp");
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
                    String name = txtName.getText();
                    String address = txtAddress.getText();
                    String phone = txtPhone.getText();
                    String status = cbbStatus.getSelectedItem().toString();
                    boolean statusBool = false;
                    if (status.equals("Còn hoạt động"))
                        statusBool = true;
                    else
                        statusBool = false;

                    if (SuplierController.getInstance().addSuplier(id, name, address, phone, statusBool))
                    {
                        JOptionPane.showMessageDialog(null,
                                "Thêm sản phẩm thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Thêm sản phẩm thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
            java.util.logging.Logger.getLogger(AddSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSuplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel bg;
    // End of variables declaration//GEN-END:variables
}
