package org.multi_access_file;

import java.util.Random;

/**
 * <p>
 * The {@code GenerateLine} class is an abstract class that offer the methods to
 * get a {@code String} or a {@code String[]} with random characters. This class
 * have the methods {@code String getLine(int maxSize)} and
 * {@code String[] getLines(int maxSize, int lines)}, both static.
 * </p>
 */
public abstract class GenerateLine {
	/**
	 * <p>
	 * The attribute {@code BOUND} is a private static final int, that represents
	 * the bound size for chars used in the {@link GenerateLine#getLine(int)}.
	 * </p>
	 */
	private static final int BOUND = 1024;

	/**
	 * <p>
	 * The attribute {@code random} is an instance of the class {@code Random} used
	 * in the method {@link GenerateLine#getLine(int)} to get a randomic {@code int}
	 * then will be converted in a {@code char}.
	 * </p>
	 */
	private static final Random random = new Random();

	/**
	 * <p>
	 * The method {@code GenerateLine()} is a private constructor used to prevent
	 * the instatiate os this class.
	 * </p>
	 */
	private GenerateLine() {
	}

	/**
	 * <p>
	 * The static method {@code getLine()} is the method used to get a
	 * {@code String}
	 * with randomic chars. It will get a int between 0 and the {@code maxSize} for
	 * the lenght of the {@code String}, create a {@code StringBuilder}, in a for
	 * loop each char is appended in the {@code StringBuilder}. Finally, return the
	 * {@code toString} of the {@code StringBuilder}.
	 * </p>
	 * 
	 * @param maxSize is a {@code int} that represents the max lenght of the
	 *                {@code String} returned by the method.
	 * @return Return a {@code String} with randomic chars.
	 */
	public static String getLine(int maxSize) {
		int size = random.nextInt(maxSize);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			sb.append((char) random.nextInt(BOUND));
		}

		return sb.toString();
	}

	/**
	 * <p>
	 * The static method {@code getLines()} is used to get a array of Strings with
	 * randomic chars. It simply create an array of Strings and fills it in a for
	 * loop with the method {@link GenerateLine#getLine(int)}. Finally return the
	 * array.
	 * </p>
	 * 
	 * @param maxSize is a {@code int} that represents the max lenght of the
	 *                {@code String} returned by the method.
	 * @param lines   is of the type {@code int} and determines the size of the
	 *                String array.
	 * @return Return a {@code String[]} of lines with randomic chars.
	 */
	public static String[] getLines(int maxSize, int lines) {
		String[] strArray = new String[lines];

		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = getLine(maxSize);
		}

		return strArray;
	}
}
