import java.util.ArrayList;

public class Reseau {
	
private ArrayList<Membre> ListeMembre; //liste des membre du reseau
private String nom;


	//constructeur
	public Reseau(String nom) {
		this.nom = nom;
		this.ListeMembre = new ArrayList<Membre>();
	}
	
	//get qui permet au autre calsse d'acceder a la liste des membre d'un reseau
	public ArrayList<Membre> getListeMembre() {
		return ListeMembre;
	}
	
	//ajout de nouveau memebre a un reseau
	public void ajoutMembre(Membre membre) {
		this.ListeMembre.add(membre);
	}
	
	//suppression de membre d'un reseau
	public void retraitMembre(Membre membre) {
		
		for (int i = 0; i < getListeMembre().size(); i++) {
			
			if(membre == getListeMembre().get(i)) {
				getListeMembre().remove(i);
			}
		}
	}
	
}