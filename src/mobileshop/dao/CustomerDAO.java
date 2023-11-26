/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mobileshop.db.JDBCUtil;
import mobileshop.model.Customer;

/**
 *
 * @author phatlee
 */
public class CustomerDAO implements IDAO<Customer> {
    
    public static CustomerDAO getIntance(){
        return new CustomerDAO();
    }

    @Override
    public int insert(Customer customer) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO customer (id, name, address, gender, birthday, phone, id_category) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getId());
            pst.setString(2, customer.getName());
            pst.setString(3, customer.getAddress());
            pst.setBoolean(4, customer.getGender());
            pst.setDate(5, customer.getBirthday());
            pst.setString(6, customer.getPhone());
            pst.setString(7, customer.getIdCategory());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(Customer customer) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE customer SET name = ?, address = ?, gender = ?, birthday = ?, phone = ?, id_category = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getName());
            pst.setString(2, customer.getAddress());
            pst.setBoolean(3, customer.getGender());
            pst.setDate(4, customer.getBirthday());
            pst.setString(5, customer.getPhone());
            pst.setString(6, customer.getIdCategory());
            pst.setString(7, customer.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(Customer customer) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM customer WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM customer";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idCustomer = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                Boolean gender = rs.getBoolean("gender");
                java.sql.Date birthday = rs.getDate("birthday");
                String phone = rs.getString("phone");
                String idCate = rs.getString("id_category");
                Customer customer = new Customer(idCustomer, name, address, gender, birthday, phone, idCate);
                list.add(customer);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public Customer selectById(String t) {
        Customer customer = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idCustomer = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                Boolean gender = rs.getBoolean("gender");
                java.sql.Date birthday = rs.getDate("birthday");
                String phone = rs.getString("phone");
                String idCate = rs.getString("id_category");
                customer = new Customer(idCustomer, name, address, gender, birthday, phone, idCate);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customer;
    }

    @Override
    public Customer selectbyId(String t, String tt) {
        return null;
    }
    
}
