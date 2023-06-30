package com.example.demoproject.webservices.data

import com.google.gson.annotations.SerializedName

data class ImageResponse(

    @SerializedName("data") val data: DataImage? = DataImage(),
    @SerializedName("success") val success: Boolean? = null,
    @SerializedName("status") val status: Int? = null

)

data class Image(

    @SerializedName("filename") val filename: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("mime") val mime: String? = null,
    @SerializedName("extension") val extension: String? = null,
    @SerializedName("url") val url: String? = null

)

data class Thumb(

    @SerializedName("filename") val filename: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("mime") val mime: String? = null,
    @SerializedName("extension") val extension: String? = null,
    @SerializedName("url") val url: String? = null

)


data class Medium(

    @SerializedName("filename") val filename: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("mime") val mime: String? = null,
    @SerializedName("extension") val extension: String? = null,
    @SerializedName("url") val url: String? = null

)

data class DataImage(

    @SerializedName("id") val id: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("url_viewer") val urlViewer: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("display_url") val displayUrl: String? = null,
    @SerializedName("width") val width: String? = null,
    @SerializedName("height") val height: String? = null,
    @SerializedName("size") val size: String? = null,
    @SerializedName("time") val time: String? = null,
    @SerializedName("expiration") val expiration: String? = null,
    @SerializedName("image") val image: Image? = Image(),
    @SerializedName("thumb") val thumb: Thumb? = Thumb(),
    @SerializedName("medium") val medium: Medium? = Medium(),
    @SerializedName("delete_url") val deleteUrl: String? = null

)