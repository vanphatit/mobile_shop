package mobileshop.controller;

import mobileshop.dao.BillDAO;
import mobileshop.dao.BillDetailDAO;
import mobileshop.dao.ObjectDAO;
import mobileshop.dao.ReceiptNoteDetailDAO;
import mobileshop.model.*;
import mobileshop.model.Object;

import javax.swing.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

    public boolean addBillDetail(BillDetail billDetail) {
        if(billDetail != null && BillDAO.getInstance().selectById(billDetail.getIdBill()) != null
                                && getStockCount(billDetail.getIdObject()) >= 0) {
            if(BillDetailDAO.getInstance().insert(billDetail) == 1){
                return true;
            }
        }
        return false;
    }

    public boolean updateBillDetail(BillDetail billDetail) {
        if(billDetail != null && BillDAO.getInstance().selectById(billDetail.getIdBill()) != null
                && getStockCount(billDetail.getIdObject()) >= 0) {
            if(BillDetailDAO.getInstance().update(billDetail) == 1){
                return true;
            }
        }
        return false;
    }

    public int getStockCount(String idProduct) {
        int quantityInStock = 0;
        if(idProduct != null) {
            ArrayList<ReceiptNoteDetail> receiptNoteDetails = ReceiptNoteDetailDAO.getInstance().selectAll();
            for (ReceiptNoteDetail receiptNoteDetail : receiptNoteDetails) {
                if(receiptNoteDetail.getIdObject().equals(idProduct)) {
                    quantityInStock += receiptNoteDetail.getCount();
                }
            }
            ArrayList<BillDetail> billDetails = BillDetailDAO.getInstance().selectAll();
            for (BillDetail billDetail : billDetails) {
                if(billDetail.getIdObject().equals(idProduct)) {
                    quantityInStock -= billDetail.getCount();
                }
            }
        }
        return quantityInStock;
    }
}
