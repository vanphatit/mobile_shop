/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileshop.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import mobileshop.dao.StaffDAO;
import mobileshop.model.Staff;

/**
 *
 * @author phatlee
 */
public class LoginController {
    public static LoginController getInstance() {
        return new LoginController();
    }
    
    public boolean checkLogin(String user, String password){
        if (user.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
        } else {
            try {                
                Staff acc = StaffDAO.getInstance().selectById(user);                
                if (acc == null) {
                    JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại trên hệ thống !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (acc.getPassword() == null ? password == null : acc.getPassword().equals(password)) {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Sai mật khẩu !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Sai mật khẩu !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            }
        }
        return false;
    }
}
