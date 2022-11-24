package stepDefinitions;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
//import pojo.AddPlace;
//import pojo.Location;
//import resources.APIResources;
//import resources.TestDataBuild;
//import resources.Utils;
import static io.restassured.RestAssured.given;

import org.junit.runner.RunWith;

import Resources.APIresource;
import Resources.TestData;
import Resources.Utils;
public class stepDefinition extends Utils{
	
	TestData data=new TestData();
	RequestSpecification requset;
	ResponseSpecification resspec;
	Response response;
	static String placeId;
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		requset=given().spec(requestSpecification()).body(data.addDataToPayload(name,language,address));
	  
	}

	@When("User call {string} using {string} request")
	public void user_call_using_request(String rosource, String method) {
		
		APIresource api=APIresource.valueOf(rosource);
		System.out.println(api.getResource());
		System.out.println(" 1");
		System.out.println(" 2");
		System.out.println(" 3");
	
		
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
			response =requset.when().post(api.getResource());
			else if(method.equalsIgnoreCase("GET"))
				response =requset.when().get(api.getResource());
	}

	@Then("The API run successfully and got status code {int}")
	public void the_api_run_successfully_and_got_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	    
	}

	@Then("Verify {string} in response body is {string}")
	public void verify_in_response_body_is(String key, String expectedVal) {
		assertEquals(getJsonPath(response,key),expectedVal);
	    
	}

	@Then("Verify the place-id created with {string} and {string} from response")
	public void verify_the_place_id_created_with_and(String expectedName, String rosource) throws IOException {
		placeId=getJsonPath(response,"place_id");
		requset=given().spec(requestSpecification()).queryParam("place_id", placeId);
		user_call_using_request(rosource,"GET");
		assertEquals(getJsonPath(response,"name"),expectedName); 
		
	}
	
	@Given("Delete place payload with place_id")
	public void delete_place_payload_with_place_id() throws IOException {
		requset=given().spec(requestSpecification()).body(data.deletePayload(placeId));

	}



}
