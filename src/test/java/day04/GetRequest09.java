package day04;

import base_url.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Account;
import pojos.Country;
import pojos.Customer;
import pojos.User;
import utilities.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest09 extends GMIBankBaseUrl {

    /*
    http://www.gmibank.com/api/tp-customers/110452
    /*
    {
    "id": 110452,
    "firstName": "Jasmine",
    "lastName": "Stehr",
    "middleInitial": "V",
    "email": "marni.zboncak@yahoo.com",
    "mobilePhoneNumber": "463-609-2097",
    "phoneNumber": "1-112-497-0270",
    "zipCode": "16525",
    "address": "14387 Al Ridge5343 Bert Burgs",
    "city": "Waltermouth",
    "ssn": "761-59-2911",
    "createDate": "2021-11-28T21:00:00Z",
    "zelleEnrolled": false,
    "country": {
        "id": 3,
        "name": "USA",
        "states": null
    },
    "state": "California",
    "user": {
        "id": 110016,
        "login": "leopoldo.reinger",
        "firstName": "Jasmine",
        "lastName": "Stehr",
        "email": "marni.zboncak@yahoo.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null
    },
    "accounts": []
}
     */


    @Test
    public void get09() {
        // Set The Url
        spec.pathParams("first", "tp-customers", "second",110452);

        // Set The Expected Data

        // Account[] accounts;
        User user = new User(110016,"leopoldo.reinger","Jasmine","Stehr","marni.zboncak@yahoo.com", true,"en",null, null);

        Country country = new Country(3,"USA", null);

        Customer expectedData = new Customer(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com"
                , "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs","Waltermouth"
                , "761-59-2911", "2021-11-28T21:00:00Z", false, country, "California", user);

        // Send The Request and Get The Response
        Response response = given().spec(spec).headers("Authorization", "Bearer " + generateToken())
                .when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        Customer actualData = response.as(Customer.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(),actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(),actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(),actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(),actualData.getZipCode());
        assertEquals(expectedData.getAddress(),actualData.getAddress());
        assertEquals(expectedData.getCity(),actualData.getCity());
        assertEquals(expectedData.getSsn(),actualData.getSsn());
        assertEquals(expectedData.getCreateDate(),actualData.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(),actualData.isZelleEnrolled());
        assertEquals(expectedData.getCountry().getId(),actualData.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(),actualData.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(),actualData.getCountry().getStates());
        assertEquals(expectedData.getState(),actualData.getState());
        assertEquals(expectedData.getUser().getId(),actualData.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(),actualData.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(),actualData.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(),actualData.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(),actualData.getUser().getEmail());
        assertEquals(expectedData.getUser().getActivated(),actualData.getUser().getActivated());
        assertEquals(expectedData.getUser().getLangKey(),actualData.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(),actualData.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(),actualData.getUser().getResetDate());

        // Object Mapper ile
        Customer actualData2 = JsonUtil.convertJsonToJava(response.asString(),Customer.class);
        System.out.println("actualData2 = " + actualData2);

        assertEquals(expectedData.getId(),actualData2.getId());
        assertEquals(expectedData.getFirstName(),actualData2.getFirstName());
        assertEquals(expectedData.getLastName(),actualData2.getLastName());
        assertEquals(expectedData.getMiddleInitial(),actualData2.getMiddleInitial());
        assertEquals(expectedData.getEmail(),actualData2.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(),actualData2.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(),actualData2.getPhoneNumber());
        assertEquals(expectedData.getZipCode(),actualData2.getZipCode());
        assertEquals(expectedData.getAddress(),actualData2.getAddress());
        assertEquals(expectedData.getCity(),actualData2.getCity());
        assertEquals(expectedData.getSsn(),actualData2.getSsn());
        assertEquals(expectedData.getCreateDate(),actualData2.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(),actualData2.isZelleEnrolled());
        assertEquals(expectedData.getCountry().getId(),actualData2.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(),actualData2.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(),actualData2.getCountry().getStates());
        assertEquals(expectedData.getState(),actualData2.getState());
        assertEquals(expectedData.getUser().getId(),actualData2.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(),actualData2.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(),actualData2.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(),actualData2.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(),actualData2.getUser().getEmail());
        assertEquals(expectedData.getUser().getActivated(),actualData2.getUser().getActivated());
        assertEquals(expectedData.getUser().getLangKey(),actualData2.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(),actualData2.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(),actualData2.getUser().getResetDate());




    }
}
