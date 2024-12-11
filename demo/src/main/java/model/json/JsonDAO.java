package model.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import controller.BOInterface;

public class JsonDAO<T extends BOInterface> {
    // private final Class<T> classType;
    private static final String NEWS_FILE = "demo\\src\\main\\java\\model\\json\\NewsDO.json";
    // private static final String CATEGORIES_FILE =
    // "demo\\src\\main\\java\\model\\json\\CategoriesDO.json";
    //private T type;
    private List<NewsDO> listtype = new ArrayList<NewsDO>();

    public T getByID(int id) {
       
        try {
            GsonBuilder gson = new GsonBuilder();
            Reader jsonReader = new FileReader(NEWS_FILE, StandardCharsets.UTF_8);
            List<T> json = new ArrayList<T>();
            Type typeToken = TypeToken.getParameterized(List.class, json.getClass()).getType();//new TypeToken<List<T>>() {}.getType();
            //Type collectionType = TypeToken.getParameterized(MyJson.class, type).getType();
           // MyJson<T> myJson = gson.create().fromJson(json, collectionType);
            json = gson.create().fromJson(jsonReader, typeToken);
            System.out.println(json);
            for (T elem : json) {
                if (elem.getId() == id) {
                    return elem;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<T> getAll() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Type type = new TypeToken<List<T>>() {
            }.getType();
            List<T> json = (List<T>) gson.fromJson(new FileReader(NEWS_FILE, StandardCharsets.UTF_8), type);
            return json;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean add(T t) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Type type = new TypeToken<List<T>>() {
            }.getType();
            List<T> json = gson.fromJson(new FileReader(NEWS_FILE, StandardCharsets.UTF_8), type);
            json.add(t);
            try (FileWriter fileWriter = new FileWriter(NEWS_FILE, StandardCharsets.UTF_8)) {
                fileWriter.write(gson.toJson(NEWS_FILE));
            }
        } catch (

        Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // public boolean editByID(T t) {
    // boolean flag = false;
    // Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // try {
    // Type type = new TypeToken<List<T>>() {
    // }.getType();
    // List<T> json = gson.fromJson(new FileReader(NEWS_FILE,
    // StandardCharsets.UTF_8), type);
    // for (int i = 0; i < json.size(); i++) {
    // if (json.get(i).id == t.id) {
    // json.get(i) = t;
    // flag = true;
    // break;
    // }
    // }
    // try (FileWriter fileWriter = new FileWriter(NEWS_FILE,
    // StandardCharsets.UTF_8)) {
    // fileWriter.write(gson.toJson(json));
    // }
    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // }
    // return flag;
    // }

    // public boolean deleteByID(T t) {
    // boolean flag = false;
    // Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // try {
    // Type type = new TypeToken<List<T>>() {
    // }.getType();
    // List<T> json = gson.fromJson(
    // new FileReader(NEWS_FILE, StandardCharsets.UTF_8), type);
    // ArrayList<T> newjson = new ArrayList<>();
    // for (T elem : json)
    // if (elem.id != t.id)
    // newjson.add(elem);
    // else
    // flag = true;
    // try (FileWriter fileWriter = new FileWriter(NEWS_FILE,
    // StandardCharsets.UTF_8)) {
    // fileWriter.write(gson.toJson(newjson));
    // }
    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // }
    // return flag;
    // }
}