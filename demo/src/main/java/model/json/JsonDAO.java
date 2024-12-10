package model.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonDAO<T> {
    private static final String NEWS_FILE = "NewsDO.json";

    public T getEntityById(int id) throws IOException {
        return null;
    }

    public List<T> getAllEntities() throws IOException {
        JSONParser jsonParser = new JSONParser();
        List<T> list = new ArrayList<>();
        try (FileReader reader = new FileReader(NEWS_FILE)) {
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            Field[] fields = Class.class.getDeclaredFields();
            String s = "";
            for (Field field : fields) 
                s.concat(field.getName());
            // for (Object object : employeeList) {
            //     JSONObject jsonObject = (JSONObject) object;

            //     for (Field field : fields) {
            //         // Включаем доступ к приватным полям
            //         field.setAccessible(true);

            //         // Проверяем наличие ключа в JSON
            //         if (jsonObj.containsKey(field.getName())) {
            //             // Получаем значение из JSON
            //             Object value = jsonObj.get(field.getName());

            //             try {
            //                 // Устанавливаем значение поля
            //                 field.set(obj, value);
            //             } catch (IllegalArgumentException e) {
            //                 System.out
            //                         .println("Ошибка при установке значения поля: " + field.getName() + " = " + value);
            //             }
            //         }
            //     }

            //     list.add(entity);
            // }
            System.out.println(employeeList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteEntityById(int id) throws IOException, ParseException {
        List<T> entities = getAllEntities();
        entities.removeIf(entity -> {
            try {
                Field idField = entity.getClass().getDeclaredField("id");
                return idField.getInt(entity) == id;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        saveAllEntities(entities);
    }

    public void addEntity(T entity) throws IOException {
        List<T> existingEntities = getAllEntities();
        existingEntities.add(entity);
        saveAllEntities(existingEntities);
    }

    private void saveAllEntities(List<T> entities) throws IOException {
    }
}
/*
 * Для определения полей класса T и заполнения ими данными из объектов
 * employeeList, вы можете использовать Java Reflection API. Вот пример того,
 * как можно это сделать:
 * 
 * 1. Сначала определим методы для получения полей и установки значений:
 * 
 * ```java
 * 
 * 
 * 
 * 3. Добавьте методы для получения и установки значений полей:
 * 
 * ```java
 * private void setValue(Object obj, String fieldName, Object value) throws
 * Exception {
 * Field field = obj.getClass().getDeclaredField(fieldName);
 * field.setAccessible(true);
 * field.set(obj, value);
 * }
 * 
 * private Object getValue(Object obj, String fieldName) throws Exception {
 * return obj.getClass().getDeclaredField(fieldName).get(obj);
 * }
 * ```
 * 
 * Этот подход позволяет динамически создавать экземпляры классов T и заполнять
 * их данными из JSON объектов. Он работает с любыми классами, которые реализуют
 * интерфейс T, включая NewsDO и CategoriesDO.
 * 
 * Обратите внимание на следующие моменты:
 * 
 * 1. Использование Reflection может быть медленным для больших объемов данных.
 * 2. Убедитесь, что все поля в JSON соответствуют полям в вашем классе T.
 * 3. Для безопасности рекомендуется добавить проверку типов полей перед
 * установкой значений.
 * 
 * Такой подход позволяет вам работать с различными типами классов через один
 * интерфейс T, что делает ваш код более гибким и универсальным.
 */