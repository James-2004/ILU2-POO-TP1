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
            // Tester avec une quantité négative
            etal.acheterProduit(-2, new Gaulois("Astérix", 30));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }

        try {
            // Tester avec un étal non occupé
            etal.acheterProduit(5, new Gaulois("Obélix", 35));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }
        
        try {
            Village village = new Village("le village des irréductibles", 10, 0);
            System.out.println(village.afficherVillageois());
        } catch (VillageSansChefException e) {
            System.err.println("VillageSansChefException: " + e.getMessage());
            // Gérer l'exception ici (par exemple, afficher un message approprié ou effectuer d'autres actions)
        }
    }
}


