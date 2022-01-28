package hechem.spring.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hechem.spring.entity.Action;
import hechem.spring.entity.PrixAction;

//repository that extends CrudRepository  
public interface PrixActionRepository extends CrudRepository<PrixAction, Integer>  
{  
	@Query(value = " SELECT prix_action.prix_act FROM prix_action WHERE prix_action.id_action_id_action = ?1 ORDER By `date_changement` DESC LIMIT 1 ", nativeQuery = true)
	public float getLastPriceAction(int id_action);
}  