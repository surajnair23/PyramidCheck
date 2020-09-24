package com.frassessment.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frassessment.app.services.PyramidServiceImpl;

@RestController
public class PyramidController {
	
	@Autowired
	PyramidServiceImpl pyramidService;
	
    @GetMapping("/assess")
    public ResponseEntity<?> getItemList(@RequestParam(value="word") String word){
    	word = word.trim();

    	if(word.isEmpty() || !word.matches("^[a-zA-Z]*$")) {
    		//formulate response
    		String errorString = "Invalid input";
    		return new ResponseEntity(errorString,HttpStatus.BAD_REQUEST);
    	}else {
    		//formulate response
    		String pyramid = pyramidService.isPyramid(word.trim().toLowerCase()) ? "a pyramid" : "not a pyramid";
    		String responseString = "The word "+word+" is "+ pyramid;
    		
    		return new ResponseEntity(responseString,HttpStatus.OK);
    	}
    			
    }
    
    //unsolicited url
    @GetMapping(value = "/{[path:[^\\.]*}")
    public ResponseEntity<?> redirect() {
    	//formulate response
    	String responseString = "Kindly access correct URL";
    	return new ResponseEntity(responseString,HttpStatus.NOT_FOUND);
    } 
    
}
