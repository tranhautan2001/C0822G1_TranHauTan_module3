package model;

public class Product {
    private  int id;
    private String name;
    private String point;
    private String describe;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, String point, String describe, String producer) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.describe = describe;
        this.producer = producer;
    }

    public Product(String name, String point, String describe, String producer) {
        this.name = name;
        this.point = point;
        this.describe = describe;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
