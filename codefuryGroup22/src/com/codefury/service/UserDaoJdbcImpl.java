package com.codefury.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserDaoJdbcImpl implements UserDao {

	@Override
	public JSONArray getMyAssets(int userId) {
		// TODO Auto-generated method stub
		JSONArray jsonArray = null;
		try 
        {  
        	Connection conn = null;
        	DBConnection dbConn = new DBConnection();
			conn = dbConn.getConn();
        	String query = "select user.id as uid, asset.id as assetid, asset.name as assetname, asset_type.type, asset_type.period, DATEDIFF(CURDATE(), asset.date_allocated) as date_difference, asset_type.days_ban, asset_type.late_fee, messages.message from user inner join allocation on user.id=allocation.user_id inner join asset on allocation.asset_id=asset.id left join asset_type on asset.type=asset_type.id left join messages on asset.id=messages.asset_id where user.id= ?;";
        	PreparedStatement ppst =  conn.prepareStatement(query);
        	ppst.setInt(1, userId);
            ResultSet rs = ppst.executeQuery();
     
            jsonArray = new JSONArray();
            while (rs.next()) {
                int columns = rs.getMetaData().getColumnCount();
                JSONObject obj = new JSONObject();
         
                for (int i = 0; i < columns; i++)
                {
                	obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));
                }
                    
         
                jsonArray.put(obj);
            }
            rs.close();
            ppst.close();
            conn.close();
            return jsonArray;
         }catch(Exception e)
		{
        	 e.printStackTrace();
		}
		return jsonArray;
	}

	@Override
	public JSONArray getAvailableAssets() {
		// TODO Auto-generated method stub
		JSONArray jsonArray = null;
		try 
        {  
        	Connection conn = null;
        	DBConnection dbConn = new DBConnection();
			conn = dbConn.getConn();
        	String query = "select asset.id as ast_id, asset.name, asset.type, asset.description, asset.is_available, asset.date_added, asset_type.type as typestr from asset left join asset_type on asset.type = asset_type.id where is_available=1;";
        	PreparedStatement ppst =  conn.prepareStatement(query);
            ResultSet rs = ppst.executeQuery();
     
            jsonArray = new JSONArray();
            while (rs.next()) {
         
                int columns = rs.getMetaData().getColumnCount();
                JSONObject obj = new JSONObject();
         
                for (int i = 0; i < columns; i++)
                    obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));
         
                jsonArray.put(obj);
            }
            rs.close();
            ppst.close();
            conn.close();
            return jsonArray;
         }catch(Exception e)
		{
        	 e.printStackTrace();
		}
		return jsonArray;
	}

	@Override
	public void allocateAsset(int userId, int assetId)
	{
		try 
        {  
        	Connection conn = null;
        	DBConnection dbConn = new DBConnection();
			conn = dbConn.getConn();
        	String query1 = "insert into allocation(user_id, asset_id) values(?, ?);";
        	PreparedStatement ppst =  conn.prepareStatement(query1);
        	ppst.setInt(1, userId);
            ppst.setInt(2, assetId);
            int rows1 = ppst.executeUpdate();
            
            String query2 = "update asset SET is_available=0 where id=?;";
            ppst =  conn.prepareStatement(query2);
            ppst.setInt(1, assetId);
            int rows2 = ppst.executeUpdate();
            
            ppst.close();
            conn.close();
         }catch(Exception e)
		{
        	 e.printStackTrace();
		}
	}

	@Override
	public void returnAsset(int userId, int assetId) {
		// TODO Auto-generated method stub
		try 
        {  
        	Connection conn = null;
        	DBConnection dbConn = new DBConnection();
			conn = dbConn.getConn();
			System.out.println("hello1");
        	String query1 = "delete from allocation where asset_id=? ;";
        	PreparedStatement ppst =  conn.prepareStatement(query1);
            ppst.setInt(1, assetId);
            int rows1 = ppst.executeUpdate();
            System.out.println("hello2");
            String query2 = "update asset SET is_available=1 where id=?;";
            ppst =  conn.prepareStatement(query2);
            ppst.setInt(1, assetId);
            int rows2 = ppst.executeUpdate();
            
            String query3 = "delete from messages where asset_id =?;";
            ppst =  conn.prepareStatement(query3);
            ppst.setInt(1, assetId);
            int rows3 = ppst.executeUpdate();
            
            ppst.close();
            conn.close();
         }catch(Exception e)
		{
        	 e.printStackTrace();
		}
	}
}
