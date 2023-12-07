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
import mobileshop.model.ReceiptNote;

/**
 *
 * @author phatlee
 */
public class ReceiptNoteDAO implements IDAO<ReceiptNote> {
    public static ReceiptNoteDAO getInstance() {
        return new ReceiptNoteDAO();
    }

    @Override
    public int insert(ReceiptNote receiptNote) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO receipt_note (id, date, more_info, id_suplierr, id_staff) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receiptNote.getId());
            pst.setDate(2, receiptNote.getDate());
            pst.setString(3, receiptNote.getMoreInfo());
            pst.setString(4, receiptNote.getIdSuplier());
            pst.setString(5, receiptNote.getIdStaff());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(ReceiptNote receiptNote) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE receipt_note SET date = ?, more_info = ?, id_suplier = ?, id_staff = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDate(1, receiptNote.getDate());
            pst.setString(2, receiptNote.getMoreInfo());
            pst.setString(3, receiptNote.getIdSuplier());
            pst.setString(4, receiptNote.getIdStaff());
            pst.setString(5, receiptNote.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(ReceiptNote receiptNote) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM receipt_note WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receiptNote.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<ReceiptNote> selectAll() {
        ArrayList<ReceiptNote> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM receipt_note";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idReceptNote = rs.getString("id");
                java.sql.Date date = rs.getDate("date");
                String moreInfo = rs.getString("more_info");
                String idSuplier = rs.getString("id_suplier");
                String idStaff = rs.getString("id_staff");
                ReceiptNote receiptNote = new ReceiptNote(idReceptNote, date, moreInfo, idSuplier, idStaff);
                list.add(receiptNote);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public ReceiptNote selectById(String t) {
        ReceiptNote receiptNote = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM receipt_note WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idReceptNote = rs.getString("id");
                java.sql.Date date = rs.getDate("date");
                String moreInfo = rs.getString("more_info");
                String idSuplier = rs.getString("id_suplier");
                String idStaff = rs.getString("id_staff");
                receiptNote = new ReceiptNote(idReceptNote, date, moreInfo, idSuplier, idStaff);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return receiptNote;
    }

    @Override
    public ReceiptNote selectbyId(String t, String tt) {
        return null;
    }
}
