package middleWares;

import java.io.File;

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

}
