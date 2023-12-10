package mobileshop.view.component;

import mobileshop.dao.*;
import mobileshop.model.*;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Frame.HAND_CURSOR;

public class PanelStatistics extends JPanel {

    private MigLayout layout;
    private int fontSize = 16;
    private JPanel mainPanel;
    private JPanel statisticsPanel;
    private JPanel productPanel;
    private JPanel countProductPanel;
    private JLabel productLabel;
    private JPanel supplierPanel;
    private JPanel countSupplierPanel;
    private JLabel supplierLabel;
    private JPanel customerPanel;
    private JPanel countCustomerPanel;
    private JLabel customerLabel;
    private JMenuBar menuBar;
    private JMenu productMenu;
    private JMenu receiptNoteMenu;
    private JMenu billMenu;
    private JPanel search;
    private JScrollPane scrollPaneProduct;
    private JScrollPane scrollPaneBill;
    private JScrollPane scrollPaneReceiptNote;
    private JTable staticticsProduct;
    private JTable staticticsBill;
    private JTable staticticsReceiptNote;
    private ArrayList<StaticticsProduct> staticticsProducts;
    private ArrayList<StaticticsBill> staticticsBills;
    private ArrayList<StaticticsReceiptNote> staticticsReceiptNotes;
    private String nameMenuBtn = "Sản phẩm";

    public PanelStatistics() {
        initComponents();
        setOpaque(false);
        init();
        layout = new MigLayout("fill, wrap", "[100%]", "[20%][80%]");
        setLayout(layout);
        setVisible(true);
    }

    private void init() {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(new MigLayout("fill, wrap", "[1500]", "[100][200][1000]"));

        statisticsPanel = new JPanel();
        statisticsPanel.setBackground(new Color(255, 255, 255));
        statisticsPanel.setLayout(new MigLayout("fill", "[500][500][500]", "[100%]"));

        //<editor-fold defaultstate="collapsed" desc="Statistics">
        productPanel = new JPanel();
        productPanel.setBackground(new Color(255, 213, 0));
        productPanel.setLayout(new MigLayout("fill, wrap", "[50%][50%]", "[100%]"));
        statisticsPanel.add(productPanel, "growx, growy");

        supplierPanel = new JPanel();
        supplierPanel.setBackground(new Color(255, 115, 0));
        supplierPanel.setLayout(new MigLayout("fill, wrap", "[50%][50%]", "[100%]"));
        statisticsPanel.add(supplierPanel, "growx, growy");

        customerPanel = new JPanel();
        customerPanel.setBackground(new Color(0, 204, 255));
        customerPanel.setLayout(new MigLayout("fill, wrap", "[50%][50%]", "[100%]"));
        statisticsPanel.add(customerPanel, "growx, growy");

        ImageIcon productIcon = new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-monitor-80.png"));
        productPanel.add(new JLabel(productIcon), "align left");

        countProductPanel = new JPanel();
        countProductPanel.setBackground(new Color(255, 213, 0));
        countProductPanel.setLayout(new MigLayout("fill, wrap", "[100%]", "[50%][50%]"));
        productPanel.add(countProductPanel, "align left");

        ImageIcon supplierIcon = new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-supplier-80.png"));
        supplierPanel.add(new JLabel(supplierIcon), "align center");

        countSupplierPanel = new JPanel();
        countSupplierPanel.setBackground(new Color(255, 115, 0));
        countSupplierPanel.setLayout(new MigLayout("fill, wrap", "[100%]", "[50%][50%]"));
        supplierPanel.add(countSupplierPanel, "align left");

        ImageIcon customerIcon = new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8-account-80.png"));
        customerPanel.add(new JLabel(customerIcon), "align center");

        countCustomerPanel = new JPanel();
        countCustomerPanel.setBackground(new Color(0, 204, 255));
        countCustomerPanel.setLayout(new MigLayout("fill, wrap", "[100%]", "[50%][50%]"));
        customerPanel.add(countCustomerPanel, "align left");

        int countProductInBill = 0;
        ArrayList<BillDetail> billDetails = BillDetailDAO.getInstance().selectAll();
        for (BillDetail billDetail : billDetails) {
            countProductInBill += billDetail.getCount();
        }
        int countProductInReceiptNote = 0;
        ArrayList<ReceiptNoteDetail> receiptNoteDetails = ReceiptNoteDetailDAO.getInstance().selectAll();
        for (ReceiptNoteDetail receiptNoteDetail : receiptNoteDetails) {
            countProductInReceiptNote += receiptNoteDetail.getCount();
        }

        int countProduct = countProductInReceiptNote - countProductInBill;
        JLabel countProductLabel = new JLabel(String.valueOf(countProduct));
        countProductLabel.setForeground(new Color(255, 255, 255));
        countProductLabel.setFont(new Font("sansserif", 1, 30));
        countProductPanel.add(countProductLabel, "align left");
        productLabel = new JLabel("Sản phẩm trong kho.");
        productLabel.setForeground(new Color(255, 255, 255));
        productLabel.setFont(new Font("sansserif", 1, fontSize));
        countProductPanel.add(productLabel, "align left");

        int countSupplier = 0;
        ArrayList<Suplier> supliers = SuplierDAO.getInstance().selectAll();
        for (Suplier suplier : supliers) {
            countSupplier += 1;
        }

        JLabel countSupplierLabel = new JLabel(String.valueOf(countSupplier));
        countSupplierLabel.setForeground(new Color(255, 255, 255));
        countSupplierLabel.setFont(new Font("sansserif", 1, 30));
        countSupplierPanel.add(countSupplierLabel, "align left");
        supplierLabel = new JLabel("Nhà cung cấp.");
        supplierLabel.setForeground(new Color(255, 255, 255));
        supplierLabel.setFont(new Font("sansserif", 1, fontSize));
        countSupplierPanel.add(supplierLabel, "align left");

        int countCustomer = 0;
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        for (Customer customer : customers) {
            countCustomer += 1;
        }

        JLabel countCustomerLabel = new JLabel(String.valueOf(countCustomer));
        countCustomerLabel.setForeground(new Color(255, 255, 255));
        countCustomerLabel.setFont(new Font("sansserif", 1, 30));
        countCustomerPanel.add(countCustomerLabel, "align left");
        customerLabel = new JLabel("Khách hàng.");
        customerLabel.setForeground(new Color(255, 255, 255));
        customerLabel.setFont(new Font("sansserif", 1, fontSize));
        countCustomerPanel.add(customerLabel, "align left");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Menu">
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255, 255, 255));
        menuBar.setLayout(new MigLayout("fill, wrap", "[33.33%][33.33%][33.33%]", "[100%]"));
        menuBar.setBorder(null);
        mainPanel.add(menuBar, "growx, wrap, top");

        productMenu = new JMenu("Sản phẩm");
        productMenu.setFont(new Font("sansserif", 1, fontSize));
        productMenu.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        menuBar.add(productMenu, "growx");
        productMenu.setCursor(new Cursor(HAND_CURSOR));

        receiptNoteMenu = new JMenu("Phiếu nhập");
        receiptNoteMenu.setFont(new Font("sansserif", 1, fontSize));
        receiptNoteMenu.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        menuBar.add(receiptNoteMenu, "growx");
        receiptNoteMenu.setCursor(new Cursor(HAND_CURSOR));

        billMenu = new JMenu("Hóa đơn");
        billMenu.setFont(new Font("sansserif", 1, fontSize));
        billMenu.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        menuBar.add(billMenu, "growx");
        billMenu.setCursor(new Cursor(HAND_CURSOR));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Search">
        search = new JPanel();
        search.setBackground(new Color(255, 255, 255));
        search.setLayout(new MigLayout("fill, wrap", "[300]5[400]5[200]", "[200]"));
        search.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lọc", TitledBorder.LEADING, TitledBorder.TOP, new Font("sansserif", 1, 16), new Color(0, 0, 0)));
        mainPanel.add(search, "growx, wrap, top");

        JComboBox area = new JComboBox();
        area.setFont(new Font("sansserif", 1, 14));
        area.setForeground(new Color(0, 0, 0));
        area.setBackground(new Color(255, 255, 255));
        area.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        area.setBorder(null);
        area.addItem("Tất cả");
        area.addItem("Mã sản phẩm");
        area.addItem("Tên sản phẩm");
        area.addItem("Số lượng nhập");
        area.addItem("Số lượng bán");
        search.add(area, "grow");

        MyTextField text = new MyTextField();
        text.setFont(new Font("sansserif", 1, 14));
        text.setForeground(new Color(0, 0, 0));
        text.setBackground(new Color(255, 255, 255));
        text.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        text.setBorder(new LineBorder(new Color(0, 0, 0)));
        text.setMargin(new Insets(10,20,10,20));
        search.add(text, "growx");

        JButton reload = new JButton();
        reload.setFont(new Font("sansserif", 1, 14));
        reload.setForeground(new Color(0, 0, 0));
        reload.setBackground(new Color(255, 255, 255));
        reload.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        reload.setText("Làm mới");
        reload.setBorder(new LineBorder(new Color(0,0,0)));
        reload.setIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/icons8_reset_25px_1.png")));
        reload.setMargin(new Insets(10,20,10,20));
        search.add(reload, "growx");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table Product">
        String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng nhập", "Số lượng bán"};
        DefaultTableModel model = new DefaultTableModel(new java.lang.Object[][]{}, columnNames)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };

        staticticsProducts = StaticticsProductDAO.getInstance().selectAll();

        try {
            model.setRowCount(0);
            for (StaticticsProduct staticticsProduct : staticticsProducts) {
                model.addRow(new java.lang.Object[]{
                        staticticsProduct.getId(),
                        staticticsProduct.getName(),
                        staticticsProduct.getCountImport(),
                        staticticsProduct.getCountExport()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        staticticsProduct = new JTable(model);
        scrollPaneProduct = new JScrollPane(staticticsProduct);
        scrollPaneProduct.setViewportView(staticticsProduct);

        staticticsProduct.setForeground(new Color(100, 100, 100));
        staticticsProduct.setFont(new Font("sansserif", 1, fontSize));
        staticticsProduct.setRowHeight(30);
        staticticsProduct.setFillsViewportHeight(true);
        staticticsProduct.setBackground(new Color(255, 255, 255));
        staticticsProduct.getTableHeader().setBackground(new Color(255, 255, 255));
        staticticsProduct.getTableHeader().setForeground(new Color(100, 100, 100));
        staticticsProduct.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) staticticsProduct.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        staticticsProduct.getTableHeader().setDefaultRenderer(renderer);
        staticticsProduct.getTableHeader().setReorderingAllowed(false);
        staticticsProduct.getTableHeader().setResizingAllowed(false);
        mainPanel.add(scrollPaneProduct, "growx, growy, wrap");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table Bill">
        String[] columnNamesBill = {"Mã hóa đơn", "Ngày lập", "Tên khách hàng", "Tên nhân viên", "Tổng tiền"};
        DefaultTableModel modelBill = new DefaultTableModel(new java.lang.Object[][]{}, columnNamesBill)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        staticticsBills = StaticticsBillDAO.getInstance().selectAll();

        try {
            modelBill.setRowCount(0);
            for (StaticticsBill staticticsBill : staticticsBills) {
                modelBill.addRow(new java.lang.Object[]{
                        staticticsBill.getId(),
                        staticticsBill.getDate(),
                        staticticsBill.getnameCustomer(),
                        staticticsBill.getnameStaff(),
                        staticticsBill.getpriceBill()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        staticticsBill = new JTable(modelBill);
        scrollPaneBill = new JScrollPane(staticticsBill);
        scrollPaneBill.setViewportView(staticticsBill);

        staticticsBill.setForeground(new Color(100, 100, 100));
        staticticsBill.setFont(new Font("sansserif", 1, fontSize));
        staticticsBill.setRowHeight(30);
        staticticsBill.setFillsViewportHeight(true);
        staticticsBill.setBackground(new Color(255, 255, 255));
        staticticsBill.getTableHeader().setBackground(new Color(255, 255, 255));
        staticticsBill.getTableHeader().setForeground(new Color(100, 100, 100));
        staticticsBill.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer rendererBill = (DefaultTableCellRenderer) staticticsBill.getTableHeader().getDefaultRenderer();
        rendererBill.setHorizontalAlignment(SwingConstants.LEFT);
        staticticsBill.getTableHeader().setDefaultRenderer(rendererBill);
        staticticsBill.getTableHeader().setReorderingAllowed(false);
        staticticsBill.getTableHeader().setResizingAllowed(false);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table Receipt Note">
        String[] columnNamesReceiptNote = {"Mã phiếu nhập", "Ngày lập", "Chi tiết","Tên nhà cung cấp", "Tên nhân viên", "Tổng tiền"};
        DefaultTableModel modelReceiptNote = new DefaultTableModel(new java.lang.Object[][]{}, columnNamesReceiptNote)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        staticticsReceiptNotes = StaticticsReceiptNoteDAO.getInstance().selectAll();

        try {
            modelReceiptNote.setRowCount(0);
            for (StaticticsReceiptNote staticticsReceiptNote : staticticsReceiptNotes) {
                modelReceiptNote.addRow(new java.lang.Object[]{
                        staticticsReceiptNote.getId(),
                        staticticsReceiptNote.getDate(),
                        staticticsReceiptNote.getMore_info(),
                        staticticsReceiptNote.getNameSuplier(),
                        staticticsReceiptNote.getNameStaff(),
                        staticticsReceiptNote.getUnitPrice()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        staticticsReceiptNote = new JTable(modelReceiptNote);
        scrollPaneReceiptNote = new JScrollPane(staticticsReceiptNote);
        scrollPaneReceiptNote.setViewportView(staticticsReceiptNote);

        staticticsReceiptNote.setForeground(new Color(100, 100, 100));
        staticticsReceiptNote.setFont(new Font("sansserif", 1, fontSize));
        staticticsReceiptNote.setRowHeight(30);
        staticticsReceiptNote.setFillsViewportHeight(true);
        staticticsReceiptNote.setBackground(new Color(255, 255, 255));
        staticticsReceiptNote.getTableHeader().setBackground(new Color(255, 255, 255));
        staticticsReceiptNote.getTableHeader().setForeground(new Color(100, 100, 100));
        staticticsReceiptNote.getTableHeader().setFont(new Font("sansserif", 1, fontSize));
        DefaultTableCellRenderer rendererReceiptNote = (DefaultTableCellRenderer) staticticsReceiptNote.getTableHeader().getDefaultRenderer();
        rendererReceiptNote.setHorizontalAlignment(SwingConstants.LEFT);
        staticticsReceiptNote.getTableHeader().setDefaultRenderer(rendererReceiptNote);
        staticticsReceiptNote.getTableHeader().setReorderingAllowed(false);
        staticticsReceiptNote.getTableHeader().setResizingAllowed(false);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Menu Event">
        productMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                PanelProduct panelProduct = new PanelProduct();
                panelProduct.setVisible(true);
                nameMenuBtn = productMenu.getText().toString();
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã sản phẩm");
                area.addItem("Tên sản phẩm");
                area.addItem("Số lượng nhập");
                area.addItem("Số lượng bán");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneProduct , "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                PanelProduct panelProduct = new PanelProduct();
                panelProduct.setVisible(true);
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã sản phẩm");
                area.addItem("Tên sản phẩm");
                area.addItem("Số lượng nhập");
                area.addItem("Số lượng bán");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneProduct, "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                PanelProduct panelProduct = new PanelProduct();
                panelProduct.setVisible(true);
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã sản phẩm");
                area.addItem("Tên sản phẩm");
                area.addItem("Số lượng nhập");
                area.addItem("Số lượng bán");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneProduct, "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        billMenu .addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                PanelBill panelBill = new PanelBill();
                panelBill.setVisible(true);
                nameMenuBtn = billMenu.getText().toString();
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã hóa đơn");
                area.addItem("Ngày lập");
                area.addItem("Tên khách hàng");
                area.addItem("Tên nhân viên");
                area.addItem("Tổng tiền");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneBill, "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                PanelBill panelBill = new PanelBill();
                panelBill.setVisible(true);
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã hóa đơn");
                area.addItem("Ngày lập");
                area.addItem("Tên khách hàng");
                area.addItem("Tên nhân viên");
                area.addItem("Tổng tiền");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneBill, "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                PanelBill panelBill = new PanelBill();
                panelBill.setVisible(true);
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã hóa đơn");
                area.addItem("Ngày lập");
                area.addItem("Tên khách hàng");
                area.addItem("Tên nhân viên");
                area.addItem("Tổng tiền");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneBill, "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        receiptNoteMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                PanelReceiptNote panelReceiptNote = new PanelReceiptNote();
                panelReceiptNote.setVisible(true);
                nameMenuBtn = receiptNoteMenu.getText().toString();
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã phiếu nhập");
                area.addItem("Ngày lập");
                area.addItem("Chi tiết");
                area.addItem("Tên nhà cung cấp");
                area.addItem("Tên nhân viên");
                area.addItem("Tổng tiền");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneReceiptNote, "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                PanelReceiptNote panelReceiptNote = new PanelReceiptNote();
                panelReceiptNote.setVisible(true);
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã phiếu nhập");
                area.addItem("Ngày lập");
                area.addItem("Chi tiết");
                area.addItem("Tên nhà cung cấp");
                area.addItem("Tên nhân viên");
                area.addItem("Tổng tiền");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneReceiptNote, "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                PanelReceiptNote panelReceiptNote = new PanelReceiptNote();
                panelReceiptNote.setVisible(true);
                mainPanel.removeAll();
                mainPanel.add(menuBar, "growx, wrap, top");
                area.removeAllItems();
                area.addItem("Tất cả");
                area.addItem("Mã phiếu nhập");
                area.addItem("Ngày lập");
                area.addItem("Chi tiết");
                area.addItem("Tên nhà cung cấp");
                area.addItem("Tên nhân viên");
                area.addItem("Tổng tiền");
                mainPanel.add(search, "growx, wrap, top");
                mainPanel.add(scrollPaneReceiptNote, "growx, growy, wrap");
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Reload Event">
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isExist = false;
                if (nameMenuBtn == "Sản phẩm") {
                    staticticsProducts = StaticticsProductDAO.getInstance().selectAll();
                    String comBoBox = area.getSelectedItem().toString();
                    String textSearch = text.getText().toString();
                    if (comBoBox == "Tất cả") {
                        try {
                            model.setRowCount(0);
                            for (StaticticsProduct staticticsProduct : staticticsProducts) {
                                model.addRow(new java.lang.Object[]{
                                        staticticsProduct.getId(),
                                        staticticsProduct.getName(),
                                        staticticsProduct.getCountImport(),
                                        staticticsProduct.getCountExport()
                                });
                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Mã sản phẩm") {
                        try {
                            model.setRowCount(0);
                            for (StaticticsProduct staticticsProduct : staticticsProducts) {
                                if (staticticsProduct.getId().contains(textSearch)) {
                                    isExist = true;
                                    model.addRow(new java.lang.Object[]{
                                            staticticsProduct.getId(),
                                            staticticsProduct.getName(),
                                            staticticsProduct.getCountImport(),
                                            staticticsProduct.getCountExport()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Tên sản phẩm") {
                        try {
                            model.setRowCount(0);
                            for (StaticticsProduct staticticsProduct : staticticsProducts) {
                                if (staticticsProduct.getName().contains(textSearch)) {
                                    isExist = true;
                                    model.addRow(new java.lang.Object[]{
                                            staticticsProduct.getId(),
                                            staticticsProduct.getName(),
                                            staticticsProduct.getCountImport(),
                                            staticticsProduct.getCountExport()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Số lượng nhập") {
                        try {
                            model.setRowCount(0);
                            for (StaticticsProduct staticticsProduct : staticticsProducts) {
                                if (String.valueOf(staticticsProduct.getCountImport()).contains(textSearch)) {
                                    isExist = true;
                                    model.addRow(new java.lang.Object[]{
                                            staticticsProduct.getId(),
                                            staticticsProduct.getName(),
                                            staticticsProduct.getCountImport(),
                                            staticticsProduct.getCountExport()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Số lượng bán") {
                        try {
                            model.setRowCount(0);
                            for (StaticticsProduct staticticsProduct : staticticsProducts) {
                                if (String.valueOf(staticticsProduct.getCountExport()).contains(textSearch)) {
                                    isExist = true;
                                    model.addRow(new java.lang.Object[]{
                                            staticticsProduct.getId(),
                                            staticticsProduct.getName(),
                                            staticticsProduct.getCountImport(),
                                            staticticsProduct.getCountExport()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
                else if (nameMenuBtn == "Phiếu nhập") {
                    staticticsReceiptNotes = StaticticsReceiptNoteDAO.getInstance().selectAll();
                    String comBoBox = area.getSelectedItem().toString();
                    String textSearch = text.getText().toString();
                    if (comBoBox == "Tất cả") {
                        try {
                            modelReceiptNote.setRowCount(0);
                            for (StaticticsReceiptNote staticticsReceiptNote : staticticsReceiptNotes) {
                                modelReceiptNote.addRow(new java.lang.Object[]{
                                        staticticsReceiptNote.getId(),
                                        staticticsReceiptNote.getDate(),
                                        staticticsReceiptNote.getMore_info(),
                                        staticticsReceiptNote.getNameSuplier(),
                                        staticticsReceiptNote.getNameStaff(),
                                        staticticsReceiptNote.getUnitPrice()
                                });
                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Mã phiếu nhập") {
                        try {
                            modelReceiptNote.setRowCount(0);
                            for (StaticticsReceiptNote staticticsReceiptNote : staticticsReceiptNotes) {
                                if (staticticsReceiptNote.getId().contains(textSearch)) {
                                    isExist = true;
                                    modelReceiptNote.addRow(new java.lang.Object[]{
                                            staticticsReceiptNote.getId(),
                                            staticticsReceiptNote.getDate(),
                                            staticticsReceiptNote.getMore_info(),
                                            staticticsReceiptNote.getNameSuplier(),
                                            staticticsReceiptNote.getNameStaff(),
                                            staticticsReceiptNote.getUnitPrice()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Ngày lập") {
                        try {
                            modelReceiptNote.setRowCount(0);
                            for (StaticticsReceiptNote staticticsReceiptNote : staticticsReceiptNotes) {
                                String dateAsString = staticticsReceiptNote.getDate().toString();
                                if (dateAsString.contains(textSearch)) {
                                    isExist = true;
                                    modelReceiptNote.addRow(new java.lang.Object[]{
                                            staticticsReceiptNote.getId(),
                                            staticticsReceiptNote.getDate(),
                                            staticticsReceiptNote.getMore_info(),
                                            staticticsReceiptNote.getNameSuplier(),
                                            staticticsReceiptNote.getNameStaff(),
                                            staticticsReceiptNote.getUnitPrice()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Chi tiết") {
                        try {
                            modelReceiptNote.setRowCount(0);
                            for (StaticticsReceiptNote staticticsReceiptNote : staticticsReceiptNotes) {
                                if (staticticsReceiptNote.getMore_info().contains(textSearch)) {
                                    isExist = true;
                                    modelReceiptNote.addRow(new java.lang.Object[]{
                                            staticticsReceiptNote.getId(),
                                            staticticsReceiptNote.getDate(),
                                            staticticsReceiptNote.getMore_info(),
                                            staticticsReceiptNote.getNameSuplier(),
                                            staticticsReceiptNote.getNameStaff(),
                                            staticticsReceiptNote.getUnitPrice()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                    else if (comBoBox == "Tên nhà cung cấp") {
                        try {
                            modelReceiptNote.setRowCount(0);
                            for (StaticticsReceiptNote staticticsReceiptNote : staticticsReceiptNotes) {
                                if (staticticsReceiptNote.getNameSuplier().contains(textSearch)) {
                                    isExist = true;
                                    modelReceiptNote.addRow(new java.lang.Object[]{
                                            staticticsReceiptNote.getId(),
                                            staticticsReceiptNote.getDate(),
                                            staticticsReceiptNote.getMore_info(),
                                            staticticsReceiptNote.getNameSuplier(),
                                            staticticsReceiptNote.getNameStaff(),
                                            staticticsReceiptNote.getUnitPrice()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                    else if (comBoBox == "Tên nhân viên") {
                        try {
                            modelReceiptNote.setRowCount(0);
                            for (StaticticsReceiptNote staticticsReceiptNote : staticticsReceiptNotes) {
                                if (staticticsReceiptNote.getNameStaff().contains(textSearch)) {
                                    isExist = true;
                                    modelReceiptNote.addRow(new java.lang.Object[]{
                                            staticticsReceiptNote.getId(),
                                            staticticsReceiptNote.getDate(),
                                            staticticsReceiptNote.getMore_info(),
                                            staticticsReceiptNote.getNameSuplier(),
                                            staticticsReceiptNote.getNameStaff(),
                                            staticticsReceiptNote.getUnitPrice()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                    else if (comBoBox == "Tổng tiền") {
                        try {
                            modelReceiptNote.setRowCount(0);
                            for (StaticticsReceiptNote staticticsReceiptNote : staticticsReceiptNotes) {
                                if (String.valueOf(staticticsReceiptNote.getUnitPrice()).contains(textSearch)) {
                                    isExist = true;
                                    modelReceiptNote.addRow(new java.lang.Object[]{
                                            staticticsReceiptNote.getId(),
                                            staticticsReceiptNote.getDate(),
                                            staticticsReceiptNote.getMore_info(),
                                            staticticsReceiptNote.getNameSuplier(),
                                            staticticsReceiptNote.getNameStaff(),
                                            staticticsReceiptNote.getUnitPrice()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
                else if (nameMenuBtn == "Hóa đơn") {
                    staticticsBills = StaticticsBillDAO.getInstance().selectAll();
                    String comBoBox = area.getSelectedItem().toString();
                    String textSearch = text.getText().toString();
                    if (comBoBox == "Tất cả") {
                        try {
                            modelBill.setRowCount(0);
                            for (StaticticsBill staticticsBill : staticticsBills) {
                                modelBill.addRow(new java.lang.Object[]{
                                        staticticsBill.getId(),
                                        staticticsBill.getDate(),
                                        staticticsBill.getnameCustomer(),
                                        staticticsBill.getnameStaff(),
                                        staticticsBill.getpriceBill()
                                });
                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Mã hóa đơn") {
                        try {
                            modelBill.setRowCount(0);
                            for (StaticticsBill staticticsBill : staticticsBills) {
                                if (staticticsBill.getId().contains(textSearch)) {
                                    isExist = true;
                                    modelBill.addRow(new java.lang.Object[]{
                                            staticticsBill.getId(),
                                            staticticsBill.getDate(),
                                            staticticsBill.getnameCustomer(),
                                            staticticsBill.getnameStaff(),
                                            staticticsBill.getpriceBill()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn có mã " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Ngày lập") {
                        try {
                            modelBill.setRowCount(0);
                            for (StaticticsBill staticticsBill : staticticsBills) {
                                String dateAsString = staticticsBill.getDate().toString();
                                if (dateAsString.contains(textSearch)) {
                                    isExist = true;
                                    modelBill.addRow(new java.lang.Object[]{
                                            staticticsBill.getId(),
                                            staticticsBill.getDate(),
                                            staticticsBill.getnameCustomer(),
                                            staticticsBill.getnameStaff(),
                                            staticticsBill.getpriceBill()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn có ngày lập " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Tên khách hàng") {
                        try {
                            modelBill.setRowCount(0);
                            for (StaticticsBill staticticsBill : staticticsBills) {
                                if (staticticsBill.getnameCustomer().contains(textSearch)) {
                                    isExist = true;
                                    modelBill.addRow(new java.lang.Object[]{
                                            staticticsBill.getId(),
                                            staticticsBill.getDate(),
                                            staticticsBill.getnameCustomer(),
                                            staticticsBill.getnameStaff(),
                                            staticticsBill.getpriceBill()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn có tên khách hàng " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Tên nhân viên") {
                        try {
                            modelBill.setRowCount(0);
                            for (StaticticsBill staticticsBill : staticticsBills) {
                                if (staticticsBill.getnameStaff().contains(textSearch)) {
                                    isExist = true;
                                    modelBill.addRow(new java.lang.Object[]{
                                            staticticsBill.getId(),
                                            staticticsBill.getDate(),
                                            staticticsBill.getnameCustomer(),
                                            staticticsBill.getnameStaff(),
                                            staticticsBill.getpriceBill()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn có tên nhân viên " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (comBoBox == "Tổng tiền") {
                        try {
                            modelBill.setRowCount(0);
                            for (StaticticsBill staticticsBill : staticticsBills) {
                                if (String.valueOf(staticticsBill.getpriceBill()).contains(textSearch)) {
                                    isExist = true;
                                    modelBill.addRow(new java.lang.Object[]{
                                            staticticsBill.getId(),
                                            staticticsBill.getDate(),
                                            staticticsBill.getnameCustomer(),
                                            staticticsBill.getnameStaff(),
                                            staticticsBill.getpriceBill()
                                    });
                                }
                            }
                            if (!isExist)
                                JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn có tổng tiền " + textSearch);
                            else
                                isExist = false;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
            }
        });
        //</editor-fold>

        add(statisticsPanel, "growx, growy, wrap");
        add(mainPanel, "growx, growy, wrap");
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
