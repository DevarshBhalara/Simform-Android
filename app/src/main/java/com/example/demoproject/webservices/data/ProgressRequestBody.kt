package com.example.demoproject.webservices.data

import android.os.Handler
import android.os.Looper
import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.Response
import okio.BufferedSink
import java.io.File
import java.io.FileInputStream
import java.io.IOException


public interface ProgressCallback {
    public fun onProgress(progress: Long)
}
internal class ProgressRequestBody(
    private val file: File,
    private val contentType: MediaType? = null,
    private val callback: ProgressCallback
) : RequestBody() {
    override fun contentType(): MediaType? = contentType
    override fun contentLength(): Long = file.length()

    override fun writeTo(sink: BufferedSink) {
        val total = file.length()
        val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
        var uploaded = 0L
        FileInputStream(file).use { fis ->
            var read: Int
            val handler = Handler(Looper.getMainLooper())
            while (fis.read(buffer).also { read = it } != -1) {
                handler.post {
                    callback.onProgress((100 * uploaded / total))
                }
                uploaded += read.toLong()
                sink.write(buffer, 0, read)
            }
        }
    }

    companion object {
        private const val DEFAULT_BUFFER_SIZE = 2048
    }
}

