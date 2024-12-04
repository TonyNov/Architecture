package controller.news.decor;

import java.util.ArrayList;
import java.util.List;

import controller.news.NewsController;
import controller.news.NewsItemBO;

public class PositiveNewsController extends NewsDecorator {

    public PositiveNewsController(NewsController decoratedNews) {
        super(decoratedNews);
    }

    @Override
    public List<NewsItemBO> getNewsKeyWord(String key) {
        System.out.println("Декоратор: Искать новости по ключевому слову '" + key + "'");
        List<NewsItemBO> temp = new ArrayList<>(decoratedNews.getNewsKeyWord(key));
        List<NewsItemBO> result = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++)
            if (!temp.get(i).getAuthor().equals("Иванова А.С."))
                result.add(temp.get(i));
        return result;
    }

    @Override
    public List<NewsItemBO> getAllNews() {
        System.out.println("Декоратор: Все новости");
        List<NewsItemBO> temp = new ArrayList<>(decoratedNews.getAllNews());
        List<NewsItemBO> result = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++)
            if (!temp.get(i).getAuthor().equals("Иванова А.С."))
                result.add(temp.get(i));
        return result;
    }

    
}