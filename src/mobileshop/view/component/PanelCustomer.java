package mobileshop.view.component;

import mobileshop.controller.CustomerController;
import mobileshop.controller.StaffController;
import mobileshop.dao.CustomerCategoryDAO;
import mobileshop.dao.CustomerDAO;
import mobileshop.dao.ObjectDAO;
import mobileshop.model.Customer;
import mobileshop.model.CustomerCategory;
import mobileshop.model.Object;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static java.awt.Frame.HAND_CURSOR;

public class PanelCustomer extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel fsPanel;
    private JPanel mainPanel;
    private JTable customer;
    private JPanel addCustomer;
    private JScrollPane scrollPane;
    private JPanel search;
    private JPanel featureMenu;
    private ArrayList<Customer> customers;
    private ArrayList<CustomerCategory> listCate;

    public PanelCustomer() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("fill, wrap", "[grow]", "[grow][grow][grow]");
        setLayout(layout);
        init();
        setVisible(true);
    }
    
    private void init() {
        mainPanel = new JPanel();
        fsPanel = new JPanel();
        search = new JPanel();
        featureMenu = new JPanel();
        addCustomer = new JPanel();

        search.setLayout(new MigLayout("fill, wrap", "[200][300][150]", "[75]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap", "[1000]", "[1000]"));
        mainPanel.setBackground(new Color(255,255,255));
        fsPanel.setLayout(new MigLayout("fill, wrap", "[300][1000]", "[75]"));
        fsPanel.setBackground(new Color(255,255,255));
        addCustomer.setLayout(new MigLayout("fill, wrap", "30[33.33%][33.33%][33.33%]30", "10[33.33%][33.33%][33.33%]10"));
        addCustomer.setBackground(new Color(255,255,255));
        addCustomer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));


        //<editor-fold defaultstate="collapsed" desc="Menu">
        featureMenu.setLayout(new MigLayout("fill, wrap", "[100][100][100]", "[75]"));
        featureMenu.setBackground(new Color(255,255,255));
        featureMenu.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));

        JButton btnAdd = new JButton();
        btnAdd.setFont(new Font("sansserif", 1, 14));
        btnAdd.setForeground(new Color(0, 0, 0));
        btnAdd.setBackground(new Color(255, 255, 255));
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnAdd.setText("Thêm");
        btnAdd.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_add_40px.png")));
        btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnAdd, "grow");

        JButton btnDel = new JButton();
        btnDel.setFont(new Font("sansserif", 1, 14));
        btnDel.setForeground(new Color(0, 0, 0));
        btnDel.setBackground(new Color(255, 255, 255));
        btnDel.setBorderPainted(false);
        btnDel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnDel.setText("Xóa");
        btnDel.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_delete_40px.png")));
        btnDel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDel.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnDel, "grow");

        JButton btnEdit = new JButton();
        btnEdit.setFont(new Font("sansserif", 1, 14));
        btnEdit.setForeground(new Color(0, 0, 0));
        btnEdit.setBackground(new Color(255, 255, 255));
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        btnEdit.setText("Sửa");
        btnEdit.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_edit_40px.png")));
        btnEdit.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEdit.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
        featureMenu.add(btnEdit, "grow");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Search">
        search.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));

        JComboBox area = new JComboBox();
        area.setFont(new Font("sansserif", 1, 14));
        area.setForeground(new Color(0, 0, 0));
        area.setBackground(new Color(255, 255, 255));
        area.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        area.addItem("Tất cả");
        area.addItem("Mã khách hàng");
        area.addItem("Giới tính");
        area.addItem("Ngày sinh");
        area.addItem("Mã loại khách hàng");
        area.setBorder(null);
        search.add(area,"grow");

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
        String[] columnNames = {"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Giới tính", "Ngày sinh", "Số điện thoại", "Loại khách hàng"};
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        customers = CustomerDAO.getInstance().selectAll();
        listCate = CustomerCategoryDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (Customer customer : customers) {
                model.addRow(new java.lang.Object[]{
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getGender() ? "Nam" : "Nữ",
                        customer.getBirthday(),
                        customer.getPhone(),
                        customer.getIdCategory()
                });

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        customer = new JTable(model);
        scrollPane = new JScrollPane(customer);
        scrollPane.setViewportView(customer);

        customer.setForeground(new Color(100, 100, 100));
        customer.setFont(new Font("sansserif", 1, fontSize));
        customer.setRowHeight(30);
        customer.setFillsViewportHeight(true);
        customer.setBackground(new Color(255, 255, 255));
        customer.getTableHeader().setBackground(new Color(255, 255, 255));
        customer.getTableHeader().setForeground(new Color(100, 100, 100));
        customer.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) customer.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        customer.getTableHeader().setDefaultRenderer(renderer);
        customer.getTableHeader().setReorderingAllowed(false);
        customer.getTableHeader().setResizingAllowed(false);

        mainPanel.add(scrollPane, "w 100%, h 100%");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Add customer">
        JPanel id = new JPanel();
        id.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        id.setBackground(new Color(255,255,255));
        id.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã khách hàng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField idText = new JTextField();
        idText.setFont(new Font("sansserif", 1, 14));
        idText.setForeground(new Color(0, 0, 0));
        idText.setBackground(new Color(255, 255, 255));
        idText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idText.setBorder(null);
        id.add(idText, "grow");
        addCustomer.add(id, "grow");

        JPanel name = new JPanel();
        name.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        name.setBackground(new Color(255,255,255));
        name.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tên khách hàng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField nameText = new JTextField();
        nameText.setFont(new Font("sansserif", 1, 14));
        nameText.setForeground(new Color(0, 0, 0));
        nameText.setBackground(new Color(255, 255, 255));
        nameText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        nameText.setBorder(null);
        name.add(nameText, "grow");
        addCustomer.add(name, "grow");

        JPanel address = new JPanel();
        address.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        address.setBackground(new Color(255,255,255));
        address.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Địa chỉ", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField addressText = new JTextField();
        addressText.setFont(new Font("sansserif", 1, 14));
        addressText.setForeground(new Color(0, 0, 0));
        addressText.setBackground(new Color(255, 255, 255));
        addressText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        addressText.setBorder(null);
        address.add(addressText, "grow");
        addCustomer.add(address, "grow");

        JPanel sex = new JPanel();
        sex.setLayout(new MigLayout("fill, wrap", "[100][100]", "[50]"));
        sex.setBackground(new Color(255,255,255));
        sex.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Giới tính", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        ButtonGroup group = new ButtonGroup();
        JRadioButton mail = new JRadioButton("Nam");
        mail.setFont(new Font("sansserif", 1, 14));
        mail.setForeground(new Color(0, 0, 0));
        mail.setBackground(new Color(255, 255, 255));
        mail.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        mail.setBorder(null);
        JRadioButton femail = new JRadioButton("Nữ");
        femail.setFont(new Font("sansserif", 1, 14));
        femail.setForeground(new Color(0, 0, 0));
        femail.setBackground(new Color(255, 255, 255));
        femail.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        femail.setBorder(null);
        group.add(mail);
        group.add(femail);
        sex.add(mail, "grow");
        sex.add(femail, "grow");
        addCustomer.add(sex, "grow");

        JPanel birthday = new JPanel();
        birthday.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        birthday.setBackground(new Color(255,255,255));
        birthday.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ngày sinh (dd/MM/yyyy)", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField birthdayText = new JFormattedTextField(format);
        birthdayText.setFont(new Font("sansserif", 1, 14));
        birthdayText.setForeground(new Color(0, 0, 0));
        birthdayText.setBackground(new Color(255, 255, 255));
        birthdayText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        birthdayText.setBorder(null);
        birthday.add(birthdayText, "grow");
        addCustomer.add(birthday, "grow");

        birthdayText.addKeyListener(new KeyAdapter() {
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

        JPanel phone = new JPanel();
        phone.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        phone.setBackground(new Color(255,255,255));
        phone.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Số điện thoại", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField phoneText = new JTextField();
        phoneText.setFont(new Font("sansserif", 1, 14));
        phoneText.setForeground(new Color(0, 0, 0));
        phoneText.setBackground(new Color(255, 255, 255));
        phoneText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        phoneText.setBorder(null);
        phone.add(phoneText, "grow");
        addCustomer.add(phone, "grow");

        JPanel idCategory = new JPanel();
        idCategory.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        idCategory.setBackground(new Color(255,255,255));
        idCategory.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã loại khách hàng", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JComboBox cbbCate = new JComboBox();
        cbbCate.setFont(new Font("sansserif", 1, 14));
        cbbCate.setForeground(new Color(0, 0, 0));
        cbbCate.setBackground(new Color(255, 255, 255));
        cbbCate.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        cbbCate.setBorder(null);
        idCategory.add(cbbCate, "grow");
        listCate = CustomerCategoryDAO.getInstance().selectAll();
        try {
            for (CustomerCategory customerCategory : listCate) {
                cbbCate.addItem(customerCategory.getName());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        addCustomer.add(idCategory, "grow");

        //</editor-fold>

        add(fsPanel, "width 100%, height 20%, wrap");
        add(addCustomer, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 60%, wrap");
        fsPanel.add(featureMenu, "width 30%, pos 0al 0 n 100%");
        fsPanel.add(search, "width 68%, pos 1al 0 n 100%");

        //<editor-fold defaultstate="collapsed" desc="Event">
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = customer.getSelectedRow();
                if(row == -1) {
                    return;
                }
                idText.setText(customer.getValueAt(row, 0).toString());
                nameText.setText(customer.getValueAt(row, 1).toString());
                addressText.setText(customer.getValueAt(row, 2).toString());
                if(customer.getValueAt(row, 3).toString().equals("Nam")) {
                    mail.setSelected(true);
                } else {
                    femail.setSelected(true);
                }
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                birthdayText.setText(format.format(customer.getValueAt(row, 4)));
                phoneText.setText(customer.getValueAt(row, 5).toString());
                listCate = CustomerCategoryDAO.getInstance().selectAll();
                try {
                    for (CustomerCategory customerCategory : listCate) {
                        if (customerCategory.getId().equals(customer.getValueAt(row, 6).toString())) {
                            cbbCate.setSelectedItem(customerCategory.getName());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText().toString();
                    String name = nameText.getText().toString();
                    String address = addressText.getText().toString();
                    Boolean gender = false;
                    if (mail.isSelected()) {
                        gender = true;
                    } else {
                        gender = false;
                    }
                    java.util.Date invoiceDate = format.parse(birthdayText.getText());
                    java.sql.Date sqlBirthday = new java.sql.Date(invoiceDate.getTime());
                    String phone = phoneText.getText();
                    String cate = cbbCate.getSelectedItem().toString();
                    for (CustomerCategory objectCategory : listCate) {
                        if (objectCategory.getName().equals(cate))
                        {
                            cate = objectCategory.getId();
                            break;
                        }
                    }
                    if(CustomerController.getInstance().addCustomer(id, name, address, gender, sqlBirthday, phone, cate)) {
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
                if(customer.getSelectedRow() >= 0) {
                    int row = customer.getSelectedRow();
                    if(row == -1) {
                        return;
                    }
                    String id = customer.getValueAt(row, 0).toString();
                    if(CustomerController.getInstance().deleteCustomerById(id)){
                        customers = CustomerDAO.getInstance().selectAll();
                        try {
                            model.setRowCount(0);
                            for (Customer cus : customers) {
                                model.addRow(new java.lang.Object[]{
                                        cus.getId(),
                                        cus.getName(),
                                        cus.getAddress(),
                                        cus.getGender() ? "Nam" : "Nữ",
                                        cus.getBirthday(),
                                        cus.getPhone(),
                                        cus.getIdCategory()
                                });
                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
                reloadTable();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText().toString();
                    String name = nameText.getText().toString();
                    String address = addressText.getText().toString();
                    Boolean gender = false;
                    if (mail.isSelected()) {
                        gender = true;
                    } else {
                        gender = false;
                    }
                    java.util.Date invoiceDate = format.parse(birthdayText.getText());
                    java.sql.Date sqlBirthday = new java.sql.Date(invoiceDate.getTime());
                    String phone = phoneText.getText();
                    String cate = cbbCate.getSelectedItem().toString();
                    for (CustomerCategory objectCategory : listCate) {
                        if (objectCategory.getName().equals(cate))
                        {
                            cate = objectCategory.getId();
                            break;
                        }
                    }
                    if(CustomerController.getInstance().updateCustomer(id, name, address, gender, sqlBirthday, phone, cate)) {
                    }
                } catch (HeadlessException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                reloadTable();
            };
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
                customers = CustomerDAO.getInstance().selectAll();
                String Text = text.getText();
                String Area = area.getSelectedItem().toString();
                boolean check = false;
                if (Area == "Tất cả") {
                    try {
                        model.setRowCount(0);
                        for (Customer customer : customers) {
                            model.addRow(new java.lang.Object[]{
                                    customer.getId(),
                                    customer.getName(),
                                    customer.getAddress(),
                                    customer.getGender() ? "Nam" : "Nữ",
                                    customer.getBirthday(),
                                    customer.getPhone(),
                                    customer.getIdCategory()
                            });
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (Area == "Mã khách hàng") {
                    try {
                        model.setRowCount(0);
                        for (Customer customer : customers) {
                            if (customer.getId().toLowerCase().contains(Text.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        customer.getId(),
                                        customer.getName(),
                                        customer.getAddress(),
                                        customer.getGender() ? "Nam" : "Nữ",
                                        customer.getBirthday(),
                                        customer.getPhone(),
                                        customer.getIdCategory()
                                });
                                check = true;
                            }
                        }
                        if (check == false) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (Area == "Giới tính") {
                    try {
                        model.setRowCount(0);
                        for (Customer customer : customers) {
                            if (customer.getGender() == true) {
                                if ("Nam".toLowerCase().contains(Text.toLowerCase())) {
                                    model.addRow(new java.lang.Object[]{
                                            customer.getId(),
                                            customer.getName(),
                                            customer.getAddress(),
                                            customer.getGender() ? "Nam" : "Nữ",
                                            customer.getBirthday(),
                                            customer.getPhone(),
                                            customer.getIdCategory()
                                    });
                                    check = true;
                                }
                            } else {
                                if ("Nữ".toLowerCase().contains(Text.toLowerCase())) {
                                    model.addRow(new java.lang.Object[]{
                                            customer.getId(),
                                            customer.getName(),
                                            customer.getAddress(),
                                            customer.getGender() ? "Nam" : "Nữ",
                                            customer.getBirthday(),
                                            customer.getPhone(),
                                            customer.getIdCategory()
                                    });
                                    check = true;
                                }
                            }
                        }
                        if (check == false) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (Area == "Ngày sinh") {
                    try {
                        model.setRowCount(0);
                        for (Customer customer : customers) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            String date = sdf.format(customer.getBirthday());
                            if (date.toLowerCase().contains(Text.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        customer.getId(),
                                        customer.getName(),
                                        customer.getAddress(),
                                        customer.getGender() ? "Nam" : "Nữ",
                                        customer.getBirthday(),
                                        customer.getPhone(),
                                        customer.getIdCategory()
                                });
                                check = true;
                            }
                        }
                        if (check == false) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else if (Area == "Mã loại khách hàng") {
                    try {
                        model.setRowCount(0);
                        for (Customer customer : customers) {
                            if (customer.getIdCategory().toLowerCase().contains(Text.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        customer.getId(),
                                        customer.getName(),
                                        customer.getAddress(),
                                        customer.getGender() ? "Nam" : "Nữ",
                                        customer.getBirthday(),
                                        customer.getPhone(),
                                        customer.getIdCategory()
                                });
                                check = true;
                            }
                        }
                        if (check == false) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!", "Error", JOptionPane.ERROR_MESSAGE);
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
        customers = CustomerDAO.getInstance().selectAll();
        DefaultTableModel model = (DefaultTableModel) customer.getModel();
        try {
            model.setRowCount(0);
            for (Customer customer1 : customers) {
                model.addRow(new java.lang.Object[]{
                        customer1.getId(),
                        customer1.getName(),
                        customer1.getAddress(),
                        customer1.getGender() ? "Nam" : "Nữ",
                        customer1.getBirthday(),
                        customer1.getPhone(),
                        customer1.getIdCategory()
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
