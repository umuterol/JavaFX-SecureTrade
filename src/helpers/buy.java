package helpers;

import java.io.File;
import java.io.FileInputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Product;
import model.dealer;
import model.user;

public class buy extends database {
	
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
	
	private int getDistrictId(String districtName) {
		sql="select DistrictID from district where DistrictName=?";
		
		try {
			
			commandParameter=connect.prepareStatement(sql);	
			commandParameter.setString(1, districtName);
			
			datas=commandParameter.executeQuery();
			
			if(datas.next()) {
				return (datas.getInt("DistrictID"));
			}

			return -1;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
		}	
	}
	
public String insertMyOrder(Product product , dealer dealerObject , String clientName , String clientPhone , String branch,String cardNo,String cardCvv,String deliveryDate) {
		
		String InputControl=middleWares.buy.buyInputControl(product ,dealerObject ,clientName ,clientPhone ,branch,cardNo,cardCvv);
	    if(InputControl != null) {
	    	return InputControl;
	    }
	    
	    int district_id=new buy().getDistrictId(branch);
		
		sql="insert into myorder set product_id=? , user_id=? , order_clientName=? , order_clientPhone=? , order_deliveryDate=? , district_id=?";
		
		try {
			
			
		    commandParameter=connect.prepareStatement(sql);
			commandParameter.setInt(1,product.getId());
			commandParameter.setInt(2,user.getId());
			commandParameter.setString(3,clientName);
			commandParameter.setString(4,clientPhone);
			commandParameter.setString(5, deliveryDate);
			commandParameter.setInt(6,district_id);
			
			commandParameter.executeUpdate();
			
			return null;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return "Exception";
		} 
		
	} 
	
		

}
