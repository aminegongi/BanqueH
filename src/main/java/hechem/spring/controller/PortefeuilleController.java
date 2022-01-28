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
import hechem.spring.entity.Portefeuille;
import hechem.spring.service.PortefeuilleService;

@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping("/get/{userid}")
	@ResponseBody
	private List<Portefeuille> getListPrixAction(@PathVariable("userid") int userid) {
		return portefeuilleService.portfeuilleClient(userid);
	}
	
	@GetMapping("/getAction/{userid}/{actionid}")
	@ResponseBody
	private List<Portefeuille> getListActionUser(@PathVariable("userid") int userid,@PathVariable("actionid") int actionid) {
		return portefeuilleService.detailActionPortfeuilleClient(userid, actionid);
	}
	
	@PostMapping("/optAction/{actionid}/{nombre}/{type}/{userid}")
	@ResponseBody
	private String optAction(@PathVariable("actionid") int actionId,@PathVariable("nombre") String nombre, @PathVariable("type") String type, @PathVariable("userid") int userid ){
		return portefeuilleService.achatVenteAction(userid, actionId, nombre, type);
	}
	
}