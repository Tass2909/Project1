package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMenuDAO;
import com.example.demo.entity.Menu;

@Service
public class MenuService {
	@Autowired
	private IMenuDAO cltdao;

	public void AjoutMenuService(Menu clt) {
		cltdao.save(clt);
	}

	public void SupprimerMenuService(Menu clt) {
		cltdao.delete(clt);
	}

	public Menu GetByIdMenu(Long idMenu) {
		return cltdao.getOne(idMenu);
	}
	public List<Menu> GetAllMenu() {
		return cltdao.findAll();
	}
	public void UpdateMenuService(Menu clt) {
		cltdao.saveAndFlush(clt);
	}
}
