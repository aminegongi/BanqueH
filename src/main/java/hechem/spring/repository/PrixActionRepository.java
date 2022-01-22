package hechem.spring.repository;

import org.springframework.data.repository.CrudRepository;

import hechem.spring.entity.Action;
import hechem.spring.entity.PrixAction;

//repository that extends CrudRepository  
public interface PrixActionRepository extends CrudRepository<PrixAction, Integer>  
{  
}  