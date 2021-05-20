package helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.databaseConnect;

public class database {
	
	protected  PreparedStatement commandParameter;
	protected  ResultSet datas;
	protected  String sql;
	protected  Connection connect;
	
	public database() {
		connect=databaseConnect.Connect();
	}
	

}
