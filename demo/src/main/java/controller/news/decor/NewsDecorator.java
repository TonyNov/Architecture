package controller.news.decor;

import java.util.ArrayList;
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
    public List<NewsItemBO> getNewsKeyWord(String key) {
        List<NewsItemBO> result = new ArrayList<>(decoratedNews.getNewsKeyWord(key));
        // Здесь вы можете добавить дополнительное поведение
        System.out.println("Декоратор: Искать новости по ключевому слову '" + key + "'");
        return result;
    }

    @Override
    public List<NewsItemBO> getAllNews() {
        return decoratedNews.getAllNews();
    }
}
