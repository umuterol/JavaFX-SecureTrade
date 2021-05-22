package middleWares;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class product {
	
	public static String productInsertInputControl(String name, String price,String category,String features,File file) {
		
		if(name.isEmpty()) {
			return "�r�n�n ad�n� girin";
		}
		
		if(price.isEmpty()) {
			return "�r�n fiyat�n� girin";
		}else {
			try {
				Double.parseDouble(price);
			} catch (Exception e) {
				return "Ge�erli Bir fiyat Girin";
			}
		}
		
		if(category == null) {
			return "�r�n�n kategorisini Se�in";
		}
		if(features.isEmpty()) {
			return "�r�n �zellikleri girin";
		}
		if(file == null) {
			return "Resim ekleyin";
		}
		
		return null;
	}
	


public static String productUpdateInputControl(int id ,String name, String price,String features) {
	
	if(name.isEmpty()) {
		return "�r�n�n ad�n� girin";
	}
	
	if(price.isEmpty()) {
		return "�r�n fiyat�n� girin";
	}else {
		try {
			Double.parseDouble(price);
		} catch (Exception e) {
			return "Ge�erli Bir fiyat Girin";
		}
	}
	
	if(features.isEmpty()) {
		return "�r�n �zellikleri girin";
	}
	
	
	if(!(new helpers.product().isProduct(id))){
		return "D�zenlemeye �al��t���n�z �r�n ge�erli de�il"; 
	}
	
	return null;
}
	
}
