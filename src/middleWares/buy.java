package middleWares;

import java.io.File;

import model.Product;
import model.dealer;
import model.user;


public class buy {
	
public static String buyInputControl(Product product , dealer dealerObject , String clientName , String clientPhone , String branch,String cardNo,String cardCvv) {
		
		if(user.getId() == -1 || (! new helpers.auth().isUser(user.getEmail()))) {
			return "Kimliðiniz Doðrulanamadý";
		}
		
		if( !(new helpers.product().isProduct(product.getId()))) {
			return "Ürün artýk geçerli deðil";
		}
		
		if(user.getId() == product.getDealerId()) {
			
			return "Kendi ürününüzü satýn alamazsýnýz";
		}
		
		if(clientName.isEmpty()) {
			return "Ad Soyad bilgileri girilmelidir.";
		}else if(clientName.length() < 5) {
			return "Geçersiz Ad Soyad";
		}
		
		if(clientPhone.isEmpty()) {
			return "Telefon bilgileri girilmelidir.";
		}else{
			if(clientPhone.length() < 10 || clientPhone.length() > 11)
			return "Geçersiz telefon formatý.";
			
			try {
				Double.parseDouble(clientPhone);
			} catch (Exception e) {
				// TODO: handle exception
				return "Geçersiz telefon formatý.";
			}
		}
		
		if(branch == null) {
			return "Teslimat þubesini seçin";
		}
		
		if(cardNo.isEmpty() || cardCvv.isEmpty()) {
			return "Kart bilgileri boþ geçilmez";
		}
		
		if(cardNo.length() != 16) {
			return "Geçersiz Kart Numarasý";
		}else {

				try {
					Double.parseDouble(cardNo);
				} catch (Exception e) {
					// TODO: handle exception
					return "Geçersiz Kart Numarasý";
				}
		
			
		}
		
		
		if(cardCvv.length() != 3) {
			return "Geçersiz CVV";
		}else {
			try {
				Integer.parseInt(cardCvv);
			} catch (Exception e) {
				// TODO: handle exception
				return "Geçersiz CVV";
			}
			
		}
		
		
		return null;
	}
	

}
