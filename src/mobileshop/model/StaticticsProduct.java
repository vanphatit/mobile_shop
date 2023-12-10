package mobileshop.model;

import java.util.Objects;

public class StaticticsProduct {
    private String objectId;
    private String objectName;
    private int countImport;
    private int countExport;

    public StaticticsProduct() {
    }

    public StaticticsProduct(String objectId, String objectName, int countImport, int countExport) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.countImport = countImport;
        this.countExport = countExport;
    }

    public String getId() {
        return objectId;
    }

    public void setId(String ObjectId) {
        this.objectId = ObjectId;
    }

    public String getName() {
        return objectName;
    }

    public void setName(String ObjectName) {
        this.objectName = ObjectName;
    }

    public int getCountImport() {
        return countImport;
    }

    public void setCountImport(int countImport) {
        this.countImport = countImport;
    }

    public int getCountExport() {
        return countExport;
    }

    public void setCountExport(int countExport) {
        this.countExport = countExport;
    }
}