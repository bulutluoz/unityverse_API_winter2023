package testDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {

    public static JSONObject parametreIleRequestBodyOlustur(String firstname, String lastname,int totalPrice, boolean depositpaid, String checkin, String checkout, String additionalneeds ){

        JSONObject bookingdatesJson = new JSONObject();
        bookingdatesJson.put("checkin",checkin);
        bookingdatesJson.put("checkout",checkout);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname",firstname);
        requestBody.put("lastname",lastname);
        requestBody.put("totalprice",totalPrice);
        requestBody.put("depositpaid",depositpaid);
        requestBody.put("bookingdates",bookingdatesJson);
        requestBody.put("additionalneeds",additionalneeds);

        return requestBody;
    }

    public static JSONObject parametreIleResponseBodyOlustur(int bookingid, String firstname, String lastname,int totalPrice, boolean depositpaid, String checkin, String checkout, String additionalneeds){

        JSONObject bookingdatesJson = new JSONObject();
        bookingdatesJson.put("checkin",checkin);
        bookingdatesJson.put("checkout",checkout);

        JSONObject bookingJson = new JSONObject();
        bookingJson.put("firstname",firstname);
        bookingJson.put("lastname",lastname);
        bookingJson.put("totalprice",totalPrice);
        bookingJson.put("depositpaid",depositpaid);
        bookingJson.put("bookingdates",bookingdatesJson);
        bookingJson.put("additionalneeds",additionalneeds);

        JSONObject responseBody = new JSONObject();
        responseBody.put("bookingid",bookingid);
        responseBody.put("booking",bookingJson);

        return responseBody;
    }

    public static Map<String,Object> requestBodyMapOlustur(String firstname, String lastname,int totalPrice, boolean depositpaid, String checkin, String checkout, String additionalneeds){
        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);

        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname",firstname);
        requestBodyMap.put("lastname",lastname);
        requestBodyMap.put("totalprice",totalPrice);
        requestBodyMap.put("depositpaid",depositpaid);
        requestBodyMap.put("bookingdates",bookingDatesMap);
        requestBodyMap.put("additionalneeds",additionalneeds);

        return requestBodyMap;
    }

    public static Map<String,Object> responseBodyMapOlustur(Double bookingid, String firstname, String lastname,Double totalPrice, boolean depositpaid, String checkin, String checkout, String additionalneeds){

        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);

        Map<String,Object> bookingMap = new HashMap<>();
        bookingMap.put("firstname",firstname);
        bookingMap.put("lastname",lastname);
        bookingMap.put("totalprice",totalPrice);
        bookingMap.put("depositpaid",depositpaid);
        bookingMap.put("bookingdates",bookingDatesMap);
        bookingMap.put("additionalneeds",additionalneeds);

        Map<String,Object> responseBodyMap = new HashMap<>();
        responseBodyMap.put("bookinid",bookingid);
        responseBodyMap.put("booking",bookingMap);

        return responseBodyMap;
    }
}
