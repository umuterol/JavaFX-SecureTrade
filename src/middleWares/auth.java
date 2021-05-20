package middleWares;

import controller.register;

public class auth {
	
	
	public static String registerInputControl(String name,String password,String password2,String phone,String email){
		
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
	

}
