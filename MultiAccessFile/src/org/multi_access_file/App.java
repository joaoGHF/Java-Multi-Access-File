package org.multi_access_file;

import java.io.File;
import java.io.IOException;

public class App {
	public static void main(String[] args) {
		File file = new File("/arq.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("exists   : " + file.exists());
		System.out.println("can write: " + file.canWrite());
	}
}
