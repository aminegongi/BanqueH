package hechem.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hechem.spring.entity.Portefeuille;
import hechem.spring.service.PortefeuilleService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/portefeuille")
public class PortefeuilleController {

	@Autowired
	PortefeuilleService portefeuilleService;
	
	@GetMapping("/getAll")
	@ResponseBody
	private List<Portefeuille> getAllPortefeuilles() {
		
		return portefeuilleService.getAll();
	}

	@PostMapping("/add")
	@ResponseBody
	private Portefeuille saveActions(@RequestBody Portefeuille portefeuilles) {
		portefeuilleService.save(portefeuilles);
		return portefeuilles;
	}


}