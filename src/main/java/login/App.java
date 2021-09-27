package login;

import java.io.FileInputStream;
import java.util.Properties;

public class App {
	public boolean userLogin(String userName,String password) {
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream("C:\\Users\\Sai Teja\\eclipse-workspace\\Tsl949_DevOps\\src\\main\\resources\\credentials.property"));
		}catch (Exception E) {
			System.out.println("Error with file reading");
		}
		//Data coming from property file
		String un=prop.getProperty("user");
		String pwd=prop.getProperty("password");
		if(userName.equals(un) && password.equals(pwd))
			return true;
		else
			return false;
	}
}
