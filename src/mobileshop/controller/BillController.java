package mobileshop.controller;

import mobileshop.dao.BillDAO;
import mobileshop.model.Bill;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BillController {
    public static BillController getInstance() {
        return new BillController();
    }

    public boolean addBill(Bill bill) {
        if(bill != null) {
            if(BillDAO.getInstance().insert(bill) == 1){
                return true;
            }
        }
        return false;
    }

    public boolean updateBill(String id, Date date, String status, String idCustomer, String idStaff) {

        Bill bill = new Bill(id, date, status, idCustomer, idStaff);
        if(bill != null) {
            if(BillDAO.getInstance().update(bill) == 1){
                return true;
            }
        }

        return false;
    }

    public boolean deleteBill(String id) {
        if(id != null) {
            Bill bill = BillDAO.getInstance().selectById(id);
            if(BillDAO.getInstance().delete(bill) == 1){
                return true;
            }
        }
        return false;
    }
}
