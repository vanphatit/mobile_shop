package mobileshop.view.UI;

import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import mobileshop.dao.ObjectCategoryDAO;
import mobileshop.dao.ObjectDAO;
import mobileshop.model.Object;
import mobileshop.model.ObjectCategory;
import mobileshop.view.component.PanelCoverEditItem;
import net.miginfocom.swing.MigLayout;

public class editItem extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCoverEditItem cover;
    private JPanel addPanel;
    private int fonsize = 14;
    private String idObject;
    private Object object;
    private ArrayList<ObjectCategory> listCate;
            
    public editItem(String id) {
        initComponents();
        setTitle("Sửa thông tin sản  phẩm");
        initComponents();

        this.idObject = id;
        init();

    }
    
    private void init()
    {
        object = ObjectDAO.getInstance().selectById(idObject);

        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverEditItem();
        addPanel = new JPanel();
        bg.setLayout(layout);
        addPanel.setBackground(new Color(255, 255, 255));
        
        addPanel.setLayout(new MigLayout("wrap", "push[center]push", "15[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]25"));

        JLabel id = new JLabel("Mã sản phẩm: ");
        id.setForeground(new Color(100, 100, 100));
        id.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(id, "w 60%");
        JTextField txtInfo = new JTextField();
        txtInfo.setFont(new Font("sansserif", 1, fonsize));
        txtInfo.setText(object.getId());
        txtInfo.setEnabled(false);
        addPanel.add(txtInfo, "wrap, width 60%");
        
        JLabel name = new JLabel("Tên sản phẩm: ");
        name.setForeground(new Color(100, 100, 100));
        name.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(name, "w 60%");
        JTextField txtName = new JTextField();
        txtName.setFont(new Font("sansserif", 1, fonsize));
        txtName.setText(object.getName());
        addPanel.add(txtName, "wrap, width 60%");

        JLabel status = new JLabel("Nhập trạng thái: ");
        status.setForeground(new Color(100, 100, 100));
        status.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(status, "w 60%");
        JComboBox cbbStatus = new JComboBox();
        cbbStatus.setForeground(new Color(100, 100, 100));
        cbbStatus.setFont(new Font("sansserif", 1, fonsize));
        cbbStatus.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        cbbStatus.setBackground(new Color(255, 255, 255));
        cbbStatus.addItem("Còn hàng");
        cbbStatus.addItem("Hết hàng");
        cbbStatus.setSelectedItem(object.getStatus());
        addPanel.add(cbbStatus, "w 60%");
        
        JLabel sx = new JLabel("Nhập nơi sản xuất: ");
        sx.setForeground(new Color(100, 100, 100));
        sx.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(sx, "w 60%");
        JTextField txtSx = new JTextField();
        txtSx.setFont(new Font("sansserif", 1, fonsize));
        txtSx.setText(object.getManufacturer());
        addPanel.add(txtSx, "wrap, width 60%");
        
        JLabel price = new JLabel("Nhập giá tiền: ");
        price.setForeground(new Color(100, 100, 100));
        price.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(price, "w 60%");
        JTextField txtPrice = new JTextField();
        txtPrice.setFont(new Font("sansserif", 1, fonsize));
        txtPrice.setText(String.valueOf(object.getUnitPrice()));
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
        cbbCate.setSelectedItem(object.getIdCategory());
        addPanel.add(cbbCate, "wrap, width 60%");
        
        JButton btnEdit = new JButton();
        btnEdit.setText("Sửa thông tin");
        btnEdit.setFont(new Font("sansserif", 1, fonsize));
        btnEdit.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnEdit.setForeground(new Color(255, 255, 255));
        btnEdit.setBackground(new Color(7, 164, 121));
        btnEdit.setMargin(new Insets(10,20,10,20));
        addPanel.add(btnEdit);
        
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
        
        bg.add(cover, "height 20%, width 100%, wrap");
        bg.add(addPanel, "height 80%, width 100%");

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                object.setName(txtName.getText());
                object.setStatus(cbbStatus.getSelectedItem().toString());
                object.setManufacturer(txtSx.getText());
                object.setUnitPrice(Integer.parseInt(txtPrice.getText()));
                for (ObjectCategory objectCategory : listCate) {
                    if (objectCategory.getName().equals(cbbCate.getSelectedItem().toString()))
                    {
                        object.setIdCategory(objectCategory.getId());
                        break;
                    }
                }
                if(ObjectDAO.getInstance().update(object) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Sửa thông tin sản phẩm thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Sửa thông tin sản phẩm thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    // End of variables declaration//GEN-END:variables
}
