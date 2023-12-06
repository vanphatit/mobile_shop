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
        initPass();
        passChange.setVisible(true);
    }  
    
    private void initPass() {
        passChange.setLayout(new MigLayout("wrap", "push[center]push", "5[]25[]25[]20[]30"));

        JLabel user = new JLabel("Nhập tên người dùng: ");
        user.setForeground(new Color(100, 100, 100));
        user.setFont(new Font("sansserif", 1, 14));
        passChange.add(user, "w 60%");
        MyTextField txtInfo = new MyTextField();
        txtInfo.setPrefixIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/user.png")));
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passChange = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

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
    private javax.swing.JPanel passChange;
    // End of variables declaration//GEN-END:variables
}
