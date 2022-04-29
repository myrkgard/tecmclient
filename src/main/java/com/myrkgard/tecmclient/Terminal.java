package com.myrkgard.tecmclient;

import java.io.IOException;
import java.net.URISyntaxException;

import com.myrkgard.tecmclient.model.ChildrenResponse;
import com.myrkgard.tecmclient.model.Document;
import com.myrkgard.tecmclient.model.Folder;

public class Terminal {
	static void printAllElements(Folder rootFolder) throws URISyntaxException, IOException, InterruptedException {
		String currentPath = rootFolder.name;
		System.out.printf("f %s %s\n", rootFolder.id, currentPath);
		printChildren(Network.fetchChildren(rootFolder.id), currentPath);
	}

	private static void printFolder(Folder folder, String parentPath)
			throws URISyntaxException, IOException, InterruptedException {
		String currentPath = parentPath + "/" + folder.name;
		System.out.printf("f %s %s\n", folder.id, currentPath);
		printChildren(Network.fetchChildren(folder.id), currentPath);
	}

	private static void printDocument(Document document, String parentPath) {
		String currentPath = parentPath + "/" + document.name;
		System.out.printf("d %s %s\n", document.id, currentPath);
	}

	private static void printChildren(ChildrenResponse children, String parentPath)
			throws URISyntaxException, IOException, InterruptedException {
		if (children.folders != null) {
			for (Folder folder : children.folders) {
				printFolder(folder, parentPath);
			}
		}
		if (children.documents != null) {
			for (Document document : children.documents) {
				printDocument(document, parentPath);
			}
		}
	}

}
