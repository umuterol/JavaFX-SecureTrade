package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Product {
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDealerId() {
		return dealerId;
	}
	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	private int id;
	private Image img;
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	private String name;
	private String features;
	private double price;
	private int dealerId;
	private String publishTime;
	
	public Product(int id , int dealerId , double price, String name , String features , String puslishTime , Image img ) {
		this.setId(id);
		this.setDealerId(dealerId);
		this.setPrice(price);
		this.setName(name);
		this.setFeatures(features);
		this.setPublishTime(puslishTime);
		this.setImg(img);
		
	}
	
	public Product() {}
}
