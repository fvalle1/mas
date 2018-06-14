package it.unito.ph.mas;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class go extends CyclicBehaviour{

	@Override
	public void action() {
		MessageTemplate MT=MessageTemplate.MatchLanguage("Italiano"); 
		ACLMessage msg=myAgent.receive(MT);
		if (msg!=null) {
			String contenuto=msg.getContent();
			if (contenuto.equalsIgnoreCase("Smile")) {
				System.out.println("L'agente " + myAgent.getAID().getName() + " sta sorridendo...:-)");
			}
		}else {
			block();
		}

	}

}
