package controller;

import java.io.File;

import helpers.auth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class profileSettings {

	@FXML
    private AnchorPane anchorProfileSettings;

    @FXML
    private Circle imgProfileCircle;

    @FXML
    private HBox menuSettingProfil;

    @FXML
    private HBox menuSettingPassword;

    @FXML
    private HBox menuSettingProduct;

    @FXML
    private HBox menuSettingOrder;

    @FXML
    private AnchorPane anchorMenu;

    @FXML
    private VBox vboxProfileSettings;

    @FXML
    private ImageView imgProfile;

    @FXML
    private Button btnProfileUploadImage;

    @FXML
    private TextField txtProfileName;

    @FXML
    private TextField txtProfileMail;

    @FXML
    private TextField txtProfilePhone;

    @FXML
    private Button btnProfileSaveChanged;
    
    @FXML
    private BorderPane borderPaneProfileSettings;


    public BorderPane getBorderPaneProfileSettings() {
		return borderPaneProfileSettings;
	}

	public void setBorderPaneProfileSettings(BorderPane borderPaneProfileSettings) {
		this.borderPaneProfileSettings = borderPaneProfileSettings;
	}

	@FXML
    void btnProfileSaveChanged_Click(ActionEvent event) {

    }

    @FXML
    void btnProfileUploadImage_Click(ActionEvent event) {
    	
    	FileChooser filechooser=new FileChooser();
    	filechooser.setTitle("Open File Dialog");
    	Stage stage=(Stage)borderPaneProfileSettings.getParent().getScene().getWindow();

    	File file=filechooser.showOpenDialog(stage);

    	if(file.isFile()) {
    		Image img=new Image(file.toURI().toString(),500,400,true,true);
    		imgProfile.setImage(img);
    		
    		auth authObject=new auth();
        	if(authObject.userProfileImageUpdate(file)) {
        		System.out.print("Update profileImage Successful");
        	}
    		
    	}
    	

    }

    @FXML
    void menuSettingPassword_Pressed(MouseEvent event) {
    	
   
    	 try {
   	    	
    		 FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("../views/passwordOperation.fxml"));
             AnchorPane anchorPane = fxmlLoader.load();

             passwordOperation controller = fxmlLoader.getController();
             
             
             anchorMenu.getChildren().setAll(controller.getVboxMenuPassword());
     	    
    	  
    		
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	

    }
    
    @FXML
    void menuSettingProfil_Pressed(MouseEvent event) {
    	    
            anchorMenu.getChildren().setAll(this.vboxProfileSettings);
    }
    
    @FXML
    void menuSettingProduct_Pressed(MouseEvent event) {
    	

   	 try {
  	    	
   		 FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../views/myProfileProductSettings.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            myProfileProductSettings controller = fxmlLoader.getController();
            
            
            anchorMenu.getChildren().setAll(controller.getTabPaneMyProductOperations());
    	    
   	  
   		
   		} catch(Exception e) {
   			e.printStackTrace();
   		}
   	

    }
    

    @FXML
    void menuSettingOrder_Pressed(MouseEvent event) {
    	

   	 try {
  	    	
   		 FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../views/myOrder.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            myOrder controller = fxmlLoader.getController();
            
            
            anchorMenu.getChildren().setAll(controller.getVboxMyOrder());
    	    
   	  
   		
   		} catch(Exception e) {
   			e.printStackTrace();
   		}

    }
    
    @FXML
    void btnBackToShop_Click(ActionEvent event) {

    	try {
 	    	
   		    FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../views/shop.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            shop controller = fxmlLoader.getController();
            
            
            AnchorPane thisAnchor=(AnchorPane)borderPaneProfileSettings.getParent();
            thisAnchor.getChildren().setAll(controller.getBorderPaneShop());
    	    
   	  
   		
   		} catch(Exception e) {
   			e.printStackTrace();
   		}


    }
    
    


}



