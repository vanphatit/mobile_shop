package mobileshop.view.UI;

import mobileshop.view.component.PanelCoverHome;
import mobileshop.view.component.PanelCoverFeature;
import mobileshop.view.component.PanelCoverSearch;
import mobileshop.view.component.PanelCoverProduct;

import net.miginfocom.swing.MigLayout;


public class home extends javax.swing.JFrame {

   private MigLayout layout;
   private PanelCoverHome cover;
   private PanelCoverFeature feature;
   private PanelCoverSearch search;
   private PanelCoverProduct product;
    
    public home() {
        setTitle("Phần mềm quản lý mobile shop!");
        initComponents();
        init();
    }

    private void init()
    {
        layout = new MigLayout("debug, fill, insets 0");
        cover = new PanelCoverHome();
        feature = new PanelCoverFeature();
        search = new PanelCoverSearch();
        product = new PanelCoverProduct();
        
        bg.setLayout(layout);
        bg.add(cover, "width 20%, height 100%");
        bg.add(feature, "width 30%, height 14%, top");
        bg.add(search, "width 50%, height 10%, top");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1321, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
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
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new home().setVisible(true);
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
