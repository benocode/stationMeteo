/*
 * Pattern Observateur
 * Il définit une relation entre objets de type un-à-plusieurs, de façon que,
 * lorsqu'un objet change d'état, tous ceux qui en dépendent en soient notifiés
 * et soient mis à jour automatiquement.
 */

package fr.benocode.stationMeteo;

public class StationMeteo {

	public static void main(String[] args) {
		DonneesMeteo donneesMeteo = new DonneesMeteo();

		AffichageConditions affichageCond = new AffichageConditions(donneesMeteo);
//		AffichageStats affichageStat = new AffichageStats(donneesMeteo);
//		AffichagePrevisions affichagePrev = new AffichagePrevisions(donneesMeteo);
		AffichageHumidex affichageHumidex = new AffichageHumidex(donneesMeteo);

		donneesMeteo.setMesures(25, 65, 1020);
		System.out.println("*************************");
		donneesMeteo.setMesures(28, 70, 1012);
		System.out.println("*************************");
		donneesMeteo.setMesures(22, 90, 1012);
		System.out.println("*************************");
		donneesMeteo.setMesures(31.7f, 62, 1012);
	}
}
