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
import mobileshop.model.BillDetail;

/**
 *
 * @author phatlee
 */
public class BillDetailDAO implements IDAO<BillDetail> {
    public static BillDetailDAO getInstance() {
        return new BillDetailDAO();
    }

    @Override
    public int insert(BillDetail billDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO bill_detail (count, id_object, id_bill) VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, billDetail.getCount());
            pst.setString(2, billDetail.getIdObject());
            pst.setString(3, billDetail.getIdBill());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(BillDetail billDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE bill_detail SET count = ? WHERE id_object = ? AND id_bill = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, billDetail.getCount());
            pst.setString(2, billDetail.getIdObject());
            pst.setString(3, billDetail.getIdBill());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(BillDetail billDetail) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM bill_detail WHERE id_object = ? and id_bill = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, billDetail.getIdObject());
            pst.setString(2, billDetail.getIdBill());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<BillDetail> selectAll() {
        ArrayList<BillDetail> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM bill_detail";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("count");
                String idObject = rs.getString("id_object");
                String idBill = rs.getString("id_bill");
                BillDetail billDetail = new BillDetail(count, idObject, idBill);
                list.add(billDetail);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public BillDetail selectById(String t) {
        return null;
    }

    @Override
    public BillDetail selectbyId(String t, String tt) {
        BillDetail billDetail = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM bill_detail WHERE id_object = ? AND id_bill = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            pst.setString(2, tt);
            var rs = pst.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("count");
                String idObject = rs.getString("id_object");
                String idBill = rs.getString("id_bill");
                billDetail = new BillDetail(count, idObject, idBill);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return billDetail;
    }
}
