package entity.model;

public class ExpenseCategory {
	 private int category_id;
	    private String categoryname;

	    public ExpenseCategory() {}

	    public ExpenseCategory(int category_id, String categoryname) {
	        this.category_id = category_id;
	        this.categoryname = categoryname;
	    }
	    //getters and setters
	    public int getcategory_id() {
	    	return category_id;
	    }
	    public void setcategory_id(int category_id) {
	    	this.category_id = category_id;
	    }
	    public String getcategoryname() {
	    	return categoryname;
	    }
	    public void setcategoryname(String categoryname) {
	    	this.categoryname = categoryname;
	    }
}
