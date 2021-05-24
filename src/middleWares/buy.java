package middleWares;

import java.io.File;

import model.Product;
import model.dealer;
import model.user;


public class buy {
	
public static String buyInputControl(Product product , dealer dealerObject , String clientName , String clientPhone , String branch,String cardNo,String cardCvv) {
		
		if(user.getId() == -1 || (! new helpers.auth().isUser(user.getEmail()))) {
			return "Kimli�iniz Do�rulanamad�";
		}
		
		if( !(new helpers.product().isProduct(product.getId()))) {
			return "�r�n art�k ge�erli de�il";
		}
		
		if(user.getId() == product.getDealerId()) {
			
			return "Kendi �r�n�n�z� sat�n alamazs�n�z";
		}
		
		if(clientName.isEmpty()) {
			return "Ad Soyad bilgileri girilmelidir.";
		}else if(clientName.length() < 5) {
			return "Ge�ersiz Ad Soyad";
		}
		
		if(clientPhone.isEmpty()) {
			return "Telefon bilgileri girilmelidir.";
		}else{
			if(clientPhone.length() < 10 || clientPhone.length() > 11)
			return "Ge�ersiz telefon format�.";
			
			try {
				Double.parseDouble(clientPhone);
			} catch (Exception e) {
				// TODO: handle exception
				return "Ge�ersiz telefon format�.";
			}
		}
		
		if(branch == null) {
			return "Teslimat �ubesini se�in";
		}
		
		if(cardNo.isEmpty() || cardCvv.isEmpty()) {
			return "Kart bilgileri bo� ge�ilmez";
		}
		
		if(cardNo.length() != 16) {
			return "Ge�ersiz Kart Numaras�";
		}else {

				try {
					Double.parseDouble(cardNo);
				} catch (Exception e) {
					// TODO: handle exception
					return "Ge�ersiz Kart Numaras�";
				}
		
			
		}
		
		
		if(cardCvv.length() != 3) {
			return "Ge�ersiz CVV";
		}else {
			try {
				Integer.parseInt(cardCvv);
			} catch (Exception e) {
				// TODO: handle exception
				return "Ge�ersiz CVV";
			}
			
		}
		
		
		return null;
	}
	

}
