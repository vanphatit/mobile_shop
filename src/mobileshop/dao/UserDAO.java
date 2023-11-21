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
import mobileshop.model.Users;

/**
 *
 * @author phatlee
 */

public class UserDAO implements IDAO<Users>{

    public static UserDAO getInstance() {
        return new UserDAO();
    }
    @Override
    public int insert(Users users) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO users (id_staff, password, id_user_role) VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getIdStaff());
            pst.setString(2, users.getPassword());
            pst.setString(3, users.getIdRole());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(Users users) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE users SET password = ?, id_user_role = ? WHERE id_staff = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getPassword());
            pst.setString(2, users.getIdRole());
            pst.setString(3, users.getIdStaff());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(Users users) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM users WHERE id_staff = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getIdStaff());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<Users> selectAll() {
        ArrayList<Users> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idStaff = rs.getString("id_staff");
                String password = rs.getString("password");
                String idRole = rs.getString("id_user_role");
                Users users = new Users(idStaff, password, idRole);
                list.add(users);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public Users selectById(String t) {
        Users users = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM users WHERE id_staff = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idStaff = rs.getString("id_staff");
                String password = rs.getString("password");
                String idRole = rs.getString("id_user_role");
                users = new Users(idStaff, password, idRole);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return users;
    }
}