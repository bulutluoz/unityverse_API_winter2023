package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_JsonpathIleApiTesti {

    @Test
    public void test01(){

        /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-10",
                "checkout" : "2023-01-20"},
            "additionalneeds" : "wi-fi"
            }

         donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ahmet",
                ve "lastname“in, "Bulut",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2023-01-10
                ve "checkout" tarihinin 2023-01-20
                ve "additionalneeds“in,"wi-fi"
             oldugunu test edin


         */


        // 1- request hazirla , request body ve endpoint olustur
        String endpoint = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject bookingJsonObje = new JSONObject();

        // once icerdeki Json objeyi tamamlayalim
        bookingJsonObje.put("checkin","2023-01-10");
        bookingJsonObje.put("checkout","2023-01-20");
        // simdi requestbody ye elemanlari ekleyelim

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingJsonObje);
        requestBody.put("additionalneeds","wi-fi");


        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                                .when().body(requestBody.toString())
                                .post(endpoint);
        // response.prettyPrint();

        // 4- istenen assertion'lari yap

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", Matchers.equalTo("Ahmet"))
                .body("booking.lastname",Matchers.equalTo("Bulut"))
                .body("booking.totalprice",Matchers.equalTo(500))
                .body("booking.depositpaid",Matchers.equalTo(false))
                .body("booking.bookingdates.checkin",Matchers.equalTo("2023-01-10"))
                .body("booking.bookingdates.checkout",Matchers.equalTo("2023-01-20"))
                .body("booking.additionalneeds",Matchers.equalTo("wi-fi"));



    }
}
