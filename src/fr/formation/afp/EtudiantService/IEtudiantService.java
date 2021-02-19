package fr.formation.afp.EtudiantService;

import java.util.List;

import fr.formation.afp.treetable.*;

public interface IEtudiantService {

	public List<Etudiant> listEtudiant();

	public String ajouterEtudiant(Etudiant e);

	public void modifierEtudiant(Etudiant e);
	
	public Etudiant chercherUnEtudiantParSonId(long idEtudiant);

	public void supprimeUnEtudiant(long idEtudiant);
}
