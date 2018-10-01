package it.unito.ph.mas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import jade.core.Agent;
import jade.core.BehaviourID;
import jade.core.behaviours.Behaviour;

public class Buddy extends Agent {

	Double[] whereAmI;
	Behaviour whatIAmDoing;
	Route percorso;

	private static int[] YEARLYAGENDA; 

	protected void setup() {
		setupArgs();

		addBehaviour(new BuddyListener());
	}

	/**
	 * 
	 */
	private void setupArgs() {
		Object[] arg = getArguments();
		YEARLYAGENDA = new int[arg.length];
		for (int i =0; i < arg.length; i++) {
			YEARLYAGENDA[i]=(int) arg[i];
		}
	}

	@Override
	protected void takeDown() {

	}

	public void RunAgent() throws IOException {

		addBehaviour(readCard());

		cercaLinea();
		miMuovo();
		salgo();
		scendo();
		miMuovo();
	}

	Behaviour readCard() throws IOException {
		int currentCard = YEARLYAGENDA[UniversalCentralTime.day];

		Reader reader = new FileReader("card"+currentCard+".card");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(reader);		
		int whatShouldIDo = Integer.parseInt(records.iterator().next().get(UniversalCentralTime.time));

		Behaviour behaviour = null;

		switch (whatShouldIDo) {
		case 0:
			behaviour = new GoHomeBehaviour();
			break;
		case 1:
			behaviour = new GoSchoolBehaviour();
			break;
		case 2:
			behaviour = new GoWorkBehaviour();
			break;
		case 3:
			behaviour = new GoMarketBehaviour();
			break;
		case 4:
			behaviour = new GoHospitalBehaviour();
			break;
		case 5:
			behaviour = new GoRandomBehaviour();
			break;
		case 6:
			behaviour = new NeverGoBehaviour();
			break;
		default:
			behaviour = new GoRandomBehaviour();
			break;
		}

		return behaviour;
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
