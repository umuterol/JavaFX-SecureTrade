package controller;

import helpers.Control;
import helpers.auth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;

public class passwordUpdate {

    @FXML
    private VBox vboxMenuPassword;

    @FXML
    private PasswordField txtProfileNowPass;

    @FXML
    private PasswordField txtProfileNewPass;

    @FXML
    private PasswordField txtProfileNewPass2;
    
    @FXML
    private Label lblResult;
    

    public VBox getVboxMenuPassword() {
		return vboxMenuPassword;
	}

	public void setVboxMenuPassword(VBox vboxMenuPassword) {
		this.vboxMenuPassword = vboxMenuPassword;
	}

	@FXML
    private Button btnProfileChangedPassword;

    @FXML
    void btnProfileChangedPassword_Click(ActionEvent event) {
    	
    	String nowPassword=txtProfileNowPass.getText();
    	String newPassword=txtProfileNewPass.getText();
    	String newPassword2=txtProfileNewPass2.getText();
    	
    	String passwordUpdateControl=new auth().passwordUpdate(nowPassword, newPassword, newPassword2);
    	if(Control.errorControl(passwordUpdateControl, lblResult)) {
    		inputClear();
    	}

    }
    
    private void inputClear() {
    	txtProfileNowPass.clear();
		txtProfileNewPass.clear();
		txtProfileNewPass2.clear();
    }

}
