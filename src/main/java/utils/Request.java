package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Request extends Properties {

    String actualLatitude;
    String actualLongitude;


    public void GETRequestBody() {
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    public String getResponse() {

        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();
        response = request.get();
        return jsonString = response.asString();


    }

    public void verifyResponseCode(int statusCode) {

        Assert.assertEquals(statusCode, response.getStatusCode());
        System.out.println(response.getStatusCode());
    }

    public void verifyResponseData(String country, String city, String latitude, String longitude) {
        List<Map<String, String>> company = JsonPath.from(jsonString).get("networks.location");
        for (int i = 0; i <= company.size() - 1; i++) {
            if (company.get(i).get("country").equals(country) && company.get(i).get("city").equals(city)) {
                actualLatitude = String.valueOf(company.get(i).get("latitude"));
                actualLongitude = String.valueOf(company.get(i).get("longitude"));
            }
        }
        Assert.assertEquals(latitude, actualLatitude);
        Assert.assertEquals(longitude, actualLongitude);
    }

    public void verifyInvalidResponseData(String country, String city, String latitude, String longitude) {
        List<Map<String, String>> company = JsonPath.from(jsonString).get("networks.location");
        for (int i = 0; i <= company.size() - 1; i++) {
            if (company.get(i).get("country").equals(country) && company.get(i).get("city").equals(city)) {
                actualLatitude = String.valueOf(company.get(i).get("latitude"));
                actualLongitude = String.valueOf(company.get(i).get("longitude"));
            }
        }
        Assert.assertNotEquals(latitude, actualLatitude);
        Assert.assertNotEquals(longitude, actualLongitude);
    }
}
