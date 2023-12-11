package mobileshop.controller;

import mobileshop.dao.CustomerDAO;
import mobileshop.dao.ReceiptNoteDAO;
import mobileshop.dao.StaffDAO;
import mobileshop.model.Customer;
import mobileshop.model.ReceiptNote;
import mobileshop.model.Staff;

import javax.swing.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class StaffController {
    public static StaffController getInstance() {
        return new StaffController();
    }

    public boolean addStaff(String id, String name, String password, String address, Boolean gender, Date birthday, String phone, Boolean role, String id_shift) {
        try {
            Staff staff = new Staff(id, name, password, address, gender, birthday, phone, role, id_shift);
            if(StaffDAO.getInstance().insert(staff) == 1) {
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

    public boolean updateStaff(String id, String name, String password, String address, Boolean gender, Date birthday, String phone, Boolean role, String id_shift) {
        try {
            // TODO add your handling code here:
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date invoiceDate = formatDate.parse(String.valueOf(birthday));
            java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
            Staff staff = new Staff(id, name, password, address, gender, sqlDate, phone, role, id_shift);
            if(StaffDAO.getInstance().update(staff) == 1) {
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

    public boolean deleteStaffById(String id){
        try {
            Staff staff = StaffDAO.getInstance().selectById(id);
            if(StaffDAO.getInstance().delete(staff) == 1) {
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
