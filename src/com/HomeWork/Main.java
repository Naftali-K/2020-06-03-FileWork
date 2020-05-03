package com.HomeWork;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<String> nameFiles = new ArrayList<>();
        int fullSize;
        long fullSizeTeacher;

        File file = new File("C:/Users/Naftali/Documents/Resume");
        nameFiles.addAll(getAllFiles(file));
        for (String nameFile : nameFiles) {
            System.out.println(nameFile);
        }
        System.out.println(nameFiles.toString());

        System.out.println("----------------");

        fullSize = getSizeAllFiles(file);
        System.out.println("Full size is - " + fullSize);

        System.out.println("----------------");

        fullSizeTeacher = getSizeAllFilesTeacher(file);
        System.out.println("Full size is - " + fullSizeTeacher);
    }

    //my option count size all folders
    public static int getSizeAllFiles(File scr){
        int fullSize = 0;
        for (File file : scr.listFiles()) {
            if (file.isFile()){
                fullSize += file.length();
            }else {
                fullSize += getSizeAllFiles(file);
                fullSize += file.length();
            }
        }
        return fullSize;
    }

    //teacher option count size all folders
    public static long getSizeAllFilesTeacher(File scr){
        long fullSize = scr.length();
        for (File file : scr.listFiles()) {
            if (file.isFile()){
                fullSize += file.length();
            }else {
                fullSize += getSizeAllFiles(file);
            }
        }
        return fullSize;
    }

    public static ArrayList<String> getAllFiles(File scr){
        ArrayList<String> list = new ArrayList<>();
        for(File file: scr.listFiles()){
            if(file.isFile()){
                list.add(file.getName());
            }else{
                list.addAll(getAllFiles(file));
            }
        }
        return list;
    }
}
