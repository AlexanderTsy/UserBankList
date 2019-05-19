package by.aliaxandrtsyhanok.devincubator;

public class User {
    private int userid;
    private String name;
    private String sureName;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public User(int userid, String name, String sureName) {
        this.userid = userid;
        this.name = name;
        this.sureName = sureName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                '}';
    }
}
