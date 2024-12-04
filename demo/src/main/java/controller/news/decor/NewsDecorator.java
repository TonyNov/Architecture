package controller.news.decor;

import java.time.LocalDate;
import java.util.List;

import controller.news.NewsController;
import controller.news.NewsItemBO;

public abstract class NewsDecorator implements NewsListInterface {
    protected NewsController decoratedNews;

    protected NewsDecorator() {

    }

    protected NewsDecorator(NewsController decoratedNews) {
        this.decoratedNews = decoratedNews;
    }
@Override
    public NewsItemBO getNewsById(int id) {
        return decoratedNews.getNewsById(id);
    }
    @Override
    public List<NewsItemBO> getNewsKeyWord(String key) {
        return decoratedNews.getNewsKeyWord(key);
    }

    @Override
    public List<NewsItemBO> getAllNews() {
        return decoratedNews.getAllNews();
    }
    @Override
    public NewsItemBO getNewsByTitle(String title) {
        return decoratedNews.getNewsByTitle(title);
    }

    @Override
    public List<String> getAllAuthors() {
        return decoratedNews.getAllAuthors();
    }

    @Override
    public List<String> getTitlesByCategory(int categoryId) {
        return decoratedNews.getTitlesByCategory(categoryId);
    }

    @Override
    public void addNews(String title, String content, String image, String author, LocalDate publicationDate,
            int categoryID) {
        decoratedNews.addNews(title, content, image, author, publicationDate, categoryID);
    }

    @Override
    public void updateNews(int id, String title, String content, String image, String author, LocalDate publicationDate,
            int categoryID) {
        decoratedNews.updateNews(id, title, content, image, author, publicationDate, categoryID);
    }

    @Override
    public void deleteNews(int id) {
        decoratedNews.deleteNews(id);
    }
}
