package org.avci.floweradmin.login;

import org.avci.flower.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowerLoginRestController {

	 @RequestMapping("/login")
	    public RestResponse login (
	    		@RequestParam(value="login") String name,
	    		@RequestParam("password") String password
	    		) 
	 	{
	        RestResponse resp = new RestResponse(true, "logged in");
	        return resp;
	 	}
}
