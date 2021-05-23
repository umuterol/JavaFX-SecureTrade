package model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class myOrder extends Product{
	
	private int orderNo;
	private String orderDate;
	private String deliveryDate;
	private String deliveryAddress;
	private ImageView imgView;
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryDate() {
	       return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public ImageView getImgView() {
		return imgView;
	}
	public void setImgView(Image img) {
		this.imgView=new ImageView();
		this.imgView.setFitWidth(100);
		this.imgView.setFitHeight(100);
		this.imgView.setImage(img);
	}
	


}
