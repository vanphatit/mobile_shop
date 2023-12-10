package mobileshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mobileshop.db.JDBCUtil;
import mobileshop.model.StaticticsProduct;

public class StaticticsProductDAO {
    public static StaticticsProductDAO getInstance() {
        return new StaticticsProductDAO();
    }
    public ArrayList<StaticticsProduct> selectAll() {
        ArrayList<StaticticsProduct> ketQua = new ArrayList<StaticticsProduct>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT t1.id_object, object.name,countImport,countExport FROM(\n"
                    + "	SELECT id_object, SUM(count) AS countImport FROM rn_detail \n"
                    + "	JOIN receipt_note ON receipt_note.id = rn_detail.id_receipt\n"
                    + "	GROUP BY id_object\n"
                    + ") t1 \n"
                    + "JOIN(\n"
                    + "	SELECT id_object, SUM(count) AS countExport FROM bill_detail \n"
                    + "	JOIN bill ON bill.id = bill_detail.id_bill \n"
                    + "	GROUP BY id_object\n"
                    + ") t2\n"
                    + "ON t1.id_object = t2.id_object\n"
                    + "JOIN object ON t1.id_object = object.id";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String objectId = rs.getString("id_object"); // Corrected column name
                String objectName = rs.getString("name"); // Corrected column name
                int countImport = rs.getInt("countImport");
                int countExport = rs.getInt("countExport");
                StaticticsProduct p = new StaticticsProduct(objectId, objectName, countImport, countExport);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

}
