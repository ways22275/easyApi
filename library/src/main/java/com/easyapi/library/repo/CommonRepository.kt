package com.easyapi.library.repo

import com.easyapi.library.data.Resource
import com.easyapi.library.network.CommonService
import com.google.gson.Gson
import retrofit2.Response

class CommonRepository constructor(
  private val gson: Gson,
  private val service: CommonService
) {

  suspend fun <T> getResource(path: String): Resource {
    return service.get<T>(path).toResource(gson)
  }

  suspend fun <T, R> postResource(request: R): Resource {
    return service.post<T, R>(request).toResource(gson)
  }

  suspend fun <T, R> putResource(request: R): Resource {
    return service.put<T, R>(request).toResource(gson)
  }

  suspend fun <T, R> patchResource(request: R): Resource {
    return service.patch<T, R>(request).toResource(gson)
  }

  suspend fun <T> deleteResource(): Resource {
    return service.delete<T>().toResource(gson)
  }
}

fun <T> Response<T>.toResource(gson: Gson): Resource {
  return if (this.isSuccessful) {
    Resource.success(gson.toJson(body()))
  } else {
    Resource.error(
      code = code(),
      message = errorBody().toString()
    )
  }
}