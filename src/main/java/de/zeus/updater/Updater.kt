package de.zeus.updater;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Updater {

    public static void main(String[] args) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (args.length < 3) {
            System.out.println("Updater must be run with three arguments!");
            return;
        }

        String url = args[0];
        String oldName = args[1];
        String newName = args[2];

        boolean restart = false;
        if (args.length == 4) {
            restart = Boolean.parseBoolean(args[3]);
        }

        if (url == null || url.isEmpty()) {
            System.out.println("URL empty!");
            return;
        }

        if (oldName == null || oldName.isEmpty()) {
            System.out.println("OldName empty!");
            return;
        }

        if (newName == null || newName.isEmpty()) {
            System.out.println("NewName empty!");
            return;
        }

//        File oldFile = new File("./" + oldName);
//        File newFile = new File("./" + newName);

        File oldFile = new File(oldName);
        File newFile = new File(newName);

        if (oldFile.exists())
            oldFile.delete();

        downloadFile(url, newFile);

        if (restart) {
            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            ProcessBuilder builder = new ProcessBuilder(javaBin, "-jar", newFile.getAbsolutePath());

            try {
                builder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.exit(0);
    }

    private static void downloadFile(String url, File destination) {
        try {
            FileUtils.copyURLToFile(new URL(url), destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}