package mobileshop.controller;

import mobileshop.dao.ObjectDAO;
import mobileshop.dao.SuplierDAO;
import mobileshop.model.Object;
import mobileshop.model.Suplier;

import javax.swing.*;

public class ProductController {
    public static ProductController getInstance() {
        return new ProductController();
    }

    public boolean addProduct(String id, String name, String status, String manufacturer, String price, String cate) {
        try {
            Object object = new Object(id, name, status, manufacturer, Integer.parseInt(price), cate);
            if(ObjectDAO.getInstance().insert(object) == 1) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean updateObject(String id, String name, String status, String manufacturer, String price, String cate) {
        try {
            // TODO add your handling code here:
            Object object = new Object(id, name, status, manufacturer, Integer.parseInt(price), cate);
            if(ObjectDAO.getInstance().update(object) == 1) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteObjectById(String id){
        try {
            Object object = ObjectDAO.getInstance().selectById(id);
            if(ObjectDAO.getInstance().delete(object) == 1) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
