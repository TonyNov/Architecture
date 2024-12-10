package model.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    private static void parseEmployeeObject(JSONObject employee) {
        // Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        // Get employee first name
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        // Get employee last name
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        // Get employee website name
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }

    public List<T> getAllEntities() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        List<T> list = new ArrayList<>();
        /* try (FileReader reader = new FileReader(NEWS_FILE)) {
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } */
        try (FileReader reader = new FileReader(NEWS_FILE)){
            Object obj = jsonParser.parse(reader);
        } catch (ParseException e) {
            // Обработка исключения
            e.printStackTrace();
        }

        return list;
    }

    public void deleteEntityById(int id) throws IOException {
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