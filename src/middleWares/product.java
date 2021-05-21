package middleWares;

import java.io.File;

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

}
