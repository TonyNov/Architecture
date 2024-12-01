package controller;

import java.util.List;

import controller.news.NewsController;
import controller.news.NewsItemBO;
import controller.news.decor.PositiveNewsController;
import view.api.dto.ReaderNewsItemDTO;
import view.api.dto.ReaderNewsListDTO;

public class FacadeController {
    NewsController newsController = new NewsController();
    PositiveNewsController positiveNewsController = new PositiveNewsController(newsController);

    public ReaderNewsListDTO getAllNews() {
        ReaderNewsListDTO listDTO = new ReaderNewsListDTO();
        List<NewsItemBO> list = positiveNewsController.getAllNews();
        for (int i = 0; i < list.size(); i++) {
            listDTO.newsItems.add(new ReaderNewsItemDTO());
            listDTO.newsItems.get(i).author = list.get(i).getAuthor();
            listDTO.newsItems.get(i).id = list.get(i).getId();
            listDTO.newsItems.get(i).title = list.get(i).getTitle();
            listDTO.newsItems.get(i).content = list.get(i).getContent();
            listDTO.newsItems.get(i).category = list.get(i).getCategoryID();
        }
        return listDTO;
    }

    public ReaderNewsItemDTO getNewsByID(int id) {
        ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
        NewsItemBO elem = newsController.getNewsById(id);
        newsItem.author = elem.getAuthor();
        newsItem.id = elem.getId();
        newsItem.title = elem.getTitle();
        newsItem.content = elem.getContent();
        newsItem.category = elem.getCategoryID();
        return newsItem;
    }

    public ReaderNewsItemDTO getNewsByTitle(String title) {
        ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
        NewsItemBO elem = newsController.getNewsByTitle(title);
        newsItem.author = elem.getAuthor();
        newsItem.id = elem.getId();
        newsItem.title = elem.getTitle();
        newsItem.content = elem.getContent();
        newsItem.category = elem.getCategoryID();
        return newsItem;
    }

    public ReaderNewsListDTO getNewsByKeyWord(String key) {
        ReaderNewsListDTO listDTO = new ReaderNewsListDTO();
        ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
        for (NewsItemBO elem : newsController.getNewsKeyWord(key)) {
            newsItem.author = elem.getAuthor();
            newsItem.id = elem.getId();
            newsItem.title = elem.getTitle();
            newsItem.content = elem.getContent();
            newsItem.category = elem.getCategoryID();
            listDTO.newsItems.add(newsItem);
        }
        return listDTO;
    }
}