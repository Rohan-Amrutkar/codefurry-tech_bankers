package com.codefury.service;

import org.json.JSONArray;

import com.codefury.model.beans.User;

public interface UserDao {
	public JSONArray getMyAssets(int uid);
	public JSONArray getAvailableAssets();
	public void allocateAsset(int userid, int assetid);
	public void returnAsset(int userid, int assetid);
}
