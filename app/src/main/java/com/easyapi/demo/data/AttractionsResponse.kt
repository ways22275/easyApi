package com.easyapi.demo.data

data class AttractionsResponse (
  val total: Int,
  val data: List<Attraction>? = null
)