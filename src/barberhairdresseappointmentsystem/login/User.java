package barberhairdresseappointmentsystem.login;

/**
 * modeling the user. We can have an object that encapsulates
 * everything that has to do with the user

 */
public class User {

    private int id;
    private int userAccountTypdId;
    private String fullName;
    private String mobile;
    private String email;
    private String location;
    private String password;

    public User() {

    }

    public User(
            String email,
            String password) {
        this.email = email;
        this.password = password;
    }

    public User(
            int id,
            int userAccountTypeId,
            String fullName,
            String mobile,
            String email,
            String location,
            String password) {
        this.id = id;
        this.userAccountTypdId = userAccountTypeId;
        this.fullName = fullName;
        this.mobile = mobile;
        this.email = email;
        this.location = location;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the userAccountTypdId
     */
    public int getUserAccountTypdId() {
        return userAccountTypdId;
    }

    /**
     * @param userAccountTypdId the userAccountTypdId to set
     */
    public void setUserAccountTypdId(int userAccountTypdId) {
        this.userAccountTypdId = userAccountTypdId;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
