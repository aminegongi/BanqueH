package hechem.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hechem.spring.entity.Action;
import hechem.spring.entity.PrixAction;
import hechem.spring.entity.PrixAction_utils;
import hechem.spring.service.ActionService;
import hechem.spring.service.PrixActionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/prixaction")
public class PrixActionController {

	@Autowired
	PrixActionService prixactionService;
	@Autowired
	ActionService actService;
	
	@GetMapping("/getAll")
	@ResponseBody
	private List<PrixAction> getAllActions() {
		
		return prixactionService.getAll();
	}

	@PostMapping("/add")
	@ResponseBody
	private PrixAction saveActions(@RequestBody PrixAction actions) {
		prixactionService.save(actions);
		return actions;
	}
	
	@PostMapping("/addPrix/{actionid}")
	@ResponseBody
	private PrixAction savePrixAction(@RequestBody PrixAction actions,@PathVariable("actionid") int actionId) {
		Action act = actService.getById(actionId);
		actions.setIdAction(act);
		prixactionService.save(actions);
		return actions;
	}

	@GetMapping("/get/{actionid}")
	@ResponseBody
	private List<PrixAction_utils> getListPrixAction(@PathVariable("actionid") int actionId) {
		return prixactionService.prixActions(actionId);
	}


}