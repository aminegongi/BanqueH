package hechem.spring.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



public class PortefeuilleClient_utils {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Action> p_action;

	User actionUser;

	public List<Action> getP_action() {
		return p_action;
	}

	public void setP_action(List<Action> p_action) {
		this.p_action = p_action;
	}

	public User getActionUser() {
		return actionUser;
	}

	public void setActionUser(User actionUser) {
		this.actionUser = actionUser;
	}
	
	
}
