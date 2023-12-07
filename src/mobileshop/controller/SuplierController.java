package mobileshop.controller;

import mobileshop.dao.SuplierDAO;
import mobileshop.model.Suplier;

import javax.swing.*;

public class SuplierController {
    public static SuplierController getInstance() {
        return new SuplierController();
    }

    public boolean addSuplier(String id, String name, String address, String phone, boolean status) {
        try {
            Suplier suplier = new Suplier(id, name, address, phone, status);
            if(SuplierDAO.getInstance().insert(suplier) == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean delSuplier(String id) {
        try {
            Suplier suplier = SuplierDAO.getInstance().selectById(id);
            if(SuplierDAO.getInstance().delete(suplier) == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
