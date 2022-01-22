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
}