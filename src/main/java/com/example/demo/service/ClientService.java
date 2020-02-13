package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IClientDAO;
import com.example.demo.entity.Client;

@Service
public class ClientService {
	@Autowired
	private IClientDAO cltdao;

	public IClientDAO getCltdao() {
		return cltdao;
	}

	public void setCltdao(IClientDAO cltdao) {
		this.cltdao = cltdao;
	}

	public void AjoutClientService(Client clt) {
		cltdao.save(clt);
	}

	public void SupprimerClientService(Client clt) {
		cltdao.delete(clt);
	}

	public Client GetByIdClient(Long idClient) {
		return cltdao.getOne(idClient);
	}

	public List<Client> GetAllClient() {
		return cltdao.findAll();
	}

	public void UpdateClientService(Client clt) {
		cltdao.saveAndFlush(clt);
	}

	public void createOrUpdateClient(Client entity) {
		Client client = cltdao.getOne(entity.getIdClient());

		List<Client> lst = cltdao.findAll();
		Client newEntity = new Client();
		for (int i = 0; i < lst.size(); i++) {
			if (client.equals(lst.get(i))) {
				newEntity.setNomClient(entity.getNomClient());
				newEntity.setNumClient(entity.getNumClient());
				newEntity = cltdao.save(newEntity);

			} else
				cltdao.save(entity);
		}
	}

//	public List<Client> findByNameEndsWith(String name) {
//
//		List<Client> clients = (List<Client>) cltdao.findByNameEndsWith(name);
//		return clients;
//	}

}
