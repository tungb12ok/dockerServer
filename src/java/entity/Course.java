/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author msi
 */
public class Course extends CourseType {

    private int ID;
    private String Course_name;
    private String Description;
    private int Type_ID;
    private double price;
    private String Public_date;
    private int MentorID;
    private String Image;
    private int Status;
    private String Mentor_name;
    private String URL;

    public Course() {
    }

    public Course(int ID, String Course_name, String Description, int Type_ID, double price, String Public_date, int MentorID, String Image, int Status) {
        this.ID = ID;
        this.Course_name = Course_name;
        this.Description = Description;
        this.Type_ID = Type_ID;
        this.price = price;
        this.Public_date = Public_date;
        this.MentorID = MentorID;
        this.Image = Image;
        this.Status = Status;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getMentor_name() {
        return Mentor_name;
    }

    public void setMentor_name(String Mentor_name) {
        this.Mentor_name = Mentor_name;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String Course_name) {
        this.Course_name = Course_name;
    }

    public String getDescription() {
        return Description;
    }

    public String getDescription(int x) {
        if (x == 1) {
            String[] words = Description.split(" ");
            if (words.length >= 40) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 40; i++) {
                    sb.append(words[i]).append(" ");
                }
                return sb.toString().trim(); // Loại bỏ khoảng trắng cuối cùng
            }
        }
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getType_ID() {
        return Type_ID;
    }

    public void setType_ID(int Type_ID) {
        this.Type_ID = Type_ID;
    }

    public String getPublic_date() {
        return Public_date;
    }

    public void setPublic_date(String Public_date) {
        this.Public_date = Public_date;
    }

    public int getMentorID() {
        return MentorID;
    }

    public void setMentorID(int MentorID) {
        this.MentorID = MentorID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" + "ID=" + ID + ", Course_name=" + Course_name + ", Description=" + Description + ", Type_ID=" + Type_ID + ", price=" + price + ", Public_date=" + Public_date + ", MentorID=" + MentorID + ", Image=" + Image + ", Status=" + Status + '}';
    }

}
