package mobileshop.model;

public class Customer {
    private String id;
    private String name;
    private String address;
    private Boolean gender;
    private java.sql.Date birthday;
    private String phone;
    private String idCategory;

    public Customer(String id, String name, String address, Boolean gender, java.sql.Date birthday, String phone, String idCategory) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.idCategory = idCategory;
    }

    //getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
}