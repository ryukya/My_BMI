package com.example.mybmi

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class BaseActivity : AppCompatActivity() {
    val TAG ="LifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"${javaClass.simpleName} On Create")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG,"${javaClass.simpleName} On Start")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"${javaClass.simpleName} On Resume")
        super.onResume()
    }

    override fun onRestart() {
        Log.d(TAG,"${javaClass.simpleName} On Restart")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(TAG,"${javaClass.simpleName} On Pause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"${javaClass.simpleName} On Stop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"${javaClass.simpleName} On Destroy")
        super.onDestroy()
    }
}
