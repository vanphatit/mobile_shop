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
import mobileshop.model.Bill;

/**
 *
 * @author phatlee
 */
public class BillDAO implements IDAO<Bill> {
    public static BillDAO getInstance() {
        return new BillDAO();
    }

    @Override
    public int insert(Bill bill) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO bill (id, date, status, id_customer, id_staff) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bill.getId());
            pst.setDate(2, bill.getDate());
            pst.setString(3, bill.getStatus());
            pst.setString(4, bill.getIdCustomer());
            pst.setString(5, bill.getIdStaff());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int update(Bill bill) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE bill SET date = ?, status = ?, id_customer = ?, id_staff = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, bill.getDate());
            pst.setString(2, bill.getStatus());
            pst.setString(3, bill.getIdCustomer());
            pst.setString(4, bill.getIdStaff());
            pst.setString(5, bill.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public int delete(Bill bill) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM bill WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bill.getId());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ketqua;
    }

    @Override
    public ArrayList<Bill> selectAll() {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM bill";
            PreparedStatement pst = con.prepareStatement(sql);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idBill = rs.getString("id");
                java.sql.Date date = rs.getDate("date");
                String status = rs.getString("status");
                String idCustomer = rs.getString("id_customer");
                String idStaff = rs.getString("id_staff");
                Bill bill = new Bill(idBill, date, status, idCustomer, idStaff);
                list.add(bill);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public Bill selectById(String t) {
        Bill bill = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM bill WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            var rs = pst.executeQuery();
            while (rs.next()) {
                String idBill = rs.getString("id");
                java.sql.Date date = rs.getDate("date");
                String status = rs.getString("status");
                String idCustomer = rs.getString("id_customer");
                String idStaff = rs.getString("id_staff");
                bill = new Bill(idBill, date, status, idCustomer, idStaff);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return bill;
    }

    @Override
    public Bill selectbyId(String t, String tt) {
        return null;
    }
}
