package controller.news.decor;

import java.util.List;

import controller.news.NewsItemBO;

public interface NewsListInterface {

    List<NewsItemBO> getNewsKeyWord(String key);

    List<NewsItemBO> getAllNews();

}
