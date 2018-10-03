package it.unito.ph.mas;

import java.util.HashMap;
import java.util.Map;

import jade.core.Agent;

public class Supervisor extends Agent {

	public static  Map<String,Line> map;
	public Route GoogleMaps(Double[] whereAmI, Double[] destinazione) {


		return null;
	}

	protected void setup() {
		System.out.println("Supervisor is online");

		createMap();

	}

	/**
	 * 
	 */
	private void createMap() {
		map = new HashMap<String,Line>();
		map.put("18", new Line(
				new Coordinates(0, 0),
				new Coordinates(1, 1)
				)
				);
		
		map.put("16", new Line(
				new Coordinates(0, 0),
				new Coordinates(1, 1),
				new Coordinates(1, 2),
				new Coordinates(1, 3),
				new Coordinates(3, 0)

				)
				);
	}

	@Override
	protected void takeDown() {

	}

	void TrustMatrix() {

	}


	void spostaPullman() {

	}
}
