package helpers;

import java.io.InputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import model.Product;
import model.dealer;
import model.tableMyProduct;
import model.user;

public class shop extends database {
	

	public ObservableList<Product> getAllProduct() {
		
		ObservableList<Product> productList=FXCollections.observableArrayList();
		
		sql="select * from product  order by product_publishTime desc";
		
		try {
			
			commandParameter=connect.prepareStatement(sql);	
		
			datas=commandParameter.executeQuery();
			
			while(datas.next()) {
				InputStream inputStream = datas.getBinaryStream("product_image");
				Image img=new Image(inputStream);
				
				
				Product product=new Product(
						datas.getInt("product_id"),
						datas.getInt("user_id"),
						datas.getDouble("product_price"),
						datas.getString("product_name"),
						datas.getString("product_features"),
						datas.getString("product_publishTime"),
						img
						);
				
				productList.add(product);
			}
			
			return productList;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
		
	}
	
public  dealer getDealer(int id) {
		
		sql="select  * from user where user_id=?";
		
	try {
			
			commandParameter=connect.prepareStatement(sql);
			commandParameter.setInt(1, id);
		
			
			datas=commandParameter.executeQuery();
			
			if(datas.next()) {
				InputStream inputStream = datas.getBinaryStream("user_profileImage");
				Image img;

				if(inputStream !=null && inputStream.available() > 1) {
					img=new Image(inputStream);
				
				}else {
					img=new Image("/img/defaultProfileImage.png",false);
				}
				
				dealer dealerObject=new dealer();
				
				dealerObject.setName(datas.getString("user_name"));
				dealerObject.setEmail(datas.getString("user_email"));
				dealerObject.setPhone(datas.getString("user_phone"));
				dealerObject.setImg(img);
				
				return dealerObject;
			}
			
			return null;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
		
	}

public ObservableList getAllCity() {
	ObservableList<String> city=FXCollections.observableArrayList();
	
	sql="select CityName from city";
	
	try {
		
		commandParameter=connect.prepareStatement(sql);	
		
		datas=commandParameter.executeQuery();
		
		while(datas.next()) {
			city.add(datas.getString("CityName"));
		}
		
		return city;
		
	} catch (Exception e) {
		// TODO: handle exception
		throw new Error(e);
		
	}	
	
}

public ObservableList getAllTown(String city) {
	ObservableList<String> town=FXCollections.observableArrayList();
	
	sql="select TownName from town where CityID=(select CityID from city where CityName=?) ";
	
	try {
		
		commandParameter=connect.prepareStatement(sql);	
		commandParameter.setString(1, city);
		
		datas=commandParameter.executeQuery();
		
		while(datas.next()) {
			town.add(datas.getString("TownName"));
		}
		
		return town;
		
	} catch (Exception e) {
		// TODO: handle exception
		throw new Error(e);
		
	}	
	
}

public ObservableList getAllBranch(String town) {
	ObservableList<String> branch=FXCollections.observableArrayList();
	
	sql="select DistrictName from district where TownID=(select TownID from town where TownName=?)";
	
	try {
		
		commandParameter=connect.prepareStatement(sql);	
		commandParameter.setString(1, town);
		
		datas=commandParameter.executeQuery();
		
		while(datas.next()) {
			branch.add(datas.getString("DistrictName"));
		}
		
		return branch;
		
	} catch (Exception e) {
		// TODO: handle exception
		throw new Error(e);
		
	}	
	
}
	

}
