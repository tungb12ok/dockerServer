/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author msi
 */
public class Mentor extends User {

    private int mentor_id;
    private String skill;
    private String job;
    private int UserID;
    private double amount;

    public Mentor() {
    }

    public Mentor(int mentor_id, String skill, String job, int UserID, int id, String username, String password, String full_name, String mail, int roleID, String phone, int Verified, String birth, String avatar, int status) {
        super(id, username, password, full_name, mail, roleID, phone, Verified, birth, avatar, status);
        this.mentor_id = mentor_id;
        this.skill = skill;
        this.job = job;
        this.UserID = UserID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(int mentor_id) {
        this.mentor_id = mentor_id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

}
