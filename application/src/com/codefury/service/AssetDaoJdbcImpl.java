package com.codefury.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.codefury.model.beans.Asset;


public class AssetDaoJdbcImpl implements AssetDao {

	@Override
	public void addAsset(Asset assetOb) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		try {
			DBConnection dbConn = new DBConnection();
			conn = dbConn.getConn();
			String query = "insert into asset(name, type, description, date_added, is_available, date_allocated) values(?, ?, ?, ?, ?, null)";
			PreparedStatement ppst = conn.prepareStatement(query);
			
			ppst.setString(1, assetOb.getName());
			ppst.setInt(2, assetOb.getType());
			ppst.setString(3, assetOb.getDescription());
			ppst.setDate(4, Date.valueOf(assetOb.getDateAdded()));
			ppst.setInt(5, assetOb.getIsAvailable());
			//ppst.setInt(7, assetOb.getAllocatedTo());
			int rows = ppst.executeUpdate();
			
			System.out.println(rows+" rows are updated");
			ppst.close();
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println("Exception at dao");
			e.printStackTrace();
		}
		
	}


	@Override
	public JSONArray overdueAssetMgmt() {
		// TODO Auto-generated method stub
		JSONArray jsonArray = null;
		try 
        {  
        	Connection conn = null;
        	DBConnection dbConn = new DBConnection();
			conn = dbConn.getConn();
        	String query = "select user.id as uid, user.name as uname, asset.id as assetid, asset.name as assetname, asset_type.type, asset_type.period, DATEDIFF(CURDATE(), asset.date_allocated) as date_difference, asset_type.days_ban, asset_type.late_fee from user inner join allocation on user.id=allocation.user_id inner join asset on allocation.asset_id=asset.id left join asset_type on asset.type=asset_type.id where is_available=0 having date_difference > asset_type.period;";
        	PreparedStatement ppst =  conn.prepareStatement(query);;
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

}
