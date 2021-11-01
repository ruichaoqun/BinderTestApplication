package com.ruichaoqun.bindertestapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Process
import android.view.View
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var mService:IRemoteService
    lateinit var tvLog:TextView
    val logs:StringBuilder = StringBuilder()
    private val connection:ServiceConnection = object :ServiceConnection{

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mService = IRemoteService.Stub.asInterface(service)
            updateLogs("onServiceConnected")
            updateLogs("${mService.pid}")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            updateLogs("onServiceDisconnected")
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvLog = findViewById(R.id.tv_log)
        updateLogs("current pid:${Process.myPid()}")
    }

    fun bindService(view: View) {
        val intent = Intent(this,RemoteService::class.java)
        bindService(intent,connection, Context.BIND_AUTO_CREATE)
        updateLogs("binding")
    }

    fun unBindService(view: View) {
        unbindService(connection)
    }

    fun killService(view: View) {

    }

    private fun updateLogs(log:String){
        logs.appendLine(log)
        tvLog.text = logs.toString()
    }
}