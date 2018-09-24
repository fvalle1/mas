package it.unito.ph.mas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import javax.swing.SingleSelectionModel;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

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

	
	private static Reader SCHEDULE_READER;
	
	private static void setup() throws FileNotFoundException {
		jadeSetup();
		fileSetup();
	}

	/**
	 * initialize jade
	 */
	private static void jadeSetup() {
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
	
	private static void fileSetup() throws FileNotFoundException {
		SCHEDULE_READER = new FileReader("schedule.csv");
	}

	private static void Daicard(int day) throws IOException {
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(SCHEDULE_READER);

		for (CSVRecord agentSchedule : records) {
			System.out.println(agentSchedule.get(day));
		}
	
	}

	public static void main(String[] args) {
		System.out.println("Inizio modello :-)");

		
		try {
			setup();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		for(int day=0;day<365;day ++) {

			try {
				Daicard(day);
			} catch (IOException e) {
				e.printStackTrace();
			}

			int numerorun = 24 * 60 / parameters.duratarun / parameters.numerofasciaoraria;

			for (int fascia = 0; fascia < parameters.numerofasciaoraria; fascia++) {

				for(int run = 0; run<numerorun; run++) {

					//chiama runagent;

				}

			}

		}

	}

}
