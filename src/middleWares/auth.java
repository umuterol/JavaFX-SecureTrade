package middleWares;

import controller.register;
import model.user;

public class auth {
	
	
	public static String RegisterInputControl(String name,String phone,String email,String password,String password2){
		
		if(name.length() < 3) {
			return "isim 3 karakterden uzun olmalý";
		}
		
		if(email.length() < 6) {
			return "e mailinizi kontrol edin.";
		}
		
		if(phone.length() < 10) {
			return "telefon numaranýz eksik lütfen kontrol edin";
		}
		
		if(!password.equals(password2)) {
			return "þifreleriniz uyuþmuyor";
		}
		
		if(password.length() < 6) {
			return "þifreniz en az 6 karakter olmalýdýr";
		}	
		
		if(new helpers.auth().isUser(email)) {
			return "email adresi zaten kayýtlý";
		}
		
		return null;
	}
	
	public static String menuProfileUpdateInputControl(String name,String phone,String email){
		
		if(name.length() < 3) {
			return "isim 3 karakterden uzun olmalý";
		}
		
		if(email.length() < 6) {
			return "e mailinizi kontrol edin.";
		}
		
		if(phone.length() < 10) {
			return "telefon numaranýz eksik lütfen kontrol edin";
		}
		
		
		if( (!user.getEmail().equals(email)) && new helpers.auth().isUser(email)) {
			return "email adresi zaten kayýtlý";
		}
		
		return null;
	}
	
	public static String passwordUpdateInputControl(String nowPassword,String newPassword , String newPassword2) {
		
		if(nowPassword.isEmpty()) {
			return "mevvut þifrenizi girin";
		}
		
		String nowPasswordControl=new helpers.auth().passwordControl(nowPassword);
		if( nowPasswordControl != null) {
			return nowPasswordControl;
		}
		
		if(newPassword.isEmpty() || newPassword2.isEmpty()) {
			return "þifre alanlarý doldurulmalýdýr";
		}
		
		if(!newPassword.equals(newPassword2)) {
			return "yeni þifrelerin uyuþmuyor";
		}
		
		if(newPassword.length() < 6) {
			return "þifreniz en az 6 karakter olmalýdýr";
		}
		
		return null;
	}
	
}
