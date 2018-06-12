package it.unito.ph.mas;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Persona extends Agent {

	Double[] whereAmI;
	Behaviour whatIAmDoing;
	Percorso percorso;

	
	protected void setup() {
		
	}
	
	@Override
	protected void takeDown() {
		
	}
	
	public void RunAgent() {
		LeggiCarta();
		cercaLinea();
		miMuovo();
		salgo();
		scendo();
		miMuovo();
	}
	
	Behaviour LeggiCarta() {
		return null;
	}
	void cercaLinea() {
		//modelManager.GoogleMaps();
	};
	void miMuovo() {
	}
	void salgo() {
	}
	void scendo() {
	}
}
