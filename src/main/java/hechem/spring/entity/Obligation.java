package hechem.spring.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Obligation")
public class Obligation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_obligation")
	private int id;
	
	@Column(name = "nom")
	private String Nom;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "valeur_nominale")
	private float valeur_nominale;
	
	@Column(name = "taux_c")
	private float taux_c;
	
	@Column(name = "taux_r")
	private float taux_r;
	
	@Column(name = "nombreAnnee")
	private String nombreAnnee;
	
	@Column(name = "nombreObligation")
	private String nombreObligation;
	
	@Column(name = "dateAjout", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dateAjout;
	
	
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getValeur_nominale() {
		return valeur_nominale;
	}


	public void setValeur_nominale(float valeur_nominale) {
		this.valeur_nominale = valeur_nominale;
	}


	public float getTaux_c() {
		return taux_c;
	}


	public void setTaux_c(float taux_c) {
		this.taux_c = taux_c;
	}


	public float getTaux_r() {
		return taux_r;
	}


	public void setTaux_r(float taux_r) {
		this.taux_r = taux_r;
	}


	public String getNombreAnnee() {
		return nombreAnnee;
	}


	public void setNombreAnnee(String nombreAnnee) {
		this.nombreAnnee = nombreAnnee;
	}


	public String getNombreObligation() {
		return nombreObligation;
	}


	public void setNombreObligation(String nombreObligation) {
		this.nombreObligation = nombreObligation;
	}


	public Date getDateAjout() {
		return dateAjout;
	}


	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nom == null) ? 0 : Nom.hashCode());
		result = prime * result + ((dateAjout == null) ? 0 : dateAjout.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombreAnnee == null) ? 0 : nombreAnnee.hashCode());
		result = prime * result + ((nombreObligation == null) ? 0 : nombreObligation.hashCode());
		result = prime * result + Float.floatToIntBits(taux_c);
		result = prime * result + Float.floatToIntBits(taux_r);
		result = prime * result + Float.floatToIntBits(valeur_nominale);
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
		Obligation other = (Obligation) obj;
		if (Nom == null) {
			if (other.Nom != null)
				return false;
		} else if (!Nom.equals(other.Nom))
			return false;
		if (dateAjout == null) {
			if (other.dateAjout != null)
				return false;
		} else if (!dateAjout.equals(other.dateAjout))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (nombreAnnee == null) {
			if (other.nombreAnnee != null)
				return false;
		} else if (!nombreAnnee.equals(other.nombreAnnee))
			return false;
		if (nombreObligation == null) {
			if (other.nombreObligation != null)
				return false;
		} else if (!nombreObligation.equals(other.nombreObligation))
			return false;
		if (Float.floatToIntBits(taux_c) != Float.floatToIntBits(other.taux_c))
			return false;
		if (Float.floatToIntBits(taux_r) != Float.floatToIntBits(other.taux_r))
			return false;
		if (Float.floatToIntBits(valeur_nominale) != Float.floatToIntBits(other.valeur_nominale))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Obligation [id=" + id + ", Nom=" + Nom + ", description=" + description + ", valeur_nominale="
				+ valeur_nominale + ", taux_c=" + taux_c + ", taux_r=" + taux_r + ", nombreAnnee=" + nombreAnnee
				+ ", nombreObligation=" + nombreObligation + ", dateAjout=" + dateAjout + "]";
	}

	

	
}
