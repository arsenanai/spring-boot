package kz.weber.demo.topic;

public class Topic {
    public Topic(){}

    public Topic(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    private Integer id;
    private String name, description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
