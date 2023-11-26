package mobileshop.model;

public class Suplier {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String status;

    public Suplier(String id, String name, String address, String phone, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    //getter and setter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phone;
    }
    public String getStatus() {
        return status;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name= name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
