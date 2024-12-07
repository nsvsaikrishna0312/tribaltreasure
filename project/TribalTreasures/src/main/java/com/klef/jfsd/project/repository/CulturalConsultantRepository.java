package com.klef.jfsd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.project.model.CulturalConsultant;

@Repository
public interface CulturalConsultantRepository extends JpaRepository<CulturalConsultant, Integer>{
	
	@Query("select cc from CulturalConsultant cc where cc.ccusername=?1 and cc.ccpassword=?2")
	public CulturalConsultant checkculturalconsultantlogin(String ccusername, String ccpassword);

}
