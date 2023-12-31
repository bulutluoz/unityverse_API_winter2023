package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_TekrarlardanKurtulma {

    @Test
    public void test01(){
        //    http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
        //    donen Response'in
        //    status code'unun 200,
        //    ve content type'inin Aplication.JSON,
        //    ve response body'sindeki
        //    employees sayisinin 24
        //    ve employee'lerden birinin "Ashton Cox"
        //    ve girilen yaslar icinde 61,66 ve 22 degerinin oldugunu
        //    test edin.

        // 1- request hazirla , request body ve endpoint olustur
        String endPoint = "http://dummy.restapiexample.com/api/v1/employees";

        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet
        Response response = given()
                .when()
                .get(endPoint);

        // response.prettyPrint();

        // 4- istenen assertion'lari yap

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age",hasItems(61,66,22));
    }
}
