package com.ruichaoqun.bindertestapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Process
import android.os.RemoteCallbackList

class RemoteService:Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }


    private val binder = object :IRemoteService.Stub(){
        override fun getPid(): Int {
            return Process.myPid()
        }

        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {

        }

    }
}