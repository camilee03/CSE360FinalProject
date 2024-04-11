
public class UserInfo {
	private String UUID;
	private String someInfo;
	
	UserInfo(){
		UUID = "";
		someInfo = "";
	}
	
	public String getUUID() {
		return this.UUID;
	}
	
	public String getInfo() {
		return this.someInfo;
	}
	
	//Need to create persistent file writing
}
