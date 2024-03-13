package histoire;

import villagegaulois.Etal;
import villagegaulois.Etal.EtalNonOccupeException;
import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Village.VillageSansChefException;

public class ScenarioCasDegrade {
    public static void main(String[] args) {
        Etal etal = new Etal();
        try {
            // Tester avec un acheteur null
            etal.acheterProduit(5, null);
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }

        try {
            // Tester avec une quantit� n�gative
            etal.acheterProduit(-2, new Gaulois("Ast�rix", 30));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }

        try {
            // Tester avec un �tal non occup�
            etal.acheterProduit(5, new Gaulois("Ob�lix", 35));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }
        
        try {
            Village village = new Village("le village des irr�ductibles", 10, 0);
            System.out.println(village.afficherVillageois());
        } catch (VillageSansChefException e) {
            System.err.println("VillageSansChefException: " + e.getMessage());
            // G�rer l'exception ici (par exemple, afficher un message appropri� ou effectuer d'autres actions)
        }
    }
}


