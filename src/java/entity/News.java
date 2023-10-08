/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Mai
 */
public class News extends NewsType{
//NewsID	Title	Image	Create_Date	NewsContent	Create_By	CourseID

    private int NewsID;
    private String title;
    private String image;
    private String created_date;
    private String content;
    private String create_by;
    private int status;
    private int type;
    private String URL;

    public News() {
    }

    public int getNewsID() {
        return NewsID;
    }

    public void setNewsID(int NewsID) {
        this.NewsID = NewsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "News{" + "NewsID=" + NewsID + ", title=" + title + ", image=" + image + ", created_date=" + created_date + ", content=" + content + ", create_by=" + create_by + ", status=" + status + ", type=" + type + '}';
    }

}
