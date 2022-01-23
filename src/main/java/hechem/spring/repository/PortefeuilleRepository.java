package hechem.spring.repository;

import org.springframework.data.repository.CrudRepository;

import hechem.spring.entity.Action;
import hechem.spring.entity.Portefeuille;

//repository that extends CrudRepository  
public interface PortefeuilleRepository extends CrudRepository<Portefeuille, Integer>  
{  
}  