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
@Table(name="Portefeuille")
public class Portefeuille {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	Action p_action;
	
	@ManyToOne
	User actionUser;
	
	@Column(name = "prixAction")
	private float prixAction;
	
	@Column(name = "nombreAction")
	private String nombreAction;
	
	@Column(name = "Type") //Achat ou Vente
	private String type;
	
	@Column(name = "dateAchat", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dateMarche;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Action getP_action() {
		return p_action;
	}


	public void setP_action(Action p_action) {
		this.p_action = p_action;
	}


	public User getActionUser() {
		return actionUser;
	}


	public void setActionUser(User actionUser) {
		this.actionUser = actionUser;
	}


	public float getPrixAction() {
		return prixAction;
	}


	public void setPrixAction(float prixAction) {
		this.prixAction = prixAction;
	}


	public String getNombreAction() {
		return nombreAction;
	}


	public void setNombreAction(String nombreAction) {
		this.nombreAction = nombreAction;
	}


	public Date getDateMarche() {
		return dateMarche;
	}


	public void setDateMarche(Date dateMarche) {
		this.dateMarche = dateMarche;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionUser == null) ? 0 : actionUser.hashCode());
		result = prime * result + ((dateMarche == null) ? 0 : dateMarche.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombreAction == null) ? 0 : nombreAction.hashCode());
		result = prime * result + ((p_action == null) ? 0 : p_action.hashCode());
		result = prime * result + Float.floatToIntBits(prixAction);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Portefeuille other = (Portefeuille) obj;
		if (actionUser == null) {
			if (other.actionUser != null)
				return false;
		} else if (!actionUser.equals(other.actionUser))
			return false;
		if (dateMarche == null) {
			if (other.dateMarche != null)
				return false;
		} else if (!dateMarche.equals(other.dateMarche))
			return false;
		if (id != other.id)
			return false;
		if (nombreAction == null) {
			if (other.nombreAction != null)
				return false;
		} else if (!nombreAction.equals(other.nombreAction))
			return false;
		if (p_action == null) {
			if (other.p_action != null)
				return false;
		} else if (!p_action.equals(other.p_action))
			return false;
		if (Float.floatToIntBits(prixAction) != Float.floatToIntBits(other.prixAction))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
	

	
}
