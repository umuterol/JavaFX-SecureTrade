package controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Product;
import model.tableMyProduct;
import model.user;

public class myOrder {

    @FXML
    private VBox vboxMyOrder;

    @FXML
    private TableView<model.myOrder> tableViewOrder;

    @FXML
    private TableColumn<model.myOrder, Integer> columnOrderNo;

    @FXML
    private TableColumn<model.myOrder, String> columnOrderName;

    @FXML
    private TableColumn<model.myOrder,String> columnOrderDate;

    @FXML
    private TableColumn<model.myOrder, String> columnDeliveryDate;
    
    @FXML
    private TableColumn<model.myOrder, String> columnDeliveryAddress;

    @FXML
    private TableColumn<model.myOrder, ImageView> columnOrderProductImg;
    
    @FXML
    private TableColumn<model.myOrder, Double> columnOrderProductPrice;
    
    
    private ObservableList<model.myOrder> datas;

    public VBox getVboxMyOrder() {
		return vboxMyOrder;
	}

	public void setVboxMyOrder(VBox vboxMyOrder) {
		this.vboxMyOrder = vboxMyOrder;
	}

	@FXML
	void initialize() {
		setTable();
	}
    
    private void setTable() {
    	datas=new helpers.myOrder().getAllMyOrder();
    	
    	columnOrderNo.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
    	columnOrderName.setCellValueFactory(new PropertyValueFactory<>("name"));
    	columnOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
    	columnDeliveryDate.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
    	columnDeliveryAddress.setCellValueFactory(new PropertyValueFactory<>("deliveryAddress"));
    	columnOrderProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    	columnOrderProductImg.setCellValueFactory(new PropertyValueFactory<>("imgView"));
    	
    	tableViewOrder.setItems(datas); 
    }
    

}
