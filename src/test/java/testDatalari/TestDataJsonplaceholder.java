package testDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonplaceholder {
    public static int basariliResponseStatusCode = 200;
    public static String contentType = "application/json; charset=utf-8";
    public static String connectionHeaderDegeri = "keep-alive";

    public static JSONObject ornekResponseBody(){

        /*
                {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                         um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
         */

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId",3);
        jsonObject.put("id",22);
        jsonObject.put("title","dolor sint quo a velit explicabo quia nam");
        jsonObject.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return jsonObject;
    }

    public static JSONObject parametreIleBodyOlustur(int userId, int id, String title, String body ){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId",userId);
        jsonObject.put("id",id);
        jsonObject.put("title",title);
        jsonObject.put("body",body);


        return jsonObject;
    }

    public static Map<String,Object> requestBodyMapOlustur(int userId, int id, String title, String body){

        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("userId",userId);
        requestBodyMap.put("id",id);
        requestBodyMap.put("title",title);
        requestBodyMap.put("body",body);

        return requestBodyMap;
    }

    public static Map<String,Object> responseBodyMapOlustur(Double userId, Double id, String title, String body){

        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("userId",userId);
        requestBodyMap.put("id",id);
        requestBodyMap.put("title",title);
        requestBodyMap.put("body",body);

        return requestBodyMap;
    }
}
