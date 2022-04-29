package com.myrkgard.tecmclient.model;

import org.json.JSONObject;

public class Folder extends Element {
	public int numberOfChildren = 0;

	public Folder(JSONObject obj) {
		super(obj);
		numberOfChildren = obj.getInt("numberOfChildren");
	}

}
