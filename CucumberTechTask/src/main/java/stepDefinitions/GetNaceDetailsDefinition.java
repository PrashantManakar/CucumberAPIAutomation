package stepDefinitions;

import org.testng.Assert;

import com.api.constants.Endpoints;
import com.api.manager.FileReaderManager;
import com.api.testDataType.NaceTestData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author prash
 *
 */
public class GetNaceDetailsDefinition {

	Response response = null;

	/**
	 * Purpose: Set up of Restassured BASE_URL nd Port
	 * 
	 */
	@Given("API is ready and I can fetch data from application")
	public void api_is_ready_and_i_can_fetch_data_from_application() {
		RestAssured.baseURI = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
		RestAssured.port = Integer.parseInt(FileReaderManager.getInstance().getConfigReader().getApplicationPort());
	}

	/**
	 * Purpose: Getting response from server when we send query parameter.
	 * 
	 * @param order
	 */
	@When("get NaceDetails by using  {string}")
	public void get_nace_details_by_using(String order) {
		response = RestAssured.given().queryParam("Order", order).contentType(ContentType.JSON)
				.get(Endpoints.GET_NACE_DETAILS_RESPONSE).then().extract().response();
	
		Assert.assertEquals(response.getStatusCode(), 200, "Api response is wrong");
	}

	/**
	 * Purpose: This method is used to verify response values with JSON file.
	 * 
	 * @param order
	 */
	@Then("verify NaceDetails are as per {string}")
	public void verify_nace_details_are_as_per(String order) {
		// Getting JSON values by using order
		Integer orderNumber = Integer.parseInt(order);
		NaceTestData naceTestOrders = FileReaderManager.getInstance().getJsonReader().getNaceByOrder(orderNumber);

	
		// Asserting all the response values
		Assert.assertEquals(response.jsonPath().getString("Order[0]").trim(), Integer.toString(naceTestOrders.order),
				naceTestOrders.order + "Is not matching with " + response.jsonPath().getString("Order[0]"));
		Assert.assertEquals(response.jsonPath().getString("Level[0]").trim(), Integer.toString(naceTestOrders.level),
				naceTestOrders.level + "Is not matching with " + response.jsonPath().getString("Level[0]"));
		Assert.assertEquals(response.jsonPath().getString("Code[0]").trim(), naceTestOrders.code,
				naceTestOrders.code + "Is not matching with " + response.jsonPath().getString("Code[0]"));
		Assert.assertEquals(response.jsonPath().getString("Parent[0]").trim(), naceTestOrders.parent,
				naceTestOrders.parent + "Is not matching with " + response.jsonPath().getString("Parent[0]"));
		Assert.assertEquals(response.jsonPath().getString("Description[0]").trim(), naceTestOrders.description,
				naceTestOrders.description + "Is not matching with " + response.jsonPath().getString("Description[0]"));
		
	//	System.out.println(response.jsonPath().getString("This item includes").trim());
		
		
	/*	Assert.assertEquals(response.jsonPath().getString("This item includes[0]").trim(), naceTestOrders.thisItemIncludes,
				naceTestOrders.thisItemIncludes + "Is not matching with "
						+ response.jsonPath().getString("This item includes[0]"));
		Assert.assertEquals(response.jsonPath().getString("This item also includes[0]").trim(), naceTestOrders.thisItemAlsoIncludes,
				naceTestOrders.thisItemAlsoIncludes + "Is not matching with "
						+ response.jsonPath().getString("This item also includes[0]"));
		Assert.assertEquals(response.jsonPath().getString("Ruling").trim(), naceTestOrders.rulings,
				naceTestOrders.rulings + "Is not matching with " + response.jsonPath().getString("Ruling"));
		Assert.assertEquals(response.jsonPath().getString("This item excludes[0]"), naceTestOrders.thisItemExcludes,
				naceTestOrders.thisItemExcludes + "Is not matching with "
						+ response.jsonPath().getString("This item excludes[0]"));
		Assert.assertEquals(response.jsonPath().getString("Reference to ISIC Rev. 4[0]").trim(), naceTestOrders.referenceToISICRev4,
				naceTestOrders.referenceToISICRev4 + "Is not matching with "
						+ response.jsonPath().getString("Reference to ISIC Rev. 4[0]"));
*/
	}

}
