/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author msi
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String full_name;
    private String mail;
    private int roleID;
    private String phone;
    private int Verified;
    private String birth;
    private String avatar;
    private int status;

    public User() {
    }

    // Constructor for login
    public User(String username, String password, int id, int roleID, String mail, int Verified, String avatar) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.roleID = roleID;
        this.mail = mail;
        this.Verified = Verified;
        this.avatar = avatar;
    }
    //Constructor for get all

    public User(int id, String username, String password, String full_name, String mail, int roleID, String phone, int Verified, String birth, String avatar, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.mail = mail;
        this.roleID = roleID;
        this.phone = phone;
        this.Verified = Verified;
        this.birth = birth;
        this.avatar = avatar;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User(int id, String username, String full_name, String mail, int roleID, String phone, int Verified, String birth) {
        this.id = id;
        this.username = username;
        this.full_name = full_name;
        this.mail = mail;
        this.roleID = roleID;
        this.phone = phone;
        this.Verified = Verified;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getVerified() {
        return Verified;
    }

    public void setVerified(int Verified) {
        this.Verified = Verified;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", full_name=" + full_name + ", mail=" + mail + ", roleID=" + roleID + ", phone=" + phone + ", Verified=" + Verified + ", birth=" + birth + ", avatar=" + avatar + ", status=" + status + '}';
    }

}
