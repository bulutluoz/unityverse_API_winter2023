package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_ResponseBodysiniTestEtme {

    @Test
    public void test01(){
        /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine
        asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
            {
                    "title":"Ahmet",
                    "body":"Merhaba",
                    "userId":10,
                    "id":70
            }
            donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve Server isimli Header’in degerinin cloudflare,
                ve status Line’in HTTP/1.1 200 OK
                ve title'in "Ahmet"
                ve body attribute'unun "Merhaba"
                ve userId'nin 10 oldugunu test edin

         */

        // 1- request hazirla , request body ve endpoint olustur
        String endpoint = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title","Ahmet");
        requestBody.put("body","Merhaba");
        requestBody.put("userId",10);
        requestBody.put("id",70);

        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                            // yapacagimiz sorgu icin verilmesi gereken on bilgiler
                            .when().body(requestBody.toString())
                            // yapacagimiz sorgu icin body gerekiyorsa String olarak yazilir
                            .put(endpoint);
                            // kullanacagimiz HTTP methodu
                            // GET ve DELETE icin body gerekmez, PUT,POST,PATCH icin body gereklidir


        // response.prettyPrint();


        // 4- istenen assertion'lari yap

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK")
                .body("title", Matchers.equalTo("Ahmet"))
                .body("body",Matchers.equalTo("Merhaba"))
                .body("userId", Matchers.equalTo(10));

    }
}
