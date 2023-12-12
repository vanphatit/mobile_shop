package mobileshop.controller;

import mobileshop.dao.ReceiptNoteDAO;
import mobileshop.dao.ReceiptNoteDetailDAO;
import mobileshop.model.ReceiptNote;
import mobileshop.model.ReceiptNoteDetail;

import javax.swing.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ReceiptNoteController {
    public static ReceiptNoteController getInstance(){
        return new ReceiptNoteController();
    }

    public boolean addReceiptNote(String id, Date date, String moreInfo, String idSuplier, String idStaff){
        try {
            ReceiptNote receiptNote = new ReceiptNote(id, date, moreInfo, idSuplier, idStaff);
            if(ReceiptNoteDAO.getInstance().insert(receiptNote) == 1) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public boolean updateReceiptNote(String id, Date date, String moreInfo, String idSuplier, String idStaff){
        try {
            // TODO add your handling code here:
            ReceiptNote receiptNote = new ReceiptNote(id, date, moreInfo, idSuplier, idStaff);
            if(ReceiptNoteDAO.getInstance().update(receiptNote) == 1) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteReceiptNoteById(String id){
        try {
            ReceiptNote receiptNote = ReceiptNoteDAO.getInstance().selectById(id);
            if(ReceiptNoteDAO.getInstance().delete(receiptNote) == 1) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean addReceiptNoteDetail(ReceiptNoteDetail receiptNoteDetail){
        try {
            if(ReceiptNoteDetailDAO.getInstance().insert(receiptNoteDetail) == 1) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean updateReceiptNoteDetail(ReceiptNoteDetail receiptNoteDetail){
        try {
            if(ReceiptNoteDetailDAO.getInstance().update(receiptNoteDetail) == 1) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteReceiptNoteDetailById(String idObject, String idReceipt){
        try {
            ReceiptNoteDetail receiptNoteDetail = ReceiptNoteDetailDAO.getInstance().selectbyId(idReceipt, idObject);
            if(ReceiptNoteDetailDAO.getInstance().delete(receiptNoteDetail) == 1) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
