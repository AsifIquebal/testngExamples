package dataSupplier;

import lombok.Data;

@Data
public class User {
    public String username;
    public String password;
    public User(String username1, String password1) {
        this.username = username1;
        this.password = password1;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
