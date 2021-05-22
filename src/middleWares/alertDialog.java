package middleWares;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class alertDialog {
	
    public static Boolean AlertQuestion(String Content) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	

    	alert.setHeaderText("Uyarý");
    	alert.setContentText(Content);
    	
    	
    	
    	
    	Optional<ButtonType> result=alert.showAndWait();
    	
    	if(result.get() == ButtonType.OK) {
    		return true;
    	}
    	else if(result.get() == ButtonType.CANCEL) {
    		return false;
    	}
    	
    	return false;
    	
    }
    

}
