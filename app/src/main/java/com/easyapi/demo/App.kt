package com.easyapi.demo

import android.app.Application
import com.easyapi.library.data.HostInfo
import com.easyapi.library.di.InjectHelper

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    InjectHelper.initKoin()
    InjectHelper.addCommonModule {
      HostInfo(
        host = "https://www.travel.taipei/"
      )
    }
  }
}