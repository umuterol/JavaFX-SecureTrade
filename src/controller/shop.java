package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import database.databaseConnect;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import model.Product;
import model.tableMyProduct;
import model.user;

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
    
    @FXML
    private MenuItem dropdownProfilSettings;

    @FXML
    private MenuItem dropdownLogout;
    
    private ObservableList<Product> datas;
    
    @FXML
    private Circle circleProfileImage;
    
    
    public BorderPane getBorderPaneShop() {
		return borderPaneShop;
	}

	public void setBorderPaneShop(BorderPane borderPaneShop) {
		this.borderPaneShop = borderPaneShop;
	}



    @FXML
    void initialize() {
    	
    	getAllProduct(new helpers.product().getAllProduct());
        getProfileImageFromUser();
          		
    }
    
    private void getAllProduct(ObservableList<Product> newDatas) { 
    	
    	  gridviewProduct.getChildren().clear();
    	
    	  int column = 0;
          int row = 1;
          
          datas=newDatas;
          
          try {
              for (Product product : datas) {
                  FXMLLoader fxmlLoader = new FXMLLoader();
                  fxmlLoader.setLocation(getClass().getResource("../views/product.fxml"));
                  AnchorPane anchorPane = fxmlLoader.load();

                  product controller = fxmlLoader.getController();
                  
                
                  
                  controller.setData(product);

                  if (column == 6) {
                	  row++;
                      column = 0;
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
    
    
    @FXML
    void dropdownLogout_Click(ActionEvent event) {
    	user.clear();
    	try {
 	    	
   		    FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../views/index.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            index controller = fxmlLoader.getController();
            
            
            AnchorPane thisAnchor=(AnchorPane)borderPaneShop.getParent();
            thisAnchor.getChildren().setAll(controller.getBorderPaneIndex());
    	    
   	  
   		
   		} catch(Exception e) {
   			e.printStackTrace();
   		}

    }

    @FXML
    void dropdownProfilSettings_Click(ActionEvent event) {
    	
    	try {
 	    	
   		    FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../views/profileSettings.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            profileSettings controller = fxmlLoader.getController();
            
            
            AnchorPane thisAnchor=(AnchorPane)borderPaneShop.getParent();
            thisAnchor.getChildren().setAll(controller.getBorderPaneProfileSettings());
    	    
   	  
   		
   		} catch(Exception e) {
   			e.printStackTrace();
   		}

		 


    }
    
    private void getProfileImageFromUser() {
    	circleProfileImage.setFill(new ImagePattern(user.getImg()));
    }
    

    private void getProductWithFilter(String searchData){
    	if(new helpers.product().getProductWithFilter(searchData) == null) {
    		productNotFound();
    		return;
    	}
    	this.getAllProduct(new helpers.product().getProductWithFilter(searchData));
    }
    
    private void productNotFound() {
    	gridviewProduct.getChildren().clear();
    	
    	Label message=new Label(" ?zg?n?z arad???n?z ?r?n? bulamad?k :(");
    	message.setPadding(new Insets(10));
		gridviewProduct.addRow(0,message);
    }
    
    @FXML
    void txtSearch_Enter(ActionEvent event) {
    	String search=txtSearch.getText().trim();
    	this.getProductWithFilter(search);
    }
    
    @FXML
    void btnSearch_Click(ActionEvent event) {
    	String search=txtSearch.getText().trim();
    	this.getProductWithFilter(search);
    }
    

    @FXML
    void home_Click(MouseEvent event) {
    	getAllProduct(new helpers.product().getAllProduct());

    }
   
}
