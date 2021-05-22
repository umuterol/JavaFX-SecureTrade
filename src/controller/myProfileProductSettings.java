package controller;

import java.io.File;


import helpers.Control;
import helpers.auth;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.user;
import model.Product;
import model.tableMyProduct;

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
    private TableView<tableMyProduct> tab2Table;
    

    @FXML
    private Label tab1LblResult;
    
    @FXML
    private Label tab2LblResult;
    
    @FXML
    private Label tab2ProductId;
    
    @FXML
    private TableColumn<tableMyProduct, Integer> colProductId;

    @FXML
    private TableColumn<tableMyProduct, String> colProductName;

    @FXML
    private TableColumn<tableMyProduct, String> colProductFeatures;

    @FXML
    private TableColumn<tableMyProduct, Double> colProductPrice;

    @FXML
    private TableColumn<tableMyProduct, String> colProductPublishTime;

    @FXML
    private TableColumn<tableMyProduct, ImageView> colProductImg;
    
    @FXML
    private TableColumn<tableMyProduct, Button> colBtnDelete;


    public static ObservableList<tableMyProduct> datas;
    
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
		
		String name=tab2TxtProductName.getText();
		String price=tab2TxtProductPrice.getText();
		String features=tab2TxtareaProductFeatures.getText();
		int id=Integer.parseInt(tab2ProductId.getText());
	
		String updateControl=new helpers.product().updateProduct(id, name, price, features);
		if(Control.errorControl(updateControl, tab2LblResult)) {
			updateTab2Table(id,name,price,features);
		}

    }
	
	private void updateTab2Table(int id , String name , String price , String feautures) {
		
		for(tableMyProduct myProduct : datas) {
			
			if(myProduct.getId() == id) {
				
				myProduct.setName(name);
				myProduct.setPrice(Double.parseDouble(price));
				myProduct.setFeatures(feautures);
				
				datas.set(datas.indexOf(myProduct), myProduct);
				break;
			}
			
		}
		
	}
	
private void updateImageToTab2Table(int id , Image img) {
		
		for(tableMyProduct myProduct : datas) {
			
			if(myProduct.getId() == id) {
				
				myProduct.setImgView(img);
		
				datas.set(datas.indexOf(myProduct), myProduct);
				break;
			}
			
		}
		
	}

    @FXML
    void Tab2BtnUploadImage_Click(ActionEvent event) {
    	
    	FileChooser filechooser=new FileChooser();
    	filechooser.setTitle("Open File Dialog");
    	Stage stage=(Stage)tabPaneMyProductOperations.getParent().getScene().getWindow();

    	File file=filechooser.showOpenDialog(stage);

    	if(file.isFile()) {
    		Image img=new Image(file.toURI().toString());
    		tab2ImgProduct.setImage(img);
    		
    		int productId=Integer.parseInt(tab2ProductId.getText());
    		
    		String imageUpdateControl=new helpers.product().productImageUpdate(file,productId);
    		
    		if(Control.errorControl(imageUpdateControl, tab2LblResult)) {
    			System.out.print("test");
    			updateImageToTab2Table(productId,img);
    		}
    		
    	}

    }


    @FXML
    void Tab1BtnUploadProduct_Click(ActionEvent event) {
    	
    	String productName=tab1TxtProductName.getText();
    	String productFeatures=tab1TxtareaProductFeatures.getText();
    	String productPrice=tab1TxtProductPrice.getText();
        String productCategory=tab1CbProductCategorySub.getValue();
        String insertControl=new helpers.product().insertProduct(productName, productPrice, productCategory, productFeatures, fileTab1);
        if(Control.errorControl(insertControl, tab1LblResult)) {
        	tab1InputClear();
        	datas.clear();
            datas.setAll(new helpers.product().getAllMyProduct());
        }
    	
    }
    

    @FXML
    void initialize() {	
    	
    	getComboBoxCategoryMain();
    	setTab2Table();
    		
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
    
    private void tab1InputClear() {
    	tab1TxtProductName.clear();
    	tab1TxtProductPrice.clear();
    	tab1TxtareaProductFeatures.clear();
    	tab1CbProductCategorySub.getSelectionModel().clearSelection();
    	tab1CbProductCategoryMain.getSelectionModel().clearAndSelect(0);
    	tab1ImgProduct.setImage(null);
    	fileTab1=null;
    }
    
    private void setTab2Table() {
    	datas=new helpers.product().getAllMyProduct();
    	
    	
    	colProductId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
    	colProductFeatures.setCellValueFactory(new PropertyValueFactory<>("features"));
    	colProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    	colProductPublishTime.setCellValueFactory(new PropertyValueFactory<>("publishTime"));
    	colProductImg.setCellValueFactory(new PropertyValueFactory<>("imgView"));
    	colBtnDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
    	
    	tab2Table.setItems(datas); 
    }
    
    @FXML
    void tab2Table_Click(MouseEvent event) {
    	
    	Product myProduct=new Product();
    	
    	int selectedIndex=tab2Table.getSelectionModel().getSelectedIndex();
    	
    	if(selectedIndex != -1) {
    		
    		myProduct=(tableMyProduct)tab2Table.getItems().get(selectedIndex);
    		
    		tab2ProductId.setText(String.valueOf(myProduct.getId()));
    		tab2TxtProductName.setText(myProduct.getName());
    		tab2TxtProductPrice.setText(String.valueOf(myProduct.getPrice()));
    		tab2TxtareaProductFeatures.setText(myProduct.getFeatures());
    		tab2ImgProduct.setImage(myProduct.getImg());
    		
    	}

    }

    
}
