package model.json;

import java.time.LocalDate;

import controller.BOInterface;

public class NewsDO implements BOInterface {
    public int id;
    public String title;
    public String author;
    public String content;
    public String image;
    public int likesCount;
    public int dislikesCount;
    public int categoryID;

    @Override
    public int getId() {
        return id;
    }
}