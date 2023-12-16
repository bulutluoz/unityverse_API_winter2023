package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_ResponseBodyTestEtme {

    @Test
    public void test01(){
        //        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET ruquest gönderdiğimizde,
        //        dönen response'in
        //         status code'nun 200,
        //         ve content type'nin application.JSON
        //         ve response body'sinde bulunan userId'nin 5
        //         ve response body'sinde bulunan title'in "optio dolor molestias sit"
        //         olduğunu test edin

        // 1- request hazirla , request body ve endpoint olustur
        String endpoint = "https://jsonplaceholder.typicode.com/posts/44";
        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet
        Response response = given().when().get(endpoint);

        // 4- istenen assertion'lari yap

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON) // application/json; charset=utf-8 da olur
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}
