package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C07_JSonObjectIleJsonPathKullanimi {

    @Test
    public void test01(){
        JSONObject kisiBilgileriJsonObj= new JSONObject();
        // firstname,lastname,age ==> direk bilgi
        // address ==> bir JSonObject
        // phoneNumbers ==> bir JsonArray  ==> icinde 2 tane JsonObject var

        // olusturmaya en icerdeki json objelerinden basliyorum
        JSONObject cepTelJsonObj= new JSONObject();
        JSONObject evTelJsonObj= new JSONObject();
        cepTelJsonObj.put("type","iPhone");
        cepTelJsonObj.put("number","0123-4567-8888");
        evTelJsonObj.put("type","home");
        evTelJsonObj.put("number","0123-4567-8910");

        JSONArray telefonBilgileriArr= new JSONArray();
        telefonBilgileriArr.put(cepTelJsonObj);
        telefonBilgileriArr.put(evTelJsonObj);


        JSONObject adresJsonObj= new JSONObject();
        adresJsonObj.put("streetAddress","naist street");
        adresJsonObj.put("city","Nara");
        adresJsonObj.put("postalCode","630-0192");


        // icerdeki tum json objeleri hazir olunca
        // asil Json objesine tum elementleri ekleyebiliriz

        kisiBilgileriJsonObj.put("firstname","Jonn");
        kisiBilgileriJsonObj.put("lastname","Doe");
        kisiBilgileriJsonObj.put("age",26);
        kisiBilgileriJsonObj.put("address",adresJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArr);

        System.out.println(kisiBilgileriJsonObj);

        /*
            {"firstname":"Jonn","address":{"streetAddress":"naist street","city":"Nara","postalCode":"630-0192"},"age":26,"phoneNumbers":[{"number":"0123-4567-8888","type":"iPhone"},{"number":"0123-4567-8910","type":"home"}],"lastname":"Doe"}
         */

        // soyismini buyuk harf olarak yazdirin

        System.out.println(kisiBilgileriJsonObj.getString("lastname").toUpperCase()); // DOE

        // kisinin yasadigi sehri yazdirin

        System.out.println(kisiBilgileriJsonObj.getJSONObject("address").getString("city"));// Nara

        // cep telefonunun numarasini yazdirin

        System.out.println(kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        // 0123-4567-8888


    }
}
