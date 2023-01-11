package fr.benocode.stationMeteo;

public interface Observateur {

	public void actualiser(float temp, float humidite, float pression);
}
