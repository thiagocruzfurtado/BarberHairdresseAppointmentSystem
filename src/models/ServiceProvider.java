package models;

public class ServiceProvider {
    private Integer id;
    private String name,email,mobile,password,location;

    public ServiceProvider(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public ServiceProvider(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ServiceProvider(String name, String email, String mobile, String password) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public ServiceProvider(Integer id, String name, String location, String mobile) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobileNumber() {
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
}
