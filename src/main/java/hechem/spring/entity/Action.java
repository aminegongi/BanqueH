package hechem.spring.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Action")
public class Action {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_action")
	private int id;
	
	@Column(name = "nom")
	private String Nom;
	
	@Column(name = "prixEntree")
	private float prixEntree;
	
	@Column(name = "nombreAction")
	private String nombreAction;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "dateMarche", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
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


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public float getPrixEntree() {
		return prixEntree;
	}


	public void setPrixEntree(float prixEntree) {
		this.prixEntree = prixEntree;
	}


	public String getNombreAction() {
		return nombreAction;
	}


	public void setNombreAction(String nombreAction) {
		this.nombreAction = nombreAction;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result + ((Nom == null) ? 0 : Nom.hashCode());
		result = prime * result + ((dateMarche == null) ? 0 : dateMarche.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombreAction == null) ? 0 : nombreAction.hashCode());
		result = prime * result + Float.floatToIntBits(prixEntree);
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
		Action other = (Action) obj;
		if (Nom == null) {
			if (other.Nom != null)
				return false;
		} else if (!Nom.equals(other.Nom))
			return false;
		if (dateMarche == null) {
			if (other.dateMarche != null)
				return false;
		} else if (!dateMarche.equals(other.dateMarche))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (nombreAction == null) {
			if (other.nombreAction != null)
				return false;
		} else if (!nombreAction.equals(other.nombreAction))
			return false;
		if (Float.floatToIntBits(prixEntree) != Float.floatToIntBits(other.prixEntree))
			return false;
		return true;
	}

	
	


	
}
