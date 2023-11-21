package mobileshop.model;

public class CustomerCategory {
    private String id;
    private String name;
    private double discount;

    public CustomerCategory(String id, String name, double discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    //getter and setter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getDiscount() {
        return discount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name= name;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
