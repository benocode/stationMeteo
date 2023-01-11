package fr.benocode.stationMeteo;

import java.util.ArrayList;
import java.util.List;

public class DonneesMeteo implements Sujet {

	private List<Observateur> observateurs;
	private float temperature;
	private float humidite;
	private float pression;

	/* Constructeur */
	public DonneesMeteo() {
		observateurs = new ArrayList<Observateur>();
	}

	/* Méthodes */
	@Override
	public void enregistrerObservateur(Observateur o) {
		observateurs.add(o);
	}

	@Override
	public void supprimerObservateur(Observateur o) {
		observateurs.remove(o);
	}

	@Override
	public void notifierObservateurs() {
		for (Observateur current : observateurs) {
			current.actualiser(temperature, humidite, pression);
		}
	}

	public void actualiserMesures() {
		notifierObservateurs();
	}

	public void setMesures(float temperature, float humidite, float pression) {
		this.temperature = temperature;
		this.humidite = humidite;
		this.pression = pression;
		actualiserMesures();
	}

	/* Getters */
	public float getTemperature() {
		return temperature;
	}

	public float getHumidite() {
		return humidite;
	}

	public float getPression() {
		return pression;
	}
}
