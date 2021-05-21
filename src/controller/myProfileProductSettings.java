package controller;

import java.io.File;

import helpers.Control;
import helpers.auth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.user;

public class myProfileProductSettings {

    @FXML
    private TabPane tabPaneMyProductOperations;

    @FXML
    private VBox vboxMenuPassword;

    @FXML
    private ImageView tab1ImgProduct;

    @FXML
    private Button Tab1BtnUploadImage;

    @FXML
    private TextField tab1TxtProductName;

    @FXML
    private TextField tab1TxtProductPrice;

    @FXML
    private ComboBox<String> tab1CbProductCategoryMain;

    @FXML
    private ComboBox<String> tab1CbProductCategorySub;

    @FXML
    private TextArea tab1TxtareaProductFeatures;

    @FXML
    private Button Tab1BtnUploadProduct;

    @FXML
    private VBox vboxMenuPassword1;

    @FXML
    private ImageView tab2ImgProduct;

    @FXML
    private Button Tab2BtnUploadImage;

    @FXML
    private TextField tab2TxtProductName;

    @FXML
    private TextField tab2TxtProductPrice;

    @FXML
    private TextArea tab2TxtareaProductFeatures;

    @FXML
    private Button Tab2BtnUpdateProduct;

    @FXML
    private TableView<?> tab2Table;
    

    @FXML
    private Label tab1LblResult;

    
    private File fileTab1=null;

    @FXML
    void Tab1BtnUploadImage_Click(ActionEvent event) {
    	
    	FileChooser filechooser=new FileChooser();
    	filechooser.setTitle("Open File Dialog");
    	Stage stage=(Stage)tabPaneMyProductOperations.getParent().getScene().getWindow();

    	File file=filechooser.showOpenDialog(stage);

    	if(file.isFile()) {
    		Image img=new Image(file.toURI().toString());
    		tab1ImgProduct.setImage(img);
    	    fileTab1=file;		
    	}
    	
    }

    public TabPane getTabPaneMyProductOperations() {
		return tabPaneMyProductOperations;
	}

	public void setTabPaneMyProductOperations(TabPane tabPaneMyProductOperations) {
		this.tabPaneMyProductOperations = tabPaneMyProductOperations;
	}

	@FXML
    void Tab2BtnUpdateProduct_Click(ActionEvent event) {

    }

    @FXML
    void Tab2BtnUploadImage_Click(ActionEvent event) {

    }


    @FXML
    void Tab1BtnUploadProduct_Click(ActionEvent event) {
    	
    	String productName=tab1TxtProductName.getText();
    	String productFeatures=tab1TxtareaProductFeatures.getText();
    	String productPrice=tab1TxtProductPrice.getText();
        String productCategory=tab1CbProductCategorySub.getValue();
        String insertControl=new helpers.product().insertProduct(productName, productPrice, productCategory, productFeatures, fileTab1);
        if(Control.errorControl(insertControl, tab1LblResult)) {
        	
        }
    	
    }
    

    @FXML
    void initialize() {	
    	
    	getComboBoxCategoryMain();
    		
    }
    
    
    private void getComboBoxCategoryMain() {
    	
    	tab1CbProductCategoryMain.setPromptText("Ürünün kategorisini Seçin");
        tab1CbProductCategoryMain.getItems().addAll(new helpers.product().getAllTopCategory());
    	
    }
    

    @FXML
    void tab1CbProductCategoryMain_Selected(ActionEvent event) {
    	
    	tab1CbProductCategorySub.setVisible(true);
    	tab1CbProductCategorySub.setPromptText("Kategori Seçimi");
    	
    	String selectedTopCategory=tab1CbProductCategoryMain.getSelectionModel().getSelectedItem().toString();
        tab1CbProductCategorySub.getItems().setAll(new helpers.product().getAllSubCategory(selectedTopCategory));
    }
    

}
