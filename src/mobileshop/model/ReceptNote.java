package mobileshop.model;

import java.sql.Date;

public class ReceptNote {
    private String id;
    private java.sql.Date date;
    private String moreInfo;
    private String idSuplier;
    private String idStaff;

    public ReceptNote(String id, Date date, String moreInfo, String idSuplier, String idStaff) {
        this.id = id;
        this.date = date;
        this.moreInfo = moreInfo;
        this.idSuplier = idSuplier;
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

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(String idSuplier) {
        this.idSuplier = idSuplier;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }
}