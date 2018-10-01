package it.unito.ph.mas;

import java.util.ArrayList;

public class Line {
	ArrayList<BusStop> route;
	
	Line(Coordinates... stops){
		for(Coordinates stop : stops) {
			route.add(new BusStop(stop));
		}
	}
}
