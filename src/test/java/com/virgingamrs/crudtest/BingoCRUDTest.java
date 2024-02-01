package com.virgingamrs.crudtest;

import com.virgingamrs.testbase.TestBase;
import com.virgingamrs.userinfo.UserSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class BingoCRUDTest extends TestBase {
    static ValidatableResponse response;
    @Steps
    UserSteps steps;

    @Title("create user successfully")
    @Test
    public void iSendAGETRequestToUserEndpoint () {
        response = steps.getAllUsersOfBingo();
        response.log().all();
    }

    @Title("Verify if the user was created successfully")
    @Test
    public void  iVerifyTheResponseCodeIs(){
        response.statusCode(200);
    }

    @Title("verify endpoints")
    @Test
    public void iSendDifferentQueryParameters() {
        response = steps.getUsersWithQueryParams();
        response.log().all();
    }
}
