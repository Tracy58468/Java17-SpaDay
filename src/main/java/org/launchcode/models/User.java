package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "Name is required.")
    @Size(min = 5, max = 15, message = "Name must be between 5 and 15 characters")
    private String username;
    @Email
    private String email;
    @NotBlank(message = "Password must not be blank.")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @NotBlank(message = "Password verification field must not be empty.")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkVerifyPassword();
    }

    public void checkVerifyPassword() {
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            setVerifyPassword(null);
        }
    }
}

