package controller.categories;

import java.util.ArrayList;
import java.util.List;

public class CategoriesController {
    public List<CategoryBO> categoriesList = new ArrayList<>();

    public void addCategory(CategoryBO new_cat) {
        categoriesList.add(new_cat);
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
        categoriesList.remove(id);
    }

    public void removeCategory(int id) {
        categoriesList.remove(id);
    }

    public List<CategoryBO> getCategoriesByKey(String str) {
        List<CategoryBO> temp = new ArrayList<>();
        return temp;
    }

}
