package com.klef.jfsd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.project.model.CulturalConsultant;
import com.klef.jfsd.project.service.CulturalConsultantService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CulturalConsultantController {
	@Autowired
	private CulturalConsultantService culturalConsultantService;
	
	@GetMapping("/culturalconsultanthome")
    public ModelAndView culturalconsultanthome() {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("culturalconsultanthome");
    	return mv;
    }
	
	@GetMapping("/culturalconsultantreg")
    public ModelAndView culturalconsultantreg() {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("culturalconsultant_registration");
    	return mv;
    }
	
	@PostMapping("/insertculturalconsultant")
	public ResponseEntity<String> insertculturalconsultant(@RequestBody CulturalConsultant cc) {
		
		
		return culturalConsultantService.culturalconsultantregistration(cc);
		

	}
	
	@GetMapping("/culturalconsultantlogin")
	public ModelAndView culturalconsultantlogin() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("culturalconsultantlogin");
		return mv;
	}
	
	@PostMapping("/checkculturalconsultantlogin")
	public ResponseEntity<String> checkculturalconsultantlogin(@RequestBody CulturalConsultant cc) {
		
		String ccusername=cc.getCcusername();
		String ccpassword=cc.getCcpassword();
		
		
		
		CulturalConsultant culturalConsultant=culturalConsultantService.checkculturalconsultantlogin(ccusername, ccpassword);
		if(culturalConsultant!=null) {
			return ResponseEntity.ok("Login Successfull");
		}
		else {
				return ResponseEntity.ok("Login Unsuccessfull");	
		}
		
		
	}
	
	
}
