package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserDAO;
import com.example.demo.entity.User;

@Service
public class UserService {
	@Autowired
	private IUserDAO cltdao;

	public void AjoutUserService(User clt) {
		cltdao.save(clt);
	}

	public void SupprimerUserService(User clt) {
		cltdao.delete(clt);
	}

	public User GetByIdUser(Long idClient) {
		return cltdao.getOne(idClient);
	}

	public List<User> GetAllUser() {
		return cltdao.findAll();
	}

	public void UpdateUserService(User clt) {
		cltdao.saveAndFlush(clt);
	}

}
