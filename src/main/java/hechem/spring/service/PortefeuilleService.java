package hechem.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hechem.spring.entity.Action;
import hechem.spring.entity.Portefeuille;
import hechem.spring.entity.PrixAction_utils;
import hechem.spring.entity.User;
import hechem.spring.repository.ActionRepository;
import hechem.spring.repository.PortefeuilleRepository;


@Service
public class PortefeuilleService {
	@Autowired
	PortefeuilleRepository portefeuilleRepository;
	@Autowired
	PrixActionService prixActionService;
	@Autowired
	ActionService actionService;
	

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
	
	public List<Portefeuille> detailActionPortfeuilleClient(int id_client, int id_action){
		List<Portefeuille> portefeuilles = new ArrayList<Portefeuille>();
		
		portefeuilleRepository.findAll().forEach(pc -> {
			if(pc.getActionUser().getId_user() == id_client && pc.getP_action().getId() == id_action){
				portefeuilles.add(pc);
			}
		});
		
		return portefeuilles;
	}
	
	public String achatVenteAction(int id_User, int id_action, String nombre, String type){
		User u = new User();
		u.setId_user(id_User);
		if(actionService.updateNombreAction(id_action, nombre, type)){
			Portefeuille p = new Portefeuille();
			p.setActionUser(u);
			p.setNombreAction(nombre);
			p.setP_action(actionService.getById(id_action));
			p.setPrixAction(prixActionService.lastPrixAction(id_action));
			p.setType(type);
			portefeuilleRepository.save(p);
			return type+" Action Success";
		}
		return type+" Action Error";
		
	}
	
	
}