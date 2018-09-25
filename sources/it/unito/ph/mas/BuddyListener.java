package it.unito.ph.mas;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class BuddyListener extends CyclicBehaviour {

	@Override
	public void action() {
		MessageTemplate MT1=MessageTemplate.MatchLanguage("Italian"); 
		ACLMessage msg=myAgent.receive(MT1);
		if (msg!=null) {
			String content=msg.getContent();
			
		}else {
			block();
		}
	}

}
