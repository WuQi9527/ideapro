package cn.itcast.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String Username;
    private String password;
    private Integer age;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
