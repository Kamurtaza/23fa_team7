package application;

public class Group {
	private String title;
	private Category category;

	public Group(String name, Category category) {
		this.title = name;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Group) {
			Group g = (Group)o;
			if(this.title.equals(g.title)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return title;
	}
}
