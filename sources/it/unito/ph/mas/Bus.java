package it.unito.ph.mas;

import jade.core.Agent;

public class Bus extends Agent {

	int peopleOn;
	Line myLinea;

	private int capacita;

	protected void setup() {
		peopleOn = 0;

	}

	@Override
	protected void takeDown() {

	}
	
	public void peopleOn() {
		peopleOn++;
	}

	void rispondiPersona() {

	}

	void contrattaPullman() {

	}

	void contattaSupervisor() {

	}

	void Think() {

	}
}
