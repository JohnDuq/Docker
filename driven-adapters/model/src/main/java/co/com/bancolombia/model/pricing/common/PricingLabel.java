package co.com.bancolombia.model.pricing.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PricingLabel {
    public static final String PRICING = "PRICING";
    public static final String RETRIEVE_BASIC_PRODUCT_INFO = "RETRIEVE BASIC PRODUCT INFO";
    public static final String RETRIEVE_INFO_PRODUCT_BENEFIT = "RETRIEVE INFO PRODUCT BENEFIT";
    public static final String RETRIEVE_DETAIL_GMF = "RETRIEVE DETAIL GMF";
    public static final String RETRIEVE_DETAIL_PRODUCT_INFORMATION = "RETRIEVE DETAIL PRODUCT INFORMATION";
    public static final String RETRIEVE_DETAIL_BENEFIT = "RETRIEVE DETAIL BENEFIT";
    public static final String RETRIEVE_DETAIL_INFORMATION = "RETRIEVE DETAIL INFORMATION";
    public static final String RETRIEVE_ACCOUNT_PLAN = "RETRIEVE ACCOUNT PLAN";
    public static final String SAVED = "SAVED";
    public static final String SPACE = " ";
    public static final String REQUEST = "REQUEST";
    public static final String RESPONSE = "RESPONSE";
    public static final String OK = "OK";
    public static final String BAD_REQUEST = "BAD REQUEST";
    public static final String REDIS = "REDIS";
    public static final String DOUBLE_POINT = ":";
    public static final String STATUS = "STATUS";
    public static final String EXCEPTION = "EXCEPTION";
    public static final String TIMEOUT = "TIMEOUT";
    public static final String QUERY = "QUERY";
    public static final String COMPLETED = "COMPLETED";
    public static final String MESSAGE = "MESSAGE";
    public static final String MESSAGE_ID = "MESSAGE-ID";
    public static final String TRANSFORMATION = "TRANSFORMATION";
    public static final String REQUEST_STRING = "REQUEST -> STRING";
    public static final String REDIS_RESPONSE = "REDIS -> RESPONSE";
    public static final String RESPONSE_REDIS = "RESPONSE -> REDIS";
    public static final String DYNAMODB_DRIVEN_ADAPTER = "DYNAMODB DRIVEN ADAPTER";
    public static final String JSONOBJECT_DYNAMODBRESPONSEUC = "JSONOBJECT -> DYNAMODBRESPONSEUC";
}
