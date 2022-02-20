package hechem.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hechem.spring.entity.Action;
import hechem.spring.repository.ActionRepository;


@Service
public class ActionService {
	@Autowired
	ActionRepository actionRepository;

	public List<Action> getAll() {
		List<Action> actions = new ArrayList<Action>();
		actionRepository.findAll().forEach(act -> actions.add(act));
		return actions;
	}

	public Action getById(int id) {
		return actionRepository.findById(id).get();
	}

	public void save(Action actions) {
		actionRepository.save(actions);
	}

	public void update(Action actions) {
		actionRepository.save(actions);
	}

	public void delete(int id) {
		actionRepository.deleteById(id);
	}
	
	public boolean checkNbAction(int id_action, String nombre){ // False Nombre insuffisant | True Nombre suffisant
		if ( Integer.valueOf(getById(id_action).getNombreAction()) >= Integer.valueOf(nombre)){
			return true;
		}
		return false;
	}
	
	public boolean updateNombreAction(int id_action, String nombre, String type){ // False transaction impossible | True transaction OK
		if(checkNbAction(id_action, nombre)){
			Action act = getById(id_action);
			int nn = 0;
			if(type.toLowerCase() == "achat"){
				nn = Integer.valueOf(act.getNombreAction()) - Integer.valueOf(nombre) ;
			}
			else if(type.toLowerCase() == "vente"){
				nn = Integer.valueOf(act.getNombreAction()) + Integer.valueOf(nombre) ;
			}
			act.setNombreAction( Integer.toString(nn) );
			update(act);
			return true;
		}
		return false;
	}
	
	
}