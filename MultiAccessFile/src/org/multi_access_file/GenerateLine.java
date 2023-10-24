package org.multi_access_file;

import java.util.Random;

public abstract class GenerateLine {
	private GenerateLine() {
	}

	private static final Random random = new Random();

	public static String getLine(int maxSize) {
		int size = random.nextInt(maxSize);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			sb.append((char) random.nextInt(128));
		}

		return sb.toString();
	}

	public static String[] getLines(int maxSize, int lines) {
		String[] strArray = new String[lines];

		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = getLine(maxSize);
		}

		return strArray;
	}
}
