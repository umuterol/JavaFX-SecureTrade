package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

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
    private ComboBox<?> tab1CbProductCategoryMain;

    @FXML
    private ComboBox<?> tab1CbProductCategorySub;

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
    void Tab1BtnUploadImage_Click(ActionEvent event) {

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
    void btnProfileSaveChanged_Click(ActionEvent event) {

    }

}
