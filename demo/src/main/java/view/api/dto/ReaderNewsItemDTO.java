package view.api.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReaderNewsItemDTO {

    @JsonProperty("id")
    public int id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("author")
    public String author;
    @JsonProperty("content")
    public String content;
    @JsonProperty("category")
    public int category;

    public ReaderNewsItemDTO() {
    }

    public ReaderNewsItemDTO(int id, String title, String author, String content, int category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.category = category;
    }
}
