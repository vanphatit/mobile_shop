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

/**
 *
 * @author phatlee
 */
public class SuplierDAO implements IDAO<mobileshop.model.Suplier>{
    public static SuplierDAO getInstance() {
        return new SuplierDAO();
    }
    @Override
    public int insert(mobileshop.model.Suplier o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO suplier (id, name, address, phone, status) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, o.getId());
            pst.setString(2, o.getName());
            pst.setString(3, o.getAddress());
            pst.setString(4, o.getPhoneNumber());
            pst.setBoolean(5, o.getStatus());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(mobileshop.model.Suplier o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE suplier SET name = ?, address = ?, phone = ?, status = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, o.getName());
            pst.setString(2, o.getAddress());
            pst.setString(3, o.getPhoneNumber());
            pst.setBoolean(4, o.getStatus());
            pst.setString(5, o.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(mobileshop.model.Suplier o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM suplier WHERE id = ?";
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
    public ArrayList<mobileshop.model.Suplier> selectAll() {
        ArrayList<mobileshop.model.Suplier> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM suplier";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Boolean status = rs.getBoolean("status");
                mobileshop.model.Suplier sup = new mobileshop.model.Suplier(id, name, address, phone, status);
                list.add(sup);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public mobileshop.model.Suplier selectById(String t) {
        mobileshop.model.Suplier sup = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM suplier WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Boolean status = rs.getBoolean("status");
                sup = new mobileshop.model.Suplier(id, name, address, phone, status);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return sup;
    }

    @Override
    public mobileshop.model.Suplier selectbyId(String t, String tt) {
        return null;
    }
}
