package testDatalari;

import org.json.JSONObject;

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

}
