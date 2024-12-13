package controller.news.decor;

import java.util.List;

import controller.news.NewsItemBO;

public interface NewsListInterface {
    List<NewsItemBO> getNewsKeyWord(String key);

    List<NewsItemBO> getAllNews();

    NewsItemBO getNewsById(int id);

    NewsItemBO getNewsByTitle(String title);

    List<String> getAllAuthors();

    List<String> getTitlesByCategory(int categoryId);

    void addNews(String title, String content, String image, String author, String publicationDate,
            int categoryID);

    void updateNews(int id, String title, String content, String image, String author, String publicationDate,
            int categoryID);

    void deleteNews(int id);
}
