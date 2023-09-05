package api.payload;

public class UserPojo {
	
	int id;
	String username;
	String firstName;
	String lastName;
	String email;
	String Password;
	String phone;
	int userStatus=0;
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getusername()
	{
		return username;
	}
	
	public void setusername(String username)
	{
		this.username = username;
	}
	
	public String getlsatName()
	{
		return lastName;
	}
	
	public void setlastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return Password;
	}

	public void setPassword(String Password)
	{
		this.Password = Password;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public int getuserStatus()
	{
		return userStatus;
	}
	
	public void setuserStatus(int userStatus)
	{
		this.userStatus = userStatus;
	}
	public String getfirstName()
	{
		return firstName;
	}
	public void setfirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
}
