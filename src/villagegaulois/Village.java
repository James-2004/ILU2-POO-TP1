package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;
	
	public Village(String nom, int nbVillageoisMaximum, int nombreDetals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		this.marche = new Marche(nombreDetals);
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	public class  Marche{
		private Etal[] etals;
		
		public Marche(int nombreDetals) {
			etals = new Etal[nombreDetals];
			for (int i = 0;i < etals.length;i++) {
				etals[i] = new Etal();
			}
		}
		
		public void utiliserEtal(int indiceEtal,Gaulois vendeur,String produit,int nbProduit) {
			if (!etals[indiceEtal].isEtalOccupe()) {
				etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
			} else {
				System.out.println("L'etal "+ indiceEtal+ "est deja occupe par "+ etals[indiceEtal].getVendeur().getNom()+ ".");
			}	
		}
		
		public int trouverEtalLibre() {
			for (int i = 0;i < etals.length;i++) {
				if (!etals[i].isEtalOccupe()) {
					return i;
				}
			}
			return -1;
		}
		
		public Etal[] trouverEtals(String produit) {
			Etal[] etalsTrouves = new Etal[nbVillageois];
			int compteur = 0;
			for (int i = 0;i < etals.length;i++) {
				if (etals[i].contientProduit(produit)) {
					etalsTrouves[compteur] = etals[i];
					compteur+=1;
				}
			}
			Etal[] result = new Etal[compteur];
			for (int i = 0;i < compteur;i++) {
				result[i] = etalsTrouves[i];
			}
			return result;
		}

		public Etal trouverVendeur(Gaulois gaulois) {
			for (int i = 0;i < etals.length;i++) {
				if (etals[i].getVendeur() != null && etals[i].getVendeur().equals(gaulois)) {
					return etals[i];
				}
			}
			return null;
		}
		
		public String afficherMarche() {
			StringBuilder result = new StringBuilder();
			int libre = 0;
			for (Etal etal : etals) {
				result.append(etal.afficherEtal()).append("\n");
				if (!etal.isEtalOccupe()) {
					libre+=1;
				}
			}
			result.append("Il reste").append(libre).append("étals non utilisés dans le marché.\n");
			return result.toString();
		}
	}
}
		