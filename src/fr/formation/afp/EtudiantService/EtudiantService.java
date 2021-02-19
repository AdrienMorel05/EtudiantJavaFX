package fr.formation.afp.EtudiantService;

import java.util.List;

import fr.formation.afp.treetable.*;
import fr.formation.afp.EtudiantService.*;
import fr.formation.afp.dao.*;

public class EtudiantService implements IEtudiantService  {
	private IEtudiantDao dao = new EtudiantDaoFile();
	@Override
	public List<Etudiant> listEtudiant() {
		return dao.getAll();
	}

	@Override
	public String ajouterEtudiant(Etudiant e) {
		return dao.add(e);
	}

	@Override
	public void modifierEtudiant(Etudiant e) {
		dao.update(e)	;	
	}

	@Override
	public Etudiant chercherUnEtudiantParSonId(long idEtudiant) {
		return dao.getEtudiantByid(idEtudiant);
	}

	@Override
	public void supprimeUnEtudiant(long idEtudiant) {
		dao.delete(idEtudiant);		
	}

	
	

}
