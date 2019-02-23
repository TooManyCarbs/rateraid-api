package com.rateraid.rateraidapi.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rateraid.rateraidapi.core.BaseEntity;
import com.rateraid.rateraidapi.review.Review;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends BaseEntity {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @OneToMany
    private List<Review> reviews;
    private int userRanking;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    protected User() {
        super();
    }

    public User(String username, String password, String[] roles) {
        this();
        this.username = username;
        setPassword(password);
        this.roles = roles;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public int getUserRanking() {
        return userRanking;
    }

    public void setUserRanking(int userRanking) {
        this.userRanking = userRanking;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
