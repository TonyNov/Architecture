package controller.news;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.news.decor.NewsListInterface;
import model.json.JsonDAO;

public class NewsController implements NewsListInterface {
    private final List<NewsItemBO> newsList;

    public NewsController() {
        JsonDAO<NewsItemBO> newsDAO = new JsonDAO<>(NewsItemBO.class);
        newsList = newsDAO.getAll();
    }

    // Получение описания новости по id
    @Override
    public NewsItemBO getNewsById(int id) {
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getID() == id)
                return newsItemBO;
        return null;
    }

    @Override
    public NewsItemBO getNewsByTitle(String title) {
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getTitle().equals(title))
                return newsItemBO;
        return null;
    }

    @Override
    public List<NewsItemBO> getNewsKeyWord(String key) {
        List<NewsItemBO> temp = new ArrayList<>();
        for (NewsItemBO news : newsList) {
            if ((news.getTitle().toLowerCase().contains(key.toLowerCase()) ||
                    news.getContent().toLowerCase().contains(key.toLowerCase()))) {
                temp.add(news);
            }
        }
        return temp;
    }

    @Override
    public List<NewsItemBO> getAllNews() {
        return newsList;
    }

    // Получение списка авторов всех новостей
    @Override
    public List<String> getAllAuthors() {
        List<String> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            temp.add(newsItemBO.getAuthor());
        return temp;
    }

    // Получение заголовков новостей определенной категории
    @Override
    public List<String> getTitlesByCategory(int categoryId) {
        List<String> temp = new ArrayList<>();
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getCategoryID() == categoryId)
                temp.add(newsItemBO.getTitle());
        return temp;
    }

    // Добавление новости
    @Override
    public void addNews(String title, String content, String image, String author, LocalDate publicationDate,
            int categoryID) {
        NewsItemBO temp = new NewsItemBO();
        temp.setTitle(title);
        temp.setContent(content);
        temp.setPublicationDate(publicationDate);
        temp.setImage(image);
        temp.setCategoryID(categoryID);
        temp.setAuthor(author);
        newsList.add(temp);
    }

    // Обновление новости
    @Override
    public void updateNews(int id, String title, String content, String image, String author, LocalDate publicationDate,
            int categoryID) {
        for (NewsItemBO newsItemBO : newsList)
            if (newsItemBO.getID() == id) {
                newsItemBO.setTitle(title);
                newsItemBO.setContent(content);
                newsItemBO.setPublicationDate(publicationDate);
                newsItemBO.setImage(image);
                newsItemBO.setCategoryID(categoryID);
                newsItemBO.setAuthor(author);
            }
    }

    // Удаление новости
    @Override
    public void deleteNews(int id) {
        newsList.removeIf(item -> item.getID() == id);
    }
}
