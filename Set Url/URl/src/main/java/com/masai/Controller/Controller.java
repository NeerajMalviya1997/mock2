package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.URLsServiceIMPL;

@RestController
public class Controller {
	
	@Autowired
	private URLsServiceIMPL impl;
	
	
	
	@PostMapping("/url")
	public ResponseEntity<String> saveurl(@RequestParam String url){
		String s=impl.createSorturl(url);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/url")
	public ResponseEntity<String> geturl(@RequestParam String url){
		String s=impl.getcustomurl(url);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	
}
