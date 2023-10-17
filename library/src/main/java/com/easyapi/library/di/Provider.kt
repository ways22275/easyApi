package com.easyapi.library.di

import com.easyapi.library.data.HostInfo
import com.easyapi.library.network.CommonService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

fun provideRetrofit(hostInfo: HostInfo): Retrofit {
  return Retrofit.Builder().apply {
    baseUrl(hostInfo.host)
    client(
      OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
          level = HttpLoggingInterceptor.Level.BODY
        }).build()
    )
    addConverterFactory(
      GsonConverterFactory.create(
        GsonBuilder()
          .setLenient()
          .create()
      )
    )
  }.build()
}

fun provideCommonService(retrofit: Retrofit): CommonService {
  return retrofit.create()
}