package org.avci.floweradmin.bouquet;

import java.util.List;

import org.avci.bouquet.Bouquet;
import org.avci.bouquet.BouquetService;
import org.avci.flower.FlowerService;
import org.avci.floweradmin.login.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class BouquetAdminController {

@Autowired
BouquetService bouquetService;
	
//-------------------Retrieve All Bouquets--------------------------------------------------------

@RequestMapping(value = "/bouquet", method = RequestMethod.GET)
public ResponseEntity<List<Bouquet>> listAllBouquets() {
    List<Bouquet> bouquets = bouquetService.findAllBouquets();
    if(bouquets.isEmpty()){
        return new ResponseEntity<List<Bouquet>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
    }
    return new ResponseEntity<List<Bouquet>>(bouquets, HttpStatus.OK);
}

//-------------------Retrieve Single Bouquet--------------------------------------------------------

@RequestMapping(value = "/bouquet/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Bouquet> getBouquet(@PathVariable("name") String name) {
    //System.out.println("Fetching User with id " + id);
    Bouquet bouquet = bouquetService.findByName(name);
    if (bouquet == null) {
        System.out.println("User with id " + name + " not found");
        return new ResponseEntity<Bouquet>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Bouquet>(bouquet, HttpStatus.OK);
}

//-------------------Create a Bouquet--------------------------------------------------------

@RequestMapping(value = "/bouquet", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> createBouquet(@RequestBody Bouquet bouquet ) {
    System.out.println("Creating User " + bouquet.getName());

    if (bouquetService.isExists(bouquet.getName())) {
        System.out.println("A User with name " + bouquet.getName() + " already exist");
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    bouquetService.saveBouquet(bouquet);

    //HttpHeaders headers = new HttpHeaders();
    //headers.setLocation(ucBuilder.path("/bouquet/{name}").buildAndExpand(bouquet.getName()).toUri());
    return new ResponseEntity<Void>( HttpStatus.CREATED);
}

//------------------- Update a Bouquet --------------------------------------------------------

@RequestMapping(value = "/bouquet/{name}", method = RequestMethod.PUT)
public ResponseEntity<Bouquet> updateBouquet(@PathVariable("id") String name, @RequestBody Bouquet bouquet) {
    System.out.println("Updating User " + name);
     
    Bouquet currentBouquet = bouquetService.findByName(name);
     
    if (currentBouquet==null) {
        System.out.println("User with id " + name + " not found");
        return new ResponseEntity<Bouquet>(HttpStatus.NOT_FOUND);
    }
     
    bouquetService.updateBouquet(bouquet);
    return new ResponseEntity<Bouquet>(HttpStatus.OK);
}

//------------------- Delete a Bouquet --------------------------------------------------------

@RequestMapping(value = "/bouquet/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Bouquet> deleteBouquet(@PathVariable("name") String name) {
    System.out.println("Fetching & Deleting User with id " + name);

    Bouquet bouquet = bouquetService.findByName(name);
    if (bouquet == null) {
        System.out.println("Unable to delete. User with id " + name + " not found");
        return new ResponseEntity<Bouquet>(HttpStatus.NOT_FOUND);
    }

    bouquetService.deleteBouquet(name);
    return new ResponseEntity<Bouquet>(HttpStatus.NO_CONTENT);
}

	 
}
