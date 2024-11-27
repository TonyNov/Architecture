package controller.news.decor;

import java.time.LocalDate;
import java.util.List;

import controller.news.NewsItemBO;

public interface Interface {
    NewsItemBO getNewsById(int id);

    NewsItemBO getNewsByTitle(String title);

    List<NewsItemBO> getNewsKeyWord(String key);

    List<NewsItemBO> getNewsByKeyWord(String key);

    List<NewsItemBO> getAllNews();

    List<String> getAllAuthors();

    List<String> getTitlesByCategory(int categoryId);

    void addNews(String title, String content, String image, String author, LocalDate publicationDate, int categoryID);

    void updateNews(int id, String title, String content, String image, String author, LocalDate publicationDate,
            int categoryID);

    void deleteNews(int id);

}
