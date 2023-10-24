package org.multi_access_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileController {
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

	public static synchronized void writeLine(String line, File staticFile) {
		synchronized (staticFile) {
			if (staticFile.canWrite()) {
				//try (BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(staticFile)))) {
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

	public static synchronized ArrayList<String> readLines(File staticFile) {
		synchronized (staticFile) {
			if (staticFile.canRead()) {
				try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(staticFile)))) {
					ArrayList<String> lines = new ArrayList<>();
					while (br.ready()) {
						lines.add(br.readLine());
					}

					return lines;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Not can read from the file: " + staticFile.getName() + " in path "
						+ staticFile.getPath());
			}

			return null;
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
