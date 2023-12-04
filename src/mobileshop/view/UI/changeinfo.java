package mobileshop.view.UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import mobileshop.view.component.PanelChangeinfo;
import mobileshop.view.component.PanelCoverChangeinfo;
//import mobileshop.view.component.PanelLogin;
import net.miginfocom.swing.MigLayout;

public class changeinfo extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCoverChangeinfo cover;
    private PanelChangeinfo change;
    private JMenuBar menu;
    
    public changeinfo() {
        setTitle("Thay đổi thông tin");
        initComponents();
        init();
    }

    private void init()
    {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCoverChangeinfo();
        change = new PanelChangeinfo();

        JMenuItem info = new JMenuItem("Thông tin");
        JMenuItem pass = new JMenuItem("Mật khẩu");
        info.setForeground(new Color(100, 100, 100));
        pass.setForeground(new Color(100, 100, 100));
        info.setFont(new Font("sansserif", 1, 14));
        pass.setFont(new Font("sansserif", 1, 14));
        
        info.addActionListener((ActionEvent e) -> {
            change.showChange(false);
        });
        pass.addActionListener((ActionEvent e) -> {
            change.showChange(true);
        });
        
        menu = new JMenuBar();
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.add(info);
        menu.add(pass);
        
        bg.setLayout(layout);
        bg.add(cover, "height 20%, width 100%, wrap");
        bg.add(menu, "height 7.5%, width 100%, wrap");
        bg.add(change, "height 80%, width 100%");
        
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new changeinfo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    // End of variables declaration//GEN-END:variables
}
