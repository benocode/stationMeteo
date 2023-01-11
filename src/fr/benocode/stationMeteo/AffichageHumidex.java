package fr.benocode.stationMeteo;

public class AffichageHumidex implements Observateur, Affichage {

	private float temperature;
	private float humidite;
	private float humidex;
	private Sujet donneesMeteo; // Pour s'incrire ou se désincrire plus tard de la liste d'observateurs

	public AffichageHumidex(Sujet donneesMeteo) {
		this.donneesMeteo = donneesMeteo;
		donneesMeteo.enregistrerObservateur(this);
	}

	public void calculHumidex(float tempCelsius, float humidite) {

		// calcul du point de rosée (formule de Heinrich Gustav Magnus-Tetens)
		double alpha = Math.log(humidite / 100.0) + (17.27 * tempCelsius) / (237.3 + tempCelsius);
		double rosee = (237.3 * alpha) / (17.27 - alpha);

		// calcul de l'humidex
		this.humidex = (float) (tempCelsius
				+ 0.5555 * (6.112 * Math.exp(5417.753 * ((1.0 / 273.16) - (1.0 / (273.15 + rosee)))) - 10.0));
	}

	@Override
	public void afficher() {
		calculHumidex(this.temperature, this.humidite);
		System.out.printf("L'humidex est de %.1f%n", humidex);

	}

	@Override
	public void actualiser(float temp, float humidite, float pression) {
		this.temperature = temp;
		this.humidite = humidite;
		afficher();
	}

}
