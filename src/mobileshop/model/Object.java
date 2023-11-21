package mobileshop.model;

public class Object {
    private String id;
    private String name;
    private String status;
    private String manufacturer;
    private int unitPrice;
    private String idCategory;

    public Object(String id, String name, String status, String manufacturer, int unitPrice, String idCategory) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.manufacturer = manufacturer;
        this.unitPrice = unitPrice;
        this.idCategory = idCategory;
    }

    //getter and setter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public int getUnitPrice() {
        return unitPrice;
    }
    public String getIdCategory() {
        return idCategory;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name= name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
}
