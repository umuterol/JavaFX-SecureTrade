package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class myOrder {

    @FXML
    private VBox vboxMyOrder;

    @FXML
    private TableView<?> tableViewOrder;

    @FXML
    private TableColumn<?, ?> columnOrderNo;

    @FXML
    private TableColumn<?, ?> columnOrderName;

    @FXML
    private TableColumn<?, ?> columnOrderDate;

    @FXML
    private TableColumn<?, ?> columnDeliveryDate;

    public VBox getVboxMyOrder() {
		return vboxMyOrder;
	}

	public void setVboxMyOrder(VBox vboxMyOrder) {
		this.vboxMyOrder = vboxMyOrder;
	}

	@FXML
    private TableColumn<?, ?> columnDeliveryAddress;

    @FXML
    private TableColumn<?, ?> columnOrderProductImg;

}
