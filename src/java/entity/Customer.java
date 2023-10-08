/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author msi
 */
public class Customer extends User {

    private int customer_id;
    private String address;
    private int UserID;

    public Customer() {
    }

    public Customer(int customer_id, String address, int UserID, int id, String username, String password, String full_name, String mail, int roleID, String phone, int Verified, String birth, String avatar, int status) {
        super(id, username, password, full_name, mail, roleID, phone, Verified, birth, avatar, status);
        this.customer_id = customer_id;
        this.address = address;
        this.UserID = UserID;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    @Override
    public String toString() {
        return super.toString()+"Customer{" + "customer_id=" + customer_id + ", address=" + address + ", UserID=" + UserID + '}';
    }
    
}
