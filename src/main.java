import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner ;
public class main {
	
	public static void main(String[] args){
		
		//Voici un enchainement d'instruction sans aucune interation avec l'utilisateur
		System.out.println("SCENARIO N1 :");
		System.out.println("");
		Admin lea = new Admin("lea", 10);
		lea.creerReseau("echange");
		
		Membre sarah = new Membre("Sarah", 20, ClasseSociale.NORMALE);
		
		Membre maxime = lea.creerMembre("maxime", 10, ClasseSociale.ZERO);
		Membre charly = lea.creerMembre("charly", 10, ClasseSociale.DEMIE);
		Membre theo = lea.creerMembre("theo", 10, ClasseSociale.DEMIE);

		Service jardinage1 = new Service("jardinage", 3, sarah);
		Tache jardiner1 = new Tache(false,3,2,jardinage1);
		
		lea.ajoutCompetence(maxime,jardinage1);
		lea.ajoutCompetence(charly,jardinage1);
		lea.ajoutCompetence(theo,jardinage1);
		
			if(lea.tacheEffectuer(jardiner1)){
				System.out.println("Lea l'administratrice du Reseau \"echange\" va donc attribuer la tache de jardiner à maxime et charly a la demande de sarah");
				sarah.diminuerArgent(jardiner1.getPrixTache());
				for(int m = 0; m < lea.getReseau().getListeMembre().size(); m++) {
					lea.getReseau().getListeMembre().get(m).augmenterArgent(jardiner1.getPrixTache() / lea.getReseau().getListeMembre().size());
					System.out.println("Le solde final de " + lea.getReseau().getListeMembre().get(m).getNomMembre() + " est de : " + lea.getReseau().getListeMembre().get(m).getArgent());
				}
				sarah.diminuerArgent(jardiner1.getPrixTache());
				System.out.println("la tache jardiner a donc été effectuer par maxime et charly pour sarah");
			}
		
		System.out.println("");
		
		
		//Voici un enchainement d'instruction ou il y a des interations avec l'utilisateur
		System.out.println("SCENARIO N2 :");
		System.out.println("");

		int n;
		String nomAdmin, nomReseau;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bonjour vueillez entrez votre nom afin de pouvoir ensuite créer votre propre reseau");
		nomAdmin = sc.nextLine();
		
		
		Admin admin = new Admin(nomAdmin, 10);
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Bonjour Mr/Mme " + nomAdmin + " entrez le nom du reseau que vous voulez créer");
		nomReseau = sc2.nextLine();
		
		admin.creerReseau(nomReseau);
		
		
		
		//ces 3 demandeurs sont crée par le programme, l'administrateur va donc gérer la création de ses membres et l'attribution de leurs rôles afin de répondre a leurs demandes
		Membre philippe = new Membre("Philippe", 30, ClasseSociale.NORMALE);
		Membre mehdi = new Membre("Mehdi", 15, ClasseSociale.DEMIE);
		Membre alexandre = new Membre("Alexandre", 5, ClasseSociale.ZERO);
		
		System.out.println("il y a 3 personne qui aimeraient beneficier de vos service : " + philippe.getNomMembre() + ", " + mehdi.getNomMembre() + " et " + alexandre.getNomMembre());
		

		Service coursDeMath = new Service("enseigner", 2, philippe);
		Tache coursMath = new Tache(false,1,2,coursDeMath);
		
		
		Service jardinage = new Service("jardinage", 3, mehdi);
		Tache jardiner = new Tache(true,2,1,jardinage);
		
		
		Service babysitter = new Service("garde d'enfant", 5, alexandre);
		Tache gardeEnfant = new Tache(false,1,4,babysitter);		
		
		
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Veuillez entrez le nombre de membre que vous voulez créer et ajouter a votre reseau :");
		n = sc3.nextInt();
		
		//cration de tout les nouveaux membres appartenant au reseau
		for(int i = 0 ; i < n ;i++) {
			String nomNouvMembre, nomClasse;
			int s, nbCompetence;
			ClasseSociale classe;
			
			Scanner sc4 = new Scanner(System.in);
			System.out.println("Entrez le nom de votre nouveau membre,");
			nomNouvMembre = sc4.nextLine();
			
			Scanner sc5 = new Scanner(System.in);
			System.out.println("son solde initiale,");
			s = sc5.nextInt();
			
			Scanner sc6 = new Scanner(System.in);
			System.out.println("sa Classe sociale (zero, demie ou normale)");
			nomClasse = sc6.nextLine();
			
			if(nomClasse.equals("zero")){
				classe = ClasseSociale.ZERO;
			}else if(nomClasse.equals("demi")){
				classe = ClasseSociale.DEMIE;
			}else{
				classe = ClasseSociale.NORMALE;
			}
			Membre membre = admin.creerMembre(nomNouvMembre, s, classe);
			
			Scanner sc7 = new Scanner(System.in);
			System.out.println("Enfin entrez le nombre de compétence que possede ce Membre on les énumère ensuite :");
			nbCompetence = sc7.nextInt();
			
			for(int j = 0 ; j < nbCompetence ; j++) {
				String nomCompetence;
				
				//precondition il existe que 3 services et 3 taches dans cet exemple 
				Scanner sc8 = new Scanner(System.in);
				System.out.println("Entrez le nom de la compétence que possède ce membre (jardinage, enseigner, babysitter)");
				nomCompetence = sc8.nextLine();
				
				if(nomCompetence.equals(jardinage.getNom())) {
					admin.ajoutCompetence(membre,jardinage);
					
				}else if(nomCompetence.equals(coursDeMath.getNom())){
					admin.ajoutCompetence(membre,coursDeMath);
					
				}else {
					admin.ajoutCompetence(membre,babysitter);
				}	
			}
	
		}
		

		
		if(admin.tacheEffectuer(jardiner)){
			System.out.println(nomAdmin + " l'administrateur du Rseau " + nomReseau + " va donc attribuer la tache de jardiner  des membres de reseau");
			double sommePayer = jardiner.getPrixTache() / 2;
			
			mehdi.diminuerArgent(sommePayer);
			
			
			for(int i = 0; i < admin.getlisteActeur(jardiner).size(); i++) {
				admin.getlisteActeur(jardiner).get(i).augmenterArgent(jardiner1.getPrixTache() / admin.getlisteActeur(jardiner).size());
				System.out.println("Le solde final de " + admin.getlisteActeur(jardiner).get(i).getNomMembre() + " est de : " + admin.getlisteActeur(jardiner).get(i).getArgent());
			}
			
			System.out.println("la tache jardiner a donc t effectuer par le ou les membre du reseau " + nomReseau + ", pour mehdi");
			System.out.println("solde de Mehdi : " + mehdi.getArgent());
			
		}
		
		System.out.println("");
			
		if(admin.tacheEffectuer(coursMath)){
			System.out.println(nomAdmin + " l'administrateur du Rseau " + nomReseau + " va donc attribuer la tache de donner des cours de math  des membres de son reseau");
			double sommePayer = coursMath.getPrixTache();
			
			philippe.diminuerArgent(sommePayer);
			
			for(int i = 0; i < admin.getlisteActeur(coursMath).size(); i++) {
				admin.getlisteActeur(coursMath).get(i).augmenterArgent(coursMath.getPrixTache() / admin.getlisteActeur(coursMath).size());
				System.out.println("Le solde final de " + admin.getlisteActeur(coursMath).get(i).getNomMembre() + " est de : " + admin.getlisteActeur(coursMath).get(i).getArgent());
			}
			
			System.out.println("la tache ou faudra donner des cours de math a donc t effectuer par le ou les membre du reseau " + nomReseau + ", pour Philippe");
			System.out.println("solde de Philippe : " + philippe.getArgent());
		}
		
		System.out.println("");
			
		if(admin.tacheEffectuer(gardeEnfant)){
			System.out.println(nomAdmin + " l'administrateur du Rseau " + nomReseau + " va donc attribuer la tache de garder d'enfants  des membres de son reseau");
			double sommePayer = gardeEnfant.getPrixTache() * 0;
			
			philippe.diminuerArgent(sommePayer);
			
			for(int i = 0; i < admin.getlisteActeur(gardeEnfant).size(); i++) {
				admin.getlisteActeur(gardeEnfant).get(i).augmenterArgent(gardeEnfant.getPrixTache() / admin.getlisteActeur(gardeEnfant).size());
				System.out.println("Le solde final de " + admin.getlisteActeur(gardeEnfant).get(i).getNomMembre() + " est de : " + admin.getlisteActeur(gardeEnfant).get(i).getArgent());
			}
			
			System.out.println("la tache ou faudra garder des enfants a donc t effectuer par le ou les membre du reseau " + nomReseau + ", pour Alexandre");
			System.out.println("solde de Alexandre : " + alexandre.getArgent());
		}

		
		
	}
		
		
	
	
}
