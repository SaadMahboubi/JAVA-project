import java.util.ArrayList;

public class Tache {
	
private boolean estBenevole;
private Service service; // la tache qui repond au service
private int nbPersonne;  // personne requise pour cette tache
private int duree;       // temps afin deffecteur cette tache
	

	//constructeur
	public Tache(boolean estBenevole, int nbPersonne, int duree, Service service) {
		
		this.estBenevole = estBenevole;
		this.nbPersonne = nbPersonne;
		this.service = service;
		this.duree = duree;
		
	}
	
	//methode permettant de calculer le prix d'une tache
	public double getPrixTache() {
		double prixTache;
		
			if(estBenevole || service.getBeneficiare().getClasse() == ClasseSociale.ZERO ){
				prixTache = 0;
			}else if(service.getBeneficiare().getClasse() == ClasseSociale.DEMIE ) {
				prixTache = (service.getCoutHoraire() * duree * getNbPersonne()) / 2;
			}else {
				prixTache = service.getCoutHoraire() * duree * getNbPersonne();
			} 
			
		return prixTache;
	}
	
	
	public int getDuree() {
		return duree;
	}
	
	public int getNbPersonne() {
		return this.nbPersonne;
	}
	
	//verifie si un membre possede cette competence (service) dans la liste de ses services
	public boolean tacheFaisable(Membre Acteur) {  
		return Acteur.possedeUnService(this.service);
	}

				

}
