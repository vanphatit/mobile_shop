package mobileshop.model;

import java.sql.Date;

public class StaticticsBill {
    private String billId;
    private java.sql.Date date;
    private String nameCustomer;
    private String nameStaff;
    private int priceBill;

    public StaticticsBill() {
    }

    public StaticticsBill(String billId, Date date, String nameCustomer, String nameStaff, int priceBill) {
        this.billId = billId;
        this.date = date;
        this.nameCustomer = nameCustomer;
        this.nameStaff = nameStaff;
        this.priceBill = priceBill;
    }

    public String getId() {
        return billId;
    }

    public void setId(String billId) {
        this.billId = billId;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getnameCustomer() {
        return nameCustomer;
    }

    public void setnameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getnameStaff() {
        return nameStaff;
    }

    public void setnameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public int getpriceBill() {
        return priceBill;
    }

    public void setpriceBill(int priceBill) {
        this.priceBill = priceBill;
    }
}