package org.multi_access_file;

import java.io.File;

public class App {
	public static void main(String[] args) {
		File file = new File("arq.txt");

		System.out.println("exists   : " + file.exists());
		System.out.println("can write: " + file.canWrite());

		FileController.initFile(file);
		FileController.writeLine(GenerateLine.getLine(50), file);
	}
}
