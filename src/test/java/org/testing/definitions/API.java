package org.testing.definitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.github.javafaker.Faker;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class API {}
//
//    private final String apiKey = "65f85aaf1f2e054a6144f557";
//    private final String baseUrl = "https://dummyapi.io/data/v1/user";
//    private String newlyCreatedId;
//    private String email;
//    private Response response;
//    private RequestSpecification requestSpec;
//
//    private final Faker faker = new Faker();
//    private String email1;
//
//    @Given("I have API Key")
//    public void iHaveAPIKey() {
//        RestAssured.baseURI = baseUrl;
//        requestSpec = given().header("app-id", apiKey).contentType("application/json");
//    }
//
//    @When("I send a POST request to create a user with unique email")
//    public void iSendPOSTRequestToCreateUser() {
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        String email1 = faker.internet().emailAddress();
//
//        response = given()
//                .header("app-id", apiKey)
//                .contentType("application/json")
//                .body("{ \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"email\": \"" + email1 + "\" }")
//                .when()
//                .post("/create")
//                .then()
//                .extract().response();
//
//        newlyCreatedId = response.jsonPath().getString("id");
//    }
//
//    @Then("the response status code should be {int}")
//    public void responseStatusCodeShouldBe(int statusCode) {
//        if (response != null) {
//            response.then().statusCode(statusCode);
//        }
//    }
//
//    @When("I send a DELETE request to delete the created user")
//    public void iSendDELETERequestToDeleteUser() {
//        if (newlyCreatedId != null) {
//            response = given()
//                    .header("app-id", apiKey)
//                    .pathParam("userId", newlyCreatedId)
//                    .when()
//                    .delete("/{userId}")
//                    .then()
//                    .extract().response();
//        }
//    }
//
//    @Then("the delete response status code should be {int}")
//    public void deleteResponseStatusCodeShouldBe(int statusCode) {
//        if (response != null) {
//            response.then().statusCode(statusCode);
//        }
//    }
//
//    @Then("the delete response message should indicate user deletion success")
//    public void deleteResponseMessageShouldIndicateSuccess() {
//        // Assuming this step validates the response message, which is not explicitly defined in the feature file.
//        // You can add assertion logic here based on the actual response.
//    }
//
//    @When("I send a POST request to create a user")
//    public void iSendPOSTRequestToCreateUserAndSaveData() {
//        email = faker.internet().emailAddress();
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//
//        String requestBody = "{ \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"email\": \"" + email + "\" }";
//
//        response = requestSpec.body(requestBody).post("/create");
//        newlyCreatedId = response.jsonPath().getString("id");
//    }
//
//    @Then("the response message should indicate email already used")
//    public void responseMessageShouldIndicateEmailAlreadyUsed() {
//        if (response != null) {
//            response.then()
//                    .statusCode(400)
//                    .body("error", equalTo("BODY_NOT_VALID"))
//                    .body("data.email", equalTo("Email already used"));
//        }
//    }
//
//    @When("I send a DELETE request to delete a user with an invalid ID")
//    public void iSendDELETERequestToDeleteUserWithInvalidID() {
//        given()
//                .header("app-id", apiKey)
//                .pathParam("userId", "invalidUserId")
//                .when()
//                .delete("/{userId}")
//                .then()
//                .statusCode(400)
//                .body("error", equalTo("PARAMS_NOT_VALID"));
//    }
//}