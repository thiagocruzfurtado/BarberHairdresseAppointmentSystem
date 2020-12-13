package models;

public class Customer {
    private Integer id;
    private String name,email,mobile,password,location;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Customer(Integer id, String name, String email, String mobile, String password, String location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.location = location;
    }

    public Customer(String name, String email, String mobile, String password, String location) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.location = location;
    }

    public Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
}
