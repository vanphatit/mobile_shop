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
import mobileshop.model.ReceiptNoteDetail;

/**
 *
 * @author phatlee
 */
public class ReceiptNoteDetailDAO implements IDAO<ReceiptNoteDetail> {
    public static ReceiptNoteDetailDAO getInstance() {
        return new ReceiptNoteDetailDAO();
    }

    @Override
    public int insert(ReceiptNoteDetail receiptNoteDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO rn_detail (unit_price, count, id_object, id_receipt) VALUES (?,?,?,?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, receiptNoteDetail.getUnitPrice());
            pst.setInt(2, receiptNoteDetail.getCount());
            pst.setString(3, receiptNoteDetail.getIdObject());
            pst.setString(4, receiptNoteDetail.getIdRecept());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(ReceiptNoteDetail receiptNoteDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE rn_detail SET unit_price = ?, count = ? WHERE id_object = ? AND id_receipt = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, receiptNoteDetail.getUnitPrice());
            pst.setInt(2, receiptNoteDetail.getCount());
            pst.setString(3, receiptNoteDetail.getIdObject());
            pst.setString(4, receiptNoteDetail.getIdRecept());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(ReceiptNoteDetail receiptNoteDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM rn_detail WHERE id_object = ? and id_receipt = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receiptNoteDetail.getIdObject());
            pst.setString(2, receiptNoteDetail.getIdRecept());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<ReceiptNoteDetail> selectAll() {
        ArrayList<ReceiptNoteDetail> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM rn_detail";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                int unitPrice = rs.getInt("unit_price");
                int count = rs.getInt("count");
                String idObject = rs.getString("id_object");
                String idReceptNote = rs.getString("id_receipt");
                ReceiptNoteDetail receiptNoteDetail = new ReceiptNoteDetail(unitPrice, count, idObject, idReceptNote);
                list.add(receiptNoteDetail);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public ReceiptNoteDetail selectById(String t) {
        return null;
    }

    @Override
    public ReceiptNoteDetail selectbyId(String t, String tt) {
        ReceiptNoteDetail receiptNoteDetail = null;
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
                String idReceptNote = rs.getString("id_receipt");
                receiptNoteDetail = new ReceiptNoteDetail(unitPrice, count, idObject, idReceptNote);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return receiptNoteDetail;
    }
}