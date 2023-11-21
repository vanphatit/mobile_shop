package mobileshop.model;

public class ReceptNoteDetail {
    private int unitPrice;
    private int count;
    private String idObject;
    private String idRecept;

    public ReceptNoteDetail(int unitPrice, int count, String idObject, String idRecept) {
        this.unitPrice = unitPrice;
        this.count = count;
        this.idObject = idObject;
        this.idRecept = idRecept;
    }

    //getter and setter
    public int getUnitPrice() {
        return unitPrice;
    }
    public int getCount() {
        return count;
    }
    public String getIdObject() {
        return idObject;
    }
    public String getIdRecept() {
        return idRecept;
    }
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setIdObject(String idObject) {
        this.idObject = idObject;
    }
    public void setIdRecept(String idRecept) {
        this.idRecept = idRecept;
    }
}
