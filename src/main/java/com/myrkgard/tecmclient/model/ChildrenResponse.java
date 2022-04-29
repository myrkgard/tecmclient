package com.myrkgard.tecmclient.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChildrenResponse {
	public List<Folder> folders;
	public List<Document> documents;
	
	public ChildrenResponse(JSONObject obj) {
		{
			JSONArray arr = obj.optJSONArray("folders");
			if (arr != null) {
				folders = new ArrayList<Folder>();
				for (int i = 0; i < arr.length(); ++i) {
					Folder folder = new Folder(arr.getJSONObject(i));
					folders.add(folder);
				}
				folders = folders.isEmpty() ? null : folders;
			}
		}
		{
			JSONArray arr = obj.optJSONArray("documents");
			if (arr != null) {
				documents = new ArrayList<Document>();
				for (int i = 0; i < arr.length(); ++i) {
					Document document = new Document(arr.getJSONObject(i));
					documents.add(document);
				}
				documents = documents.isEmpty() ? null : documents;
			}
		}
	}
	
}
