package hechem.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hechem.spring.entity.PrixAction;
import hechem.spring.entity.PrixAction_utils;
import hechem.spring.service.PrixActionService;


@RestController
@RequestMapping("/prixaction")
public class PrixActionController {

	@Autowired
	PrixActionService prixactionService;
	
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

	@GetMapping("/get/{actionid}")
	@ResponseBody
	private List<PrixAction_utils> getListPrixAction(@PathVariable("actionid") int actionId) {
		return prixactionService.prixActions(actionId);
	}


}