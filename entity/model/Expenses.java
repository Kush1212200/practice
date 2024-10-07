package entity.model;

public class Expenses {
	
	private int expense_id; 
	private int user_id ;
	private double amount;
	private int category_id ;
	private String date;
	private String description;

	public Expenses() {}
	
	
	public Expenses(int expense_id , int user_id , double amount , int category_id, String date , String description) {
		this.expense_id = expense_id;
		this.user_id = user_id;
		this.amount = amount;
		this.category_id = category_id;
		this.date = date;
		this.description = description;
	}
	//getters and setters
	public int getexpense_id() {
        return expense_id;
    }

    public void setexpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public int getcategory_id() {
        return category_id;
    }

    public void setCategory(int category_id) {
        this.category_id = category_id;
    }
    public String getdate() {
    	return date;
    }
    public void setdate(String date) {
    	this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

