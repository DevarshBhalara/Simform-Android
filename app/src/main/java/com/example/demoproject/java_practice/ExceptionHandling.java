package com.example.demoproject.java_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionHandling {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int a = 100/0;
        }catch (ArithmeticException e){
            System.out.println(e);
        }
        ArrayList<FileInfo> listFileInfo = new ArrayList<FileInfo>();
        listFileInfo.add(new FileInfo("Project.txt",1,10));
        listFileInfo.add(new FileInfo("Project2.txt",1,80));
        listFileInfo.add(new FileInfo("Project3.txt",0,20));
        listFileInfo.add(new FileInfo("Project4.txt",1,40));

        FileInfo objInfo = new FileInfo();
        try {
            objInfo.getFileByName("Project6.txt", listFileInfo);
            objInfo.isReadable("Project7.txt", listFileInfo);
        }catch (FileNotFoundException e){
            System.out.println("File not Found");
        }catch (NotReadableException e){
            System.out.println("This file is not Readable");
        }

    }


}

class FileInfo{
    String name;
    int isReadable;
    int size;

    FileInfo(String name, int isReadable, int size ) {
        this.name = name;
        this.isReadable = isReadable;
        this.size = size;;
    }

    public FileInfo() {

    }

    void getFileByName(String name, ArrayList<FileInfo> info) throws FileNotFoundException {
        int flag = 0;
        for (FileInfo fileInfo : info) {

            if(fileInfo.name.equals(name)){
                System.out.println("Found file");
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            throw new FileNotFoundException();
        }
    }

    void isReadable(String name, ArrayList<FileInfo> info) throws NotReadableException, FileNotFoundException {

        int flag = 0;
        for (FileInfo fileInfo: info){
            if(fileInfo.name.equals(name)){
                flag = 1;
                if (fileInfo.isReadable == 0){
                    throw new NotReadableException();
                }
            }
        }
        if (flag == 0){
            throw new FileNotFoundException();
        }

    }
}

class NotReadableException extends  Exception {
    public NotReadableException(){
        super();
    }
}