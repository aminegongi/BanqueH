package hechem.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hechem.spring.entity.Portefeuille;
import hechem.spring.entity.PortefeuilleClient_utils;
import hechem.spring.entity.PrixAction_utils;
import hechem.spring.repository.PortefeuilleRepository;


@Service
public class PortefeuilleService {
	@Autowired
	PortefeuilleRepository portefeuilleRepository;

	public List<Portefeuille> getAll() {
		List<Portefeuille> portefeuilles = new ArrayList<Portefeuille>();
		portefeuilleRepository.findAll().forEach(act -> portefeuilles.add(act));
		return portefeuilles;
	}

	public void save(Portefeuille portefeuilles) {
		portefeuilleRepository.save(portefeuilles);
	}

	public void update(Portefeuille portefeuilles) {
		portefeuilleRepository.save(portefeuilles);
	}

	public void delete(int id) {
		portefeuilleRepository.deleteById(id);
	}
	
	public void portfeuilleClients(int id_client) {
		List<PortefeuilleClient_utils> portefeuilles = new ArrayList<PortefeuilleClient_utils>();
		portefeuilleRepository.findAll().forEach(pc -> {
			if(pc.getActionUser().getId_user() == id_client){
				
			}
		});
		
		
	}
}