package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class deneme {

    @Test
    public void apiTest(){
        // 1- request hazirla , request body ve endpoint olustur
        String endpoint = "https://flights-api.buraky.workers.dev/";
        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet
        Response response = given().when().get(endpoint);

        response.prettyPrint();
        // 4- istenen assertion'lari yap

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }
}
