package co.com.bancolombia.dynamodb.util;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DynamoDBMapperUtilTest {
    
    private final DynamoDBMapperUtil dynamoDBMapperUtil = new DynamoDBMapperUtil();

    @Test
    public void mapToJsonNull(){
        assertNull(dynamoDBMapperUtil.mapToJson(null));
    }

    @Test
    public void mapToJson(){
        Map<String, AttributeValue> attributeValues = new HashMap<>();
        AttributeValue attributeNull = AttributeValue.builder().nul(true).build();
        AttributeValue attributeString = AttributeValue.builder().s("STRING").build();
        AttributeValue attributeNumber = AttributeValue.builder().n("0").build();
        AttributeValue attributeBoolean = AttributeValue.builder().bool(true).build();

        Map<String, AttributeValue> attributeValues2 = new HashMap<>();
        attributeValues2.put("string", attributeString);
        AttributeValue attributeMap = AttributeValue.builder().m(attributeValues2).build();

        List<AttributeValue> attributeValueList = new ArrayList<>();
        attributeValueList.add(attributeNull);
        attributeValueList.add(attributeString);
        attributeValueList.add(attributeNumber);
        attributeValueList.add(attributeBoolean);
        attributeValueList.add(attributeMap);
        AttributeValue attributeList = AttributeValue.builder().l(attributeValueList).build();

        AttributeValue attributeListString = AttributeValue.builder().ss("STRING").build();
        AttributeValue attributeListNumber = AttributeValue.builder().ns("1").build();

        attributeValues.put("null", attributeNull);
        attributeValues.put("string", attributeString);
        attributeValues.put("number", attributeNumber);
        attributeValues.put("boolean", attributeBoolean);
        attributeValues.put("list", attributeList);
        attributeValues.put("map", attributeMap);
        attributeValues.put("ss", attributeListString);
        attributeValues.put("ns", attributeListNumber);
        assertNotNull(dynamoDBMapperUtil.mapToJson(attributeValues));
    }

    @Test
    public void listToJsonNull(){
        assertNull(dynamoDBMapperUtil.listToJson(null));
    }

    @Test
    public void attributeValueToJsonNUll() {
        assertNull(dynamoDBMapperUtil.attributeValueToJson(null));
    }

    @Test
    public void addNull() {
        JsonObjectBuilder jsonObjectBuilder = Mockito.mock(JsonObjectBuilder.class);
        dynamoDBMapperUtil.add(null, null, jsonObjectBuilder);
        Assert.assertNotNull(jsonObjectBuilder);
    }

    @Test
    public void addNull2() {
        JsonArrayBuilder jsonArrayBuilder = Mockito.mock(JsonArrayBuilder.class);
        dynamoDBMapperUtil.add(JsonValue.NULL, jsonArrayBuilder);
        Assert.assertNotNull(jsonArrayBuilder);
    }

    @Test
    public void attributeValueToJson() {
        AttributeValue attributeValue = AttributeValue.builder().build();
        Assert.assertNull(dynamoDBMapperUtil.attributeValueToJson(attributeValue));
    }

}
