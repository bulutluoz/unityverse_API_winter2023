package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_ResponseBilgileriniTestEtme {

    @Test
    public void test01(){

        // https://restful-booker.herokuapp.com/booking/10 url’ine
        // bir GET request gonderdigimizde donen Response’un,
        // 	status code’unun 200,
        //	ve content type’inin application/json; charset=utf-8,
        //	ve Server isimli Header’in degerinin Cowboy,
        //	ve status Line’in HTTP/1.1 200 OK
        //	ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.


        // 1- request hazirla , request body ve endpoint olustur
        String endpoint = "https://restful-booker.herokuapp.com/booking/10";
        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet
        Response response = given().when().get(endpoint);

        // 4- istenen assertion'lari yap

        // bu gorevde manuel olarak test ediniz dendigi cin bu degerleri yazdiralim

        response.prettyPrint(); // sadece response body'sini yazdirir

        // response ile ilgili diger tum bilgiler de response objesinde kayitlidir
        // istediklerimize ulasabilir ve istenirse yazdirabiliriz

        System.out.println("Status code : "+ response.statusCode()); // Status code : 200
        System.out.println("Content type : "+response.getContentType());
        System.out.println("Server isimli header'in degeri : "+response.getHeader("Server"));
        System.out.println("Status line : "+response.statusLine());
        System.out.println("Response suresi : "+response.getTime());
    }
}
