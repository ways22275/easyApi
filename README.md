# EasyApi
[![](https://jitpack.io/v/ways22275/easyApi.svg)](https://jitpack.io/#ways22275/easyApi)

## startup
  ### gradle 
  
  - Step 1 : Add it in your root build.gradle at the end of repositories:
    ```
    dependencyResolutionManagement {
		  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		  repositories {
			  mavenCentral()
			  maven { url 'https://jitpack.io' }
    }
    ```
  - Step 2 : Add the dependency
    ```
    dependencies {
	     implementation 'com.github.ways22275:easyApi:Tag'
	  }
    ```
 ### maven
 - Step 1 : Add the JitPack repository to your build file
   ```
   <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
   ```
 - Step 2 : Add the dependency
   ```
   <dependency>
	    <groupId>com.github.ways22275</groupId>
	    <artifactId>easyApi</artifactId>
	    <version>Tag</version>
	</dependency>
   ```
  
 ### Quick Start
 - Step 1 : Add followings to your application
   ```
   InjectHelper.initKoin()
   InjectHelper.addCommonModule {
      HostInfo(
        host = "Your service domain"
      )
    }
   ```
 - Step 2 : use helper method get CommonRepository
   ```
   private val repo by lazy {
    InjectHelper.get<CommonRepository>()
   }
   ```
 - Step 3 : use CommonRepository to envoke api request
   ```
    lifecycleScope.launch {
      val resource = repo.getResource<String>("Your api url path")
      when(resource.status) {
        Status.SUCCESS -> {
          val data = resource.parseData<"Api data class">().data
        }
        Status.ERROR -> {
          val errorCode = resource.code
          val errorMessage = resource.message
        }
      }
    }
   
   ```



