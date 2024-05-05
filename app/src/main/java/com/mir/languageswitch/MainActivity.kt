package com.mir.languageswitch


import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.mir.languageswitch.base.BaseActivity
import com.zeugmasolutions.localehelper.Locales
import java.util.Locale

class MainActivity : BaseActivity() {

    private val tag = "class:MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val btnToDefault = findViewById<Button>(R.id.btnToDefault)
        val btnArUAE = findViewById<Button>(R.id.btnArUAE)
        val btnEnUSA = findViewById<Button>(R.id.btnEnUSA)

        btnToDefault.setOnClickListener {
            updateLocale(Locale("en"))
        }
        btnEnUSA.setOnClickListener {
            updateLocale(Locales.English)
        }

        btnArUAE.setOnClickListener {
            val arUAELocale = Locale("ar", "AE")
            updateLocale(arUAELocale)
        }

    }
}