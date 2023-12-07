package mobileshop.dao;

import mobileshop.db.JDBCUtil;
import mobileshop.model.CustomerCategory;
import mobileshop.model.CustomerCategory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerCategoryDAO implements IDAO<CustomerCategory> {
    public static CustomerCategoryDAO getInstance() {
        return new CustomerCategoryDAO();
    }

    @Override
    public int insert(CustomerCategory o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO customer_category (id, name, discount) VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, o.getId());
            pst.setString(2, o.getName());
            pst.setDouble(3, o.getDiscount());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(CustomerCategory o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE customer_category SET name = ?, discount WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, o.getName());
            pst.setDouble(2, o.getDiscount());
            pst.setString(3, o.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(CustomerCategory o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM customer_category WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, o.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<CustomerCategory> selectAll() {
        ArrayList<CustomerCategory> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM customer_category";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                Double discount = rs.getDouble("discount");
                CustomerCategory obj = new CustomerCategory(id, name, discount);
                list.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public CustomerCategory selectById(String t) {
        CustomerCategory obj = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM customer_category WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                Double discount = rs.getDouble("discount");
                obj = new CustomerCategory(id, name, discount);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return obj;
    }

    @Override
    public CustomerCategory selectbyId(String t, String tt) {
        return null;
    }
}
