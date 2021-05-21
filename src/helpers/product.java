package helpers;

import java.io.File;
import java.io.FileInputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.user;

public class product extends database{
	
	private middleWares.product mwProduct;
	
	public ObservableList getAllTopCategory() {
		ObservableList<String> category=FXCollections.observableArrayList();
		
		sql="select * from category where category_top=-1 ";
		
		try {
			
			commandParameter=connect.prepareStatement(sql);	
			
			datas=commandParameter.executeQuery();
			
			while(datas.next()) {
				category.add(datas.getString("category_name"));
			}
			
			return category;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
		
	}
	
	public ObservableList getAllSubCategory(String topCategory) {
		ObservableList<String> category=FXCollections.observableArrayList();
		
		sql="select * from category where category_top=(select category_id from category where category_name=?) ";
		
		try {
			
			commandParameter=connect.prepareStatement(sql);	
			commandParameter.setString(1, topCategory);
			
			datas=commandParameter.executeQuery();
			
			while(datas.next()) {
				category.add(datas.getString("category_name"));
			}
			
			return category;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
		
	}
	
	public String insertProduct(String name, String price,String category,String features,File file) {
		
		String InputControl=mwProduct.productInsertInputControl(name, price, category, features, file);
	    if(InputControl != null) {
	    	return InputControl;
	    }
	    
	   
		
		sql="insert into product set product_name=?,product_price=?,product_image=?,product_features=?,user_id=?,category_id=?";
		
		try {
			
			 Double dPrice=Double.parseDouble(price);
			 int categoryId=new product().getCategoryId(category);
			 FileInputStream fileInputStream=new FileInputStream(file);
			
		    commandParameter=connect.prepareStatement(sql);
			commandParameter.setString(1,name);
			commandParameter.setDouble(2,dPrice);
			commandParameter.setBinaryStream(3,fileInputStream);
			commandParameter.setString(4,features);
			commandParameter.setInt(5,user.getId());
			commandParameter.setInt(6,categoryId);
			
			commandParameter.executeUpdate();
			
			
			return null;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return "Exception";
		} 
		
	} 
	
	private int getCategoryId(String categoryName) {
		sql="select category_id from category where category_name=?";
		
		try {
			
			commandParameter=connect.prepareStatement(sql);	
			commandParameter.setString(1, categoryName);
			
			datas=commandParameter.executeQuery();
			
			if(datas.next()) {
				return (datas.getInt("category_id"));
			}

			return -1;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
		}	
		
	}


}
