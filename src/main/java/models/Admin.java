package models;


import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class Admin implements Serializable {

    private String email;
    private String password;


    public Admin() {
    }

    public Admin( String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    


	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
