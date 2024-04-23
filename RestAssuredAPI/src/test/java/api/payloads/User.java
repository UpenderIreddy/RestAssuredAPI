package api.payloads;

// User Pojo class (plain old Java object)
public class User {
	

	  
	 int id;
	String username;


	String firstname;
	String lastname;
	String email;
	String password;
	String phone;
	int userstatus= 0;
	
	
	
	public void setID(int id) {
		
		this.id =id;
	}
	
	
	public int getID() {
		
		return id;
	}
	
	public String getUsername() {


		return username;
	}


	public void setUsername(String username) {

		this.username = username;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getUserstatus() {
		return userstatus;
	}


	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}

	
	
	

}
