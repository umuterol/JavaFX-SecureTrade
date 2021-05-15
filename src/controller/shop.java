package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import model.Product;

public class shop {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private AnchorPane anchorFilter;

    @FXML
    private ScrollPane scrollProduct;

    @FXML
    private GridPane gridviewProduct;
    
    @FXML
    private BorderPane borderPaneShop;
    
    public BorderPane getBorderPaneShop() {
		return borderPaneShop;
	}

	public void setBorderPaneShop(BorderPane borderPaneShop) {
		this.borderPaneShop = borderPaneShop;
	}

	private Product product;

    @FXML
    void btnSearch_Click(ActionEvent event) {

    }

    @FXML
    void initialize() {
      
    	  int column = 0;
          int row = 1;
          try {
              for (int i = 0; i < 20; i++) {
                  FXMLLoader fxmlLoader = new FXMLLoader();
                  fxmlLoader.setLocation(getClass().getResource("../views/product.fxml"));
                  AnchorPane anchorPane = fxmlLoader.load();

                  product controller = fxmlLoader.getController();
                  
                  String [] array= {"Umut","umut","umut","umut"};
                  this.product=new Product();
                  this.product.setName("umut");
                  this.product.setDescription("test");
                  this.product.setPrice(1.3);
                  this.product.setImgSrc("../img/computer.jpg");
                  this.product.setFeatures(array);
                  
                  controller.setData(this.product);

                  if (column == 3) {
                      column = 0;
                      row++;
                  }

                  gridviewProduct.add(anchorPane, column++, row); //(child,column,row)
                  //set grid width
                  gridviewProduct.setMinWidth(Region.USE_COMPUTED_SIZE);
                  gridviewProduct.setPrefWidth(Region.USE_COMPUTED_SIZE);
                  gridviewProduct.setMaxWidth(Region.USE_PREF_SIZE);

                  //set grid height
                  gridviewProduct.setMinHeight(Region.USE_COMPUTED_SIZE);
                  gridviewProduct.setPrefHeight(Region.USE_COMPUTED_SIZE);
                  gridviewProduct.setMaxHeight(Region.USE_PREF_SIZE);

                  GridPane.setMargin(anchorPane, new Insets(10));
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
          

    }
}
