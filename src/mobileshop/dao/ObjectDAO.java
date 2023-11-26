/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileshop.dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import mobileshop.db.JDBCUtil;
import mobileshop.model.Object;

/**
 *
 * @author phatlee
 */

public class ObjectDAO implements IDAO<Object>{
    @Override
    public int insert(Object o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO object (id, name, status, manufacture, unitprice, id_category) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, o.getId());
            pst.setString(2, o.getName());
            pst.setString(3, o.getStatus());
            pst.setString(4, o.getManufacturer());
            pst.setInt(5, o.getUnitPrice());
            pst.setString(6, o.getIdCategory());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(Object o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE object SET name = ?, status = ?, manufacture = ?, unitprice = ?, id_category = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, o.getName());
            pst.setString(2, o.getStatus());
            pst.setString(3, o.getManufacturer());
            pst.setInt(4, o.getUnitPrice());
            pst.setString(5, o.getIdCategory());
            pst.setString(6, o.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(Object o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM object WHERE id = ?";
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
    public ArrayList<Object> selectAll() {
        ArrayList<Object> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM object";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String status = rs.getString("status");
                String manufacture = rs.getString("manufacture");
                int unitPrice = rs.getInt("unitprice");
                String idCategory = rs.getString("id_category");
                Object obj = new Object(id, name, status, manufacture, unitPrice, idCategory);
                list.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public Object selectById(String t) {
        Object obj = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM object WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String status = rs.getString("status");
                String manufacture = rs.getString("manufacture");
                int unitPrice = rs.getInt("unitprice");
                String idCategory = rs.getString("id_category");
                obj = new Object(id, name, status, manufacture, unitPrice, idCategory);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return obj;
    }
}