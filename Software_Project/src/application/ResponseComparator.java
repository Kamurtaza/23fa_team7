package application;

import java.util.Comparator;

public class ResponseComparator implements Comparator<Response>{
	
	public int compare(Response r1, Response r2) {
		int dateDifference = r1.getDate().compareTo(r1.getDate());
		if(dateDifference == 0) {
			return r1.getTime().compareTo(r2.getTime());
		}
		return dateDifference;
	}
}
