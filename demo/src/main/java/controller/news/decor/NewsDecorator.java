package controller.news.decor;

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
        System.out.println("Декоратор: Искать новости по ключевому слову '" + key + "'");
        return decoratedNews.getNewsKeyWord(key);
    }

    @Override
    public List<NewsItemBO> getAllNews() {
        System.out.println("Декоратор: Все новости");
        return decoratedNews.getAllNews();
    }
}
