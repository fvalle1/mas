package it.unito.ph.mas;

import java.util.Map;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

enum fasciaoraria{
	kmattino,
	ktardamattinata,
	kpranzo,
	kprimopomeriggio,
	kpomeriggio,
	ksera,
	knotte
}

public class modelManager {

	public static Map<String,Linea> mappa;
	public Percorso GoogleMaps(Double[] whereAmI, Double[] destinazione) {
		return null;
	}

	public static int today;
	public static fasciaoraria fasciaoraria;


	private static Profile profile;
	private static Runtime runtime;
	private static AgentContainer mainContainer;

	private static void setup() {

		System.out.println("Inizio modello :-)");

		runtime = Runtime.instance();
		runtime.setCloseVM(true);

		profile = new ProfileImpl(true);
		profile.setParameter(Profile.CONTAINER_NAME, "Città");
		profile.setParameter(Profile.MAIN_HOST, "localhost");
		profile.setParameter(Profile.GUI, "true");


		mainContainer = runtime.createMainContainer(profile);

		try {
			AgentController persona = mainContainer.createNewAgent("persona","it.unito.ph.mas.Persona", new Object[0]);
			persona.start();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}


	}

	private static void Daicard(int day) {

		//..

	}

	public static void main(String[] args) {

		setup();

		for(int day=0;day<365;day ++) {

			Daicard(day);

			int numerorun = 24 * 60 / parameters.duratarun / parameters.numerofasciaoraria;

			for (int fascia = 0; fascia < parameters.numerofasciaoraria; fascia++) {

				for(int run = 0; run<numerorun; run++) {

					//chiama runagent;

				}

			}

		}

	}

}
