package mobileshop.view.UI;

import mobileshop.controller.CustomerController;
import mobileshop.dao.CustomerCategoryDAO;
import mobileshop.model.CustomerCategory;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import mobileshop.view.component.PanelReceiptNoteDetail;

public class ReceiptNoteDetail extends JFrame {

    private MigLayout layout;
    private int fonsize = 14;
    private PanelReceiptNoteDetail panelReceiptNoteDetail;
    private JPanel mainPanel;

    public ReceiptNoteDetail(String id) {
        initComponents();
        setTitle("Chi tiết phiếu nhập hàng");
        setLocationRelativeTo(null);
        layout = new MigLayout("fill, insets 0");
        setLayout(layout);
        mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("wrap", "[grow]", "[grow]"));
        mainPanel.setBackground(new Color(255, 255, 255));
        panelReceiptNoteDetail = new PanelReceiptNoteDetail(id);
        mainPanel.add(panelReceiptNoteDetail, "width 100%, pos 1al 0 n 100%");
        add(mainPanel, "width 100%, pos 1al 0 n 100%");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));

        bg.setBackground(new Color(255, 255, 255));
        bg.setOpaque(false);

        GroupLayout bgLayout = new GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private JPanel bg;
    // End of variables declaration//GEN-END:variables
}
