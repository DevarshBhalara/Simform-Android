package com.example.demoproject.kotlinPractice.exception

import java.io.FileNotFoundException

fun main() {
    val arrayList = arrayListOf<FileDataClass>()
    arrayList.add(FileDataClass("FileOne", 1, 12))
    arrayList.add(FileDataClass("FileTwo", 0, 12))
    arrayList.add(FileDataClass("FileThree", 0, 12))
    arrayList.add(FileDataClass("FileFour", 1, 12))

    var fileinfoObj = FileInfo(arrayList)
    try{
        fileinfoObj.getByFileName("FileTwo",arrayList)
        fileinfoObj.isReadable("FileTwo",arrayList)
    } catch (e: FileNotFoundException) {
        println(e)
    } catch (e: NotReadableFile){
        println(e)
    }
}