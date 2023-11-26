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
import mobileshop.model.ReceptNoteDetail;

/**
 *
 * @author phatlee
 */
public class ReceptNoteDetailDAO implements IDAO<ReceptNoteDetail> {
    public static ReceptNoteDetailDAO getInstance() {
        return new ReceptNoteDetailDAO();
    }

    @Override
    public int insert(ReceptNoteDetail receptNoteDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO rn_detail (unit_price, count, id_object, id_recept) VALUES (?,?,?,?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, receptNoteDetail.getUnitPrice());
            pst.setInt(2, receptNoteDetail.getCount());
            pst.setString(3, receptNoteDetail.getIdObject());
            pst.setString(4, receptNoteDetail.getIdRecept());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(ReceptNoteDetail receptNoteDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE rn_detail SET unit_price = ?, count = ? WHERE id_object = ? AND id_recept = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, receptNoteDetail.getUnitPrice());
            pst.setInt(2, receptNoteDetail.getCount());
            pst.setString(3, receptNoteDetail.getIdObject());
            pst.setString(4, receptNoteDetail.getIdRecept());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(ReceptNoteDetail receptNoteDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM rn_detail WHERE id_object = ? and id_recept = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receptNoteDetail.getIdObject());
            pst.setString(2, receptNoteDetail.getIdRecept());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<ReceptNoteDetail> selectAll() {
        ArrayList<ReceptNoteDetail> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM rn_detail";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                int unitPrice = rs.getInt("unit_price");
                int count = rs.getInt("count");
                String idObject = rs.getString("id_object");
                String idReceptNote = rs.getString("id_recept");
                ReceptNoteDetail receptNoteDetail = new ReceptNoteDetail(unitPrice, count, idObject, idReceptNote);
                list.add(receptNoteDetail);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public ReceptNoteDetail selectById(String t) {
        return null;
    }

    @Override
    public ReceptNoteDetail selectbyId(String t, String tt) {
        ReceptNoteDetail receptNoteDetail = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM receptNote_detail WHERE id_object = ? AND id_recept = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            pst.setString(2, tt);
            var rs = pst.executeQuery();
            while (rs.next()) {
                int unitPrice = rs.getInt("unit_price");
                int count = rs.getInt("count");
                String idObject = rs.getString("id_object");
                String idReceptNote = rs.getString("id_recept");
                receptNoteDetail = new ReceptNoteDetail(unitPrice, count, idObject, idReceptNote);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return receptNoteDetail;
    }
}