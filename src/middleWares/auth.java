package middleWares;

import controller.register;

public class auth {
	
	
	public static String registerInputControl(String name,String password,String password2,String phone,String email){
		
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
	

}
