package helpers;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.swing.ImageIcon;

import database.databaseConnect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.user;


public class auth extends database {
	

	private middleWares.auth mwAuth;
	
	
	public  String register(String name,String phone,String email,String password,String password2){
		
		String InputControl=mwAuth.RegisterInputControl(name, phone, email, password, password2);
	    if(InputControl != null) {
	    	return InputControl;
	    }
		
		sql="insert into user (user_name,user_password,user_phone,user_email) values(?,?,?,?)";
		
		try {
			
		    commandParameter=connect.prepareStatement(sql);
			commandParameter.setString(1, name);
			commandParameter.setString(2,MD5(password));
			commandParameter.setString(3, phone);
			commandParameter.setString(4, email);
			
			commandParameter.executeUpdate();
			
			
			return null;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return "Exception";
		}
	}
	
	//MD5
	public static String MD5(String password) {
		
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] bytePassword=md.digest(password.getBytes());
			
			BigInteger bigInteger=new BigInteger(1,bytePassword);
			
			String hashPassword=bigInteger.toString(16);
			
			while (hashPassword.length() < 32) {
				hashPassword="0"+hashPassword;
			}
			
			return hashPassword;
					
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public  boolean isUser(String email) {
		
	
		
		sql="select * from user where user_email=?";
		
	try {
			
			commandParameter=connect.prepareStatement(sql);
			commandParameter.setString(1, email);
		
			
			datas=commandParameter.executeQuery();
			
			if(datas.next()) {
				return true;
			}
			
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
		
		
	}
	
	public String login(String email , String password) {
		
	
		
		if(email.isEmpty()) {
			return "email girin";
		}
		
		if(password.isEmpty()) {
			return "Þifre Girin";
		}
		
		if(!( new helpers.auth().isUser(email) )) {
			return "Kullanýcý bulunamadý.";
		}
		
		
		
		sql="select * from user where user_email=? and user_password=?";
		
		try {
				
				commandParameter=connect.prepareStatement(sql);
				commandParameter.setString(1, email);
				commandParameter.setString(2, MD5(password));
				
				datas=commandParameter.executeQuery();
				
				if(datas.next()) {
					user.setId(datas.getInt("user_id"));
					user.setName(datas.getString("user_name"));
					user.setEmail(datas.getString("user_email"));
					user.setPhone(datas.getString("user_phone"));
					
					//img
					InputStream inputStream = datas.getBinaryStream("user_profileImage");
					if(inputStream !=null && inputStream.available() > 1) {
					user.setImg(new Image(inputStream));
					
					}else {
						user.setImg(new Image("/img/defaultProfileImage.png",false));
					}
					
					return null;
				}else {
					return "yanlýþ þifre girdiniz.";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return "Exception";
			}	
		
	}
	
	public boolean userProfileImageUpdate(File file) {
		
	
		
		sql="update user set user_profileImage=? where user_id=?";
		
		try {
			
			FileInputStream fileInputStream=new FileInputStream(file);
			
		    commandParameter=connect.prepareStatement(sql);
			commandParameter.setBinaryStream(1,fileInputStream);
			commandParameter.setInt(2,user.getId());
					
			commandParameter.executeUpdate();
			
			
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return false;
		}
		
	
		
	}
	
	public String menuProfileUpdate(String name,String email,String phone){
		
	
	
	    String InputControl=mwAuth.menuProfileUpdateInputControl(name, phone, email);
		if(InputControl !=null) {
			return InputControl;
		}
	
		sql="update user set user_name=? , user_email=? , user_phone=? where user_id=?";
		
		try {
			
		    commandParameter=connect.prepareStatement(sql);
			commandParameter.setString(1, name);
			commandParameter.setString(2, email);
			commandParameter.setString(3, phone);
			commandParameter.setInt(4, user.getId());
			
			
			commandParameter.executeUpdate();
			
			
			return null;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return "Exception";
		}
	}
	
	
	public String passwordControl(String password) {
		
	
		if(!(new helpers.auth().isUser(user.getEmail()))) {
			return "Kullanýcý bulunamadý.";
		}
		
		sql="select * from user where user_email=? and user_password=?";
		
		try {
				
				commandParameter=connect.prepareStatement(sql);
				commandParameter.setString(1, user.getEmail());
				commandParameter.setString(2, MD5(password));
				
				datas=commandParameter.executeQuery();
				
				if(datas.next()) {	
					return null;
				}else {
					return "mevcut þifreniz yanlýþ.";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return "Exception";
			}	
		
	}
	
	public String passwordUpdate(String nowPassword,String newPassword,String newPassword2){
		
		
	    String InputControl=mwAuth.passwordUpdateInputControl(nowPassword, newPassword, newPassword2);
		if(InputControl != null) {
			return InputControl;
		}
	
		sql="update user set user_password=? where user_id=?";
		
		try {
		    commandParameter=connect.prepareStatement(sql);
			commandParameter.setString(1, MD5(newPassword));
			commandParameter.setInt(2, user.getId());
			
			commandParameter.executeUpdate();
			
			return null;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return "Exception";
		}
	}
	

}
