package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class buy {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorBuy;

    @FXML
    private Button btnBackToProduct;

    @FXML
    private ImageView imgBuyProduct;

    @FXML
    private Label lblBuyProductName;

    @FXML
    private Label lblBuyProductPrice;

    @FXML
    private ImageView imgBuyDealer;

    @FXML
    private Label lblBuyDealerName;

    @FXML
    private Label lblBuyDealerPhone;

    @FXML
    private Label lblBuyDealerMail;

    @FXML
    private TextField txtBuyClientName;

    @FXML
    private TextField txtBuyClientPhone;

    @FXML
    private ComboBox<?> cbBuyClientCity;

    @FXML
    private ComboBox<?> cbBuyClientTown;

    @FXML
    private ComboBox<?> cbBuyClientBranch;

    @FXML
    private TextField txtBuyClientCardNumber;

    @FXML
    private TextField txtBuyClientCardCvv;

    @FXML
    private Button btnBuy;

    @FXML
    void btnBackToProduct_Click(ActionEvent event) {
    	
    	 try {
   	    	
	   		FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("/views/productDetails.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            //productDetails controller = fxmlLoader.getController();
            //controller.setForm(this.product);

          
            anchorBuy.getChildren().setAll(anchorPane);
    	    
    	  
   	  
   		
   		} catch(Exception e) {
   			e.printStackTrace();
   		}


    }

    @FXML
    void btnBuy_Click(ActionEvent event) {

    }

 
}


    	