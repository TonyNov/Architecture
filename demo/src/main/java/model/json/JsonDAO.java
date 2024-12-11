package model.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDAO<T> {
    private final Class<T> classType;
    private static final String NEWS_FILE = "/NewsDO.json";
    private static final String CATEGORIES_FILE = "/CategoriesDO.json";

    public JsonDAO(Class<T> type) {
        this.classType = type;
    }

    public T getByID(int id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            if (classType == NewsDO.class) {
                NewsDO[] json = (NewsDO[]) gson.fromJson(new FileReader(NEWS_FILE, StandardCharsets.UTF_8), classType);
                for (NewsDO elem : json) {
                    if (elem.id == id) {
                        return (T) elem;
                    }
                }
            } else if (classType == CategoriesDO.class) {
                CategoriesDO[] json = (CategoriesDO[]) gson
                        .fromJson(new FileReader(CATEGORIES_FILE, StandardCharsets.UTF_8), classType);
                for (CategoriesDO elem : json) {
                    if (elem.id == id) {
                        return (T) elem;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public T getAllItems() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            if (classType == NewsDO[].class) {
                NewsDO[] json = (NewsDO[]) gson.fromJson(
                        new FileReader(NEWS_FILE, StandardCharsets.UTF_8), classType);
                return (T) json;
            } else if (classType == CategoriesDO[].class) {
                CategoriesDO[] json = (CategoriesDO[]) gson.fromJson(
                        new FileReader(CATEGORIES_FILE, StandardCharsets.UTF_8), classType);
                return (T) json;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean addItem(T t) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            if (classType == NewsDO.class) {
                NewsDO[] json = (NewsDO[]) gson.fromJson(new FileReader(NEWS_FILE, StandardCharsets.UTF_8), classType);
                NewsDO newsDO = (NewsDO) t;
                NewsDO[] newjson = new NewsDO[json.length + 1];
                System.arraycopy(json, 0, newjson, 0, json.length);
                newjson[newjson.length - 1] = newsDO;
                try (FileWriter fileWriter = new FileWriter(NEWS_FILE, StandardCharsets.UTF_8)) {
                    fileWriter.write(gson.toJson(newjson));
                }
            } else if (classType == CategoriesDO.class) {
                CategoriesDO[] json = (CategoriesDO[]) gson
                        .fromJson(new FileReader(CATEGORIES_FILE, StandardCharsets.UTF_8), classType);
                CategoriesDO categoryDO = (CategoriesDO) t;
                CategoriesDO[] newjson = new CategoriesDO[json.length + 1];
                System.arraycopy(json, 0, newjson, 0, json.length);
                newjson[newjson.length - 1] = categoryDO;
                try (FileWriter fileWriter = new FileWriter(CATEGORIES_FILE, StandardCharsets.UTF_8)) {
                    fileWriter.write(gson.toJson(newjson));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean editByID(T t) {
        boolean flag = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            if (classType == NewsDO.class) {
                NewsDO[] json = (NewsDO[]) gson.fromJson(new FileReader(NEWS_FILE, StandardCharsets.UTF_8), classType);
                NewsDO newsDO = (NewsDO) t;
                for (int i = 0; i < json.length; i++) {
                    if (json[i].id == newsDO.id) {
                        json[i] = newsDO;
                        flag = true;
                        break;
                    }
                }
                try (FileWriter fileWriter = new FileWriter(NEWS_FILE, StandardCharsets.UTF_8)) {
                    fileWriter.write(gson.toJson(json));
                }
            } else if (classType == CategoriesDO.class) {
                CategoriesDO[] json = (CategoriesDO[]) gson
                        .fromJson(new FileReader(CATEGORIES_FILE, StandardCharsets.UTF_8), classType);
                CategoriesDO categoryDO = (CategoriesDO) t;
                for (int i = 0; i < json.length; i++) {
                    if (json[i].id == categoryDO.id) {
                        json[i] = categoryDO;
                        flag = true;
                        break;
                    }
                }
                try (FileWriter fileWriter = new FileWriter(CATEGORIES_FILE, StandardCharsets.UTF_8)) {
                    fileWriter.write(gson.toJson(json));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public boolean deleteByID(T t) {
        boolean flag = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            if (classType == NewsDO.class) {
                NewsDO[] json = (NewsDO[]) gson.fromJson(
                        new FileReader(NEWS_FILE, StandardCharsets.UTF_8), classType);
                ArrayList<NewsDO> newjson = new ArrayList<>();
                NewsDO newsDO = (NewsDO) t;
                for (NewsDO elem : json)
                    if (elem.id != newsDO.id)
                        newjson.add(elem);
                    else
                        flag = true;
                try (FileWriter fileWriter = new FileWriter(NEWS_FILE,
                        StandardCharsets.UTF_8)) {
                    fileWriter.write(gson.toJson(newjson));
                }
            } else if (classType == CategoriesDO.class) {
                CategoriesDO[] json = (CategoriesDO[]) gson.fromJson(
                        new FileReader(CATEGORIES_FILE, StandardCharsets.UTF_8), classType);
                ArrayList<CategoriesDO> newjson = new ArrayList<>();
                CategoriesDO categoryDO = (CategoriesDO) t;
                for (CategoriesDO elem : json)
                    if (elem.id != categoryDO.id)
                        newjson.add(elem);
                    else
                        flag = true;
                try (FileWriter fileWriter = new FileWriter(CATEGORIES_FILE, StandardCharsets.UTF_8)) {
                    fileWriter.write(gson.toJson(newjson));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}