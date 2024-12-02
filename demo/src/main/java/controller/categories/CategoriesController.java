package controller.categories;
import java.util.ArrayList;
import java.util.List;
public class CategoriesController {
    public List<CategoryBO> list_cat = new ArrayList<>();

    public void add_cat(CategoryBO new_cat){
        list_cat.add(new_cat);
    }

    public List<CategoryBO> get_list_cat(){
        List<CategoryBO> temp = new ArrayList<>();

        for (int i = 0; i < list_cat.size(); i++) {
            if (list_cat.get(i).list_n.size() > 0)
                temp.add(list_cat.get(i));
        }
        return temp;
    }

    public void del_cat(int id){
        list_cat.remove(id);
    }

    public List<CategoryBO> get_po_slovam(String str){

    }

}
