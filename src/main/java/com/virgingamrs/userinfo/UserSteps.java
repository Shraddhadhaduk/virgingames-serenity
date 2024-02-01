package com.virgingamrs.userinfo;

import com.virgingamrs.constant.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.equalTo;

public class UserSteps {
    @Step("Getting all users of Bingo")
    public ValidatableResponse getAllUsersOfBingo(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_USERS)
                .then();
    }
    @Step("Getting all users of Bingo with query parameters")
    public ValidatableResponse getUsersWithQueryParams(){
        return SerenityRest.given().log().ifValidationFails()
                .when()
                .queryParams("currency","GBP")
                .get(EndPoints.GET_ALL_USERS)
                .then()
                .body("data.pots.find{it.id == '309'}.currency",equalTo("GBP"));
    }
}
