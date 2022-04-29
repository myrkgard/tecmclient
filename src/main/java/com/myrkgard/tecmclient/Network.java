package com.myrkgard.tecmclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;

import org.json.JSONObject;

import com.myrkgard.tecmclient.model.ChildrenResponse;
import com.myrkgard.tecmclient.model.Folder;

public class Network {

	private static JSONObject fetch(String url) throws URISyntaxException, IOException, InterruptedException {
		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return new JSONObject(response.body());
	}

	public static Folder fetchRoot() throws URISyntaxException, IOException, InterruptedException {
		JSONObject obj = fetch("http://localhost:8080/root");
		return new Folder(obj);
	}

	public static ChildrenResponse fetchChildren(String folderId)
			throws URISyntaxException, IOException, InterruptedException {
		JSONObject obj = fetch("http://localhost:8080/children/" + folderId);
		return new ChildrenResponse(obj);

	}
	
}
