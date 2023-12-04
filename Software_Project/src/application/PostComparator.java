package application;

import java.util.Comparator;

public class PostComparator implements Comparator<Post>{
	
	public int compare(Post p1, Post p2) {
		int dateDifference = p1.getDate().compareTo(p1.getDate());
		if(dateDifference == 0) {
			return p1.getTime().compareTo(p2.getTime());
		}
		return dateDifference;
	}
}
