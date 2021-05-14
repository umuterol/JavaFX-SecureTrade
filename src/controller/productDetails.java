package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Product;

public class productDetails {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorProductDetails;

    @FXML
    private Label lblProductName;

    @FXML
    private Label lblPrductPrice;

    @FXML
    private ImageView imgProduct;

    @FXML
    private Button btnSecureBuy;

    @FXML
    private ListView<String> lwFeature;

    @FXML
    private TextArea txtareaDescription;

    @FXML
    private ImageView imgDealer;

    @FXML
    private Label lblDealerName;

    @FXML
    private Label lblDealerPhone;

    @FXML
    private Label lblDealerMail;
    
    @FXML
    private VBox vboxProductDetails;

    private Product product;

    public void setForm(Product product) {
    	this.product=product;
    	
    	this.lblProductName.setText(product.getName());
    	this.lblPrductPrice.setText(product.getPrice()+" TL");
    	this.imgProduct.setImage(new Image(getClass().getResourceAsStream(product.getImgSrc())));
    	this.txtareaDescription.setText(product.getDescription());
    	this.lwFeature.getItems().addAll(product.getFeatures());
    }

    @FXML
    void btnSecureBuy_Click(ActionEvent event) {
    	
    	 try {
  	    	
    		 FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("/views/buy.fxml"));
             AnchorPane anchorPane = fxmlLoader.load();

             buy controller = fxmlLoader.getController();
             //controller.setForm(this.product);
             
             AnchorPane thisAnchor=(AnchorPane)vboxProductDetails.getParent();
             thisAnchor.getChildren().setAll(controller.getVboxBuy());
     	    
    	  
    		
    		} catch(Exception e) {
    			e.printStackTrace();
    		}


    }

	public VBox getVboxProductDetails() {
		return vboxProductDetails;
	}

	public void setVboxProductDetails(VBox vboxProductDetails) {
		this.vboxProductDetails = vboxProductDetails;
	}



}



