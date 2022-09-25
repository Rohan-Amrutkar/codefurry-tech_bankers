package com.codefury.service;

import org.json.JSONArray;

import com.codefury.model.beans.Asset;

public interface AssetDao {
	public void addAsset(Asset asset);
	public JSONArray overdueAssetMgmt();
}
