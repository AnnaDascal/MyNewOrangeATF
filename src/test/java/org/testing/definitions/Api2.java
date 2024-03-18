package org.testing.definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class Api2 {

    private final String apiKey = "65f85aaf1f2e054a6144f557";
    private final String baseUrl = "https://dummyapi.io/data/v1/user";
    private final Faker faker = new Faker();
    private String email;
    private Response response;
    private RequestSpecification requestSpec;
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);


    @Given("I have API Key")
    public void iHaveAPIKey() {
        RestAssured.baseURI = baseUrl;
        requestSpec = given().header("app-id", apiKey).contentType("application/json");
    }
    @When("I send a POST request to create a user")
    public void iSendPOSTRequestToCreateUser() {

        email = emailGeneration();
//        context.set(email);
//        String requestBody = requestBody1(firstNameGeneration(), lastNameGeneration(), emailGeneration());
        String requestBody = requestBody1(firstNameGeneration(), lastNameGeneration(), email);
        response = requestSpec.body(requestBody).post("/create");
    }

    @Then("the response status code should be {int}")
    public void responseStatusCodeShouldBe(int responseStatusCode) {
//        response.then().statusCode(200)
//                .extract().path("id");
//        responseStatusCode == 200) {
//            response.then().statusCode(200);
//            logger.info("User successfully created, code" + response + "matches the expected code 200");

//        @Then("the response status code {int}")
//    public void responseStatusCodeShouldBe(int responseStatusCode) {
//            response.then().statusCode(400);
//            logger.info("User can't be created, code " + response + " matches the expected code 400");
//        }
        Assert.assertEquals(responseStatusCode, response.getStatusCode());
// response.then().statusCode(200);
        //   TODO: Почитать и придумать лог AssetrJ core (from maven)



    }
    @And("repeat request")
    public void repeatRequest() {
        String requestBody2 = requestBody1(firstNameGeneration(), lastNameGeneration(), email);
        response = requestSpec.body(requestBody2).post("/create");
    }
    @And("the response message should indicate email already used")
    public void responseMessageShouldIndicateEmailAlreadyUsed() {
        Assert.assertEquals("BODY_NOT_VALID", response.then().extract().path("error"));
        Assert.assertEquals("Email already used", response.then().extract().path("data.email"));
        logger.info("JSON response matches with the expected JSON response");
    }  // TODO: AssetrJ core (from maven) Assert softly
    private String requestBody1(String firstName, String lastName, String email) {
        String requestBody = "{\n" +
                "    \"firstName\": \"" + firstName + "\",\n" +
                "    \"lastName\": \"" + lastName + "\",\n" +
                "    \"email\": \"" + email + "\"\n" +
                "}";
        return requestBody;
    }

    private String emailGeneration() {
        return faker.internet().emailAddress();
    }

    private String firstNameGeneration() {
        return faker.name().firstName();
    }

    private String lastNameGeneration() {
        return faker.name().lastName();
    }
}

