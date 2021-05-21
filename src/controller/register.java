package controller;




import helpers.auth;
import helpers.Control;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
    private Label lblResult;
    
  
  
    @FXML
     void btnRegister_Click(ActionEvent event) {
    	
    	String name=txtRegisterName.getText();
    	String password=txtRegisterPass.getText();
    	String password2=txtRegisterPass2.getText();
    	String phone=txtRegisterPhone.getText();
    	String email=txtRegisterMail.getText();
  /*
    	String inputControl=middleWares.auth.RegisterInputControl(name,phone, email,password, password2);
    	if(inputControl !=null) {
    		lblResult.setText(inputControl);
    		lblResult.setTextFill(Color.RED);
    		lblResult.setVisible(true);
    		return;
    	}
    	
    	if(new auth().register(name, password2, phone, email)) {
    	lblResult.setText("Kayýt Baþarýlý");
		lblResult.setTextFill(Color.GREEN);
		lblResult.setVisible(true);
		goToLoginWithInputInfos();
    	}else {
    		lblResult.setText("Uygulama Hatasý! Özür dileriz daha sonra tekrar deneyiniz.");
    		lblResult.setTextFill(Color.RED);
    		lblResult.setVisible(true);
    		return;
    	}
    	*/
    	
    	String registerControl=new auth().register(name, phone, email, password, password2);
    	if(Control.errorControl(registerControl,lblResult)) {
    	     goToLoginWithInputInfos();
    	}
    	
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

    private void goToLoginWithInputInfos() {
    	

    	 try {
	    	
  		 FXMLLoader fxmlLoader = new FXMLLoader();
           fxmlLoader.setLocation(getClass().getResource("../views/index.fxml"));
           AnchorPane anchorPane = fxmlLoader.load();

           index controller = fxmlLoader.getController();
           controller.setTxtLoginMail(txtRegisterMail.getText());
           controller.setTxtLoginPass(txtRegisterPass.getText());
           
           AnchorPane thisAnchor=(AnchorPane)vboxRegister.getParent();
           thisAnchor.getChildren().setAll(controller.getVboxLogin());
   	    
  	  
  		
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
    	
    }

}
