package mobileshop.view.UI;

import mobileshop.dao.ObjectDAO;
import mobileshop.dao.SuplierDAO;
import mobileshop.model.ObjectCategory;
import mobileshop.model.Suplier;
import mobileshop.view.component.PanelCoverEditItem;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditSuplier extends JFrame {

    private MigLayout layout;
    private PanelCoverEditItem cover;
    private JPanel addPanel;
    private JPanel panelBtn;
    private int fonsize = 14;
    private String idSuplier;
    private Suplier suplier;
    private ArrayList<ObjectCategory> listCate;

    public EditSuplier(String id) {
        initComponents();
        setTitle("Sửa thông tin nhà cung cấp");
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.idSuplier = id;
        init();

    }
    
    private void init()
    {
        suplier = SuplierDAO.getInstance().selectById(idSuplier);

        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverEditItem();
        addPanel = new JPanel();
        bg.setLayout(layout);
        addPanel.setBackground(new Color(255, 255, 255));
        
        addPanel.setLayout(new MigLayout("wrap", "push[center]push", "15[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]25"));

        JLabel id = new JLabel("Mã nhà cung cấp: ");
        id.setForeground(new Color(100, 100, 100));
        id.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(id, "w 60%");
        JTextField txtInfo = new JTextField();
        txtInfo.setFont(new Font("sansserif", 1, fonsize));
        txtInfo.setText(suplier.getId());
        txtInfo.setEditable(false);
        addPanel.add(txtInfo, "wrap, width 60%");
        
        JLabel name = new JLabel("Tên nhà cung cấp: ");
        name.setForeground(new Color(100, 100, 100));
        name.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(name, "w 60%");
        JTextField txtName = new JTextField();
        txtName.setFont(new Font("sansserif", 1, fonsize));
        txtName.setText(suplier.getName());
        addPanel.add(txtName, "wrap, width 60%");

        JLabel address = new JLabel("Địa chỉ nhà cung cấp: ");
        address.setForeground(new Color(100, 100, 100));
        address.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(address, "w 60%");
        JTextField txtAddress = new JTextField();
        txtAddress.setFont(new Font("sansserif", 1, fonsize));
        txtAddress.setText(suplier.getAddress());
        addPanel.add(txtAddress, "wrap, width 60%");
        
        JLabel phone = new JLabel("Nhập số điện thoại: ");
        phone.setForeground(new Color(100, 100, 100));
        phone.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(phone, "w 60%");
        JTextField txtPhone = new JTextField();
        txtPhone.setFont(new Font("sansserif", 1, fonsize));
        txtPhone.setText(suplier.getPhoneNumber());
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
        cbbStatus.addItem("Hết hoạt động");
        if(suplier.getStatus())
            cbbStatus.setSelectedItem("Còn hoạt động".toString());
        else
            cbbStatus.setSelectedItem("Hết hoạt động");
        addPanel.add(cbbStatus, "w 60%");

        panelBtn = new JPanel();
        panelBtn.setBackground(new Color(255, 255, 255));
        panelBtn.setLayout(new MigLayout("wrap", "push[center]10[center]push"));
        addPanel.add(panelBtn, "width 60%, wrap");

        JButton btnEdit = new JButton();
        btnEdit.setText("Sửa thông tin");
        btnEdit.setFont(new Font("sansserif", 1, fonsize));
        btnEdit.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnEdit.setForeground(new Color(255, 255, 255));
        btnEdit.setBackground(new Color(7, 164, 121));
        btnEdit.setMargin(new Insets(10,20,10,20));
        panelBtn.add(btnEdit);

        JButton btnCancel = new JButton();
        btnCancel.setText("Hủy");
        btnCancel.setFont(new Font("sansserif", 1, fonsize));
        btnCancel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnCancel.setForeground(new Color(255, 255, 255));
        btnCancel.setBackground(new Color(225, 35, 35));
        btnCancel.setMargin(new Insets(10,20,10,20));
        panelBtn.add(btnCancel);
        
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
                suplier.setName(txtName.getText());
                if(cbbStatus.getSelectedItem().toString() == "Còn hoạt động")
                    suplier.setStatus(true);
                else
                    suplier.setStatus(false);
                suplier.setAddress(txtAddress.getText());
                suplier.setPhoneNumber(txtPhone.getText());
                if(SuplierDAO.getInstance().update(suplier) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Sửa thông tin sản phẩm thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Sửa thông tin sản phẩm thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
