package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C01_ilkRequest {

    @Test
    public void ilkRequest(){

        // 1- request hazirla , request body ve endpoint olustur
        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet
        // 4- istenen assertion'lari yap

        /*
            API testing'de yapilacak islem yukaridaki 4 maddedir
            sadece sirketlere ve framework'lere bagli olarak
            o 4 islemin yapilisi degisebilir
            1- Matchers ile beklenen degerler ile actual degerleri karsilastiracagiz
            2- JUnit assert class'i ile testleri yapicaz
            3- bize expected body verildiginde json ile expected response olusturma
            4- Jsonpath kullanarak bilgilere daha pratik ulasma
            5- expected response olusturulurken Map kullanimi
            6- Pojo Class'lar kullanarak, karmasik expected body'leri olusturma
            7- Cucumber framework ile API testleri
            8- Karate framework kullanilarak, hazir method'larla api testi
         */

        // https://restful-booker.herokuapp.com/booking/10 url’ine
        // bir GET request gonderdigimizde donen Response’u yazdirin.

        // 1- request hazirla , request body ve endpoint olustur
        String endpoint = "https://restful-booker.herokuapp.com/booking/10";
        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet

        Response response = given() // request yollanmadan yapilmasi gereken on hazirliklar icin kullanilir
                            .when() // request yollarken body kullanmamiz gerekirse, body ile ilgili detaylari when()'den sonra yapariz
                            .get(endpoint); // kullanacagimiz HTTP methodu get, post,put,patch,delete
                                            // icine de kullanacagimiz endpoint yazilir


        response.prettyPrint();

        // 4- istenen assertion'lari yap
    }
}
