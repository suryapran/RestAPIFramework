package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@Deleteplace")
	public void beforeScenario() throws IOException
	{
		stepDefinition stpDef=new stepDefinition();
		if (stpDef.placeId==null)
		{
		stpDef.add_place_payload_with("Pranhome","French","23 toronto");
		stpDef.user_call_using_request("AddplaceAPI", "POST");
		stpDef.verify_the_place_id_created_with_and("Pranhome", "getPlaceAPI");
		}
		
	}
}
