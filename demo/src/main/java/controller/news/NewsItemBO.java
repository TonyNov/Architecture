package controller.news;

import java.time.LocalDate;

import model.json.JsonItem;

public class NewsItemBO implements JsonItem {
    private int id;
    private String title;
    private String content;
    private String image;
    private LocalDate publicationDate;
    private int likesCount;
    private int dislikesCount;
    private int categoryID;
    private String author;

    public NewsItemBO() {
        id = 0;
        title = "noTitle";
        content = "noContent";
        image = "image";
        publicationDate = LocalDate.of(2024, 11, 20);
        likesCount = 0;
        dislikesCount = 0;
        categoryID = 0;
        author = "noName";
    }

    @Override
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getDislikesCount() {
        return dislikesCount;
    }

    public void setDislikesCount(int dislikesCount) {
        this.dislikesCount = dislikesCount;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
