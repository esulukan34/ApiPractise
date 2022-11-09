package day04;

import base_url.GMIBankBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Customer;
import utilities.ReadText;
import utilities.WriteToText;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class GMIBank01 extends GMIBankBaseUrl {
    /*
            http://www.gmibank.com/api/tp-customers end point'ine
            request gönderin
             1) Tüm Customer bilgilerini ekrana yazdırın.
             2) Tüm Customer SSN lerini ekrana yazdırın.
             3) Tüm Customer SSN lerini text dosyası olarak kaydedin
             4) Olusturduğunuz text dosyasından  SSNleri okuyarak
                "531-95-8437", "049-43-2360", "123-34-3434" SSNlerinin olduğunu doğrulayın
 */

    @Test
    public void test11() throws JsonProcessingException {
        Customer[] customers; // kullanmayacağimiz icin ekledik
        // Set The Url
        spec.pathParam("first","tp-customers");

        // Set The Expected Data

        // Send The Request Data and Get The Response
        Response response = given().spec(spec).headers("Authorization", "Bearer " + generateToken())
                .when().get("/{first}");
        //response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();
        customers = obj.readValue(response.asString(),Customer[].class);

        // 1) Tüm Customer bilgilerini ekrana yazdırın.
        for (int i = 0; i< customers.length; i++)
        System.out.println(customers[i]);

        // 2) Tüm Customer SSN lerini ekrana yazdırın.
        for (int i = 0; i< customers.length; i++)
            System.out.println("Ssnler: " + customers[i].getSsn());

        // 3) Tüm Customer SSN lerini text dosyası olarak kaydedin
        String fileName = "src/test/java/day04/SSNNumbers.txt";
        WriteToText.saveSSNData(fileName,customers);

        // 4) Olusturduğunuz text dosyasından  SSNleri okuyarak
        // "531-95-8437", "049-43-2360", "123-34-3434" SSNlerinin olduğunu doğrulayın
        List<String> expectedSSN = new ArrayList<>();
        expectedSSN.add("531-95-8437");
        expectedSSN.add("049-43-2360");
        expectedSSN.add("123-34-3434");

        List<String> actualSSN = ReadText.readCustomerSSNList(fileName);

        Assert.assertTrue("SSNler eslesmedi",actualSSN.containsAll(expectedSSN));


    }
}
