package controller.categories;

import java.util.ArrayList;
import java.util.List;

import controller.news.NewsItemBO;

public class CategoryBO {

    private int id;
    private String title;
    private String discription;
    private final List<NewsItemBO> newsList = new ArrayList<>();

    public CategoryBO(String n, String d) {
        title = n;
        discription = d;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        title = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addToList(NewsItemBO value) {
        newsList.add(value);
    }

    public void addToBeginning(NewsItemBO value) {
        newsList.add(0, value);
    }

    public void removeNewsByID(int newsID) {
        for (int i = 0; i < newsList.size(); i++)
            if (newsList.get(i).getId() == newsID) {
                newsList.remove(i);
                return;
            }
    }

    public int indexOf(NewsItemBO value) {
        return newsList.indexOf(value);
    }

    public int lastIndexOf(NewsItemBO value) {
        return newsList.lastIndexOf(value);
    }

    public boolean contains(NewsItemBO value) {
        return newsList.contains(value);
    }

    public int size() {
        return newsList.size();
    }

    public void clear() {
        newsList.clear();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public List<NewsItemBO> getAllNews() {
        return newsList;
    }

}
