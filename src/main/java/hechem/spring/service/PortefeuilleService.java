package hechem.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hechem.spring.entity.Action;
import hechem.spring.entity.Portefeuille;
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
	
	public List<Portefeuille> portfeuilleClient(int id_client) {
		List<Portefeuille> portefeuilles = new ArrayList<Portefeuille>();
		portefeuilleRepository.findAll().forEach(pc -> {
			if(pc.getActionUser().getId_user() == id_client){
				portefeuilles.add(pc);
			}
		});
		
		return portefeuilles;
	}
}