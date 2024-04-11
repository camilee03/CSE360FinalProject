
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserList {
	public ArrayList<User> ulist = new ArrayList<User>();
	private Map<Integer,UserInfo> finalMap = new HashMap<Integer, UserInfo>();
	
	
	public void addList(User u) {
		ulist.add(u);
	}
	
	public void pairInfo(User u, UserInfo usin) {
		
	}
	
	public Boolean exists(User u) {
		Boolean out = false;
		for(int i = 0; i < this.ulist.size(); i++) {
			if(u == this.ulist.get(i)) {
				out = true;
			}
		}
		
		return out;
	}
}
