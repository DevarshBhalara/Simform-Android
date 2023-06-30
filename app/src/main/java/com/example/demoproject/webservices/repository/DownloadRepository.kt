package com.example.demoproject.webservices.repository

import android.os.Environment
import android.util.Log
import com.example.demoproject.webservices.interfaces.UserMockApiService
import okhttp3.ResponseBody
import java.io.*


class DownloadRepository (private val downloadService: UserMockApiService) {

    suspend fun downloadFile() {
        val fileStream = downloadService.downloadFile("https://files.all-free-download.com/downloadfiles/graphic/graphic_8/closeup_of_wild_butterfly_in_nature_6891908.zip").byteStream()
        Log.e("file", fileStream.toString())
        val aa = writeResponseBodyToDisk(fileStream, "My")
        Log.e("file", aa.toString())
    }

    private fun writeResponseBodyToDisk(data: InputStream, name: String): Boolean {

        return try {
            val path: String =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .toString()
            val futureStudioIconFile = File(path, "$name.zip")
            if (futureStudioIconFile.exists()) futureStudioIconFile.delete()
            futureStudioIconFile.createNewFile()

            var outputStream: OutputStream? = null
            try {
                val fileReader = ByteArray(4096)
                var fileSizeDownloaded: Long = 0

                outputStream = FileOutputStream(futureStudioIconFile)
                while (true) {
                    val read: Int = data.read(fileReader)
                    if (read == -1) {
                        break
                    }
                    outputStream.write(fileReader, 0, read)
                    fileSizeDownloaded += read.toLong()
                }
                outputStream.flush()
                true
            } catch (e: IOException) {
                e.printStackTrace()
                false
            } finally {
                data.close()
                outputStream?.close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

}