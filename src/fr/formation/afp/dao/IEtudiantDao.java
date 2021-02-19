package fr.formation.afp.dao;

import java.util.List;

import fr.formation.afp.treetable.Etudiant;
import fr.formation.afp.EtudiantService.*;

public interface IEtudiantDao {
	
	public List<Etudiant> getAll();
	
	public String add(Etudiant e);
	
	public void update(Etudiant e);

	public Etudiant getEtudiantByid(long idEtudiant);

	public void delete(long idEtudiant);
}
