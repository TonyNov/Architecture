package controller.news;

import java.time.LocalDate;

public class NewsItemBO {
    private Long id;
    private String title;
    private String content;
    private String image;
    private LocalDate publicationDate;
    private int likesCount;
    private int dislikesCount;

    public NewsItemBO() {
        id = 0L;
        title = "noTitle";
        content = "noContent";
        image = "image";
        publicationDate = LocalDate.of(2024, 11, 20);
        likesCount = 0;
        dislikesCount = 0;
    }

    // Геттеры и сеттеры для всех полей
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
}
