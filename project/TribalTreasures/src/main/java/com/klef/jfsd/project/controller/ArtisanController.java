package com.klef.jfsd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.project.model.Artisan;
import com.klef.jfsd.project.service.ArtisanService;


@Controller
public class ArtisanController {
	@Autowired
	private ArtisanService artisanService;
	
	
	
	
	
	@PostMapping("/insertartisan")
	public ResponseEntity<String> insertartisan(@RequestBody Artisan aa) {
		
		return artisanService.artisanregistration(aa);
		

	}
	
	
	
	@PostMapping("/checkartisanlogin")
	public ResponseEntity<?> checkartisanlogin(@RequestBody Artisan alogin) {
	    String aausername = alogin.getAausername();
	    String aapassword = alogin.getAapassword();

	    Artisan artisan = artisanService.checkartisanlogin(aausername, aapassword);

	    if (artisan != null) {
	        return ResponseEntity.ok(artisan);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	    }
	}

	
	
}
