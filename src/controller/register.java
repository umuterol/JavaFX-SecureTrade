package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class register {

    @FXML
    private VBox vboxRegister;

    public VBox getVboxRegister() {
		return vboxRegister;
	}

	public void setVboxRegister(VBox vboxRegister) {
		this.vboxRegister = vboxRegister;
	}

	@FXML
    private TextField txtRegisterName;

    @FXML
    private TextField txtRegisterMail;

    @FXML
    private TextField txtRegisterPhone;

    @FXML
    private PasswordField txtRegisterPass;

    @FXML
    private PasswordField txtRegisterPass2;

    @FXML
    private Hyperlink linkRegisterToLogin;

    @FXML
    private Button btnRegister;

    @FXML
    void btnRegister_Click(ActionEvent event) {

    }

    @FXML
    void linkRegisterToLogin_Click(MouseEvent event) {
    	

     	 try {
	    	
   		 FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../views/index.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            index controller = fxmlLoader.getController();
            
            
            AnchorPane thisAnchor=(AnchorPane)vboxRegister.getParent();
            thisAnchor.getChildren().setAll(controller.getVboxLogin());
    	    
   	  
   		
   		} catch(Exception e) {
   			e.printStackTrace();
   		}
   	 

    }

}
