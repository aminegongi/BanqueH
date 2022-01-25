package hechem.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hechem.spring.entity.Action;
import hechem.spring.service.ActionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/action")
public class ActionController {

	@Autowired
	ActionService actionService;
	
	@GetMapping("/getAll")
	@ResponseBody
	private List<Action> getAllActions() {
		
		return actionService.getAll();
	}

	@PostMapping("/add")
	@ResponseBody
	private Action saveActions(@RequestBody Action actions) {
		actionService.save(actions);
		return actions;
	}

	@GetMapping("/get/{actionid}")
	@ResponseBody
	private Action getAction(@PathVariable("actionid") int actionId) {
		return actionService.getById(actionId);
	}

	@DeleteMapping("/delete/{actionid}")
	@ResponseBody
	private void deleteAction(@PathVariable("actionid") int actionId) {
		actionService.delete(actionId);
	}

	@PutMapping("/edit")
	@ResponseBody
	private Action updateAction(@RequestBody Action action) {
		actionService.update(action);
		return action;
	}

}