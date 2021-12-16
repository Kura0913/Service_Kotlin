package com.example.service_kotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.broadcast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        val intent = Intent(this, SecActivity::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            delay(3000)
            //宣告Intent，從MService啟動Activity

            //加入Flag表示要產生一個新的Activity
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
        override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
            return START_NOT_STICKY  //Service終止後不再做
        }

        override fun onBind(intent: Intent): IBinder? = null
}
