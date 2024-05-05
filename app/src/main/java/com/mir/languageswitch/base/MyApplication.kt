package com.mir.languageswitch.base

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import com.zeugmasolutions.localehelper.LocaleAwareApplication
import com.zeugmasolutions.localehelper.LocaleHelper
import com.zeugmasolutions.localehelper.LocaleHelperApplicationDelegate

/**
Created by Shitab Mir on 5/5/24.
shitabmir@gmail.com
 **/
class MyApplication: LocaleAwareApplication(){
 private val localeAppDelegate = LocaleHelperApplicationDelegate()
 private val tag = "class:MyApplication"
 override fun attachBaseContext(base: Context) {
  Log.d(tag, "attachBaseContext")
  super.attachBaseContext(localeAppDelegate.attachBaseContext(base))
 }

 override fun onConfigurationChanged(newConfig: Configuration) {
  Log.d(tag, "onConfigurationChanged")

  super.onConfigurationChanged(newConfig)
  localeAppDelegate.onConfigurationChanged(this)
 }

// override fun getApplicationContext(): Context =
//  LocaleHelper.onAttach(super.getApplicationContext())
}