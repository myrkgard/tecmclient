package com.myrkgard.tecmclient.model;

import org.json.JSONObject;

public class Document extends Element {
	public int size = 0;

	public Document(JSONObject obj) {
		super(obj);

		// parentId is optional in Element but required here. 
		// Just parse it again to get an exception if it's null.
		parentId = obj.getString("parentId");

		size = obj.getInt("size");
	}

}
