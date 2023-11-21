package mobileshop.model;

public class Users {
    private String idStaff;
    private String password;
    private String idRole;

    public Users(String idStaff, String password, String idRole) {
        this.idStaff = idStaff;
        this.password = password;
        this.idRole = idRole;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }
}
