package view.api.dto;

import java.time.LocalDate;

public class NewsItemDTO {

    public int id;
    public String title;
    public String author;
    public String content;
    public String image;
    public LocalDate publicationDate;
    public int likesCount;
    public int dislikesCount;
    public int categoryID;

    public NewsItemDTO() {
    }
}
