package application;

import java.util.Comparator;

public class ObjectComparator implements Comparator<Object>{
	
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Category && o2 instanceof Category) {
			Category c1 = (Category)o1;
			Category c2 = (Category)o2;
			return c1.getTitle().compareTo(c2.getTitle());
		}
		else if(o1 instanceof Group && o2 instanceof Group) {
			Group g1 = (Group)o1;
			Group g2 = (Group)o2;
			return g1.getTitle().compareTo(g2.getTitle());
		}
		else if (o1 instanceof Post && o2 instanceof Post) {
			Post p1 = (Post) o1;
			Post p2 = (Post) o2;
			int dateDifference = p1.getDate().compareTo(p2.getDate());
			if(dateDifference == 0) {
				return p1.getTime().compareTo(p2.getTime());
			}
			return dateDifference;
		}
//		else if (o1 instanceof Response && o2 instanceof Response) {
//			Response r1 = (Response) o1;
//			Response r2 = (Response) o2;
//			int dateDifference = r1.getDate().compareTo(r2.getDate());
//			if(dateDifference == 0) {
//				return r1.getTime().compareTo(r2.getTime());
//			}
//			return dateDifference;
//		}
		return 0;
	}
}