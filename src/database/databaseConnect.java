package database;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class databaseConnect {
	
	static Connection connection=null;
	
	public static Connection Connect() {
		
		try {
			
			connection=DriverManager.getConnection("jdbc:mysql://176.53.69.72/umuterol_trade?useUnicode=true&characterEncoding=utf-8","umuterol","rlrea--o01");
			return connection;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("error");
			
			return null;
		}
		
	}
	

}
