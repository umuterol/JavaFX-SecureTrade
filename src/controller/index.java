package controller;

import helpers.Control;
import helpers.auth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class index {

    @FXML
    private AnchorPane anchorLoginRegister;

    @FXML
    private VBox vboxLogin;

    @FXML
    private TextField txtLoginMail;

    @FXML
    private Hyperlink linkLoginToRegister;

    @FXML
    private Button btnLogin;
    
    @FXML
    private AnchorPane anchorIndex;
    
    @FXML
    private BorderPane borderPaneIndex;
    
    @FXML
    private PasswordField txtLoginPass;

    @FXML
    private Label lblResult;
    
    public BorderPane getBorderPaneIndex() {
		return borderPaneIndex;
	}

	public void setBorderPaneIndex(BorderPane borderPaneIndex) {
		this.borderPaneIndex = borderPaneIndex;
	}

	public VBox getVboxLogin() {
		return vboxLogin;
	}

	public void setVboxLogin(VBox vboxLogin) {
		this.vboxLogin = vboxLogin;
	}



	  @FXML
	    void btnLogin_Pressed(MouseEvent event) {
		  
		 String email=txtLoginMail.getText();
		 String password=txtLoginPass.getText();
		 
		 String loginControl=new auth().login(email, password);
		 
		if(Control.errorControl(loginControl,lblResult)) {
			 try {
		 	    	
	    		 FXMLLoader fxmlLoader = new FXMLLoader();
	             fxmlLoader.setLocation(getClass().getResource("../views/shop.fxml"));
	             AnchorPane anchorPane = fxmlLoader.load();

	             shop controller = fxmlLoader.getController();
	             
	             
	             AnchorPane thisAnchor=(AnchorPane)vboxLogin.getParent().getParent().getParent();
	             thisAnchor.getChildren().setAll(controller.getBorderPaneShop());
	     	    
	    	  
	    		
	    		} catch(Exception e) {
	    			Control.errorControl("Exception",lblResult);
	    			e.printStackTrace();
	    		}
		}

	    }

    @FXML
    void linkLoginToRegister_Click(MouseEvent event) {
    	
      	 try {
 	    	
    		 FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("../views/register.fxml"));
             AnchorPane anchorPane = fxmlLoader.load();

             register controller = fxmlLoader.getController();
             
             
             AnchorPane thisAnchor=(AnchorPane)vboxLogin.getParent();
             thisAnchor.getChildren().setAll(controller.getVboxRegister());
     	    
    	  
    		
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	 

    }
/*
    public boolean showError(String error) {
    	 if(error == "Exception") {
			 lblResult.setText("Uygulama Hatasý! Özür dileriz daha sonra tekrar deneyiniz.");
	    		lblResult.setTextFill(Color.RED);
	    		lblResult.setVisible(true);
	    		return false;
		 }
		 if(error != null) {
			    lblResult.setText(error);
	    		lblResult.setTextFill(Color.RED);
	    		lblResult.setVisible(true);
	    		return false;
		 }
		 return true;
    }

*/

	public void setTxtLoginMail(String txtLoginMail) {
		this.txtLoginMail.setText(txtLoginMail);
	}


	public void setTxtLoginPass(String txtLoginPass) {
		this.txtLoginPass.setText(txtLoginPass);

	}
	

    @FXML
    void initialize() {
       txtLoginMail.setText("umutumut");
       txtLoginPass.setText("umutumut");
    
       
       
      
    }
}
