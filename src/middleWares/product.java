package middleWares;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class product {
	
	public static String productInsertInputControl(String name, String price,String category,String features,File file) {
		
		if(name.isEmpty()) {
			return "Ürünün adýný girin";
		}
		
		if(price.isEmpty()) {
			return "Ürün fiyatýný girin";
		}else {
			try {
				Double.parseDouble(price);
			} catch (Exception e) {
				return "Geçerli Bir fiyat Girin";
			}
		}
		
		if(category == null) {
			return "Ürünün kategorisini Seçin";
		}
		if(features.isEmpty()) {
			return "Ürün özellikleri girin";
		}
		if(file == null) {
			return "Resim ekleyin";
		}
		
		return null;
	}
	


public static String productUpdateInputControl(int id ,String name, String price,String features) {
	
	if(name.isEmpty()) {
		return "Ürünün adýný girin";
	}
	
	if(price.isEmpty()) {
		return "Ürün fiyatýný girin";
	}else {
		try {
			Double.parseDouble(price);
		} catch (Exception e) {
			return "Geçerli Bir fiyat Girin";
		}
	}
	
	if(features.isEmpty()) {
		return "Ürün özellikleri girin";
	}
	
	
	if(!(new helpers.product().isProduct(id))){
		return "Düzenlemeye çalýþtýðýnýz ürün geçerli deðil"; 
	}
	
	return null;
}
	
}
