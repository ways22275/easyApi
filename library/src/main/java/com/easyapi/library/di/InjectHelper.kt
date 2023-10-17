package com.easyapi.library.di

import org.koin.android.ext.koin.androidLogger
import org.koin.core.Koin
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

object InjectHelper {

  lateinit var koin: Koin

  fun initKoin() {
    koin = startKoin {
      androidLogger()
      modules(modules)
    }.koin
  }

  inline fun <reified T> get(): T {
    return koin.get()
  }

  inline fun <reified T> addCommonModule(crossinline factory : () -> T) {
    commonModule.factory {
      factory.invoke()
    }
    loadKoinModules(commonModule)
  }

}