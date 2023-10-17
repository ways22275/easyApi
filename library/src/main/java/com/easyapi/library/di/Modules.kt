package com.easyapi.library.di

import com.easyapi.library.repo.CommonRepository
import com.google.gson.Gson
import org.koin.dsl.module

val networkModule = module {
  single {
    provideRetrofit(get())
  }
  single {
    provideCommonService(get())
  }
}

val repoModule = module {
  factory {
    CommonRepository(get(), get())
  }
}

val commonModule = module {
  single {
    Gson()
  }
}

val modules = listOf(networkModule, repoModule, commonModule)