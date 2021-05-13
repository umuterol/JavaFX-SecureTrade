package model;


public class Product {
	
	
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getFeatures() {
		return features;
	}
	public void setFeatures(String[] features) {
		this.features = features;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	private String imgSrc;
	private String name;
	private String[] features;
	private String description;
	private double price;
	
}
