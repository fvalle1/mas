package it.unito.ph.mas;

import java.util.ArrayList;

public class Line {
	private ArrayList<BusStop> route;

	Line(Coordinates... stops){
		route = new ArrayList<BusStop>();
		
		for(Coordinates stop : stops) {
			route.add(new BusStop(stop));
		}
	}
}
