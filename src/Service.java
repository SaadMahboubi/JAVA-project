
public class Service {
	
private String nom;
private int coutHoraire;
private Membre beneficiaire;

	public Service(String nom, int coutHoraire, Membre beneficiaire) {
		this.nom = nom;
		this.coutHoraire = coutHoraire;
		this.beneficiaire = beneficiaire;
	}
	
	//getter
	public int getCoutHoraire() {
		return this.coutHoraire;
	}
	
	public Membre getBeneficiare() {
		return this.beneficiaire;
	}
	
	public String getNom(){
		return this.nom;
	}
	

}