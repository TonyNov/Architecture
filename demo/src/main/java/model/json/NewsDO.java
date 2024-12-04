package model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsDO {
    @JsonProperty("id")
    public int id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("author")
    public String author;

    @JsonProperty("content")
    public String content;

    @JsonProperty("image")
    public String image;

    @JsonProperty("publication_date")
    public java.time.LocalDate publicationDate;

    @JsonProperty("likes_count")
    public int likesCount;

    @JsonProperty("dislikes_count")
    public int dislikesCount;

    @JsonProperty("category_id")
    public int categoryID;
}