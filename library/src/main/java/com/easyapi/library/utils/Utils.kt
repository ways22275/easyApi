package com.easyapi.library.utils

import com.easyapi.library.di.InjectHelper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Utils {

  inline fun <reified T> parseResponseData(jsonStr: String) : T {
    val gson = InjectHelper.get<Gson>()
    val type = object : TypeToken<T>() {}.type
    return gson.fromJson(jsonStr, type)
  }
}