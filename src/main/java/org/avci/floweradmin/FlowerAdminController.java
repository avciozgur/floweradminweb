package org.avci.floweradmin;

import java.util.Map;

import org.avci.flower.FlowerService;
//import org.avci.flower.services.FlowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FlowerAdminController {

	private final Logger logger = LoggerFactory.getLogger(FlowerAdminController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

			
		return "index";
	}

}
