package application;

import java.util.Comparator;

public class GroupComparator implements Comparator<Group>{

	public int compare(Group g, Group g2) {
		return g.getTitle().compareTo(g2.getTitle());
	}
}