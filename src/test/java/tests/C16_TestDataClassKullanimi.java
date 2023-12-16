package tests;

import baseUrl.BaseUrlJsonplaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataJsonplaceholder;

import static io.restassured.RestAssured.given;

public class C16_TestDataClassKullanimi extends BaseUrlJsonplaceholder {

    @Test
    public void test01(){

        /*
         https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                         um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
         */


        // 1- request hazirla , request body ve endpoint olustur
        specJsonplaceholder.pathParams("pp1","posts","pp2","22");
        // 2- gorevde isteniyorsa expected body olustur
        JSONObject expectedResponse = TestDataJsonplaceholder.ornekResponseBody();
        // 3- request'i gonder ve donen actual response'i kaydet
        Response response= given().spec(specJsonplaceholder)
                                .when()
                                .get("/{pp1}/{pp2}");

        // 4- istenen assertion'lari yap
        //    donen response ait temel bilgiler olan
        //    status kodu, contentType, header degerleri gibi bilgileri
        //    donen response kaydettigimiz response objesi ile test edebiliriz
        //    Ama donen response'daki body icindeki attribute'lere ulasabilmek icin
        //    kaydettigimiz response objesini
        //    JsonPath objesine cevirmeliyiz

        JsonPath actualResponseJp = response.jsonPath();
        Assert.assertEquals(TestDataJsonplaceholder.basariliResponseStatusCode,response.statusCode());
        Assert.assertEquals(expectedResponse.getInt("userId"),
                            actualResponseJp.getInt("userId"));

        Assert.assertEquals(expectedResponse.getInt("id"),
                            actualResponseJp.getInt("id"));

        Assert.assertEquals(expectedResponse.getString("title"),
                            actualResponseJp.getString("title"));

        Assert.assertEquals(expectedResponse.getString("body"),
                            actualResponseJp.getString("body"));


    }
}
