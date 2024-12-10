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
            //         // �������� ������ � ��������� �����
            //         field.setAccessible(true);

            //         // ��������� ������� ����� � JSON
            //         if (jsonObj.containsKey(field.getName())) {
            //             // �������� �������� �� JSON
            //             Object value = jsonObj.get(field.getName());

            //             try {
            //                 // ������������� �������� ����
            //                 field.set(obj, value);
            //             } catch (IllegalArgumentException e) {
            //                 System.out
            //                         .println("������ ��� ��������� �������� ����: " + field.getName() + " = " + value);
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
 * ��� ����������� ����� ������ T � ���������� ��� ������� �� ��������
 * employeeList, �� ������ ������������ Java Reflection API. ��� ������ ����,
 * ��� ����� ��� �������:
 * 
 * 1. ������� ��������� ������ ��� ��������� ����� � ��������� ��������:
 * 
 * ```java
 * 
 * 
 * 
 * 3. �������� ������ ��� ��������� � ��������� �������� �����:
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
 * ���� ������ ��������� ����������� ��������� ���������� ������� T � ���������
 * �� ������� �� JSON ��������. �� �������� � ������ ��������, ������� ���������
 * ��������� T, ������� NewsDO � CategoriesDO.
 * 
 * �������� �������� �� ��������� �������:
 * 
 * 1. ������������� Reflection ����� ���� ��������� ��� ������� ������� ������.
 * 2. ���������, ��� ��� ���� � JSON ������������� ����� � ����� ������ T.
 * 3. ��� ������������ ������������� �������� �������� ����� ����� �����
 * ���������� ��������.
 * 
 * ����� ������ ��������� ��� �������� � ���������� ������ ������� ����� ����
 * ��������� T, ��� ������ ��� ��� ����� ������ � �������������.
 */