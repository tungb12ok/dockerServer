/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author msi
 */
public class CourseType {

    private int TypeID;
    private String Type_name;
    private String Created_date;
    private int Status;
    private String Description;
    private String Modified_date;

    public CourseType() {
    }

    public CourseType(int TypeID, String Type_name, String Created_date, int Status, String Description, String Modified_date) {
        this.TypeID = TypeID;
        this.Type_name = Type_name;
        this.Created_date = Created_date;
        this.Status = Status;
        this.Description = Description;
        this.Modified_date = Modified_date;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }

    public String getType_name() {
        return Type_name;
    }

    public void setType_name(String Type_name) {
        this.Type_name = Type_name;
    }

    public String getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(String Created_date) {
        this.Created_date = Created_date;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getModified_date() {
        return Modified_date;
    }

    public void setModified_date(String Modified_date) {
        this.Modified_date = Modified_date;
    }

}
