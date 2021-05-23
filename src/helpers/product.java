package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import controller.myProfileProductSettings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import middleWares.alertDialog;
import model.tableMyProduct;
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
	
	
	
     public String updateProduct(int id ,String name, String price,String features) {
		
        String InputControl=mwProduct.productUpdateInputControl(id, name, price, features);
 	    if(InputControl != null) {
 	    	return InputControl;
 	    }
 	    
 	   

 		
 		sql="update product set product_name=?,product_price=?,product_features=? where product_id=?";
 		
 		try {
 			
 			 Double dPrice=Double.parseDouble(price);
 			
 		    commandParameter=connect.prepareStatement(sql);
 			commandParameter.setString(1,name);
 			commandParameter.setDouble(2,dPrice);
 			commandParameter.setString(3,features);
 			commandParameter.setInt(4,id);
 			
 			commandParameter.executeUpdate();
 			
 			return null;
 			
 		}catch (Exception e) {
 			// TODO: handle exception
 			System.out.print(e);
 			throw new Error(e);
 			//return "Exception";
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


	public ObservableList<tableMyProduct> getAllMyProduct() {
		
		ObservableList<tableMyProduct> productList=FXCollections.observableArrayList();
		
		sql="select * from product where user_id=? order by product_publishTime desc";
		
		try {
			
			commandParameter=connect.prepareStatement(sql);	
			commandParameter.setInt(1, user.getId());
		
			datas=commandParameter.executeQuery();
			
			while(datas.next()) {
				InputStream inputStream = datas.getBinaryStream("product_image");
				Image img=new Image(inputStream);
				
				Button btnDelete=this.getBtnDelete();
				
				tableMyProduct myProduct=new tableMyProduct(
						datas.getInt("product_id"),
						datas.getInt("user_id"),
						datas.getDouble("product_price"),
						datas.getString("product_name"),
						datas.getString("product_features"),
						datas.getString("product_publishTime"),
						img,
						btnDelete
						);
				
				productList.add(myProduct);
			}
			
			return productList;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
		
	}
	

    private Button getBtnDelete() {
    	
    	Button btnDelete=new Button();
    	btnDelete.setOnAction(this::btnDeleteClick);
    	btnDelete.setText("Sil");
		btnDelete.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-background-radius: 20");
		btnDelete.setPrefWidth(100);
    	
    	return btnDelete;
    }
    
    
    
    @FXML
    private void btnDeleteClick(ActionEvent e) {
    	Button btnDelete=(Button)e.getTarget();
        int id=Integer.parseInt(btnDelete.getId());
       
        Boolean result=alertDialog.AlertQuestion("Ürünü silmek istediðinizden emin misiniz?");
        
        ObservableList<tableMyProduct> selectedMyProduct=FXCollections.observableArrayList();
        if(result) {
        	Boolean deleteResult=new helpers.product().deleteMyProduct(id);
        	if(deleteResult) {
        	for(tableMyProduct myProduct : myProfileProductSettings.datas) {
        		if(myProduct.getId() == id) {
        			selectedMyProduct.add(myProduct);
        		}
        	}
        	selectedMyProduct.forEach(myProfileProductSettings.datas :: remove);
        }
        }
    }
    
    public Boolean deleteMyProduct(int id) {
    	
    	sql="delete from product where product_id=?";
		
		try {
			
			commandParameter=connect.prepareStatement(sql);	
			
			commandParameter.setInt(1, id);

			
			commandParameter.executeUpdate();
			
			return true;
		
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
    	
    }
    
public  boolean isProduct(int id) {
		
		sql="select  * from product where product_id=?";
		
	try {
			
			commandParameter=connect.prepareStatement(sql);
			commandParameter.setInt(1, id);
		
			
			datas=commandParameter.executeQuery();
			
			if(datas.next()) {
				
				return true;
			}
			
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
		
		
	}

public String productImageUpdate(File file,int id) {
	
	if(!(new helpers.product().isProduct(id) )) {
		return "Düzenlemeye çalýþtýðýnýz ürün geçerli deðil";
	}
	
	sql="update product set product_image=? where product_id=?";
	
	try {
		
		FileInputStream fileInputStream=new FileInputStream(file);
		
	    commandParameter=connect.prepareStatement(sql);
		commandParameter.setBinaryStream(1,fileInputStream);
		commandParameter.setInt(2,id);
				
		commandParameter.executeUpdate();
		
		
		return null;
		
	}catch (Exception e) {
		// TODO: handle exception
		System.out.print(e);
		return "Exception";
	}
	

	
}
	
}
