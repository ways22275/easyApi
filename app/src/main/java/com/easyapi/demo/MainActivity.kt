package com.easyapi.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.easyapi.demo.data.AttractionsResponse
import com.easyapi.library.data.Status
import com.easyapi.library.data.parseData
import com.easyapi.library.di.InjectHelper
import com.easyapi.library.repo.CommonRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

  private val repo by lazy {
    InjectHelper.get<CommonRepository>()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    testGetApi()
  }

  private fun testGetApi() {
    lifecycleScope.launch {
      val resource = repo.getResource<String>("/open-api/zh-tw/Attractions/All")
      val message = when(resource.status) {
        Status.SUCCESS -> {
          val count = resource.parseData<AttractionsResponse>().data?.size ?: 0
          "Get Attractions Success -> count : $count"
        }
        Status.ERROR -> {
          "Get Attractions Fail -> code : ${resource.code} , message : ${resource.message}"
        }
      }
      Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
  }
}