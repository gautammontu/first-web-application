package webapp;

public class userValidationService {

	
public boolean isUserValid(String name,String password) {
	
	if(name.equals("gautam")&& password.equals("montu")) {
		return true;
	}else {
		return false;
	}
}
	
}
