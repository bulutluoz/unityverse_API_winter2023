package tests;

import baseUrl.BaseUrlJsonplaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataJsonplaceholder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C20_APITestindeMapKullanimi extends BaseUrlJsonplaceholder {
    @Test
    public void test01(){
        /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

        Expected Response Body:

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
         */


        // 1- request hazirla , request body ve endpoint olustur

        specJsonplaceholder.pathParams("pp1","posts","pp2","70");

        Map<String,Object> requestBodyMap = TestDataJsonplaceholder
                                        .requestBodyMapOlustur(10,70,"Ahmet","Merhaba");

        // 2- gorevde isteniyorsa expected response body olustur
        Map<String,Object> expectedResponseMap = TestDataJsonplaceholder
                .responseBodyMapOlustur(10.0,70.0,"Ahmet","Merhaba");

        // 3- request'i gonder ve donen actual response'i kaydet
        Response response = given().spec(specJsonplaceholder).contentType(ContentType.JSON)
                                .when().body(requestBodyMap)
                                .put("/{pp1}/{pp2}");

        // 4- istenen assertion'lari yap

        // Expected data  <==> actual response objesi
        //       Map                 Response
        // Java icinde test yapmamiz istenirse
        // actual response objesini de Map'e cevirmeliyiz

        Map<String,Object> actualResponseMap = response.as(HashMap.class);

        // Expected data  <==> actualResponseMap
        //       Map                 Map

        Assert.assertEquals(expectedResponseMap.get("id"),
                            actualResponseMap.get("id"));

        Assert.assertEquals(expectedResponseMap.get("title"),
                            actualResponseMap.get("title"));

        Assert.assertEquals(expectedResponseMap.get("body"),
                            actualResponseMap.get("body"));

        Assert.assertEquals(expectedResponseMap.get("userId"),
                            actualResponseMap.get("userId"));
    }
}
