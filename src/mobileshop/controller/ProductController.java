package mobileshop.controller;

import mobileshop.dao.ObjectDAO;
import mobileshop.model.Object;

import javax.swing.*;

public class ProductController {
    public static ProductController getInstance() {
        return new ProductController();
    }

    public boolean addProduct(String id, String name, String status, String manufacturer, String price, String cate) {
        try {
            Object object = new Object(id, name, status, manufacturer, Integer.parseInt(price), cate);
            if(ObjectDAO.getInstance().insert(object) == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean delProduct(String id) {
        try {
            Object object = ObjectDAO.getInstance().selectById(id);
            if(ObjectDAO.getInstance().delete(object) == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
