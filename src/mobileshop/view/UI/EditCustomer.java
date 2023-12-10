package mobileshop.view.UI;

import mobileshop.dao.CustomerCategoryDAO;
import mobileshop.dao.CustomerDAO;
import mobileshop.model.Customer;
import mobileshop.model.CustomerCategory;
import mobileshop.view.component.PanelCoverEditItem;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EditCustomer extends JFrame {

    private MigLayout layout;
    private PanelCoverEditItem cover;
    private JPanel addPanel;
    private JPanel panelBtn;
    private int fonsize = 14;
    private String idCustomer;
    private Customer customer;
    private ArrayList<CustomerCategory> listCate;

    public EditCustomer(String id) {
        initComponents();
        setTitle("Sửa thông tin khách hàng");
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.idCustomer = id;
        init();

    }
    
    private void init()
    {
        customer = CustomerDAO.getInstance().selectById(idCustomer);

        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverEditItem();
        addPanel = new JPanel();
        bg.setLayout(layout);
        addPanel.setBackground(new Color(255, 255, 255));
        
        addPanel.setLayout(new MigLayout("wrap", "push[center]push", "15[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]25"));

        JLabel id = new JLabel("Nhập mã khách hàng: ");
        id.setForeground(new Color(100, 100, 100));
        id.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(id, "w 60%");
        JTextField txtID = new JTextField();
        txtID.setFont(new Font("sansserif", 1, fonsize));
        txtID.setText(customer.getId());
        txtID.setEditable(false);
        addPanel.add(txtID, "wrap, width 60%");

        JLabel name = new JLabel("Nhập tên khách hàng: ");
        name.setForeground(new Color(100, 100, 100));
        name.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(name, "w 60%");
        JTextField txtName = new JTextField();
        txtName.setFont(new Font("sansserif", 1, fonsize));
        txtName.setText(customer.getName());
        addPanel.add(txtName, "wrap, width 60%");

        JLabel address = new JLabel("Nhập địa chỉ: ");
        address.setForeground(new Color(100, 100, 100));
        address.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(address, "w 60%");
        JTextField txtAddress = new JTextField();
        txtAddress.setFont(new Font("sansserif", 1, fonsize));
        txtAddress.setText(customer.getAddress());
        addPanel.add(txtAddress, "wrap, width 60%");

        JLabel gender = new JLabel("Nhập giới tính: ");
        gender.setForeground(new Color(100, 100, 100));
        gender.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(gender, "w 60%");
        JComboBox cbbGender = new JComboBox();
        cbbGender.setForeground(new Color(100, 100, 100));
        cbbGender.setFont(new Font("sansserif", 1, fonsize));
        cbbGender.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        cbbGender.setBackground(new Color(255, 255, 255));
        cbbGender.addItem("Nam");
        cbbGender.addItem("Nữ");
        if(customer.getGender() == true)
            cbbGender.setSelectedItem("Nam");
        else
            cbbGender.setSelectedItem("Nữ");
        addPanel.add(cbbGender, "w 60%");

        JLabel birth = new JLabel("Nhập sinh nhật: ");
        birth.setForeground(new Color(100, 100, 100));
        birth.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(birth, "w 60%");
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField txtBirth = new JFormattedTextField(formatDate);
        txtBirth.setFont(new Font("sansserif", 1, fonsize));
        txtBirth.setText(formatDate.format(customer.getBirthday()));
        addPanel.add(txtBirth, "wrap, width 60%");

        txtBirth.addKeyListener(new KeyAdapter() {
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

        JLabel phone = new JLabel("Nhập số điện thoại: ");
        phone.setForeground(new Color(100, 100, 100));
        phone.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(phone, "w 60%");
        JTextField txtPhone = new JTextField();
        txtPhone.setFont(new Font("sansserif", 1, fonsize));
        txtPhone.setText(customer.getPhone());
        addPanel.add(txtPhone, "wrap, width 60%");

        JLabel cate = new JLabel("Nhập loại khách hàng: ");
        cate.setForeground(new Color(100, 100, 100));
        cate.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(cate, "w 60%");
        JComboBox cbbCate = new JComboBox();
        cbbCate.setFont(new Font("sansserif", 1, fonsize));
        cbbCate.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        cbbCate.setBackground(new Color(255, 255, 255));
        listCate = CustomerCategoryDAO.getInstance().selectAll();
        try {
            for (CustomerCategory customerCategory : listCate) {
                cbbCate.addItem(customerCategory.getName());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        cbbCate.setSelectedItem(CustomerCategoryDAO.getInstance().selectById(customer.getIdCategory()).getName());
        addPanel.add(cbbCate, "wrap, width 60%");

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
                // update customer to database
                try{
                    customer.setName(txtName.getText());
                    customer.setAddress(txtAddress.getText());
                    if(cbbGender.getSelectedItem().toString().equals("Nam"))
                        customer.setGender(true);
                    else
                        customer.setGender(false);
                    java.util.Date invoiceDate = formatDate.parse(txtBirth.getText());
                    java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
                    customer.setBirthday(sqlDate);
                    customer.setPhone(txtPhone.getText());
                    for (CustomerCategory customerCategory : listCate) {
                        if (customerCategory.getName().equals(cbbCate.getSelectedItem().toString()))
                        {
                            customer.setIdCategory(customerCategory.getId());
                            break;
                        }
                    }
                    if(CustomerDAO.getInstance().update(customer) == 1) {
                        JOptionPane.showMessageDialog(null, "Sửa thông tin khách hàng thành công");
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Sửa thông tin khách hàng thất bại");
                } catch (Exception ex) {
                    System.out.println(ex);
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
