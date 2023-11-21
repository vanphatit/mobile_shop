package mobileshop.model;

public class ObjectCategory {
    private String id;
    private String name;

    public ObjectCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //getter and setter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
