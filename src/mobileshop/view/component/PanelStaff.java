package mobileshop.view.component;

import mobileshop.controller.StaffController;
import mobileshop.dao.ObjectDAO;
import mobileshop.dao.StaffDAO;
import mobileshop.model.Object;
import mobileshop.model.Staff;
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

public class PanelStaff extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel fsPanel;
    private JPanel mainPanel;
    private JPanel addStaff;
    private JTable staff;
    private JScrollPane scrollPane;
    private JPanel search;
    private JPanel featureMenu;
    private ArrayList<Staff> staffs;

    public PanelStaff() {
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
        addStaff = new JPanel();

        search.setLayout(new MigLayout("fill, wrap", "[200][300][150]", "[75]"));
        search.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new MigLayout("wrap", "[1000]", "[1000]"));
        mainPanel.setBackground(new Color(255,255,255));
        fsPanel.setLayout(new MigLayout("fill, wrap", "[300][1000]", "[75]"));
        fsPanel.setBackground(new Color(255,255,255));
        addStaff.setLayout(new MigLayout("fill, wrap", "30[33.33%][33.33%][33.33%]30", "10[33.33%][33.33%][33.33%]10"));
        addStaff.setBackground(new Color(255,255,255));
        addStaff.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));

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
        area.addItem("Mã nhân viên");
        area.addItem("Địa chỉ");
        area.addItem("Giới tính");
        area.addItem("Quyền truy cập");
        area.addItem("Ca trực");
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
        String[] columnNames = {"Mã nhân viên", "Tên nhân viên","Mật khẩu", "Địa chỉ", "Giới tính", "Ngày sinh", "Số điện thoại", "Quyền truy cập","Ca trực"};
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        staffs = StaffDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (Staff staff : staffs) {
                model.addRow(new java.lang.Object[]{
                        staff.getId(),
                        staff.getName(),
                        staff.getPassword(),
                        staff.getAddress(),
                        staff.getGender() ? "Nam" : "Nữ",
                        staff.getBirthday(),
                        staff.getPhone(),
                        staff.getRole(),
                        staff.getIdShift()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        staff = new JTable(model);
        scrollPane = new JScrollPane(staff);
        scrollPane.setViewportView(staff);
        scrollPane.setSize(1000, 1000);

        staff.setForeground(new Color(100, 100, 100));
        staff.setFont(new Font("sansserif", 1, fontSize));
        staff.setRowHeight(30);
        staff.setFillsViewportHeight(true);
        staff.setBackground(new Color(255, 255, 255));
        staff.getTableHeader().setBackground(new Color(255, 255, 255));
        staff.getTableHeader().setForeground(new Color(100, 100, 100));
        staff.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) staff.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        staff.getTableHeader().setDefaultRenderer(renderer);
        staff.getTableHeader().setReorderingAllowed(false);
        staff.getTableHeader().setResizingAllowed(false);
        staff.getColumn("Tên nhân viên").setPreferredWidth(150);

        mainPanel.add(scrollPane, "grow");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Add staff">
        JPanel id = new JPanel();
        id.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        id.setBackground(new Color(255,255,255));
        id.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mã nhân viên", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField idText = new JTextField();
        idText.setFont(new Font("sansserif", 1, 14));
        idText.setForeground(new Color(0, 0, 0));
        idText.setBackground(new Color(255, 255, 255));
        idText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        idText.setBorder(null);
        id.add(idText, "grow");
        addStaff.add(id, "grow");

        JPanel name = new JPanel();
        name.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        name.setBackground(new Color(255,255,255));
        name.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tên nhân viên", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField nameText = new JTextField();
        nameText.setFont(new Font("sansserif", 1, 14));
        nameText.setForeground(new Color(0, 0, 0));
        nameText.setBackground(new Color(255, 255, 255));
        nameText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        nameText.setBorder(null);
        name.add(nameText, "grow");
        addStaff.add(name, "grow");

        JPanel pass = new JPanel();
        pass.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        pass.setBackground(new Color(255,255,255));
        pass.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mật khẩu", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JTextField passText = new JTextField();
        passText.setFont(new Font("sansserif", 1, 14));
        passText.setForeground(new Color(0, 0, 0));
        passText.setBackground(new Color(255, 255, 255));
        passText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        passText.setBorder(null);
        pass.add(passText, "grow");
        addStaff.add(pass, "grow");

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
        addStaff.add(address, "grow");

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
        addStaff.add(sex, "grow");

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
        addStaff.add(birthday, "grow");

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
        addStaff.add(phone, "grow");

        JPanel role = new JPanel();
        role.setLayout(new MigLayout("fill, wrap", "[100][100]", "[50]"));
        role.setBackground(new Color(255,255,255));
        role.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Quyền truy cập", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        ButtonGroup roleGroup = new ButtonGroup();
        JRadioButton admin = new JRadioButton("Admin");
        admin.setFont(new Font("sansserif", 1, 14));
        admin.setForeground(new Color(0, 0, 0));
        admin.setBackground(new Color(255, 255, 255));
        admin.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        admin.setBorder(null);
        JRadioButton user = new JRadioButton("User");
        user.setFont(new Font("sansserif", 1, 14));
        user.setForeground(new Color(0, 0, 0));
        user.setBackground(new Color(255, 255, 255));
        user.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        user.setBorder(null);
        roleGroup.add(admin);
        roleGroup.add(user);
        role.add(admin,"grow");
        role.add(user,"grow");
        addStaff.add(role, "grow");

        JPanel shift = new JPanel();
        shift.setLayout(new MigLayout("fill, wrap", "[200]", "[50]"));
        shift.setBackground(new Color(255,255,255));
        shift.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ca trực", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 14), new Color(0, 0, 0)));
        JComboBox shiftText = new JComboBox();
        shiftText.setFont(new Font("sansserif", 1, 14));
        shiftText.setForeground(new Color(0, 0, 0));
        shiftText.setBackground(new Color(255, 255, 255));
        shiftText.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        shiftText.setBorder(null);
        shiftText.addItem("Ca 1");
        shiftText.addItem("Ca 2");
        shiftText.addItem("Ca 3");
        shift.add(shiftText, "grow");
        addStaff.add(shift, "grow");

        //</editor-fold>

        add(fsPanel, "width 100%, height 20%, wrap");
        add(addStaff, "width 100%, height 20%, wrap");
        add(mainPanel, "width 100%, height 60%, wrap");
        fsPanel.add(featureMenu, "width 30%, pos 0al 0 n 100%");
        fsPanel.add(search, "width 68%, pos 1al 0 n 100%");

        //<editor-fold defaultstate="collapsed" desc="Event">
        staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = staff.getSelectedRow();
                if(row == -1) {
                    return;
                }
                idText.setText(staff.getValueAt(row, 0).toString());
                nameText.setText(staff.getValueAt(row, 1).toString());
                passText.setText(staff.getValueAt(row, 2).toString());
                addressText.setText(staff.getValueAt(row, 3).toString());
                if(staff.getValueAt(row, 4).toString().equals("Nam")) {
                    mail.setSelected(true);
                } else {
                    femail.setSelected(true);
                }
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                birthdayText.setText(format.format(staff.getValueAt(row, 5)));
                phoneText.setText(staff.getValueAt(row, 6).toString());
                if(staff.getValueAt(row, 7).toString().equals("true")) {
                    admin.setSelected(true);
                } else {
                    user.setSelected(true);
                }
                if(staff.getValueAt(row, 8).toString().equals("WS1")) {
                    shiftText.setSelectedIndex(0);
                } else if(staff.getValueAt(row, 8).toString().equals("WS2")) {
                    shiftText.setSelectedIndex(1);
                } else {
                    shiftText.setSelectedIndex(2);
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idText.getText().toString();
                    String name = nameText.getText().toString();
                    String password = passText.getText().toString();
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
                    Boolean role = false;
                    if (admin.isSelected()) {
                        role = true;
                    } else {
                        role = false;
                    }
                    String shift;
                    if(shiftText.getSelectedIndex() == 0) {
                        shift = "WS1";
                    } else if(shiftText.getSelectedIndex() == 1) {
                        shift = "WS2";
                    } else {
                        shift = "WS3";
                    }

                    if(StaffController.getInstance().addStaff(id, name, password, address, gender, sqlBirthday, phone, role, shift)) {
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
                if(staff.getSelectedRow() >= 0) {
                    int row = staff.getSelectedRow();
                    if(row == -1) {
                        return;
                    }
                    String id = staff.getValueAt(row, 0).toString();
                    if(StaffController.getInstance().deleteStaffById(id)){
                        staffs = StaffDAO.getInstance().selectAll();
                        try {
                            model.setRowCount(0);
                            for (Staff staff1 : staffs) {
                                model.addRow(new java.lang.Object[]{
                                        staff1.getId(),
                                        staff1.getName(),
                                        staff1.getPassword(),
                                        staff1.getAddress(),
                                        staff1.getGender() ? "Nam" : "Nữ",
                                        staff1.getBirthday(),
                                        staff1.getPhone(),
                                        staff1.getRole(),
                                        staff1.getIdShift()
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
                    String password = passText.getText().toString();
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
                    Boolean role = false;
                    if (admin.isSelected()) {
                        role = true;
                    } else {
                        role = false;
                    }
                    String shift;
                    if(shiftText.getSelectedIndex() == 0) {
                        shift = "WS1";
                    } else if(shiftText.getSelectedIndex() == 1) {
                        shift = "WS2";
                    } else {
                        shift = "WS3";
                    }
                    if(StaffController.getInstance().updateStaff(id, name, password, address, gender, sqlBirthday, phone, role, shift)) {
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
                staffs = StaffDAO.getInstance().selectAll();
                String textSearch = text.getText();
                String areaSearch = area.getSelectedItem().toString();
                Boolean check = false;
                if (areaSearch.equals("Tất cả")) {
                   try {
                        model.setRowCount(0);
                        for (Staff staff1 : staffs) {
                            model.addRow(new java.lang.Object[]{
                                    staff1.getId(),
                                    staff1.getName(),
                                    staff1.getPassword(),
                                    staff1.getAddress(),
                                    staff1.getGender() ? "Nam" : "Nữ",
                                    staff1.getBirthday(),
                                    staff1.getPhone(),
                                    staff1.getRole(),
                                    staff1.getIdShift()
                            });
                        }
                   } catch (Exception ex) {
                        System.out.println(ex);
                   }
                }
                else if (areaSearch.equals("Mã nhân viên")) {
                    try {
                        model.setRowCount(0);
                        for (Staff staff1 : staffs) {
                            if (staff1.getId().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        staff1.getId(),
                                        staff1.getName(),
                                        staff1.getPassword(),
                                        staff1.getAddress(),
                                        staff1.getGender() ? "Nam" : "Nữ",
                                        staff1.getBirthday(),
                                        staff1.getPhone(),
                                        staff1.getRole(),
                                        staff1.getIdShift()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (areaSearch.equals("Địa chỉ")) {
                    try {
                        model.setRowCount(0);
                        for (Staff staff1 : staffs) {
                            if (staff1.getAddress().toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        staff1.getId(),
                                        staff1.getName(),
                                        staff1.getPassword(),
                                        staff1.getAddress(),
                                        staff1.getGender() ? "Nam" : "Nữ",
                                        staff1.getBirthday(),
                                        staff1.getPhone(),
                                        staff1.getRole(),
                                        staff1.getIdShift()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (areaSearch.equals("Giới tính")) {
                    try {
                        model.setRowCount(0);
                        for (Staff staff1 : staffs) {
                            String gender = staff1.getGender() ? "Nam" : "Nữ";
                            if (gender.toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        staff1.getId(),
                                        staff1.getName(),
                                        staff1.getPassword(),
                                        staff1.getAddress(),
                                        staff1.getGender() ? "Nam" : "Nữ",
                                        staff1.getBirthday(),
                                        staff1.getPhone(),
                                        staff1.getRole(),
                                        staff1.getIdShift()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (areaSearch.equals("Quyền truy cập")) {
                    try {
                        model.setRowCount(0);
                        for (Staff staff1 : staffs) {
                            String role = staff1.getRole() ? "Admin" : "User";
                            if (role.toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        staff1.getId(),
                                        staff1.getName(),
                                        staff1.getPassword(),
                                        staff1.getAddress(),
                                        staff1.getGender() ? "Nam" : "Nữ",
                                        staff1.getBirthday(),
                                        staff1.getPhone(),
                                        staff1.getRole(),
                                        staff1.getIdShift()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            check = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else if (areaSearch.equals("Ca trực")) {
                    try {
                        model.setRowCount(0);
                        for (Staff staff1 : staffs) {
                            String shift = staff1.getIdShift();
                            if (shift.toLowerCase().contains("ws1")) {
                                shift = "Ca 1";
                            }
                            else if (shift.toLowerCase().contains("ws2")) {
                                shift = "Ca 2";
                            }
                            else if (shift.toLowerCase().contains("ws3")){
                                shift = "Ca 3";
                            }
                            if (shift.toLowerCase().contains(textSearch.toLowerCase())) {
                                model.addRow(new java.lang.Object[]{
                                        staff1.getId(),
                                        staff1.getName(),
                                        staff1.getPassword(),
                                        staff1.getAddress(),
                                        staff1.getGender() ? "Nam" : "Nữ",
                                        staff1.getBirthday(),
                                        staff1.getPhone(),
                                        staff1.getRole(),
                                        staff1.getIdShift()
                                });
                                check = true;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên",
                                    "Error", JOptionPane.ERROR_MESSAGE);
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
        staffs = StaffDAO.getInstance().selectAll();
        DefaultTableModel model = (DefaultTableModel) staff.getModel();
        try {
            model.setRowCount(0);
            for (Staff staff1 : staffs) {
                model.addRow(new java.lang.Object[]{
                        staff1.getId(),
                        staff1.getName(),
                        staff1.getPassword(),
                        staff1.getAddress(),
                        staff1.getGender() ? "Nam" : "Nữ",
                        staff1.getBirthday(),
                        staff1.getPhone(),
                        staff1.getRole(),
                        staff1.getIdShift()
                });
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
