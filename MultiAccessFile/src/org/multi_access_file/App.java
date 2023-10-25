package org.multi_access_file;

import java.io.File;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		File file = new File("arq.txt");

		System.out.println("exists   : " + file.exists());
		System.out.println("can write: " + file.canWrite());

		FileController.initFile(file);
		FileController.clearFile(file);

		ArrayList<Thread> writeThreads = new ArrayList<>();
		for (int i = 0; i < 100; i++) { // TODO: criar var para armazenar o numero de threds writers
			writeThreads.add(new WriteThread(file));
		}

		for (Thread writeThread : writeThreads) {
			writeThread.start();
		}

		// TODO: criar e utilizar uma Thread para leitura do arquivo

		/*System.out.println("\nReading");
		FileController.readLines(file).forEach(System.out::println);*/
	}
}
