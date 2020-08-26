package by.shirokaya.tasks.javacollections.maintask.util;

import by.shirokaya.tasks.javacollections.maintask.repo.Catalog;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    private static final String FILE_PATH = "./src/main/java/by/shirokaya/tasks/javacollections/files/catalog.json";
    private static ObjectMapper objectMapper;

    {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    public Catalog readFromFile() throws IOException {
        File file = new File(FILE_PATH);
        return objectMapper.readValue(file, Catalog.class);
    }

}
