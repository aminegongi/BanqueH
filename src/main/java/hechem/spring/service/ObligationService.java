package hechem.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hechem.spring.entity.Action;
import hechem.spring.entity.Obligation;
import hechem.spring.repository.ObligationRepository;


@Service
public class ObligationService {
	@Autowired
	ObligationRepository obligationRepo;
	
	
	public List<Obligation> getAll() {
		List<Obligation> obligations = new ArrayList<Obligation>();
		obligationRepo.findAll().forEach(act -> obligations.add(act));
		return obligations;
	}

	public Obligation getById(int id) {
		return obligationRepo.findById(id).get();
	}

	public void save(Obligation obligations) {
		obligationRepo.save(obligations);
	}

	public void update(Obligation obligations) {
		obligationRepo.save(obligations);
	}

	public void delete(int id) {
		obligationRepo.deleteById(id);
	}
	
	public boolean checkNbObligation(int id_obligation, String nombre){ // False Nombre insuffisant | True Nombre suffisant
		if ( Integer.valueOf(getById(id_obligation).getNombreObligation()) >= Integer.valueOf(nombre)){
			return true;
		}
		return false;
	}
	
	public boolean updateNombreObligation(int id_obligation, String nombre, String type){ // False transaction impossible | True transaction OK
		if(checkNbObligation(id_obligation, nombre)){
			Obligation act = getById(id_obligation);
			int nn = 0;
			nn = Integer.valueOf(act.getNombreObligation()) - Integer.valueOf(nombre) ;
			act.setNombreObligation( Integer.toString(nn) );
			update(act);
			return true;
		}
		return false;
	}
	
	
}