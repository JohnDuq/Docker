package co.com.bancolombia.dynamodb.util;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.json.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class DynamoDBMapperUtil {

    public JsonObject mapToJson(Map<String, AttributeValue> attributeValues) {
        if (attributeValues == null) {
            return null;
        }
        JsonObjectBuilder valueBuilder = Json.createObjectBuilder();
        for (Map.Entry<String, AttributeValue> a : attributeValues.entrySet()) {
            add(a.getKey(), attributeValueToJson(a.getValue()), valueBuilder);
        }
        return valueBuilder.build();
    }

    public JsonArray listToJson(List<AttributeValue> attributeValues) {
        if (attributeValues == null) {
            return null;
        }
        JsonArrayBuilder valueBuilder = Json.createArrayBuilder();
        for (AttributeValue a : attributeValues) {
            add(attributeValueToJson(a), valueBuilder);
        }
        return valueBuilder.build();
    }

    public void add(String key, Object value, JsonObjectBuilder object) {
        if (value instanceof JsonValue) {
            object.add(key, (JsonValue) value);
        } else if (value instanceof String) {
            object.add(key, (String) value);
        } else if (value instanceof BigDecimal) {
            object.add(key, (BigDecimal) value);
        } else if (value instanceof Boolean) {
            object.add(key, (Boolean) value);
        } else if (value == null || value.equals(JsonValue.NULL)) {
            object.addNull(key);
        }

    }

    public void add(Object value, JsonArrayBuilder array) {
        if (value instanceof JsonValue) {
            array.add((JsonValue) value);
        } else if (value instanceof String) {
            array.add((String) value);
        } else if (value instanceof BigDecimal) {
            array.add((BigDecimal) value);
        } else if (value instanceof Boolean) {
            array.add((Boolean) value);
        }

    }

    public Object attributeValueToJson(AttributeValue attributeValue) {

        if (attributeValue == null) {
            return null;
        }
        if (attributeValue.s() != null) {
            return attributeValue.s();
        }
        if (attributeValue.n() != null) {
            return new BigDecimal(attributeValue.n());
        }
        if (attributeValue.bool() != null) {
            return attributeValue.bool();
        }

        if (attributeValue.nul() != null && attributeValue.nul()) {
            return JsonValue.NULL;
        }

        if (!attributeValue.m().isEmpty()) {
            return mapToJson(attributeValue.m());
        }
        if (!attributeValue.l().isEmpty()) {
            return listToJson(attributeValue.l());
        }

        if (!attributeValue.ss().isEmpty()) {
            JsonArrayBuilder valueBuilder = Json.createArrayBuilder();
            for (String element : attributeValue.ss()) {
                valueBuilder.add(element);
            }
            return valueBuilder.build();
        }

        if (!attributeValue.ns().isEmpty()) {
            return attributeValue.ns();
        }

        return null;
    }

}
