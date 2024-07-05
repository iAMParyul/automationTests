package Mission;

import apiContext.AutoTestContext;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class HerokuAppMission {

    @Inject
    AutoTestContext apicontext;

    public Response createToken(String username, String password) {
        Map<String,String> body =  new HashMap<String,String>();
        body.put("password", password);
        body.put("username", username);
        return RestAssured.given()
                .when()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .body(body)
                .header("Content-type", "application/json")
                .post();
    }

    public Response getBookingIds() {
        return RestAssured.given()
                .when()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .header("Content-type", "application/json")
                .get();
    }

    public Response getDetailsOfBookingIds(String id) {
        return RestAssured
                .given()
                .when()
                .baseUri("https://restful-booker.herokuapp.com/booking/" + id)
                .header("Accept", "application/json")
                .get();
    }

    public Response getIdOfBookingUsingName(String firstname, String lastname) {
        Map<String, String> body= new HashMap<String, String>();
        body.put("firstname", firstname);
        body.put("lastname", lastname);
        RequestSpecification request =  RestAssured.given()
                .when()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .header("Content-type", "application/json")
                .params(body);
        return request.get();
    }
}
