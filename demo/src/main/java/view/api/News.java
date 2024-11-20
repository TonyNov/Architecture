package view.api;

public class News {
    private int id;
    private String content;
    private String title;
    private String author;
    private String category;

    public News() {
        id = 0;
        content = "emptycontent";
        title = "emptytitle";
        author = "noname";
        category="categoryName";
    }
    public News(int newsID,String newsContent,String newsTitle,String newsAuthor, String newsCategoty) {
        id = newsID;
        content = newsContent;
        title = newsTitle;
        author = newsAuthor;
        category=newsCategoty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}