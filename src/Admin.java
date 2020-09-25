import java.util.ArrayList;

public class Admin extends Membre{
private String nom;
private Reseau reseau;
	
	//constructeur
	public Admin(String nom,int solde) { 
		super(nom,solde, ClasseSociale.NORMALE);
		this.nom = nom;
	}
	
	public Reseau getReseau() {
		return reseau;
	}
	//methode permettant la création de Reseau par l'admin
	public void creerReseau(String nom) {
		this.reseau = new Reseau(nom);
			
	}
	
	//creation et ajout de nouveau membre au Reseau par l'admin
	public Membre creerMembre(String nom,int solde, ClasseSociale classe) {
		Membre membre = new Membre(nom, solde, classe);
		this.reseau.ajoutMembre(membre);
		return membre;
	}
	
	//ajout de compétence par l'admin au membre de son reseau
	public void ajoutCompetence(Membre membre, Service service) {
		membre.ajoutComptence(service);
	}
	
	//creation de la liste des membre qui possedent les competence nécessaire et retourne la liste
	public ArrayList<Membre> getlisteActeur(Tache tache) {
		ArrayList<Membre> ListeActeur = new ArrayList<Membre>();
		
		for(int i = 0; i < this.reseau.getListeMembre().size(); i++){
			
			if(tache.tacheFaisable(this.reseau.getListeMembre().get(i))) {
				ListeActeur.add(this.reseau.getListeMembre().get(i));
			}
				
		}
		
	return ListeActeur;
	
	}
	
	//retourne si oui ou non il y a assez de personne pour effectuer la tache
	public boolean tacheEffectuer(Tache tache) {
		return getlisteActeur(tache).size() == tache.getNbPersonne();
	}
	
	 
	


}









