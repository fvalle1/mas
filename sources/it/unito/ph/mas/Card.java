package it.unito.ph.mas;

import org.apache.commons.csv.CSVRecord;

public class Card extends Object {

	Object[] days;

	Card(CSVRecord row){
		days = new Object[365];
		
		for(int day = 0; day <365; day++) {
			days[day]=Integer.parseInt(row.get(day));	
		}
	}

	public Object[] getProperties() {
		return days;
	}
	
}
