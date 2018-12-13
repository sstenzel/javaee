package pl.sstenzel.ug.javaee.florists.restjpa.restservice;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import pl.sstenzel.ug.javaee.florists.restjpa.domain.Flower;

import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.given;
//import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.*;     // do delete("/flower/")
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.equalToIgnoringCase;

public class FlowerRESTServiceTest {

    private static final String FLOWER_NAME = "HOYA";

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/florists/api";
    }

    @Test
    public void test1() {
    }

    @Test
    public void get() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/flower/").then().assertThat().statusCode(200);
    }

    @Test
    public void get1() {
    }

    @Test
    public void add() {
        delete("/flower/").then().assertThat().statusCode(200);

        Flower flower = new Flower(FLOWER_NAME);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(flower).
                when().
                post("/flower/").then().assertThat().statusCode(201);
    }

    @Test
    public void update() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void deleteFlower() {
    }
}