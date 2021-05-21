package helpers;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Control {


    public static Boolean errorControl(String error,Label label) {
    	 if(error == "Exception") {
    		 	label.setText("Uygulama Hatas�! �z�r dileriz daha sonra tekrar deneyiniz.");
	    		label.setTextFill(Color.RED);
	    		label.setVisible(true);
	    		return false;
		 }
    	 if(error != null) {
			    label.setText(error);
	    		label.setTextFill(Color.RED);
	    		label.setVisible(true);
	    		return false;
		 }
    	 if(error == null) {
    		 	label.setText("��lem Ba�ar�l�");
	    		label.setTextFill(Color.GREEN);
	    		label.setVisible(true);
	    		return true;
    	 }
		 return false;
    }

	
}
