package model.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonDAO<T extends JsonItem> implements DAO<T> {

    private final Class<T> className; // тип для сериализуемого объекта
    private final Type listClassName; // тип для сериализуемого списка объектов
    private final Gson gson;

    private Reader getReader() {
        String itemName = this.className.getSimpleName(); // получение имени файла
        String fileName = "demo/src/main/java/model/json/DB/" + itemName + ".json";
        try {
            return new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Writer getWriter() {
        String itemName = this.className.getSimpleName(); // получение имени файла
        String fileName = "demo/src/main/java/model/json/DB/" + itemName + ".json";
        try {
            return new FileWriter(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public JsonDAO(Class<T> clazz) {
        this.className = clazz;
        this.listClassName = TypeToken.getParameterized(List.class, clazz).getType();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public T get(int id) {
        try (Reader reader = getReader()) {
            List<T> tList = gson.fromJson(reader, listClassName);
            for (T elem : tList)
                if (elem.getID() == id)
                    return elem;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        try (Reader reader = getReader()) {
            List<T> tList = gson.fromJson(reader, listClassName);
            return tList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean add(T object) {
        try (Reader reader = getReader()) {
            List<T> tList = gson.fromJson(reader, listClassName);
            tList.add(object);
            try (Writer writer = getWriter()) {
                writer.write(gson.toJson(writer));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(T object) {
        boolean flag = false;
        try (Reader reader = getReader()) {
            List<T> tList = gson.fromJson(reader, listClassName);
            for (int i = 0; i < tList.size(); i++) {
                if (tList.get(i).getID() == object.getID()) {
                    tList.set(i, object);
                    flag = true;
                    break;
                }
            }
            try (Writer writer = getWriter()) {
                writer.write(gson.toJson(writer));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try (Reader reader = getReader()) {
            List<T> tList = gson.fromJson(reader, listClassName);
            for (int i = 0; i < tList.size(); i++)
                if (tList.get(i).getID() == id)
                    tList.remove(i);
            try (Writer writer = getWriter()) {
                writer.write(gson.toJson(writer));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}