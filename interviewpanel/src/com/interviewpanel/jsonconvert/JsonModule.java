package com.interviewpanel.jsonconvert;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class JsonModule {

    private Gson gson;
    private static JsonModule jsonModule;
    private Scanner scanner;

    private JsonModule() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // Serialize LocalDate as ISO-8601 strings
        scanner = new Scanner(System.in);
    }

    public static JsonModule getInstance() {
        if (jsonModule == null) {
            jsonModule = new JsonModule();
        }
        return jsonModule;
    }

    public void convertListToJson(List<?> list, String dir) {
        if (list == null) {
            System.out.println("List is null. Skipping JSON conversion.");
            return;
        }

        String fileName = "src/com/classexample/data" + File.separator + dir + ".json";
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> convertJsonToList(String fileName, Type valueType) {
        List<T> list = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                T object = gson.fromJson(jsonElement, valueType);
                list.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public <T> String convertQueueToJson(Queue<T> queue) {
        return gson.toJson(queue.toArray());
    }

    public void convertQueueToJsonAndSave(Queue<?> queue, String dir) {
        if (queue == null) {
            System.out.println("Queue is null. Skipping JSON conversion.");
            return;
        }

        String fileName = "src/com/classexample/data" + File.separator + dir + ".json";
        try (FileWriter writer = new FileWriter(fileName)) {
            String json = convertQueueToJson(queue);
            writer.write(json);
            System.out.println("Queue saved as JSON file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> Queue<T> convertJsonToQueue(String json, Type valueType) {
        Queue<T> queue = new LinkedList<>();
        try {
            JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                T object = gson.fromJson(jsonElement, valueType);
                queue.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queue;
    }



}
