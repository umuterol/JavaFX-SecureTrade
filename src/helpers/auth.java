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
	
	
	public  boolean register(String name,String password,String phone,String email){
	
		
		sql="insert into user (user_name,user_password,user_phone,user_email) values(?,?,?,?)";
		
		try {
			
		    commandParameter=connect.prepareStatement(sql);
			commandParameter.setString(1, name);
			commandParameter.setString(2,MD5(password));
			commandParameter.setString(3, phone);
			commandParameter.setString(4, email);
			
			commandParameter.executeUpdate();
			
			
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return false;
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
		
		if(!this.isUser(email)) {
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
					Image img;
					if(inputStream !=null && inputStream.available() > 1) {
					img=new Image(inputStream);
					user.setImg(img);
					}
					
					
				}
				
				return "yanlýþ þifre girdiniz.";
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new Error(e);
				
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
	
}
