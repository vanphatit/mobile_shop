package mobileshop.controller;

import mobileshop.dao.CustomerDAO;
import mobileshop.dao.StaffDAO;
import mobileshop.model.Customer;
import mobileshop.model.Staff;

import javax.swing.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class CustomerController {
    public static CustomerController getInstance() {
        return new CustomerController();
    }

    public boolean addCustomer(String id, String name, String address, Boolean gender, Date birth, String phone, String idCategory) {
        try {
            Customer customer = new Customer(id, name, address, gender, birth, phone, idCategory);
            if(CustomerDAO.getInstance().insert(customer) == 1) {
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

    public boolean updateCustomer(String id, String name, String address, Boolean gender, Date birth, String phone, String idCategory) {
        try {
            // TODO add your handling code here:
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date invoiceDate = formatDate.parse(String.valueOf(birth));
            java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
            Customer customer = new Customer(id, name, address, gender, sqlDate, phone, idCategory);
            if(CustomerDAO.getInstance().update(customer) == 1) {
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

    public boolean deleteCustomerById(String id){
        try {
            Customer customer = CustomerDAO.getInstance().selectById(id);
            if(CustomerDAO.getInstance().delete(customer) == 1) {
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
