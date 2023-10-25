package org.multi_access_file;

import java.io.File;

public class WriteThread extends Thread {
    private static final int REPETITIONS = 10;
    private File file;

    public WriteThread(File file) {
        this.file = file;
    }

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
