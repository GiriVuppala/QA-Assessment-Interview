package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Properties {

    public static  String BASE_URL = "https://api.citybik.es/v2/networks";
    public static RequestSpecification request;
    public static Response response;
    public static String jsonString;
}
