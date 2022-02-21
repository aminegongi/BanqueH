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
@Table(name="Portefeuille_Obligation")
public class Portefeuille_Obligation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	Obligation obligation;
	
	@ManyToOne
	User actionUser;
	
	@Column(name = "prixObligation")
	private float prixObligation;
	
	@Column(name = "nombreObligation")
	private String nombreObligation;
	
	
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


	public Obligation getObligation() {
		return obligation;
	}


	public void setObligation(Obligation obligation) {
		this.obligation = obligation;
	}


	public User getActionUser() {
		return actionUser;
	}


	public void setActionUser(User actionUser) {
		this.actionUser = actionUser;
	}


	public float getPrixObligation() {
		return prixObligation;
	}


	public void setPrixObligation(float prixAction) {
		this.prixObligation = prixAction;
	}


	@Override
	public String toString() {
		return "Portefeuille_Obligation [id=" + id + ", obligation=" + obligation + ", actionUser=" + actionUser
				+ ", prixObligation=" + prixObligation + ", nombreObligation=" + nombreObligation + ", dateMarche=" + dateMarche
				+ "]";
	}


	public String getNombreObligation() {
		return nombreObligation;
	}


	public void setNombreObligation(String nombreObligation) {
		this.nombreObligation = nombreObligation;
	}


	public Date getDateMarche() {
		return dateMarche;
	}
	
	


	public void setDateMarche(Date dateMarche) {
		this.dateMarche = dateMarche;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionUser == null) ? 0 : actionUser.hashCode());
		result = prime * result + ((dateMarche == null) ? 0 : dateMarche.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombreObligation == null) ? 0 : nombreObligation.hashCode());
		result = prime * result + ((obligation == null) ? 0 : obligation.hashCode());
		result = prime * result + Float.floatToIntBits(prixObligation);
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
		Portefeuille_Obligation other = (Portefeuille_Obligation) obj;
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
		if (nombreObligation == null) {
			if (other.nombreObligation != null)
				return false;
		} else if (!nombreObligation.equals(other.nombreObligation))
			return false;
		if (obligation == null) {
			if (other.obligation != null)
				return false;
		} else if (!obligation.equals(other.obligation))
			return false;
		if (Float.floatToIntBits(prixObligation) != Float.floatToIntBits(other.prixObligation))
			return false;
		return true;
	}

	
	
}
