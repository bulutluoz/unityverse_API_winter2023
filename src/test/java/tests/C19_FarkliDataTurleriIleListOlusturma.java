package tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class C19_FarkliDataTurleriIleListOlusturma {

    @Test
    public void test01(){

        List<String> isimler = new ArrayList<>();
        isimler.add("Arda");
        // isimler.add(7);
        // isimler.add(true);
        // isimler.add('d');

        // Eger farkli data turlerinden element koymak isterseniz
        // data turu olarak herseyi kabul eden Object secebilirsiniz

        List<Object> herseyList = new ArrayList<>();
        herseyList.add("Java");
        herseyList.add(10);
        herseyList.add(true);
        herseyList.add('k');
        herseyList.add(new int[3]);

        System.out.println(herseyList); // [Java, 10, true, k, [I@289d1c02]

        // 2.element olan 10'un 3 katini yazdirin

        System.out.println(      (Integer) herseyList.get(1) *  3           ); // 30

        // 0.index'deki String'i buyuk harf olarak yazdirin

        System.out.println(  ((String)herseyList.get(0)).toUpperCase() ); // JAVA
    }
}
