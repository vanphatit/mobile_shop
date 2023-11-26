package mobileshop.model;

import java.sql.Date;

public class Staff {
    private String id;
    private String name;
    private String password;
    private String address;
    private Boolean gender;
    private java.sql.Date birthday;
    private String phone;
    private Boolean role;
    private String idShift;

    public Staff(String id, String name, String password, String address, Boolean gender, Date birthday, String phone, Boolean role, String idShift) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.role = role;
        this.idShift = idShift;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public String getIdShift() {
        return idShift;
    }

    public void setIdShift(String idShift) {
        this.idShift = idShift;
    }
}