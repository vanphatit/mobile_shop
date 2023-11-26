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
import mobileshop.model.ReceptNote;

/**
 *
 * @author phatlee
 */
public class ReceptNoteDAO implements IDAO<ReceptNote> {
    public static ReceptNoteDAO getInstance() {
        return new ReceptNoteDAO();
    }

    @Override
    public int insert(ReceptNote receptNote) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO recept_note (id, date, more_info, id_suplierr, id_staff) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receptNote.getId());
            pst.setDate(2, receptNote.getDate());
            pst.setString(3, receptNote.getMoreInfo());
            pst.setString(4, receptNote.getIdSuplier());
            pst.setString(5, receptNote.getIdStaff());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(ReceptNote receptNote) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE recept_note SET date = ?, more_info = ?, id_suplier = ?, id_staff = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDate(1, receptNote.getDate());
            pst.setString(2, receptNote.getMoreInfo());
            pst.setString(3, receptNote.getIdSuplier());
            pst.setString(4, receptNote.getIdStaff());
            pst.setString(5, receptNote.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(ReceptNote receptNote) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM recept_note WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receptNote.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<ReceptNote> selectAll() {
        ArrayList<ReceptNote> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM recept_note";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idReceptNote = rs.getString("id");
                java.sql.Date date = rs.getDate("date");
                String moreInfo = rs.getString("more_info");
                String idSuplier = rs.getString("id_suplier");
                String idStaff = rs.getString("id_staff");
                ReceptNote receptNote = new ReceptNote(idReceptNote, date, moreInfo, idSuplier, idStaff);
                list.add(receptNote);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public ReceptNote selectById(String t) {
        ReceptNote receptNote = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM recept_note WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idReceptNote = rs.getString("id");
                java.sql.Date date = rs.getDate("date");
                String moreInfo = rs.getString("more_info");
                String idSuplier = rs.getString("id_suplier");
                String idStaff = rs.getString("id_staff");
                receptNote = new ReceptNote(idReceptNote, date, moreInfo, idSuplier, idStaff);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return receptNote;
    }

    @Override
    public ReceptNote selectbyId(String t, String tt) {
        return null;
    }
}
