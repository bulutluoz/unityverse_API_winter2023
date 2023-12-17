package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C18_TestDataKullanimi extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        /*
         https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un id haric asagidaki gibi oldugunu test edin.
                Request body
                       {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
               Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
         */

        // 1- request hazirla , request body ve endpoint olustur
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody = TestDataHerokuapp.parametreIleRequestBodyOlustur("Ahmet","Bulut",500,false,"2021-06-01","2021-06-10","wi-fi");
        // 2- gorevde isteniyorsa expected body olustur
        JSONObject expectedResponse = TestDataHerokuapp.parametreIleResponseBodyOlustur(24,
                "Ahmet","Bulut",500,false,"2021-06-01","2021-06-10",
                "wi-fi");
        // 3- request'i gonder ve donen actual response'i kaydet
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                                .when().body(requestBody.toString())
                                .post("/{pp1}");

        // 4- istenen assertion'lari yap
        //    body'deki attribute degerleri test edilecegi icin
        //    response'i JsonPath objesine cevirelim

        JsonPath actualResponseJp = response.jsonPath();


        Assert.assertEquals(expectedResponse.getJSONObject("booking")
                                            .getString("firstname"),
                            actualResponseJp.getString("booking.firstname") );

        Assert.assertEquals(expectedResponse.getJSONObject("booking")
                                            .getString("lastname"),
                            actualResponseJp.getString("booking.lastname"));

        Assert.assertEquals(expectedResponse.getJSONObject("booking")
                                            .getInt("totalprice"),
                actualResponseJp.getInt("booking.totalprice"));

        Assert.assertEquals(expectedResponse.getJSONObject("booking")
                                            .getBoolean("depositpaid"),
                actualResponseJp.getBoolean("booking.depositpaid"));

        Assert.assertEquals(expectedResponse.getJSONObject("booking")
                                            .getJSONObject("bookingdates")
                                            .getString("checkin"),
                            actualResponseJp.getString("booking.bookingdates.checkin"));

        Assert.assertEquals(expectedResponse.getJSONObject("booking")
                                            .getJSONObject("bookingdates")
                                            .getString("checkout"),
                actualResponseJp.getString("booking.bookingdates.checkout"));


        String expectedAdditionalNeeds = expectedResponse.getJSONObject("booking")
                                                            .getString("additionalneeds");
        String actualAdditionalNeeds = actualResponseJp.getString("booking.additionalneeds");

        Assert.assertEquals(expectedAdditionalNeeds,actualAdditionalNeeds);

    }
}
