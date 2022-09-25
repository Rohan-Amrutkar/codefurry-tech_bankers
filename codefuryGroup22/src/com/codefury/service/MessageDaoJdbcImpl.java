package com.codefury.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.codefury.model.beans.Message;

public class MessageDaoJdbcImpl implements MessageDao {

	@Override
	public void saveMessage(Message messageOb) {
		Connection conn = null; 
		try {
			DBConnection dbConn = new DBConnection();
			conn = dbConn.getConn();
			String query = "insert into messages(user_id, asset_id, message, added_date) values(?, ?, ?, ?);";
			PreparedStatement ppst = conn.prepareStatement(query);
			ppst.setInt(1, messageOb.getUserId());
			ppst.setInt(2, messageOb.getAssetId());
			ppst.setString(3, messageOb.getMessage());
			ppst.setDate(4, Date.valueOf(messageOb.getDateAdded()));
			int rows = ppst.executeUpdate();
			
			System.out.println(rows+" rows are updated");
			ppst.close();
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println("Exception at messagedao");
			e.printStackTrace();
		}
		
		
	}

}
