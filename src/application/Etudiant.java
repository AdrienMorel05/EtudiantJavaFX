package application;

import java.io.Serializable;

public class Etudiant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEtudiant;
	private static int id = 0;
	private String nom;
	private String prenom;
	private String naissance;
	{
		id++;
	}

	public Etudiant() {
		this.id = id;
	}

	public Etudiant(String nom, String prénom, String naissance) {
		this.nom = nom;
		this.prenom = prénom;
		this.naissance = naissance;
	}

	public Etudiant(int id, String nom, String prénom, String naissance) {
		this.idEtudiant = id;
		this.nom = nom;
		this.prenom = prénom;
		this.naissance = naissance;
	}

	public int getid() {
		return id;
	}

	public void setID(int l) {
		this.idEtudiant = l;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prénom) {
		this.prenom = prénom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nom=" + nom + ", prénom=" + prenom + ", naissance=" + naissance
				+ "]";
	}

}
