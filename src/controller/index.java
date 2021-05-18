package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
		  

			 try {
		 	    	
	    		 FXMLLoader fxmlLoader = new FXMLLoader();
	             fxmlLoader.setLocation(getClass().getResource("../views/shop.fxml"));
	             AnchorPane anchorPane = fxmlLoader.load();

	             shop controller = fxmlLoader.getController();
	             
	             
	             AnchorPane thisAnchor=(AnchorPane)vboxLogin.getParent().getParent().getParent();
	             thisAnchor.getChildren().setAll(controller.getBorderPaneShop());
	     	    
	    	  
	    		
	    		} catch(Exception e) {
	    			e.printStackTrace();
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

}
