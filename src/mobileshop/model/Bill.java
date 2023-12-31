package mobileshop.model;

public class Bill {
    private String id;
    private java.sql.Date date;
    private String status;
    private String idCustomer;
    private String idStaff;

    public Bill(String id, java.sql.Date date, String status, String idCustomer, String idStaff) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.idCustomer = idCustomer;
        this.idStaff = idStaff;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }
}