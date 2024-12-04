package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.categories.CategoriesController;
import controller.categories.CategoryBO;
import controller.news.NewsController;
import controller.news.NewsItemBO;
import controller.news.decor.NewsListInterface;
import controller.news.decor.PositiveNewsController;
import view.api.dto.CategoryDTO;
import view.api.dto.CategoryesListDTO;
import view.api.dto.NewsItemDTO;
import view.api.dto.NewsListDTO;

public class FacadeController {
    NewsListInterface newsController;

    public FacadeController() {

        LocalDate today = LocalDate.now();
        LocalDate newYearsDay = LocalDate.of(today.getYear() + 1, 1, 1);
        if (java.time.temporal.ChronoUnit.DAYS.between(today, newYearsDay) < 31) {
            newsController = new PositiveNewsController(new NewsController());
        } else
            newsController = new NewsController();
    }

    CategoriesController categoriesController = new CategoriesController();

    public NewsListDTO getAllNews() {
        NewsListDTO listDTO = new NewsListDTO();
        List<NewsItemBO> list = newsController.getAllNews();
        for (int i = 0; i < list.size(); i++) {
            listDTO.items.add(new NewsItemDTO());
            listDTO.items.get(i).author = list.get(i).getAuthor();
            listDTO.items.get(i).id = list.get(i).getId();
            listDTO.items.get(i).title = list.get(i).getTitle();
            listDTO.items.get(i).content = list.get(i).getContent();
            listDTO.items.get(i).categoryID = list.get(i).getCategoryID();
            listDTO.items.get(i).image = list.get(i).getImage();
            listDTO.items.get(i).publicationDate = list.get(i).getPublicationDate();
            listDTO.items.get(i).likesCount = list.get(i).getLikesCount();
            listDTO.items.get(i).dislikesCount = list.get(i).getDislikesCount();
        }
        return listDTO;
    }

    public NewsItemDTO getNewsByID(int id) {
        NewsItemDTO newsItem = new NewsItemDTO();
        NewsItemBO elem = newsController.getNewsById(id);
        newsItem.author = elem.getAuthor();
        newsItem.id = elem.getId();
        newsItem.title = elem.getTitle();
        newsItem.content = elem.getContent();
        newsItem.categoryID = elem.getCategoryID();
        newsItem.image = elem.getImage();
        newsItem.publicationDate = elem.getPublicationDate();
        newsItem.likesCount = elem.getLikesCount();
        newsItem.dislikesCount = elem.getDislikesCount();
        return newsItem;
    }

    public NewsItemDTO getNewsByTitle(String title) {
        NewsItemDTO newsItem = new NewsItemDTO();
        NewsItemBO elem = newsController.getNewsByTitle(title);
        newsItem.author = elem.getAuthor();
        newsItem.id = elem.getId();
        newsItem.title = elem.getTitle();
        newsItem.content = elem.getContent();
        newsItem.categoryID = elem.getCategoryID();
        newsItem.image = elem.getImage();
        newsItem.publicationDate = elem.getPublicationDate();
        newsItem.likesCount = elem.getLikesCount();
        newsItem.dislikesCount = elem.getDislikesCount();
        return newsItem;
    }

    public NewsListDTO getNewsByKeyWord(String key) {
        NewsListDTO listDTO = new NewsListDTO();
        NewsItemDTO newsItem = new NewsItemDTO();
        for (NewsItemBO elem : newsController.getNewsKeyWord(key)) {
            newsItem.author = elem.getAuthor();
            newsItem.id = elem.getId();
            newsItem.title = elem.getTitle();
            newsItem.content = elem.getContent();
            newsItem.categoryID = elem.getCategoryID();
            newsItem.image = elem.getImage();
            newsItem.publicationDate = elem.getPublicationDate();
            newsItem.likesCount = elem.getLikesCount();
            newsItem.dislikesCount = elem.getDislikesCount();
            listDTO.items.add(newsItem);
        }
        return listDTO;
    }

    public void addNews(NewsItemDTO news) {
        newsController.addNews(news.title, news.content, news.image, news.author, news.publicationDate,
                news.categoryID);
    }

    public void updateNews(NewsItemDTO news) {
        newsController.updateNews(news.id, news.title, news.content, news.image, news.author, news.publicationDate,
                news.categoryID);
    }

    public void deleteNews(int id) {
        newsController.deleteNews(id);
    }

    public void addCategory(String title, String content) {
        categoriesController.addCategory(title, content);
    }

    public List<CategoryDTO> getNotEmptyCategories() {
        List<CategoryDTO> temp = new ArrayList<>();
        for (CategoryBO category : categoriesController.getNotEmptyCategories()) {
            CategoryDTO tempCategory = new CategoryDTO();
            tempCategory.id = category.getId();
            tempCategory.discription = category.getDiscription();
            tempCategory.name = category.getTitle();
            tempCategory.newsList = category.getAllNews();
            temp.add(tempCategory);
        }
        return temp;
    }

    public CategoryesListDTO getAllCategories() {
        CategoryesListDTO temp = new CategoryesListDTO();
        for (CategoryBO category : categoriesController.getAllCategories()) {
            CategoryDTO tempCategory = new CategoryDTO();
            tempCategory.id = category.getId();
            tempCategory.discription = category.getDiscription();
            tempCategory.name = category.getTitle();
            tempCategory.newsList = category.getAllNews();
            temp.items.add(tempCategory);
        }
        return temp;
    }

    public CategoryDTO getCategory(int id) {
        CategoryDTO temp = new CategoryDTO();
        for (CategoryBO elem : categoriesController.categoriesList)
            if (elem.getId() == id) {

                temp.id = elem.getId();
                temp.discription = elem.getDiscription();
                temp.name = elem.getTitle();
                temp.newsList = elem.getAllNews();
                return temp;
            }
        return temp;
    }

    public void updateCategory(CategoryDTO newCategory) {
        CategoryBO temp = new CategoryBO(newCategory.name, newCategory.discription);
        temp.setId(newCategory.id);
        for (NewsItemBO elem : newCategory.newsList)
            temp.addToList(elem);
        categoriesController.addCategory(temp);
    }

    public void removeCategory(int id) {
        categoriesController.removeCategory(id);
    }

    public CategoryesListDTO getCategoriesByKey(String str) {
        CategoryesListDTO temp = new CategoryesListDTO();
        for (CategoryBO category : categoriesController.getCategoriesByKey(str)) {
            CategoryDTO tempCategory = new CategoryDTO();
            tempCategory.id = category.getId();
            tempCategory.discription = category.getDiscription();
            tempCategory.name = category.getTitle();
            tempCategory.newsList = category.getAllNews();
            temp.items.add(tempCategory);
        }
        return temp;
    }
}