package middleWares;

import controller.register;
import model.user;

public class auth {
	
	
	public static String RegisterInputControl(String name,String phone,String email,String password,String password2){
		
		if(name.length() < 3) {
			return "isim 3 karakterden uzun olmal�";
		}
		
		if(email.length() < 6) {
			return "e mailinizi kontrol edin.";
		}
		
		if(phone.length() < 10) {
			return "telefon numaran�z eksik l�tfen kontrol edin";
		}
		
		if(!password.equals(password2)) {
			return "�ifreleriniz uyu�muyor";
		}
		
		if(password.length() < 6) {
			return "�ifreniz en az 6 karakter olmal�d�r";
		}	
		
		if(new helpers.auth().isUser(email)) {
			return "email adresi zaten kay�tl�";
		}
		
		return null;
	}
	
	public static String menuProfileUpdateInputControl(String name,String phone,String email){
		
		if(name.length() < 3) {
			return "isim 3 karakterden uzun olmal�";
		}
		
		if(email.length() < 6) {
			return "e mailinizi kontrol edin.";
		}
		
		if(phone.length() < 10) {
			return "telefon numaran�z eksik l�tfen kontrol edin";
		}
		
		
		if( (!user.getEmail().equals(email)) && new helpers.auth().isUser(email)) {
			return "email adresi zaten kay�tl�";
		}
		
		return null;
	}
	
	public static String passwordUpdateInputControl(String nowPassword,String newPassword , String newPassword2) {
		
		if(nowPassword.isEmpty()) {
			return "mevvut �ifrenizi girin";
		}
		
		String nowPasswordControl=new helpers.auth().passwordControl(nowPassword);
		if( nowPasswordControl != null) {
			return nowPasswordControl;
		}
		
		if(newPassword.isEmpty() || newPassword2.isEmpty()) {
			return "�ifre alanlar� doldurulmal�d�r";
		}
		
		if(!newPassword.equals(newPassword2)) {
			return "yeni �ifrelerin uyu�muyor";
		}
		
		if(newPassword.length() < 6) {
			return "�ifreniz en az 6 karakter olmal�d�r";
		}
		
		return null;
	}
	
}
