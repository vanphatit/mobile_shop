/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mobileshop;

import java.sql.Connection;
import mobileshop.dao.StaffDAO;

import mobileshop.db.JDBCUtil;
import mobileshop.model.Staff;
import mobileshop.view.login.login;


/**
 *
 * @author phatlee
 */
public class MobileShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Connection connection = JDBCUtil.getConnection();
        if(connection != null) {
            System.out.println("Connect successfully!");
        } else {
            System.out.println("Connect failed!");
        }
        login login = new login();
        login.setVisible(true);
    }
}
