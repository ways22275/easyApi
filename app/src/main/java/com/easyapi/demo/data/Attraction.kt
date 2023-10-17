package com.easyapi.demo.data

import com.google.gson.annotations.SerializedName

data class Attraction(
  val seq: Int,

  val id: Int,

  val name: String,

  val introduction: String,

  val address: String,

  @SerializedName("official_site")
  val officialSite: String,

  @SerializedName("modified")
  val modifiedTime: String,

  val images: List<Image>
)
