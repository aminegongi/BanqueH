package hechem.spring.repository;

import org.springframework.data.repository.CrudRepository;

import hechem.spring.entity.Action;

//repository that extends CrudRepository  
public interface ActionRepository extends CrudRepository<Action, Integer>  
{  
}  