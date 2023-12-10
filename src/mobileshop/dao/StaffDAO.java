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
import mobileshop.model.Staff;

/**
 *
 * @author phatlee
 */

public class StaffDAO implements IDAO<Staff>{

    public static StaffDAO getInstance() {
        return new StaffDAO();
    }

    @Override
    public int insert(Staff staff) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO staff (id, name, passwors, address, gender, birthday, phone, role, id_shift) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, staff.getId());
            pst.setString(2, staff.getName());
            pst.setString(3, staff.getPassword());
            pst.setString(4, staff.getAddress());
            pst.setBoolean(5, staff.getGender());
            pst.setDate(6, staff.getBirthday());
            pst.setString(7, staff.getPhone());
            pst.setBoolean(8, staff.getRole());
            pst.setString(9, staff.getIdShift());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(Staff staff) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE staff SET name = ?, password = ?, address = ?, gender = ?, birthday = ?, phone = ?, role = ?, id_shift = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, staff.getName());
            pst.setString(2, staff.getPassword());
            pst.setString(3, staff.getAddress());
            pst.setBoolean(4, staff.getGender());
            pst.setDate(5, staff.getBirthday());
            pst.setString(6, staff.getPhone());
            pst.setBoolean(7, staff.getRole());
            pst.setString(8, staff.getIdShift());
            pst.setString(9, staff.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(Staff staff) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM staff WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, staff.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<Staff> selectAll() {
        ArrayList<Staff> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM staff";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idStaff = rs.getString("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String address = rs.getString("address");
                Boolean gender = rs.getBoolean("gender");
                java.sql.Date birthday = rs.getDate("birthday");
                String phone = rs.getString("phone");
                Boolean role = rs.getBoolean("role");
                String idShift = rs.getString("id_shift");
                Staff staff = new Staff(idStaff, name, password, address, gender, birthday, phone, role, idShift);
                list.add(staff);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public Staff selectById(String t) {
        Staff staff = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM staff WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idStaff = rs.getString("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String address = rs.getString("address");
                Boolean gender = rs.getBoolean("gender");
                java.sql.Date birthday = rs.getDate("birthday");
                String phone = rs.getString("phone");
                Boolean role = rs.getBoolean("role");
                String idShift = rs.getString("id_shift");
                staff = new Staff(idStaff, name, password, address, gender, birthday, phone, role, idShift);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }

    @Override
    public Staff selectbyId(String t, String tt) {
        return null;
    }
}