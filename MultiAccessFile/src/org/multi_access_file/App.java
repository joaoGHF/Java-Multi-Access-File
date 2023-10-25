package org.multi_access_file;

import java.io.File;
import java.util.ArrayList;

public class App {
	private static final int NUMBER_THREADS = 100;
	public static void main(String[] args) {
		File file = new File("arq.txt");

		FileController.initFile(file);
		FileController.clearFile(file);

		ArrayList<Thread> writeThreads = new ArrayList<>();
		for (int i = 0; i < NUMBER_THREADS; i++) {
			writeThreads.add(new WriteThread(file));
		}

		for (Thread writeThread : writeThreads) {
			writeThread.start();
		}
	}
}
