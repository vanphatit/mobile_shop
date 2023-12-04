package mobileshop.view.component;


import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import mobileshop.view.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import mobileshop.controller.LoginController;
import mobileshop.view.login.home;
import mobileshop.view.login.login;
import net.miginfocom.swing.MigLayout;

public class PanelLogin extends javax.swing.JLayeredPane {

    public PanelLogin() {
        initComponents();
        initLogin();
        login.setVisible(true);
    }
    
    private void initLogin() {
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
                    login.setVisible(false);
                    home mainLayout = new home();
                    mainLayout.setVisible(true);
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    // End of variables declaration//GEN-END:variables
}
