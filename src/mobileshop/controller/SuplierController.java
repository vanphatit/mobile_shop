package mobileshop.controller;

import mobileshop.dao.StaffDAO;
import mobileshop.dao.SuplierDAO;
import mobileshop.model.Staff;
import mobileshop.model.Suplier;

import javax.swing.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class SuplierController {
    public static SuplierController getInstance() {
        return new SuplierController();
    }

    public boolean addSuplier(String id, String name, String address, String phone, boolean status) {
        try {
            Suplier suplier = new Suplier(id, name, address, phone, status);
            if(SuplierDAO.getInstance().insert(suplier) == 1) {
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

    public boolean updateSuplier(String id, String name, String address, String phone, boolean status) {
        try {
            // TODO add your handling code here:
            Suplier suplier = new Suplier(id, name, address, phone, status);
            if(SuplierDAO.getInstance().update(suplier) == 1) {
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

    public boolean deleteSuplierById(String id){
        try {
            Suplier suplier = SuplierDAO.getInstance().selectById(id);
            if(SuplierDAO.getInstance().delete(suplier) == 1) {
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
