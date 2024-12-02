package controller.categories;

import java.util.ArrayList;
import java.util.List;

import controller.news.NewsItemBO;

public class CategoriesController {
    public List<CategoryBO> categoriesList = new ArrayList<>();

    public void addCategory(CategoryBO newCategory) {
        categoriesList.add(newCategory);
    }

    public void addCategory(String title, String content) {
        categoriesList.add(new CategoryBO(title, content));
    }

    public List<CategoryBO> getNotEmptyCategories() {
        List<CategoryBO> temp = new ArrayList<>();
        for (int i = 0; i < categoriesList.size(); i++)
            if (categoriesList.get(i).size() > 0)
                temp.add(categoriesList.get(i));
        return temp;
    }

    public List<CategoryBO> getAllCategories() {
        return categoriesList;
    }

    public void getCategory(int id) {
        categoriesList.remove(id);
    }

    public void updateCategory(int id, CategoryBO newCategory) {
        for (int i = 0; i < categoriesList.size(); i++)
            if (categoriesList.get(i).getId() == id) {
                categoriesList.set(i, newCategory);
                return;
            }
    }

    public void removeCategory(int id) {
        categoriesList.remove(id);
    }

    public List<CategoryBO> getCategoriesByKey(String key) {
        List<CategoryBO> temp = new ArrayList<>();
        for (CategoryBO elem : categoriesList) {
            if ((elem.getTitle().toLowerCase().contains(key.toLowerCase()) ||
                    elem.getDiscription().toLowerCase().contains(key.toLowerCase()))) {
                temp.add(elem);
            } else {
                boolean f = false;
                for (NewsItemBO news : elem.getAllNews()) {
                    if (news.getTitle().toLowerCase().contains(key.toLowerCase())
                            || news.getContent().toLowerCase().contains(key.toLowerCase())) {
                        f = true;
                        break;
                    }
                }
                if (f)
                    temp.add(elem);
            }
        }
        return temp;
    }

}
