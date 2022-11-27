package model;

public class Customer {
    private int id;
    private int id_customer_type;
    private String name;
    private String date_of_birth;
    private String gender;
    private int id_card;
    private int phone_number;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int id, int id_customer_type, String name, String date_of_birth, String gender, int id_card, int phone_number, String email, String address) {
        this.id = id;
        this.id_customer_type = id_customer_type;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_customer_type() {
        return id_customer_type;
    }

    public void setId_customer_type(int id_customer_type) {
        this.id_customer_type = id_customer_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_name(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
