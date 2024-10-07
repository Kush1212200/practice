package entity.model;

public class User {
	private int user_id;
	private String username;
	private String email;
	private String password;
	
	public User() {}
	
	public User(int user_id , String username , String email , String password)
	{
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public int getuser_id() {
		return user_id;
	}
   public void setuser_id(int user_id) {
	   this.user_id = user_id;  
   }
   public String getusername() {
	   return username;
   }
   public void setusername(String username) {
	   this.username = username;
   }
   public String getemail() {
	   return email;
   }
   public void setemail(String email) {
	   this.email = email;
   }
   public String getpassword() {
	   return password;
   }
   public void setpassword(String password) {
	   this.password = password;
   }
}
