package mobileshop.view.UI;

import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mobileshop.controller.LoginController;
import mobileshop.dao.StaffDAO;
import mobileshop.model.Staff;
import mobileshop.view.component.PanelCoverChangeinfo;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

public class ChangeInfo extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCoverChangeinfo cover;
    private JPanel change;

    private Staff staff;
    
    public ChangeInfo(String idStaff) {

        staff = StaffDAO.getInstance().selectById(idStaff);

        setTitle("Thay đổi mật khẩu");
        initComponents();
        init();
    }

    private void init()
    {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverChangeinfo();
        change = new JPanel();
        change.setBackground(new Color(255, 255, 255));
        
        change.setLayout(new MigLayout("wrap", "push[center]push", "5[]25[]25[]20[]30"));

        JLabel user = new JLabel("Tên người dùng: ");
        user.setForeground(new Color(100, 100, 100));
        user.setFont(new Font("sansserif", 1, 14));
        change.add(user, "w 60%");
        MyTextField txtInfo = new MyTextField();
        txtInfo.setPrefixIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/user.png")));
        txtInfo.setHint("Username: ");
        txtInfo.setText(staff.getId());
        txtInfo.setEditable(false);
        change.add(txtInfo, "wrap, width 60%");
        
        JLabel password = new JLabel("Nhập mật khẩu của bạn: ");
        password.setForeground(new Color(100, 100, 100));
        password.setFont(new Font("sansserif", 1, 14));
        change.add(password, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/pass.png")));
        txtPass.setHint("New Password: ");
        change.add(txtPass, "wrap, width 60%");
        
        Button btnReset = new Button();
        btnReset.setBackground(new Color(7, 164, 121));
        btnReset.setForeground(new Color(250, 250, 250));
        btnReset.setText("Lưu thay đổi");
        change.add(btnReset, "w 40%, h 40");
        
        bg.setLayout(layout);
        bg.add(cover, "height 20%, width 100%, wrap");
        bg.add(change, "height 80%, width 100%");

        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(LoginController.getInstance().updatePassword(txtInfo.getText(), String.valueOf(txtPass.getPassword()))) {
                    dispose();
                }
            }
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    // End of variables declaration//GEN-END:variables
}
