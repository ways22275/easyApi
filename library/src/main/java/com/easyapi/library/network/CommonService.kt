package com.easyapi.library.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CommonService {

  @Headers("accept: application/json")
  @GET("{url}")
  suspend fun <T> get(@Path(value = "url", encoded = true) url: String): Response<T>

  @Headers("accept: application/json")
  @POST("{url}")
  suspend fun <T, R> post(@Body request: R): Response<T>

  @Headers("accept: application/json")
  @PUT("{url}")
  suspend fun <T, R> put(@Body request: R): Response<T>

  @Headers("accept: application/json")
  @PATCH("{url}")
  suspend fun <T, R> patch(@Body request: R): Response<T>

  @Headers("accept: application/json")
  @DELETE("{url}")
  suspend fun <T> delete(): Response<T>
}