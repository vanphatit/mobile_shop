package mobileshop.dao;

import mobileshop.db.JDBCUtil;
import mobileshop.model.StaticticsBill;
import mobileshop.model.StaticticsProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StaticticsBillDAO {
    public static StaticticsBillDAO getInstance() {
        return new StaticticsBillDAO();
    }
    public ArrayList<StaticticsBill> selectAll() {
        ArrayList<StaticticsBill> ketQua = new ArrayList<StaticticsBill>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT\n" +
                    "    t1.id_bill,\n" +
                    "    bill.date,\n" +
                    "    customer.name AS nameCustomer,\n" +
                    "    staff.name AS nameStaff,\n" +
                    "    t1.priceBill\n" +
                    "FROM\n" +
                    "    (\n" +
                    "        SELECT\n" +
                    "            bill_detail.id_bill,\n" +
                    "            SUM(bill_detail.count * object.unitprice) AS priceBill\n" +
                    "        FROM\n" +
                    "            bill_detail bill_detail\n" +
                    "            JOIN object object ON bill_detail.id_object = object.id\n" +
                    "        GROUP BY\n" +
                    "            bill_detail.id_bill\n" +
                    "    ) t1\n" +
                    "    JOIN bill bill ON t1.id_bill = bill.id\n" +
                    "    JOIN customer customer ON bill.id_customer = customer.id\n" +
                    "    JOIN staff staff ON bill.id_staff = staff.id;"
                    ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String billId = rs.getString("id_bill"); // Corrected column name
                java.sql.Date date = rs.getDate("date"); // Corrected column name
                String nameCustomer = rs.getString("nameCustomer");
                String nameStaff = rs.getString("nameStaff");
                int priceBill = rs.getInt("priceBill");
                StaticticsBill p = new StaticticsBill(billId, date, nameCustomer, nameStaff, priceBill);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
