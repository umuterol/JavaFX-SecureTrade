package helpers;

import java.io.InputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import model.tableMyProduct;
import model.user;

public class myOrder extends database {
	

	public ObservableList<model.myOrder> getAllMyOrder() {
		
		ObservableList<model.myOrder> orderList=FXCollections.observableArrayList();
		
		sql="select o.* , p.product_name , p.product_price , product_image, d.DistrictName from myorder o , product p , district d where o.product_id=p.product_id "
				+ "and d.DistrictID=o.district_id and  o.user_id=? order by order_date desc";
		
		try {
			
			commandParameter=connect.prepareStatement(sql);	
			
			commandParameter.setInt(1, user.getId());
		
			datas=commandParameter.executeQuery();
			
			while(datas.next()) {
				InputStream inputStream = datas.getBinaryStream("product_image");
				Image img=new Image(inputStream);
				
			    model.myOrder order=new model.myOrder();
			    order.setOrderNo(datas.getInt("order_id"));
		        order.setName(datas.getString("product_name"));
		        order.setOrderDate(datas.getString("order_date"));
		        order.setDeliveryDate(datas.getString("order_deliveryDate"));
		        order.setDeliveryAddress(datas.getString("DistrictName") + " Þubesi");
		        order.setImgView(img);
		        order.setPrice(datas.getInt("product_price"));
				
				orderList.add(order);
			}
			
			return orderList;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Error(e);
			
		}	
		
	}
	

}
