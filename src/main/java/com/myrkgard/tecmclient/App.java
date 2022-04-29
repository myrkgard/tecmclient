package com.myrkgard.tecmclient;

import java.io.IOException;
import java.net.URISyntaxException;
import com.myrkgard.tecmclient.model.Folder;

public class App {
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException  {
		Folder root = Network.fetchRoot();
		Terminal.printAllElements(root);
	}	
}
