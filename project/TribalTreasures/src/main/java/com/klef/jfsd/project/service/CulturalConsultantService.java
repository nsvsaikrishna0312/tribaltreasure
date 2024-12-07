package com.klef.jfsd.project.service;

import org.springframework.http.ResponseEntity;

import com.klef.jfsd.project.model.CulturalConsultant;

public interface CulturalConsultantService {
	public CulturalConsultant checkculturalconsultantlogin(String ccusername,String ccpassword);
	public ResponseEntity<String> culturalconsultantregistration(CulturalConsultant cc);

}
