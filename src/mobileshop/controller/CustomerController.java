package mobileshop.controller;

import mobileshop.dao.CustomerDAO;
import mobileshop.model.Customer;

import javax.swing.*;
import java.sql.Date;

public class CustomerController {
    public static CustomerController getInstance() {
        return new CustomerController();
    }

    public boolean addCustomer(String id, String name, String address, Boolean gender, Date birth, String phone, String idCategory) {
        try {
            Customer customer = new Customer(id, name, address, gender, birth, phone, idCategory);
            if(CustomerDAO.getInstance().insert(customer) == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean delCustomer(String id) {
        try {
            Customer customer = CustomerDAO.getInstance().selectById(id);
            if(CustomerDAO.getInstance().delete(customer) == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
