package mobileshop.model;

import java.sql.Date;

public class StaticticsReceiptNote {
    private String id;
    private java.sql.Date date;
    private String more_info;
    private String nameSuplier;
    private String nameStaff;
    private int UnitPrice;

    public StaticticsReceiptNote() {
    }

    public StaticticsReceiptNote(String id, Date date, String more_info, String nameSuplier, String nameStaff, int unitPrice) {
        this.id = id;
        this.date = date;
        this.more_info = more_info;
        this.nameSuplier = nameSuplier;
        this.nameStaff = nameStaff;
        UnitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getMore_info() {
        return more_info;
    }

    public void setMore_info(String more_info) {
        this.more_info = more_info;
    }

    public String getNameSuplier() {
        return nameSuplier;
    }

    public void setNameSuplier(String nameSuplier) {
        this.nameSuplier = nameSuplier;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int UnitPrice) {
        this.UnitPrice = UnitPrice;
    }
}