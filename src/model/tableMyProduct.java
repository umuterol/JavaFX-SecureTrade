package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class tableMyProduct extends Product{
	
	private Button btnDelete;
	private ImageView imgView;
	
	public tableMyProduct(int id , int dealerId , double price, String name , String features , String puslishTime , Image img , Button btnDelete) {
		
		super(id ,dealerId , price, name , features , puslishTime , img );
		
		this.setBtnDelete(btnDelete);
		this.setImgView(img);
		
		}

	
	public ImageView getImgView() {
		return imgView;
	}

	public void setImgView(Image img) {
		this.imgView=new ImageView();
		this.imgView.setFitWidth(150);
		this.imgView.setFitHeight(100);
		this.imgView.setImage(img);
	}

	public Button getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(Button btnDelete) {
		this.btnDelete = btnDelete;
		this.btnDelete.setId(String.valueOf(super.getId()));
	}


 
}