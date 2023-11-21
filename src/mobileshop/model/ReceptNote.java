package mobileshop.model;

import java.util.Date;

public class ReceptNote {
    private String id;
    private Date date;
    private String moreInfo;
    private String idSuplier;

    public ReceptNote(String id, Date date, String moreInfo, String idSuplier) {
        this.id = id;
        this.date = date;
        this.moreInfo = moreInfo;
        this.idSuplier = idSuplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
