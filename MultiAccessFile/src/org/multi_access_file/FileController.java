package org.multi_access_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>
 * The {@code FileController} class is a abstract class, with all methods
 * static. {@code FileController} have the methods {@code initFile(File)},
 * {@code writeLine(String, File)} and {@code clearFile(File)}. The last two
 * mentioned methods are synchronizeds, but the first isn't because they are
 * invoked only in the init of the program flow and have no risk of corrupting.
 * </p>
 * 
 * @see org.multi_access_file.FileController#initFile(File)
 * @see org.multi_access_file.FileController#writeLine(String, File)
 * @see org.multi_access_file.FileController#clearFile(File)
 */
public abstract class FileController {
	/**
	 * <p>
	 * The method {@code initFile(File)} receive as a parameter a {@code File}
	 * object. If the file exists, the method will print it, else the method will
	 * try create the file. Warning! This method is unsynchronized.
	 * </p>
	 * 
	 * @param file is a {@code File} object, must be an file, not a directory.
	 */
	public static void initFile(File file) {
		if (file.exists()) {
			System.out.println("Arquivo existente...");
		} else
			try {
				if (file.createNewFile()) {
					System.out.println("Arquivo criado");
				} else {
					System.out.println("Erro ao criar arquivo");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	/**
	 * <p>
	 * The method {@code writeLine(String, File)} is a synchronized method that will
	 * try create a {@code BufferedWriter} using as parameter a {@code FileWriter} with the... // TODO: continue here
	 * </p>
	 * 
	 * @param line       is of the type {@code String} and represents the to be
	 *                   writed.
	 * @param staticFile is of the type {@code File} and is the file that will be
	 *                   writed the line.
	 */
	public static synchronized void writeLine(String line, File staticFile) {
		synchronized (staticFile) {
			if (staticFile.canWrite()) {
				try (BufferedWriter bf = new BufferedWriter(new FileWriter(staticFile, true))) {
					bf.write(line);
					bf.newLine();
					System.out.println("Added in file " + staticFile.getName() + " the content: \n" + line);

				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("Not can write in file: " + staticFile.getName() + " in path "
						+ staticFile.getPath());
			}
		}
	}

	public static void clearFile(File staticFile) {
		synchronized (staticFile) {
			if (staticFile.canWrite()) {
				try (BufferedWriter bf = new BufferedWriter(new FileWriter(staticFile, false))) {
					bf.write("");
					System.out.println("Cleared the file " + staticFile.getName());

				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("Not can write in file: " + staticFile.getName() + " in path "
						+ staticFile.getPath());
			}
		}
	}
}
