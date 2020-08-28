package com.company.io;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File dir = new File("D:\\学习资料\\Linux");
        listAll(dir,0);
    }

    public static void listAll(File dir, int level) {
        File[] files = dir.listFiles();
        for(File file: files) {
            if(file.isDirectory()) {
                listAll(file, ++level);
            } else {
                System.out.println(getSpaceByLevel(level)+file.getName());
            }
        }

    }
    private static String getSpaceByLevel(int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<level; ++i) {
            stringBuilder.append("|--");
        }
        return stringBuilder.toString();
    }
}