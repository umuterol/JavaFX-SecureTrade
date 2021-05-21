package model;





import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;


public class user {
	
	private static int id;
	private static String name;
	private static String phone;
	private static String email;
	private static Image img;
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		user.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		user.name = name;
	}
	public static String getPhone() {
		return phone;
	}
	public static void setPhone(String phone) {
		user.phone = phone;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		user.email = email;
	}
	public static Image getImg() {
		return img;
	}
	public static void setImg(Image img) {
		user.img = img;
	}
	
	
	public static void clear() {
		setId(-1);
		setName(null);
		setPhone(null);
		setEmail(null);
		setImg(null);
	}
	
}
