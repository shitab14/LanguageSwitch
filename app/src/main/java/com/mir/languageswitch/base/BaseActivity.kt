package com.mir.languageswitch.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zeugmasolutions.localehelper.LocaleHelper
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegate
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegateImpl
import java.util.Locale

/**
Created by Shitab Mir on 5/5/24.
shitabmir@gmail.com
 **/
open class BaseActivity : AppCompatActivity() {
 private val localeDelegate: LocaleHelperActivityDelegate = LocaleHelperActivityDelegateImpl()
 private val tag = "class:BaseActivity"

 override fun getDelegate() = localeDelegate.getAppCompatDelegate(super.getDelegate())

 override fun attachBaseContext(newBase: Context) {
  Log.d(tag, "attachBaseContext")
  super.attachBaseContext(localeDelegate.attachBaseContext(newBase))
 }

 override fun onCreate(savedInstanceState: Bundle?) {
  Log.d(tag, "onCreate")
  super.onCreate(savedInstanceState)
  localeDelegate.onCreate(this)
 }

 override fun onResume() {
  Log.d(tag, "onResume")
  super.onResume()
  localeDelegate.onResumed(this)
 }

 override fun onPause() {
  Log.d(tag, "onPause")
  super.onPause()
  localeDelegate.onPaused()
 }

 override fun createConfigurationContext(overrideConfiguration: Configuration): Context {
  Log.d(tag, "createConfigurationContext")

  val context = super.createConfigurationContext(overrideConfiguration)
  return LocaleHelper.onAttach(context)
 }

// override fun getApplicationContext(): Context =
//  localeDelegate.getApplicationContext(super.getApplicationContext())

 open fun updateLocale(locale: Locale) {
  Log.d(tag, "updateLocale " +
          "\nCountry:${locale.country} " +
          "\nLanguage${locale.language} ")

  localeDelegate.setLocale(this, locale)
 }
}