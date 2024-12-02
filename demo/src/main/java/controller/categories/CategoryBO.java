package controller.categories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import view.api.News;

public class CategoryBO {

    private int id;
    private String name;
    private final List<News> newsList = new ArrayList<>();

    public CategoryBO(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addToList(News value) {
        newsList.add(value);
    }

    public void addToBeginning(News value) {
        newsList.add(0, value);
    }

    public boolean removeFirstOccurrence(News value) {
        return newsList.remove(value);
    }

    public void removeAllOccurrences(News value) {
        newsList.removeAll(Collections.singleton(value));
    }

    public void replaceAllWith(News newValue) {
        newsList.replaceAll(v -> newValue);
    }

    public int indexOf(News value) {
        return newsList.indexOf(value);
    }

    public int lastIndexOf(News value) {
        return newsList.lastIndexOf(value);
    }

    public boolean contains(News value) {
        return newsList.contains(value);
    }

    public int size() {
        return newsList.size();
    }

    public void clear() {
        newsList.clear();
    }

}
