package com.walletmix.custometab.models


import com.google.gson.annotations.SerializedName

data class ResponseQuotes(
    @SerializedName("author")
    val author: String?,
    @SerializedName("authorSlug")
    val authorSlug: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("dateAdded")
    val dateAdded: String?,
    @SerializedName("dateModified")
    val dateModified: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("length")
    var length: Int?,
    @SerializedName("tags")
    val tags: List<String?>?
)