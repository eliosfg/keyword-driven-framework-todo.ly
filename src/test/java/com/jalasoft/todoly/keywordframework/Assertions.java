package com.jalasoft.todoly.keywordframework;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;

public class Assertions {
    public void AssertResponse(String assertionType, Response response) {
        switch (assertionType) {
            case "basicAuthentication" -> itShouldBeBasicAuthenticated(response);
        }
    }

    public void itShouldBeBasicAuthenticated(Response response) {
        Reporter.log("Verify that a 200 OK status code and a correct response body result when a GET isAuthenticated request to the \"/authentication/isauthenticated.json\" is executed", true);
        Assert.assertEquals(response.statusCode(), 200, "Correct status code is not returned");
        Assert.assertTrue(response.statusLine().contains("200 OK"), "Correct status code and message is not returned");
        Assert.assertTrue(response.body().asString().contains("true"), "Correct response body is not returned");
    }
}
