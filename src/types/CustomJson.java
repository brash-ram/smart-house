package types;

import java.lang.reflect.Field;
import java.util.Map;

public class CustomJson {
    public static String encodeObjToJson(Object obj) {
        StringBuilder json = new StringBuilder();

        if (obj == null) {
            json.append("null");
        } else if (obj instanceof String) {
            json.append("\"").append(obj.toString()).append("\"");
        } else if (obj instanceof Number) {
            json.append(obj.toString());
        } else if (obj instanceof Boolean) {
            json.append(obj.toString());
        } else if (obj instanceof Map) {
            json.append(encodeMap((Map<?, ?>) obj));
        } else if (obj.getClass().isArray()) {
            json.append(encodeArrayObjToJson(obj));
        } else {
            json.append(encodeObjectToJson(obj));
        }

        return json.toString();
    }

    private static String encodeMap(Map<?, ?> obj) {
        StringBuilder json = new StringBuilder();

        json.append("{");

        for (Map.Entry<?, ?> entry : obj.entrySet()) {
            json.append(encodeObjToJson(entry.getKey().toString())).append(":").append(encodeObjToJson(entry.getValue())).append(",");
        }

        if (json.length() > 1) {
            json.setLength(json.length() - 1);
        }

        json.append("}");

        return json.toString();
    }

    private static String encodeArrayObjToJson(Object obj) {
        StringBuilder json = new StringBuilder();

        json.append("[");

        int length = java.lang.reflect.Array.getLength(obj);

        for (int i = 0; i < length; i++) {
            json.append(encodeObjToJson(java.lang.reflect.Array.get(obj, i))).append(",");
        }

        if (json.length() > 1) {
            json.setLength(json.length() - 1);
        }

        json.append("]");

        return json.toString();
    }

    private static String encodeObjectToJson(Object obj) {
        StringBuilder json = new StringBuilder();

        json.append("{");

        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                json.append(encodeObjToJson(field.getName())).append(":").append(encodeObjToJson(field.get(obj))).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (json.length() > 1) {
            json.setLength(json.length() - 1);
        }

        json.append("}");

        return json.toString();
    }
}
