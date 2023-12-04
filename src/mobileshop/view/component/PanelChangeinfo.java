package mobileshop.view.component;


import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import mobileshop.view.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import net.miginfocom.swing.MigLayout;

public class PanelChangeinfo extends javax.swing.JLayeredPane {
    
    public PanelChangeinfo() {
        initComponents();
        initInfo();
        initPass();
        infoChange.setVisible(true);
        passChange.setVisible(false);
    }  
    
    private void initInfo() {
        infoChange.setLayout(new MigLayout("wrap", "push[center]push", "5[]25[]5[]10[]5[]10[]5[]25[]push"));
        
        JLabel user = new JLabel("Nhập tên người dùng: ");
        user.setForeground(new Color(100, 100, 100));
        user.setFont(new Font("sansserif", 1, 14));
        infoChange.add(user, "w 60%");
        MyTextField txtInfo = new MyTextField();
        txtInfo.setHint("Username: ");
        infoChange.add(txtInfo, "wrap, width 60%");
        
        JLabel mail = new JLabel("Nhập email của bạn: ");
        mail.setForeground(new Color(100, 100, 100));
        mail.setFont(new Font("sansserif", 1, 14));
        infoChange.add(mail, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/user.png")));
        txtEmail.setHint("Email: ");
        infoChange.add(txtEmail, "wrap, width 60%");
        
        JLabel password = new JLabel("Nhập mật khẩu của bạn: ");
        password.setForeground(new Color(100, 100, 100));
        password.setFont(new Font("sansserif", 1, 14));
        infoChange.add(password, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/pass.png")));
        txtPass.setHint("Password: ");
        infoChange.add(txtPass, "wrap, width 60%");
        
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Lưu thay đổi");
        infoChange.add(cmd, "w 40%, h 40");
    }
    
    private void initPass() {
        passChange.setLayout(new MigLayout("wrap", "push[center]push", "5[]25[]5[]10[]5[]10[]5[]25[]push"));

        JLabel user = new JLabel("Nhập tên người dùng: ");
        user.setForeground(new Color(100, 100, 100));
        user.setFont(new Font("sansserif", 1, 14));
        passChange.add(user, "w 60%");
        MyTextField txtInfo = new MyTextField();
        txtInfo.setHint("Username: ");
        passChange.add(txtInfo, "wrap, width 60%");
        
        JLabel password = new JLabel("Nhập mật khẩu của bạn: ");
        password.setForeground(new Color(100, 100, 100));
        password.setFont(new Font("sansserif", 1, 14));
        passChange.add(password, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/pass.png")));
        txtPass.setHint("New Password: ");
        passChange.add(txtPass, "wrap, width 60%");
        
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Lưu thay đổi");
        passChange.add(cmd, "w 40%, h 40");
    }
    
    public void showChange(boolean show) {
        if (show) {
            passChange.setVisible(true);
            infoChange.setVisible(false);
        }
        else {
            passChange.setVisible(false);
            infoChange.setVisible(true);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoChange = new javax.swing.JPanel();
        passChange = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        infoChange.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout infoChangeLayout = new javax.swing.GroupLayout(infoChange);
        infoChange.setLayout(infoChangeLayout);
        infoChangeLayout.setHorizontalGroup(
            infoChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        infoChangeLayout.setVerticalGroup(
            infoChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        add(infoChange, "card3");

        javax.swing.GroupLayout passChangeLayout = new javax.swing.GroupLayout(passChange);
        passChange.setLayout(passChangeLayout);
        passChangeLayout.setHorizontalGroup(
            passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        passChangeLayout.setVerticalGroup(
            passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        add(passChange, "card3");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel infoChange;
    private javax.swing.JPanel passChange;
    // End of variables declaration//GEN-END:variables
}
