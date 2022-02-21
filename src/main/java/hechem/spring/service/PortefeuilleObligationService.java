package hechem.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hechem.spring.entity.Action;
import hechem.spring.entity.Obligation;
import hechem.spring.entity.Portefeuille;
import hechem.spring.entity.Portefeuille_Obligation;
import hechem.spring.entity.PrixAction_utils;
import hechem.spring.entity.User;
import hechem.spring.repository.ActionRepository;
import hechem.spring.repository.PortefeuilleObligationRepository;
import hechem.spring.repository.PortefeuilleRepository;


@Service
public class PortefeuilleObligationService {
	@Autowired
	PortefeuilleObligationRepository portefeuilleRepository;
	@Autowired
	ObligationService obligationService;
	

	public List<Portefeuille_Obligation> getAll() {
		List<Portefeuille_Obligation> p_obligations = new ArrayList<Portefeuille_Obligation>();
		portefeuilleRepository.findAll().forEach(obl -> p_obligations.add(obl));
		return p_obligations;
	}

	public void save(Portefeuille_Obligation p_obl) {
		portefeuilleRepository.save(p_obl);
	}

	public void update(Portefeuille_Obligation p_obl) {
		portefeuilleRepository.save(p_obl);
	}

	public void delete(int id) {
		portefeuilleRepository.deleteById(id);
	}
	
	public List<Portefeuille_Obligation> portfeuilleClient(int id_client) {
		List<Portefeuille_Obligation> p_obligations = new ArrayList<Portefeuille_Obligation>();
		portefeuilleRepository.findAll().forEach(pc -> {
			if(pc.getActionUser().getId_user() == id_client){
				p_obligations.add(pc);
			}
		});
		return p_obligations;
	}
	
	
	public String achatVenteObligation(int id_User, int id_obligation, String nombre){
		User u = new User();
		u.setId_user(id_User);
		if(obligationService.updateNombreObligation(id_obligation, nombre)){
			Portefeuille_Obligation p = new Portefeuille_Obligation();
			p.setActionUser(u);
			p.setNombreObligation(nombre);
			portefeuilleRepository.save(p);
			return " Action Success";
		}
		return " Action Error";
	}
	
	
}