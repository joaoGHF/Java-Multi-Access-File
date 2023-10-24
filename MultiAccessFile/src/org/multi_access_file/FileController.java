package org.multi_access_file;

import java.io.File;
import java.io.IOException;

public class FileController {
	private File file;
	
	public FileController(File file) {
		this.file = file;
		
		if (this.file.exists()) {
			System.out.println("Arquivo existente...");
		} else
			try {
				if (this.file.createNewFile()) {
					System.out.println("Arquivo criado");
				} else {
					System.out.println("Erro ao criar arquivo");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
