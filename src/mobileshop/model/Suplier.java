package mobileshop.model;

public class Suplier {
    private String id;
    private String name;
    private String address;
    private String phone;
    private boolean status;

    public Suplier(String id, String name, String address, String phone, boolean status) {
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
    public boolean getStatus() {
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
    public void setStatus(boolean status) {
        this.status = status;
    }
}
