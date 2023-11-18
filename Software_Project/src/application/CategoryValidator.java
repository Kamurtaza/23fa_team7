package application;

import java.util.List;

public class CategoryValidator {
    private List<Category> categories;
    private List<Group> groups;
    private Admin admin;
    
    public CategoryValidator(List<Category> categories, List<Group> groups) {
        this.categories = categories;
        this.groups = groups;
    }

    public boolean validateCreateCategory(String categoryTitle) {
        for (Category category : categories) {
            if (category.getTitle().equals(categoryTitle)) {
                return false; 
            }
        }

        Category newCategory = new Category(categoryTitle);
        categories.add(newCategory);
        return true; // Category creation successful
    }
}
