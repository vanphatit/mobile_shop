package mobileshop.view.UI;

import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mobileshop.controller.LoginController;
import mobileshop.view.component.PanelCoverLogin;
import mobileshop.view.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

public class Login extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCoverLogin cover;
    private JPanel login;
    private final double coverSize = 40;
    private final double loginSize = 60;
    
    public Login() {
        setTitle("Đăng nhập vào phần mềm!");
        initComponents();
        init();
    }

    private void init()
    {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverLogin();
        login = new JPanel();
        login.setBackground(new Color(255, 255, 255));

        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Login");
        login.setFont(new Font("sansserif", 1, 30));
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/user.png")));
        txtUser.setHint("Username: ");
        login.add(txtUser, "wrap, width 60%");
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/mobileshop/assets/icon/pass.png")));
        txtPass.setHint("Password: ");
        login.add(txtPass, "wrap, width 60%");
        
        JButton btnForget = new JButton("Forgot your password ?");
        btnForget.setForeground(new Color(100, 100, 100));
        btnForget.setFont(new Font("sansserif", 1, 12));
        btnForget.setContentAreaFilled(false);
        btnForget.setBorderPainted(false);
        btnForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(btnForget);
        
        Button btnLogin = new Button();
        btnLogin.setBackground(new Color(7, 164, 121));
        btnLogin.setForeground(new Color(250, 250, 250));
        btnLogin.setText("SIGN IN");
        login.add(btnLogin, "w 40%, h 40");
        
        btnLogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(LoginController.getInstance().checkLogin(txtUser.getText(), 
                        String.valueOf(txtPass.getPassword())))
                {
                    dispose();
                    Home mainLayout = new Home();
                    mainLayout.setVisible(true);
                }
            }
        });
        
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(login, "width " + loginSize + "%, pos 1al 0 n 100%");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
