package it.unito.ph.mas;

import java.util.Map;

import jade.core.AgentContainer;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class modelManager {
	
	public static Map<String,Linea> mappa;
	public Percorso GoogleMaps(Double[] whereAmI, Double[] destinazione) {
		return null;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Inizio modello :-)");
	
	Runtime runtime = runtime.instance();
	runtime.setCloseVM(true);
	
	Profile profile = new ProfileImpl(true);
	profile.setParameter(Profile.CONTAINER_NAME, "Città");
	profile.setParameter(Profile.MAIN_HOST, "localhost");
	profile.setParameter(Profile.GUI, "true");
	
	
	AgentContainer mainContainer = (AgentContainer) runtime.createMainContainer(profile);
	
	try {
		AgentController persona = ((ContainerController) mainContainer).createNewAgent("persona","it.unito.ph.mas.Persona", new Object[0]);
		persona.start();
	} catch (StaleProxyException e) {
		e.printStackTrace();
	}
	
	}

}
