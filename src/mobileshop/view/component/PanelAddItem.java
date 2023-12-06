package mobileshop.view.component;


import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import mobileshop.view.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;

public class PanelAddItem extends javax.swing.JLayeredPane {
    
    private int fonsize = 14;
    private JMenuBar menu;
    public PanelAddItem() {
        initComponents();
        init();
        addPanel.setVisible(true);
    }  
    
    private void init() {
        
        addPanel.setLayout(new MigLayout("wrap", "push[center]push", "15[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]5[]25"));

        JLabel id = new JLabel("Nhập mã sản phẩm: ");
        id.setForeground(new Color(100, 100, 100));
        id.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(id, "w 60%");
        JTextField txtInfo = new JTextField();
        txtInfo.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtInfo, "wrap, width 60%");
        
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
        JTextField txtSx = new JTextField();
        txtSx.setFont(new Font("sansserif", 1, fonsize));
        addPanel.add(txtSx, "wrap, width 60%");
        
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
        cbbCate.addItem("id1");
        cbbCate.addItem("id2");
        cbbCate.addItem("id3");
        addPanel.add(cbbCate, "wrap, width 60%");
        
        JButton addBtn = new JButton();
        addBtn.setText("Thêm sản phẩm");
        addBtn.setFont(new Font("sansserif", 1, fonsize));
        addBtn.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        addBtn.setForeground(new Color(255, 255, 255));
        addBtn.setBackground(new Color(7, 164, 121));
        addBtn.setMargin(new Insets(10,20,10,20));
        addPanel.add(addBtn);
        
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(0,0,0));
                source.setBackground(new Color(0, 255, 213));
            }
        });
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JButton source = (JButton) evt.getSource();
                source.setForeground(new Color(245, 245, 245));
                source.setBackground(new Color(7, 164, 121));
            }
        });
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPanel = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        addPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        add(addPanel, "card3");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addPanel;
    // End of variables declaration//GEN-END:variables
}
