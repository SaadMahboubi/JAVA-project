import java.util.ArrayList;

public class Membre {

private String nom;
private int solde;
private ArrayList<Service> ListeService;
private ClasseSociale classe;

	public Membre(String nom, int solde, ClasseSociale classe) {
		this.nom = nom;
		this.solde = solde;
		this.ListeService = new ArrayList<Service>();
		this.classe = classe;
	}
	
	String getNomMembre() {
		return this.nom;
	}
	
	int getArgent() {
		return this.solde;
	}
	
	ClasseSociale getClasse() {
		return this.classe;
	}
	
	//ces 2 methode ajoute ou diminue le solde que possède une personne selon ses actions 
	public void augmenterArgent(double somme){
		this.solde += somme;
	}
	
	public void diminuerArgent(double somme) {
		this.solde -= somme;
	}
	
	//ajout d'une nouvelle compétence à une personne
	public void ajoutComptence(Service service) {
		this.ListeService.add(service);
	}
	
	//Vérifie si une personne possède ce service(tâche) qui lui permettra d'être un acteur dans la classe Tâche
	public boolean possedeUnService(Service service) {
			for(int i = 0 ;  i < this.ListeService.size() ; i++) {
				if(this.ListeService.get(i) == service){
					return true;
				}
			}
			return false;
	}
	
	

}
