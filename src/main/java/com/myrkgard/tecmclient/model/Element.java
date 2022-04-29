package com.myrkgard.tecmclient.model;

import org.json.JSONObject;

public abstract class Element {
	public String id;
	public String parentId;
	public String name;
	
	public Element(JSONObject obj) {
		id = obj.getString("id");
		parentId = obj.optString("parentId", null);
		name = obj.getString("name");
	}
}
