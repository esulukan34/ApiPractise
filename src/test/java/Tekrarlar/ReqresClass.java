package Tekrarlar;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.ReqresBaseData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ReqresClass extends ReqresBaseUrl {
    /* idsi 1 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
             "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
    */

    @Test
    public void test03() {
        // Set The Url
        spec.pathParam("first","users");

        // Set The Expected Data
        ReqresBaseData obj = new ReqresBaseData();
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        // id = 1 olan
        Map<String, Object> expectedData = obj.expectedDataMethod(1,"george.bluth@reqres.in","George","Bluth","https://reqres.in/img/faces/1-image.jpg");
        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.get("id"),((Map)(actualData.get("data[0].id"))));
        assertEquals(expectedData.get("email"),actualData.get("email"));
        assertEquals(expectedData.get("first_name"),actualData.get("first_name"));
        assertEquals(expectedData.get("last_name"),actualData.get("last_name"));
        assertEquals(expectedData.get("avatar"),actualData.get("avatar"));
        System.out.println("****************");
        System.out.println("actualData: "+  actualData);
        System.out.println("****************");
        System.out.println("expectedData: "+  expectedData);







    }
}
