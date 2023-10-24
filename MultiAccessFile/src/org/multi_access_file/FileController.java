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
				try (BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(staticFile)))) {
					bf.write(line);
					System.out.println("Writed in file " + staticFile.getName() + " the content: \n" + line);

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
