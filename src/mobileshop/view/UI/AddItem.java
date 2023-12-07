package mobileshop.view.UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import mobileshop.controller.ProductController;
import mobileshop.dao.ObjectCategoryDAO;
import mobileshop.model.ObjectCategory;
import mobileshop.view.component.PanelCoverAddItem;
import net.miginfocom.swing.MigLayout;

public class AddItem extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCoverAddItem cover;
    private JPanel addPanel;
    private int fonsize = 14;
    private ArrayList<ObjectCategory> listCate;
            
    public AddItem() {
        initComponents();
        setTitle("Thêm sản phẩm mới");
        initComponents();
        init();
    }
    
    private void init()
    {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverAddItem();
        addPanel = new JPanel();
        bg.setLayout(layout);
        addPanel.setLayout(new MigLayout("wrap", "push[center]push", "15[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]25"));
        addPanel.setBackground(new Color(255, 255, 255));

        JLabel id = new JLabel("Nhập mã sản phẩm: ");
        id.setForeground(new Color(100, 100, 100));
        id.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(id, "w 60%");
        JTextField txtID = new JTextField();
        txtID.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtID, "wrap, width 60%");
        
        JLabel name = new JLabel("Nhập tên sản phẩm: ");
        name.setForeground(new Color(100, 100, 100));
        name.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(name, "w 60%");
        JTextField txtName = new JTextField();
        txtName.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtName, "wrap, width 60%");
        
        JLabel status = new JLabel("Nhập trạng thái: ");
        status.setForeground(new Color(100, 100, 100));
        status.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(status, "w 60%");
        JTextField txtStatus = new JTextField();
        txtStatus.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtStatus, "wrap, width 60%");
        
        JLabel sx = new JLabel("Nhập nơi sản xuất: ");
        sx.setForeground(new Color(100, 100, 100));
        sx.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(sx, "w 60%");
        JTextField txtManufacturer = new JTextField();
        txtManufacturer.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtManufacturer, "wrap, width 60%");
        
        JLabel price = new JLabel("Nhập giá tiền: ");
        price.setForeground(new Color(100, 100, 100));
        price.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(price, "w 60%");
        JTextField txtPrice = new JTextField();
        txtPrice.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtPrice, "wrap, width 60%");
        
        JLabel cate = new JLabel("Nhập loại sản phẩm: ");
        cate.setForeground(new Color(100, 100, 100));
        cate.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(cate, "w 60%");
        JComboBox cbbCate = new JComboBox();
        cbbCate.setFont(new Font("sansserif", 1, fonsize));
        cbbCate.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        cbbCate.setBackground(new Color(255, 255, 255));
        listCate = ObjectCategoryDAO.getInstance().selectAll();
        try {
            for (ObjectCategory objectCategory : listCate) {
                cbbCate.addItem(objectCategory.getName());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        addPanel.add(cbbCate, "wrap, width 60%");
        
        JButton btnAdd = new JButton();
        btnAdd.setText("Thêm sản phẩm");
        btnAdd.setFont(new Font("sansserif", 1, fonsize));
        btnAdd.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(7, 164, 121));
        btnAdd.setMargin(new Insets(10,20,10,20));
        addPanel.add(btnAdd);
        
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

        bg.add(cover, "height 20%, width 100%, wrap");
        bg.add(addPanel, "height 80%, width 100%");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = txtID.getText();
                    String name = txtName.getText();
                    String status = txtStatus.getText();
                    String manufacturer = txtManufacturer.getText();
                    String price = txtPrice.getText();
                    String cate = cbbCate.getSelectedItem().toString();
                    for (ObjectCategory objectCategory : listCate) {
                        if (objectCategory.getName().equals(cate))
                        {
                            cate = objectCategory.getId();
                            break;
                        }
                    }
                    if (ProductController.getInstance().addProduct(id, name, status, manufacturer, price, cate))
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

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(false);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    // End of variables declaration//GEN-END:variables
}
