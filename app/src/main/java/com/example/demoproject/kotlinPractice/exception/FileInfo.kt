package com.example.demoproject.kotlinPractice.exception

import java.io.FileNotFoundException

class FileInfo() {

    fun getByFileName(name: String, files: ArrayList<FileDataClass>) {
        var flag: Int = 0
        for (i in files) {
            if (i.name == name) {
                println("File found")
                flag = 1
                break
            }
        }

        if (flag == 0) {
            throw FileNotFoundException("$name File is Not available")
        }
    }

    fun isReadable(name: String, files: ArrayList<FileDataClass>) {
        var flag: Int = 0
        for (i in files) {
            if (i.name == name) {
                flag = 1
                if (i.isReadableFile == 1) {
                    println("$name file is readable")
                    break
                } else {
                    throw NotReadableFile("$name file is not readable ")
                }
            }
        }
        if (flag == 0) {
            throw FileNotFoundException()
        }
    }
}


