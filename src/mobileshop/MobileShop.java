/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mobileshop;

import java.sql.Connection;

import mobileshop.db.JDBCUtil;
import mobileshop.view.UI.Login;


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
            Login login = new Login();
            login.setVisible(true);
        } else {
            System.out.println("Connect failed!");
        }
    }
}
