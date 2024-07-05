package stepDefs;

import apiContext.AutoTestContext;
import Mission.HerokuAppMission;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

@Slf4j
public class HerokuAppStepDefs {

    @Inject
    HerokuAppMission herokuAppMission;

    @Inject
    AutoTestContext context;

    @When("I request for new token")
    public void i_request_for_new_token() {
        Response response = herokuAppMission.createToken("admin", "password123");
        context.setResponse(response);
    }
    @Then("I got {int} as a response")
    public void i_got_as_a_response(int int1) {
        assertEquals(int1, context.getResponse().statusCode());

    }
    @Then("I got the token in the response")
    public void i_got_the_token_in_the_response() {
        context.setToken(context.getResponse().getBody().path("token"));
        assertNotNull(context.getToken());
    }

    @When("I like to get booking ids")
    public void iLikeToGetBookingIds() {
        Response response = herokuAppMission.getBookingIds();
        context.setResponse(response);
    }

    @Then("I got details from the response")
    public void iGotTheBookingIdsFrmTheResponse() {
        context.getResponse().getBody().prettyPrint();
    }

    @When("I want to get details of booking id {string}")
    public void iWantToGetDetailsOfBookingIds(String id) {
        Response response = herokuAppMission.getDetailsOfBookingIds(id);
        context.setResponse(response);
    }

    @When("I want to get Id of booking using first name {string} and lastname {string}")
    public void iWantToGetIdOfBookingUsingName(String firstname, String lastname) {
        Response response = herokuAppMission.getIdOfBookingUsingName(firstname, lastname);
        context.setResponse(response);
    }


}
