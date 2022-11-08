package day02;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class GetRequest04 {

        /*
        http://dummy.restapiexample.com/api/v1/employees url
        GET request’i yolladigimda gelen response’un
        status kodunun 200 ve
        content type’inin “application/json”
        ve employees sayisinin 24
        ve employee’lerden birinin “Ashton Cox”
        ve gelen yaslar icinde 21, 61, ve 23 degerlerinin oldugunu test edin.
         */

    @Test
    public void test04() {

        String url = "http://dummy.restapiexample.com/api/v1/employees ";

        Response response = given().when().get(url);
        // given().when().get(url) ==> end point'e gondermek icin request olusturmus olduk
        // Response response ==> api tarfaindan bana donen respons(cevap)

        // Status kodunun 200 ve contentType'nin "application/json"
        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);

        // employees sayisinin 24 ve employee’lerden birinin “Ashton Cox”
        response.then().
                assertThat().
                body("data.id",hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(21, 61, 23));






    }
}
