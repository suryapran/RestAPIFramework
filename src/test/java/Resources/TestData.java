package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestData {
	
	public AddPlace addDataToPayload(String name,String language,String address)
	{
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 2222");
		p.setAddress(address);
		p.setWebsite("http://google.com");
		p.setLanguage(language);
		
		List<String> a= new ArrayList<String>();
		a.add("shoe park");
		a.add("shop");
		p.setTypes(a);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
	}
	public String deletePayload(String placeid)
	{
			return "{\r\n    \"place_id\":\""+placeid+"\"\r\n}\r\n";
	}

}


