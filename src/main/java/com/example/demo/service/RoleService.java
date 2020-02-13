package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IRoleDAO;
import com.example.demo.entity.Role;

@Service
public class RoleService {
	@Autowired
	private IRoleDAO cltdao;

	public void AjoutRoleService(Role clt) {
		cltdao.save(clt);
	}

	public void SupprimerRoleService(Role clt) {
		cltdao.delete(clt);
	}

	public Role GetByIdRole(Long idClient) {
		return cltdao.getOne(idClient);
	}

	public List<Role> GetAllRole() {
		return cltdao.findAll();
	}

	public void UpdateRoleService(Role clt) {
		cltdao.saveAndFlush(clt);
	}

}
