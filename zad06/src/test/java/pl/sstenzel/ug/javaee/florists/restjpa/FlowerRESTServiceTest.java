package pl.sstenzel.ug.javaee.florists.restjpa;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import pl.sstenzel.ug.javaee.florists.restjpa.domain.Flower;

public class FlowerRESTServiceTest {
//
//	private static final String FLOWER_NAME = "Gozdzik";
////	private static final String FLOWER_ = "Przyslowiowy-Kowalski";
//
//	@BeforeClass
//	public static void setUp(){
//		RestAssured.baseURI = "http://localhost";
//		RestAssured.port = 8080;
//		RestAssured.basePath = "/florists/api";
//	}
//
//
//	@Test
//	public void add(){
//		delete("/flower/").then().assertThat().statusCode(200);
//
//        Flower flower = new Flower(FLOWER_NAME, ..., 1976);
//
//		given().
//	       contentType(MediaType.APPLICATION_JSON).
//	       body(flower).
//	    when().
//	    post("/flower/").then().assertThat().statusCode(201);
//	}

}
