package org.multi_access_file;

import java.io.File;

/**
 * <p>
 * The {@code WriteThread} class extends the class {@code Thread}, is the class
 * that will be responsible to write in the given file. Override the
 * {@code run()} method to write in the file (passed in your constructor) how
 * many times the attribute {@code REPETITIONS} indicates.
 * </p>
 */
public class WriteThread extends Thread {
    /**
     * <p>
     * This attribute is a constant to represent how many lines will be written in
     * the file.
     * </P>
     */
    private static final int REPETITIONS = 10;
    /**
     * <p>
     * It is the file where will be written by the thread.
     * </p>
     */
    private File file;

    /**
     * <p>
     * Constructor that receives a {@code File} object and sets it in our attribute.
     * </p>
     * 
     * @param file Is the file where will be written by the thread.
     */
    public WriteThread(File file) {
        this.file = file;
    }

    // TODO: continue here
    /**
     * <p>
     * The {@code run()} method is ...
     * </p>
     */
    @Override
    public void run() {
        for (int i = 0; i < REPETITIONS; i++) {
            String text = String.format("[%s]:{%s}", getName(), GenerateLine.getLine(30));
            FileController.writeLine(text, file);

            try {
                sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.printf("+++%s was ENDED %n", getName());
    }
}
