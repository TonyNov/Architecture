package model.json;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDAO<T> {
    private static final String NEWS_FILE = "data.json";
    protected ObjectMapper objectMapper = new ObjectMapper();
    public T getEntityById(int id) throws IOException {
        List<T> allEntities = getAllEntities();
        return allEntities.stream()
                .filter(entity -> {
                    try {
                        Field idField = entity.getClass().getDeclaredField("id");
                        return idField.getInt(entity) == id;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .findFirst()
                .orElse(null);
    }

    public List<T> getAllEntities() throws IOException {
        File file = new File(NEWS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try {
            TypeReference<List<T>> typeRef = new TypeReference<List<T>>() {};
            return objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            throw new IOException("Ошибка при чтении файла JSON", e);
        }
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
        try {
            objectMapper.writeValue(new File(NEWS_FILE), entities);
        } catch (IOException e) {
            throw new IOException("Ошибка при записи в файл JSON", e);
        }
    }
}
