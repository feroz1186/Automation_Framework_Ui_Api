package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class API_UserSteps {
	
	Response response;
	RequestSpecification request;
	
	@Given("API base URL is set")
	public void set_base_url()
	{
		RestAssured.baseURI=ConfigReader.get("baseUrl");
		request = RestAssured.given();
	}
	
	@When("user sends GET request to {string}")
	public void send_get_request(String endpoint)
	{
		response = request.get(endpoint);
	}
    
	@Then("response status code should be {int}")
	public void response_status(int statuscode)
	{
		Assert.assertEquals(response.getStatusCode(),statuscode);
	}
	
	@Then("response field {string} should be {int}")
	public void verify_extract_data(String jsonpath, int id)
	{
		
	}
}
