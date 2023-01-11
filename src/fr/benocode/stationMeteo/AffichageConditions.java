package fr.benocode.stationMeteo;

public class AffichageConditions implements Observateur, Affichage {

	private float temperature;
	private float humidite;
	private Sujet donneesMeteo; // Pour s'incrire ou se désincrire plus tard de la liste d'observateurs

	/* Constructeur */
	public AffichageConditions(Sujet donneesMeteo) {
		this.donneesMeteo = donneesMeteo;
		donneesMeteo.enregistrerObservateur(this);
	}

	/**
	 * Affiche les mesures courantes
	 */
	@Override
	public void afficher() {
		System.out.println("Conditions actuelles : " + temperature + " degrés C et " + humidite + " % d'humidité");
	}

	@Override
	public void actualiser(float temp, float humidite, float pression) {
		this.temperature = temp;
		this.humidite = humidite;
		afficher();
	}
}
