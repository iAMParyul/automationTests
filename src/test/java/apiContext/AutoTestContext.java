package apiContext;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AutoTestContext {
    private String token;

    private Response response;

    public String getToken() {
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response){
        this.response = response;
    }

}
