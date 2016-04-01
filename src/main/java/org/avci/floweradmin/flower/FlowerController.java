package org.avci.floweradmin.flower;

import org.avci.flower.FlowerService;
import org.avci.floweradmin.login.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowerController {

@Autowired
FlowerService flowerService;
	
	 @RequestMapping("/addflower")
	    public RestResponse addFlower (
	    		@RequestParam(value="name") String name,
	    		@RequestParam("description") String description
	    		) 
	 	{
	        RestResponse resp = new RestResponse(true, "logged in");
	        return resp;
	 	}
}
