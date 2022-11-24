package Resources;

public enum APIresource {
	AddplaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	public String resorce;
	
    APIresource(String reso)
	{
		this.resorce=reso;
	}
    public String getResource()
    {
    	return resorce;
    }
}
