package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
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
    private AnchorPane anchor_itemDetails;

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
    	
    

    }
    
}

