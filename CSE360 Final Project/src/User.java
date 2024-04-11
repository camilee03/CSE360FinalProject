package asuHelloWorldJavaFX;
public class User {
	private String UUID;
	private String Username;
	private String UserPassword;
	
	
	public User() {
		UUID = "";
		Username = "";
		UserPassword = "";
	}
	
	public User(String uuid, String uname, String pword) {
		UUID = uuid;
		Username = uname;
		UserPassword = pword;
	}
	
	public String getUUID() {
		return this.UUID;
	}
	
	public String getUsername() {
		return this.Username;
	}
	
	public String getPassword() {
		return this.UserPassword;
	}
	
}
