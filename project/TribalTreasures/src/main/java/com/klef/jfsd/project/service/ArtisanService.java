package com.klef.jfsd.project.service;

import org.springframework.http.ResponseEntity;

import com.klef.jfsd.project.model.Artisan;

public interface ArtisanService {
	public Artisan checkartisanlogin(String aausername,String aapassword);
	public ResponseEntity<String> artisanregistration(Artisan aa);
	

}
