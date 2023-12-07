package mobileshop.dao;

import mobileshop.db.JDBCUtil;
import mobileshop.model.ObjectCategory;
import mobileshop.model.ObjectCategory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectCategoryDAO implements IDAO<ObjectCategory> {
    public static ObjectCategoryDAO getInstance() {
        return new ObjectCategoryDAO();
    }

    @Override
    public int insert(ObjectCategory o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO object_category (id, name) VALUES (?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, o.getId());
            pst.setString(2, o.getName());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(ObjectCategory o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE object_category SET name = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, o.getName());
            pst.setString(2, o.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(ObjectCategory o) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM object_category WHERE id = ?";
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
    public ArrayList<ObjectCategory> selectAll() {
        ArrayList<ObjectCategory> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM object_category";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                ObjectCategory obj = new ObjectCategory(id, name);
                list.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public ObjectCategory selectById(String t) {
        ObjectCategory obj = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM object_category WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                obj = new ObjectCategory(id, name);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return obj;
    }

    @Override
    public ObjectCategory selectbyId(String t, String tt) {
        return null;
    }
}
