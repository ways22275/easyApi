package com.easyapi.library.data

import com.easyapi.library.utils.Utils

class Resource (
  val code: Int,
  val status: Status,
  val jsonStr: String = "",
  val message: String? = null
) {

  companion object {

    fun success(jsonStr: String) = Resource(
      code = 200,
      status = Status.SUCCESS,
      jsonStr = jsonStr
    )

    fun error(code: Int, message: String) = Resource(
      code = code,
      status = Status.ERROR,
      message = message
    )
  }

  override fun toString(): String {
    return "Resource ${status.name} , code: $code, message : $message , jsonStr : $jsonStr"
  }

}

inline fun <reified T> Resource.parseData() = Utils.parseResponseData<T>(jsonStr)

enum class Status {
  SUCCESS,
  ERROR
}