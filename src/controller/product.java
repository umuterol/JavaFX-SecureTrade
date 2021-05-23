package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Product;
import model.dealer;

public class product{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblProductName;

    @FXML
    private Label lblProductPrice;

    @FXML
    private ImageView imgProduct;
    
    private Product product;

    @FXML
    void productClick(MouseEvent event) {
    	
    	//product details form
    	  try {
		    	

			  FXMLLoader fxmlLoader = new FXMLLoader();
              fxmlLoader.setLocation(getClass().getResource("/views/productDetails.fxml"));
              AnchorPane anchorPane = fxmlLoader.load();
              productDetails controller = fxmlLoader.getController();
             
              dealer dealerInfos=new helpers.shop().getDealer(product.getDealerId());
              
              controller.setForm(this.product,dealerInfos);
 

            Scene scene=new Scene(anchorPane);    
      	    Stage stage=new Stage();
      	    stage.setScene(scene);
         	stage.setOpacity(0.9);
      	    stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/productDetails.png")));
      	    stage.show();
        	    
      	    
    		
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    }

    public void setData(Product product) {
    	
    	this.product=product;
    	
    	lblProductName.setText(product.getName());
    	lblProductPrice.setText(product.getPrice() + " TL");
    	imgProduct.setImage(this.product.getImg());

    }

    
}
