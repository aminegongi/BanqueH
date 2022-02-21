package hechem.spring.repository;

import org.springframework.data.repository.CrudRepository;

import hechem.spring.entity.Action;
import hechem.spring.entity.Portefeuille;
import hechem.spring.entity.Portefeuille_Obligation;

//repository that extends CrudRepository  
public interface PortefeuilleObligationRepository extends CrudRepository<Portefeuille_Obligation, Integer>  
{  
}  