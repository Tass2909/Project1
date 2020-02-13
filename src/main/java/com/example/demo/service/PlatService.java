package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPlatDAO;
import com.example.demo.entity.Plat;

@Service
public class PlatService {
	@Autowired
	private IPlatDAO cltdao;

	public void AjoutPlatService(Plat clt) {
		cltdao.save(clt);
	}

	public void SupprimerPlatService(Plat clt) {
		cltdao.delete(clt);
	}

	public Plat GetByIdPlat(Long idPlat) {
		return cltdao.getOne(idPlat);
	}

	public List<Plat> GetAllPlat() {
		return cltdao.findAll();
	}

	public void UpdatePlatService(Plat clt) {
		cltdao.saveAndFlush(clt);
	}

}
