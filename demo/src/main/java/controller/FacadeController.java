package controller;

import controller.news.NewsController;
import controller.news.NewsItemBO;
import view.api.dto.ReaderNewsItemDTO;
import view.api.dto.ReaderNewsListDTO;

public class FacadeController {
    NewsController newsController = new NewsController();

    public FacadeController() {

    }

    public ReaderNewsListDTO getAllNews() {
        ReaderNewsListDTO listDTO = new ReaderNewsListDTO();
        ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
        for (NewsItemBO elem : newsController.getAllNews()) {
            newsItem.author = elem.getAuthor();
            newsItem.id = elem.getId();
            newsItem.title = elem.getTitle();
            newsItem.content = elem.getContent();
            newsItem.category = elem.getCategoryID();
            listDTO.newsItems.add(newsItem);
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

    /*
     * public Response getAllCategories() {
     * ReaderNewsItemDTO newsItem = new ReaderNewsItemDTO();
     * newsItem.author = "Иван Иванов";
     * newsItem.id = 123;
     * newsItem.title = "Новость номер один";
     * newsItem.content = "Это содержание новости";
     * return Response.ok(newsItem).type(MediaType.APPLICATION_JSON).build();
     * }
     */
}