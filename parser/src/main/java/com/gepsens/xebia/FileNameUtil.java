package com.gepsens.xebia;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNameUtil {

    private FileNameUtil() {}

    public static String getDirNameForClass(Class clazz) {
        String name = clazz.getSimpleName().toLowerCase();
        if(name.endsWith("s")) {
            name += "es";
        } else {
            name += "s";
        }
        return name;
    }

    public static void printFileNameAsHexStrings(String path) throws IOException {
        try (DirectoryStream<Path> dir = Files.newDirectoryStream(Paths.get(path))) {
            for (Path child : dir) {
                String filename = child.getFileName().toString();

                System.out.println("name=" + filename);
                for (char c : filename.toCharArray()) {
                    System.out.printf("%04x ", (int) c);
                }
                System.out.println();
            }
        }
    }
}
