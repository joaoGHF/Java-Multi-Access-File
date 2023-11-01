package org.multi_access_file;

import java.io.File;
import java.util.ArrayList;
/**
 * <p>
 * The class {@code App} is the main class of this project. The
 * {@code MultiAccessFile} program create (if not created) a file with a
 * {@code File} object that will receive the pathname {@code "arq.txt"} and is
 * located in the root path of the project, next will initialize and clear the
 * file using the statics methods: {@code FileController.initFile(File)} and
 * {@code FileController.clearFile(File)}. Will store in a
 * {@code ArrayList<Thread>} a amount of {@code WriteThread} objects and finally
 * start each thread in a for each loop.
 * </p>
 * 
 * @see org.multi_access_file.FileController
 * @see org.multi_access_file.WriteThread
 * @see java.util.ArrayList
 * @see java.lang.Thread
 * 
 * @author joaoGHF
 * @version 1.0.0
 */
public class App {
	/**
	 * <p>
	 * Defines the number of threds {@code WriteThread} that will be created in the
	 * execution of the main method.
	 * </p>
	 * 
	 * @see org.multi_access_file.WriteThread
	 */
	private static final int NUMBER_THREADS = 100;

	/**
	 * <p>
	 * The main method of the program. Responsible for create, initialize and clear
	 * the file; also responsible for create, initialize and start all subsequent
	 * threads.
	 * </p>
	 * 
	 * @param args are dont used in this program.
	 * 
	 * @see org.multi_access_file.FileController#initFile(File)
	 * @see org.multi_access_file.FileController#clearFile(File)
	 * @see org.multi_access_file.WriteThread
	 */
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
