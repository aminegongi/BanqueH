package hechem.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hechem.spring.entity.Action;
import hechem.spring.entity.PrixAction;
import hechem.spring.entity.PrixAction_utils;
import hechem.spring.repository.ActionRepository;
import hechem.spring.repository.PrixActionRepository;


@Service
public class PrixActionService {
	@Autowired
	PrixActionRepository prixactionRepository;

	public List<PrixAction> getAll() {
		List<PrixAction> prixActions = new ArrayList<PrixAction>();
		prixactionRepository.findAll().forEach(pact -> prixActions.add(pact));
		return prixActions;
	}

	public PrixAction getById(int id) {
		return prixactionRepository.findById(id).get();
	}

	public void save(PrixAction actions) {
		prixactionRepository.save(actions);
	}
	
	//Affichage de l'historique des prix d'une action par son ID
	public List<PrixAction_utils> prixActions(int idAction) {
		List<PrixAction_utils> tabpact = new ArrayList<PrixAction_utils>();
		
		prixactionRepository.findAll().forEach(pact -> {
	        if(pact.getIdAction().getId() == idAction ) {
	        	PrixAction_utils pacu= new PrixAction_utils();
	        	pacu.setPrixAct(pact.getPrixAct());
	        	pacu.setDateChangement(pact.getDateChangement());
	        	tabpact.add(pacu);
	          }
	      });
		
		return tabpact;
	}
	
	public float lastPrixAction ( int id_action ){
		return prixactionRepository.getLastPriceAction(id_action);
	}

}