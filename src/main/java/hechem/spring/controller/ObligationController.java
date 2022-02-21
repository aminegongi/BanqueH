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

import hechem.spring.entity.Obligation;
import hechem.spring.service.ObligationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/obligation")
public class ObligationController {

	@Autowired
	ObligationService obligationService;
	
	@GetMapping("/getAll")
	@ResponseBody
	private List<Obligation> getAllObligations() {
		
		return obligationService.getAll();
	}

	@PostMapping("/add")
	@ResponseBody
	private Obligation saveObligations(@RequestBody Obligation obligations) {
		obligationService.save(obligations);
		return obligations;
	}

	@GetMapping("/get/{obligationid}")
	@ResponseBody
	private Obligation getObligation(@PathVariable("obligationid") int obligationId) {
		return obligationService.getById(obligationId);
	}

	@DeleteMapping("/delete/{obligationid}")
	@ResponseBody
	private void deleteObligation(@PathVariable("obligationid") int obligationId) {
		obligationService.delete(obligationId);
	}

	@PutMapping("/edit")
	@ResponseBody
	private Obligation updateObligation(@RequestBody Obligation obligation) {
		obligationService.update(obligation);
		return obligation;
	}
	
	@PutMapping("/updateNombreObligation/{obligationid}/{nombre}")
	@ResponseBody
	private boolean updateNombreObligation(@PathVariable("obligationid") int obligationId,@PathVariable("nombre") String nombre) {
		return obligationService.updateNombreObligation(obligationId, nombre);
	}

}