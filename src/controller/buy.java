package controller;


import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import helpers.Control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.Product;
import model.dealer;
import model.user;

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
    private ComboBox<String> cbBuyClientCity;

    @FXML
    private ComboBox<String> cbBuyClientTown;

    @FXML
    private ComboBox<String> cbBuyClientBranch;

    @FXML
    private TextField txtBuyClientCardNumber;

    @FXML
    private TextField txtBuyClientCardCvv;

    @FXML
    private Button btnBuy;
    
    @FXML
    private Circle circleImgBuyDealer;
    
    @FXML
    private Label lblResult;

    
    private Product product;
    
    private dealer dealerInfos;
    
    public VBox getVboxBuy() {
		return vboxBuy;
	}

	public void setVboxBuy(VBox vboxBuy) {
		this.vboxBuy = vboxBuy;
	}

	@FXML
    private VBox vboxBuy;


    @FXML
    void btnBackToProduct_Click(ActionEvent event) {
    	
    	 try {
   	    	
	   		FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("/views/productDetails.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            productDetails controller = fxmlLoader.getController();
            controller.setForm(this.product , this.dealerInfos);

            AnchorPane thisAnchor=(AnchorPane)vboxBuy.getParent();
            thisAnchor.getChildren().setAll(controller.getVboxProductDetails());
    	    
    	  
   	  
   		
   		} catch(Exception e) {
   			e.printStackTrace();
   		}


    }

    @FXML
    void btnBuy_Click(ActionEvent event) {
    	
    	String clientName=txtBuyClientName.getText();
    	String clientPhone=txtBuyClientPhone.getText();
    	String cardNo=txtBuyClientCardNumber.getText();
    	String cardCvv=txtBuyClientCardCvv.getText();
    	String branch=cbBuyClientBranch.getValue();
    	String deliveryDate=this.getDeliveryDate();
    	
       String buyControl= new helpers.buy().insertMyOrder(product, dealerInfos, clientName, clientPhone, branch, cardNo, cardCvv, deliveryDate);

       if(Control.errorControl(buyControl, lblResult)) {
    	   lblResult.setText("Sipariþiniz alýndý");
    	   clearBuyInput();
       }
       
    }
    
    private void clearBuyInput() {	
    	txtBuyClientCardNumber.clear();
    	txtBuyClientCardCvv.clear();
    	
    }
    
    private String getDeliveryDate() {
 	   	   LocalDateTime deliveryDate = LocalDateTime.now().plusDays(5);
	       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	       String deliveryDateFormat = deliveryDate.format(formatter);
	       
	       return deliveryDateFormat;
 }
    
    public void setForm(Product product , dealer dealerInfos) {
    	
    	this.product=product;
    	this.dealerInfos=dealerInfos;
    	
    	imgBuyProduct.setImage(product.getImg());
    	lblBuyProductName.setText(product.getName());
    	lblBuyProductPrice.setText(product.getPrice() + " TL");
    	
    	//dealer
    	lblBuyDealerMail.setText(dealerInfos.getEmail());
    	lblBuyDealerName.setText(dealerInfos.getName());
    	lblBuyDealerPhone.setText(dealerInfos .getPhone());
    	circleImgBuyDealer.setFill(new ImagePattern(dealerInfos.getImg()));
    	
    	//client
    	txtBuyClientName.setText(user.getName());
    	txtBuyClientPhone.setText(user.getPhone());
    	
    }
    
    
    private void getComboBoxCity() {
    	
    	cbBuyClientCity.getItems().addAll(new helpers.buy().getAllCity());
    	
    }
    
    @FXML
    void initialize() {
    	getComboBoxCity();
    }
    
    @FXML
    void cbBuyClientCity_Selected(ActionEvent event) {
    	String selectedCity=cbBuyClientCity.getSelectionModel().getSelectedItem().toString();
        cbBuyClientTown.getItems().setAll(new helpers.buy().getAllTown(selectedCity));

    }

    @FXML
    void cbBuyClientTown_Selected(ActionEvent event) {
    	String selectedTown=cbBuyClientTown.getSelectionModel().getSelectedItem().toString();
        cbBuyClientBranch.getItems().setAll(new helpers.buy().getAllBranch(selectedTown));
        
    }
    
  
    	
}


    	