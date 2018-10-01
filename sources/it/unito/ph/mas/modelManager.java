package it.unito.ph.mas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;

enum daytime{
	kmorning,
	klatemorning,
	klunch,
	knoon,
	kafternoon,
	kevening,
	knight
}

public class modelManager {
	public static int today;
	public static daytime fasciaoraria;


	private static Profile profile;
	private static Runtime runtime;
	private static AgentContainer mainContainer;
	private static AgentContainer popContainer;
	private static AgentContainer busContainer;
	private static AgentController supervisor;
	
	private static void setup() throws StaleProxyException, IOException {
		jadeSetup();
	}

	/**
	 * initialize jade
	 * @throws StaleProxyException 
	 * @throws IOException 
	 */
	private static void jadeSetup() throws StaleProxyException, IOException {
		runtime = Runtime.instance();
		runtime.setCloseVM(true);

		profile = new ProfileImpl(true);
		profile.setParameter(Profile.CONTAINER_NAME, "Main-container");
		profile.setParameter(Profile.MAIN_HOST, "localhost");
		profile.setParameter(Profile.GUI, "true");

		mainContainer = runtime.createMainContainer(profile);
		popContainer = createAgentContainer("People", "localhost");
		busContainer = createAgentContainer("Buses", "localhost");

		supervisor = mainContainer.createNewAgent("supervisor", "it.unito.ph.mas.Supervisor", new Object[0]);
		supervisor.start();

		Reader reader = new FileReader("schedule.csv");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(reader);
		int iAgent = 0;
		for (CSVRecord agentSchedule : records) {

			if( iAgent < parameters.populationSize) {
				Card card = new Card(agentSchedule);
				AgentController ag = popContainer.createNewAgent("buddy"+iAgent,"it.unito.ph.mas.Buddy", card.getProperties());
				ag.start();
			}
			iAgent++;
		}

		reader.close();

		for (int iBus = 0; iBus < parameters.fleetSize; iBus++) {
			AgentController ag = busContainer.createNewAgent("bus"+iBus,"it.unito.ph.mas.Bus", new Object[0]);
			ag.start();
		}


	}

	/**
	 * append container to runtime
	 * @return Agent container
	 * @param name name container
	 * @param host Profile.MAIN_HOST
	 */
	private static AgentContainer createAgentContainer(String name, String host) {
		profile = new ProfileImpl(true);
		profile.setParameter(Profile.CONTAINER_NAME, name);
		profile.setParameter(Profile.MAIN_HOST, host);
		profile.setParameter(Profile.GUI, "true");


		return runtime.createAgentContainer(profile);
	}


	public static void main(String[] args) {
		System.out.println("Inizio modello :-)");


		try {
			setup();
		} catch (IOException | StaleProxyException e1) {
			e1.printStackTrace();
		}

		for(int day=0;day<365;day ++) {
			
			UniversalCentralTime.day = day;

			int runnumber = 24 * 60 / parameters.minutesInRun / parameters.numOfDaytime;

			for (int daytime = 0; daytime < parameters.numOfDaytime; daytime++) {
				
				UniversalCentralTime.time = daytime;

				for(int run = 0; run<runnumber; run++) {

					//chiama runagent;

				}

			}

		}

	}

}
