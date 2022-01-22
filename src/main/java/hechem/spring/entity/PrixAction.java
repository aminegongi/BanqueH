package hechem.spring.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PrixAction")
public class PrixAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@ManyToOne
	Action idAction;
	
	@Column(name = "prixAct")
	private float prixAct;

	@Column(name = "dateChangement", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dateChangement;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Action getIdAction() {
		return idAction;
	}


	public void setIdAction(Action idAction) {
		this.idAction = idAction;
	}


	public float getPrixAct() {
		return prixAct;
	}


	public void setPrixAct(float prixAct) {
		this.prixAct = prixAct;
	}


	public Date getDateChangement() {
		return dateChangement;
	}


	public void setDateChangement(Date dateChangement) {
		this.dateChangement = dateChangement;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateChangement == null) ? 0 : dateChangement.hashCode());
		result = prime * result + id;
		result = prime * result + ((idAction == null) ? 0 : idAction.hashCode());
		result = prime * result + Float.floatToIntBits(prixAct);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrixAction other = (PrixAction) obj;
		if (dateChangement == null) {
			if (other.dateChangement != null)
				return false;
		} else if (!dateChangement.equals(other.dateChangement))
			return false;
		if (id != other.id)
			return false;
		if (idAction == null) {
			if (other.idAction != null)
				return false;
		} else if (!idAction.equals(other.idAction))
			return false;
		if (Float.floatToIntBits(prixAct) != Float.floatToIntBits(other.prixAct))
			return false;
		return true;
	}
	
	
	
}
