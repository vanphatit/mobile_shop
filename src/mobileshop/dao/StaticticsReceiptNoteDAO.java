package mobileshop.dao;

import mobileshop.db.JDBCUtil;
import mobileshop.model.StaticticsBill;
import mobileshop.model.StaticticsProduct;
import mobileshop.model.StaticticsReceiptNote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StaticticsReceiptNoteDAO {
    public static StaticticsReceiptNoteDAO getInstance() {
        return new StaticticsReceiptNoteDAO();
    }
    public ArrayList<StaticticsReceiptNote> selectAll() {
        ArrayList<StaticticsReceiptNote> ketQua = new ArrayList<StaticticsReceiptNote>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT\n" +
                    "    t1.id_receipt,\n" +
                    "    receipt_note.date,\n" +
                    "    receipt_note.more_info,\n" +
                    "    suplier.name AS nameSuplier,\n" +
                    "    staff.name AS nameStaff,\n" +
                    "    t1.UnitPrice\n" +
                    "FROM\n" +
                    "    (\n" +
                    "        SELECT\n" +
                    "            rn_detail.id_receipt,\n" +
                    "            SUM(rn_detail.count * rn_detail.unit_price) AS UnitPrice\n" +
                    "        FROM\n" +
                    "            rn_detail\n" +
                    "            JOIN receipt_note ON rn_detail.id_receipt = receipt_note.id\n" +
                    "            JOIN suplier ON receipt_note.id_suplier = suplier.id\n" +
                    "        GROUP BY\n" +
                    "            rn_detail.id_receipt\n" +
                    "    ) t1\n" +
                    "    JOIN receipt_note receipt_note ON t1.id_receipt = receipt_note.id\n" +
                    "    JOIN suplier suplier ON receipt_note.id_suplier = suplier.id\n" +
                    "    JOIN staff staff ON receipt_note.id_staff = staff.id;\n"
                    ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String receiptId = rs.getString("id_receipt");
                java.sql.Date date = rs.getDate("date");
                String more_info = rs.getString("more_info");
                String nameSuplier = rs.getString("nameSuplier");
                String nameStaff = rs.getString("nameStaff");
                int UnitPrice = rs.getInt("UnitPrice");
                StaticticsReceiptNote p = new StaticticsReceiptNote(receiptId, date, more_info, nameSuplier, nameStaff, UnitPrice);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
