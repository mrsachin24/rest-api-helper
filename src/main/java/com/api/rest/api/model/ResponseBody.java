package com.api.rest.api.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseBody {
	public  String BrandName;
	public  Features Features;
	public  String Id;
	public  String LaptopName;
	
	
}

class Features{
	public List<String> Feature=new ArrayList<String>();
}
