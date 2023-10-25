package org.multi_access_file;

import java.io.File;

public class WriteThread extends Thread {
    private File file;

    public WriteThread(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // TODO: criar var para armazenar o numero de repeticoes do loop
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
