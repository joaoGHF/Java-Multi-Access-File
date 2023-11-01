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

    /**
     * <p>
     * The {@code run()} method is the method performed in the execution of a
     * {@code WriteThread} thread. It uses a {@code for loop} to executes how much
     * the {@link WriteThread#REPETITIONS} indicates. In the loop, a {@code String}
     * is formated to get a text with the thread name and a generated line. Next,
     * uses the synchronized method {@link FileController#writeLine(String, File)}
     * to write (append) this text in the file {@link WriteThread#file}. The thread
     * will try sleep after the text is written. When this current thread is
     * finalizing it will print a message incacating that the thread was ended.
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
