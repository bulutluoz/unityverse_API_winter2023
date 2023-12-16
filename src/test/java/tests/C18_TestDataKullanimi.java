package tests;

import baseUrl.BaseUrlHerokuapp;
import org.junit.Test;

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

        // 2- gorevde isteniyorsa expected body olustur
        // 3- request'i gonder ve donen actual response'i kaydet
        // 4- istenen assertion'lari yap
    }
}
