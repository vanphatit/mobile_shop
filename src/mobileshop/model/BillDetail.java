package mobileshop.model;

public class BillDetail {
    private int count;
    private String idObject;
    private String idBill;

    public BillDetail(int count, String idObject, String idBill) {
        this.count = count;
        this.idObject = idObject;
        this.idBill = idBill;
    }

    //getter and setter
    public int getCount() {
        return count;
    }
    public String getIdObject() {
        return idObject;
    }
    public String getIdBill() {
        return idBill;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setIdObject(String idObject) {
        this.idObject = idObject;
    }
    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }
}
